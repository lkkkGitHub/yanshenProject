package com.service.impl;

import com.dao.TbCollectionDao;
import com.pojo.TbCollection;
import com.pojo.TbDidtopic;
import com.pojo.TbTopic;
import com.service.CollectionService;
import com.tools.finaltools.CollectionFinalTool;
import com.tools.pojoexpansion.Pager;
import com.tools.utils.jedis.JedisClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author leike
 * @date 2018/12/29
 */
@Service
public class CollectionServiceImpl implements CollectionService {

    @Autowired
    private TbCollectionDao tbCollectionDao;

    @Autowired
    private JedisClient jedisClient;

    @Override
    public boolean insertCollection(String uid, Integer topicId) {
        TbCollection tbCollection = new TbCollection();
        tbCollection.setTopicId(topicId);
        tbCollection.setUserId(uid);
        boolean flag = (tbCollectionDao.insert(tbCollection) == 1);
        if (flag) {
            String num = jedisClient.hget(CollectionFinalTool.COLLECTION_NUM, uid);
            if (num != null && num.length() != 0) {
                jedisClient.hset(CollectionFinalTool.COLLECTION_NUM, uid, String.valueOf(Integer.valueOf(num) + 1));
            } else {
                jedisClient.hset(CollectionFinalTool.COLLECTION_NUM, uid, String.valueOf(1));
            }
        }
        return flag;
    }

    @Override
    public boolean deleteCollection(String uid, Integer topicId, Integer deleteFlag) {
        boolean flag = (tbCollectionDao.updateCollection(uid, topicId, deleteFlag) == 1);
        if (flag) {
            jedisClient.hset(CollectionFinalTool.COLLECTION_NUM, uid,
                    String.valueOf(Integer.valueOf(
                            jedisClient.hget(CollectionFinalTool.COLLECTION_NUM, uid)) - 1));
        }
        return flag;
    }

    @Override
    public Integer checkCollection(String uid, Integer topicId) {
        Integer flag = tbCollectionDao.checkCollection(uid, topicId);
        if (flag == null) {
            return -1;
        } else {
            return flag;
        }
    }

    @Override
    public Integer getCollectionNum(String uid) {
        String numStr = jedisClient.hget(CollectionFinalTool.COLLECTION_NUM, uid);
        if (numStr != null && numStr.length() != 0) {
            return Integer.valueOf(numStr);
        }
        Integer numInt = tbCollectionDao.getCollectionNum(uid);
        if (numInt == null) {
            numInt = 0;
        }
        jedisClient.hset(CollectionFinalTool.COLLECTION_NUM, uid, String.valueOf(numInt));
        return numInt;
    }

    @Override
    public List<TbTopic> getCollectionTopic(String uid, Pager<TbTopic> pager) {
        List<TbTopic> list;
        if (Pager.zero.equals(pager.getTotalNum())) {
            list = new ArrayList<>();
        } else {
            list = tbCollectionDao.getTopicToPager(uid, pager);
        }
        return list;
    }

    @Override
    public Boolean delete(Integer topicId, String uid) {
        if (topicId != null && uid != null && uid.length() != 0) {
            Boolean flag = tbCollectionDao.delete(topicId, uid) == 1;
            if (flag) {
                jedisClient.hset(CollectionFinalTool.COLLECTION_NUM, uid, String.valueOf(
                        Integer.valueOf(jedisClient.hget(CollectionFinalTool.COLLECTION_NUM, uid)) - 1));
            }
            return flag;
        } else {
            return false;
        }
    }

    @Override
    public TbDidtopic getDidTopic(String uid, Integer topicId) {
        return tbCollectionDao.getDidTopic(uid, topicId);
    }
}
