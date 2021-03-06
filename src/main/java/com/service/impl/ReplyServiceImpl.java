package com.service.impl;

import com.dao.TbCommentDao;
import com.dao.TbReplyDao;
import com.pojo.TbReply;
import com.service.ReplyService;
import com.tools.pojoexpansion.Pager;
import com.tools.utils.TimeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author 疯自
 */
@Service
public class ReplyServiceImpl implements ReplyService {

    @Autowired
    private TbReplyDao tbReplyDao;

    @Autowired
    private TbCommentDao tbCommentDao;

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
                List<Integer> findList = tbReplyDao.findReplyFatherId(fatherReplyId);
                Queue<Integer> queue = new LinkedBlockingQueue<>(findList);
                while (true) {
                    replyId = queue.poll();
                    if (replyId == null) {
                        tbReplyDao.deleteByIds(list);
                        break;
                    } else {
                        list.add(replyId);
                        fatherReplyId = replyId;
                        queue.addAll(tbReplyDao.findReplyFatherId(fatherReplyId));
                    }
                }
                return true;
            }
        } else {
            return false;
        }
    }

    @Override
    public List<TbReply> findReplyById(Integer replyFatherId) {
        return tbReplyDao.findReplyByFatherId(replyFatherId);
    }

    @Override
    public Integer getReplyCount(String uid, Integer isRead) {
        return tbReplyDao.getReplyCountByIsRead(uid, isRead);
    }

    @Override
    public List<TbReply> getReplyByIsRead(String uid, Integer isRead, Pager<TbReply> pager) {
        List<TbReply> list;
        if (Pager.zero.equals(pager.getTotalNum())) {
            list = new ArrayList<>();
        } else {
            list = tbReplyDao.getReplyByIsRead(uid, isRead, pager);
        }
        return list;
    }

    @Override
    public boolean updateIsRead(Integer replyId) {
        return tbReplyDao.updateIsRead(replyId) == 1;
    }
}
