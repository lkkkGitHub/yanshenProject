package com.service;

import com.tools.pojoexpansion.UserDidTopicUtil;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.pojo.TbDidtopic;
import com.dao.TbDidtopicDao;

/**
 * @author 疯自
 */
public interface DidtopicService {

    /**
     * 查询用户所有做过的题目
     * @param userId
     * @return
     */
    UserDidTopicUtil findDidTopicByUserId(String userId);
}
