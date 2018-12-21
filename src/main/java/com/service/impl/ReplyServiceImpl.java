package com.service.impl;

import com.dao.TbReplyDao;
import com.pojo.TbReply;
import com.service.ReplyService;
import com.tools.utils.TimeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
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

    @Override
    public boolean deleteReplyById(Integer[] replyIds) {
        if (replyIds != null) {
            if (replyIds.length > 1) {
                return tbReplyDao.deleteByIds(Arrays.asList(replyIds)) > 1;
            } else {
                Integer fatherReplyId = replyIds[0];
                List<Integer> list = new ArrayList<>();
                Integer replyId;
                list.add(fatherReplyId);
                replyId = tbReplyDao.findReplyFatherId(fatherReplyId);
                while (true) {
                   if (replyId == null) {
                       tbReplyDao.deleteByIds(list);
                       break;
                   } else {
                       list.add(replyId);
                       fatherReplyId = replyId;
                       replyId = tbReplyDao.findReplyFatherId(fatherReplyId);
                   }
                }
                return true;
            }
        } else {
            return false;
        }
    }
}
