package com.controller;

import com.pojo.TbComment;
import com.pojo.TbReply;
import com.pojo.TbUser;
import com.service.CommentService;
import com.service.ReplyService;
import com.service.TopicService;
import com.tools.finaltools.ReplyFinalTool;
import com.tools.finaltools.UserFinalTool;
import com.tools.pojoexpansion.Pager;
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
        tbReply.setUid(((TbUser) session.getAttribute(UserFinalTool.USER)).getUid());
        tbReply.setReplyCreateDate(TimeUtils.getNowTimestamp());
        return replyServiceImpl.insertReply(tbReply);
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
     * 获取自己未读的或者已读回复数量
     *
     * @param session
     * @return
     */
    @ResponseBody
    @GetMapping("/getReplyCount")
    public Integer getReplyCount(HttpSession session, Integer isRead) {
        return replyServiceImpl.getReplyCount((String) session.getAttribute(UserFinalTool.UID), isRead);
    }

    /**
     * 获取自己未读的或者已读消息内容，按照时间降序排列
     *
     * @param session
     * @return
     */
    @ResponseBody
    @GetMapping("/getReplyIsRead")
    public Pager<TbReply> getReplyIsRead(HttpSession session, Integer isRead, Integer currentSize) {
        String uid = (String) session.getAttribute(UserFinalTool.UID);
        Pager<TbReply> pager = new Pager<>(4, currentSize, replyServiceImpl.getReplyCount(uid, isRead));
        pager.setDateList(replyServiceImpl.getReplyByIsRead(uid, isRead, pager));
        return pager;
    }

    /**
     * 更新未读消息状态
     *
     * @param replyId
     * @return
     */
    @ResponseBody
    @GetMapping("/updateIsRead")
    public boolean updateIsRead(Integer replyId) {
        return replyServiceImpl.updateIsRead(replyId);
    }
}