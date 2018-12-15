package com.service.impl;

import com.dao.TbReplyDao;
import com.pojo.TbReply;
import com.service.ReplyService;
import com.tools.utils.TimeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 疯自
 */
@Service
public class ReplyServiceImpl implements ReplyService {

    @Autowired
    private TbReplyDao tbReplyDao;

    @Override
    public List<TbReply> findReplyByCommentId(Integer commentId) {
        return tbReplyDao.findReplyByCommentId(commentId);
    }

    @Override
    public Integer findReplyCountByCommentId(Integer commentId) {
        return tbReplyDao.findReplyCountByCommentId(commentId);
    }

    @Override
    public boolean insertReply(TbReply tbReply) {
        tbReply.setReplyCreateDate(TimeUtils.getNowTimestamp());
        return tbReplyDao.insertSelective(tbReply) == 1;
    }
}
