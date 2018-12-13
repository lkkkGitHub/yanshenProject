package com.controller;

import com.pojo.TbReply;
import com.service.ReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
    @RequestMapping("/findReplyCommentId")
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
}
