package com.controller;

import com.pojo.TbComment;
import com.pojo.TbReply;
import com.pojo.TbUser;
import com.service.CommentService;
import com.service.ReplyService;
import com.tools.finaltools.UserFinalTool;
import com.tools.utils.JsonUtils;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
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
    private RabbitTemplate rabbit;

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
        TbReply reply = null;
        TbComment comment = null;
        if (tbReply.getReplyFatherId() != -1) {
            reply = replyServiceImpl.findReplyById(tbReply.getReplyFatherId()).get(0);
        } else {
            comment = commentService.findCommentById(tbReply.getCommentId()).get(0);
        }
        if (comment != null) {
            rabbit.convertAndSend("reply" + comment.getUid(), JsonUtils.objectToJson(comment));
        } else if (reply != null) {
            rabbit.convertAndSend("reply" + reply.getUid(), JsonUtils.objectToJson(reply));
        }
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
}
