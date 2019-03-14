package com.controller;

import com.pojo.TbComment;
import com.pojo.TbReply;
import com.pojo.TbUser;
import com.service.CommentService;
import com.service.ReplyService;
import com.service.TopicService;
import com.tools.finaltools.ReplyFinalTool;
import com.tools.finaltools.UserFinalTool;
import com.tools.utils.JsonUtils;
import com.tools.utils.TimeUtils;
import com.tools.utils.jedis.JedisClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * @author lk
 * 2018/12/10 19:46
 */
@Controller
@RequestMapping("/reply")
public class ReplyController {

    @Autowired
    private ReplyService replyServiceImpl;

    @Autowired
    private CommentService commentService;

    @Autowired
    private JedisClient jedisClient;

    @Autowired
    private TopicService topicService;

    /**
     * 根据评论id，查询评论的回复信息，以及回复的用户信息
     *
     * @param commentId
     * @return
     */
    @ResponseBody
    @RequestMapping("/findReplyByCommentId")
    public List<TbReply> findReplyByCommentId(Integer commentId) {
        return replyServiceImpl.findReplyByCommentId(commentId);
    }

    /**
     * 根据评论id查询评论的回复信息个数
     *
     * @param commentId
     * @return
     */
    @ResponseBody
    @RequestMapping("/findReplyCountByCommentId")
    public Integer findReplyCountByCommentId(Integer commentId) {
        return replyServiceImpl.findReplyCountByCommentId(commentId);
    }

    /**
     * 插入评论的回复信息
     *
     * @param session 获取用户的id信息
     * @param tbReply 回复内容，回复的父id，-1表示直接回复评论，以及评论的id
     * @return 影响的行数
     */
    @ResponseBody
    @RequestMapping(method = {RequestMethod.POST}, value = "/insertReply")
    public boolean insertReply(TbReply tbReply, HttpSession session) {
        TbReply reply = null;
        TbComment comment = null;
        if (tbReply.getReplyFatherId() != -1) {
            reply = replyServiceImpl.findReplyById(tbReply.getReplyFatherId()).get(0);
        } else {
            comment = commentService.findCommentById(tbReply.getCommentId()).get(0);
        }
        StringBuffer uid;
        if (comment != null) {
            uid = new StringBuffer(comment.getUid());
        } else {
            uid = new StringBuffer(reply.getUid());
        }
        List<TbReply> replyList = this.getRedisReplyList(session, uid);
        TbUser tbUser = ((TbUser) session.getAttribute(UserFinalTool.USER));
        tbReply.setUid(tbUser.getUid());
        tbReply.setTbUser(tbUser);
        tbReply.setReplyCreateDate(TimeUtils.getNowTimestamp());
        tbReply.setTbTopic(topicService.getTopic(tbReply.getTopicId()));
        replyList.add(tbReply);
        boolean insert = replyServiceImpl.insertReply(tbReply);
        if (insert) {
            jedisClient.hset(ReplyFinalTool.REPLY, uid.append(ReplyFinalTool.REPLY_LIST).toString(), JsonUtils.objectToJson(replyList));
        }
        return insert;
    }

    /**
     * 根据id 删除回复的信息
     *
     * @param replyIds replyIds
     * @return
     */
    @ResponseBody
    @RequestMapping("/deleteReplyById")
    public boolean deleteReplyById(Integer[] replyIds) {
        return replyServiceImpl.deleteReplyById(replyIds);
    }

    /**
     * 获取redis缓存中的自己评论信息
     *
     * @param toUid   传入此参数时，则是指定的人的回复信息
     * @param session
     * @return
     */
    @ResponseBody
    @GetMapping("/getRedisReplyList")
    public List<TbReply> getRedisReplyList(HttpSession session, @RequestParam(required = false) StringBuffer toUid) {
        if (toUid == null || toUid.length() != 0) {
            toUid = new StringBuffer((String) session.getAttribute(UserFinalTool.UID));
        }
        List<TbReply> replyList = JsonUtils.jsonToList(jedisClient.hget(ReplyFinalTool.REPLY, toUid.append(ReplyFinalTool.REPLY_LIST).toString()), TbReply.class);
        if (replyList == null) {
            replyList = new ArrayList<>();
            jedisClient.hset(ReplyFinalTool.REPLY, toUid.append(ReplyFinalTool.REPLY_LIST).toString(), JsonUtils.objectToJson(replyList));
        }
        return replyList;
    }
}