package com.service.impl;

import com.dao.TbCommentDao;
import com.pojo.TbComment;
import com.service.CommentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 疯自
 */
@Service
public class TbCommentServiceImpl implements CommentService {

    @Resource
    private TbCommentDao tbCommentDao;

    @Override
    public List<TbComment> findCommentByTopicId(Integer topicId) {
        Integer commentCount = tbCommentDao.findCommentCountByTopicId(topicId);
        List<TbComment> commentList = null;
        if (commentCount != 0) {
            commentList = tbCommentDao.findCommentByTopicId(topicId);
            commentList.get(0).setCount(commentCount);
        }
        return commentList;
    }
}
