package com.controller;

import com.pojo.TbComment;
import com.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author lk
 * 2018/12/11 22:05
 */
@Controller
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    private CommentService commentServiceImpl;

    @ResponseBody
    @RequestMapping("/findCommentByTopicId")
    public TbComment findCommentByTopicId(Integer topicId) {
        return commentServiceImpl.findCommentByTopicId(topicId);
    }
}
