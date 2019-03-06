package com.service.impl;

import com.dao.TbCommentDao;
import com.pojo.TbComment;
import com.pojo.TbReply;
import com.service.CommentService;
import com.service.ReplyService;
import com.tools.utils.TimeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 疯自
 */
@Service
public class CommentServiceImpl implements CommentService {

    @Resource
    private TbCommentDao tbCommentDao;

    @Autowired
    private ReplyService replyServiceImpl;

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

    @Override
    public boolean insertComment(TbComment tbComment) {
        tbComment.setCommentCreateDate(TimeUtils.getNowTimestamp());
        return tbCommentDao.insertSelective(tbComment) == 1;
    }

    @Override
    public boolean deleteById(Integer commentId) {
        if (replyServiceImpl.findReplyCountByCommentId(commentId) == 0) {
            return tbCommentDao.deleteByCommentId(commentId) == 1;
        } else {
            List<TbReply> list = replyServiceImpl.findReplyByCommentId(commentId);
            Integer[] replyIds = new Integer[list.size()];
            int i = 0;
            for (TbReply reply : list) {
                replyIds[i] = reply.getReplyId();
                i++;
            }
            boolean replyFlag = replyServiceImpl.deleteReplyById(replyIds);
            if (replyFlag) {
                return tbCommentDao.deleteByCommentId(commentId) == 1;
            }
            return false;
        }
    }

    @Override
    public List<TbComment> findCommentById(Integer commentId) {
        return tbCommentDao.findCommentById(commentId);
    }
}
