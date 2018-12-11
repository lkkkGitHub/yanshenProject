package com.service.impl;

import com.dao.TbCommentDao;
import com.pojo.TbComment;
import com.service.CommentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author 疯自
 */
@Service
public class TbCommentServiceImpl implements CommentService {

    @Resource
    private TbCommentDao tbCommentDao;

    @Override
    public TbComment findCommentByTopicId(Integer topicId) {
        return tbCommentDao.findCommentByTopicId(topicId);
    }
}
