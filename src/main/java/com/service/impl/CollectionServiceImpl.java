package com.service.impl;

import com.dao.TbCollectionDao;
import com.pojo.TbCollection;
import com.service.CollectionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class CollectionServiceImpl implements CollectionService {

    @Resource
    private TbCollectionDao tbCollectionDao;

    @Override
    public boolean insertCollection(String uid, Integer topicId) {
        TbCollection tbCollection = new TbCollection();
        tbCollection.setTopicId(topicId);
        tbCollection.setUserId(uid);
        return tbCollectionDao.insert(tbCollection) == 1;
    }

    @Override
    public boolean deleteCollection(String uid, Integer topicId, Integer deleteFlag) {
        return tbCollectionDao.updateCollection(uid, topicId, deleteFlag) == 1;
    }

    @Override
    public Integer checkCollection(String uid, Integer topicId) {
        Integer flag =  tbCollectionDao.checkCollection(uid, topicId);
        if (flag == null) {
            return -1;
        } else {
           return flag;
        }
    }
}
