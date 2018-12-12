package com.controller;

import com.pojo.TbComment;
import com.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author lk
 * 2018/12/11 22:05
 */
@Controller
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    private CommentService commentServiceImpl;

    /**
     * 传入topicId到service
     *
     * @param topicId 题目id
     * @return 查询题目的评论信息，以及评论的用户信息
     */
    @ResponseBody
    @RequestMapping("/findCommentByTopicId")
    public List<TbComment> findCommentByTopicId(Integer topicId) {
        return commentServiceImpl.findCommentByTopicId(topicId);
    }
}
