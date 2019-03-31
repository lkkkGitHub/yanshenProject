package com.service.impl;

import com.dao.TbClassifyDao;
import com.pojo.TbClassify;
import com.service.ClassifyService;
import com.tools.finaltools.ClassifyFinalTool;
import com.tools.utils.JsonUtils;
import com.tools.utils.jedis.JedisClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author lk
 * 2018/10/29 10:37
 * @description:
 */
@Service
public class ClassifyServiceImpl implements ClassifyService {

    @Autowired
    private TbClassifyDao tbClassifyDao;

    @Autowired
    private JedisClient jedisClient;

    @Override
    public List<TbClassify> allClassify() {
        String classifyRedis = jedisClient.hget(ClassifyFinalTool.CLASSIFY,
                ClassifyFinalTool.COMMENT);
        List<TbClassify> list;
        if (classifyRedis != null && !classifyRedis.isEmpty()) {
            list = JsonUtils.jsonToList(classifyRedis, TbClassify.class);
        } else {
            list = tbClassifyDao.allClassify();
            jedisClient.hset(ClassifyFinalTool.CLASSIFY, ClassifyFinalTool.COMMENT, JsonUtils.objectToJson(list));
        }
        return list;
    }
}
