package com.dao;

import com.pojo.TbComment;

/**
 * @author 疯自
 */
public interface TbCommentDao {
    /**
     * 根据题目id，查询题目评论，以及评论的用户信息
     *
     * @param topicId
     * @return
     */
    TbComment findCommentByTopicId(Integer topicId);
}
