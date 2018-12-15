package com.controller;

import com.pojo.TbReply;
import com.pojo.TbUser;
import com.service.ReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
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
    @RequestMapping(method = {RequestMethod.POST},value = "/insertReply")
    public boolean insertReply(TbReply tbReply, HttpSession session) {
        tbReply.setUid(((TbUser) session.getAttribute("user")).getUid());
        return replyServiceImpl.insertReply(tbReply);
    }
}
