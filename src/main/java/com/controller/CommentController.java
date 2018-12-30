package com.controller;

import com.pojo.TbComment;
import com.pojo.TbUser;
import com.service.CommentService;
import com.tools.finaltools.UserFinalTool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
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

    /**
     * 插入评论信息,对题目的评论
     *
     * @param tbComment 评论内容，题目id
     * @param session   获取用户id
     * @return true 插入成功
     */
    @ResponseBody
    @RequestMapping(value = "/insertComment", method = {RequestMethod.POST})
    public boolean insertComment(TbComment tbComment, HttpSession session) {
        tbComment.setUid(((TbUser) session.getAttribute(UserFinalTool.USER)).getUid());
        return commentServiceImpl.insertComment(tbComment);
    }

    /**
     * 根据评论id删除评论信息，以及之下的回复信息
     *
     * @param commentId
     * @return
     */
    @ResponseBody
    @RequestMapping("/deleteCommentById")
    public boolean deleteById(Integer commentId) {
        return commentServiceImpl.deleteById(commentId);
    }

}
