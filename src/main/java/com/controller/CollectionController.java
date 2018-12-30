package com.controller;

import com.pojo.TbUser;
import com.service.CollectionService;
import com.tools.finaltools.UserFinalTool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * @author lk
 * 2018/11/30 15:33
 */
@RestController
@RequestMapping("/collection")
public class CollectionController {

    @Autowired
    private CollectionService collectionServiceImpl;

    /**
     * 收藏和取消收藏（逻辑删除）
     *
     * @param session    获取用户信息id
     * @param topicId    题目id
     * @param deleteFlag 0表示取消收藏，1表示收藏
     * @param flag       判断用户之前是否已经收藏过该题目，收藏过即返回 1 ，直接对数据库数据进行更新
     *                   没有收藏过即添加数据 0
     * @return 是否操作成功
     */
    @RequestMapping("/insertCollection")
    public boolean insertCollection(HttpSession session, Integer topicId,
                                    @RequestParam(required = false) Integer deleteFlag, Integer flag) {
        String uid = ((TbUser) session.getAttribute(UserFinalTool.USER)).getUid();
        if (flag == 0) {
            return collectionServiceImpl.insertCollection(uid, topicId);
        } else {
            return collectionServiceImpl.deleteCollection(uid, topicId, deleteFlag);
        }
    }

    /**
     * 检查用户是否之前关注了该题目，以及是否关注
     *
     * @param session 获取用户id
     * @param topicId 题目id
     * @return 之前已经关注，0 表示已经收藏， 1 表示没有收藏 ；没有关注返回-1
     */
    @RequestMapping("/checkCollection")
    public Integer checkCollection(HttpSession session, Integer topicId) {
        return collectionServiceImpl.checkCollection(((TbUser) session.getAttribute(UserFinalTool.USER)).getUid()
                , topicId);
    }

    /**
     * 获取用户收藏的题目个数
     *
     * @param session 获取用户信息
     * @return 收藏题目的个数
     */
    @RequestMapping("/getNum")
    public Integer getCollectionNum(HttpSession session) {
        return collectionServiceImpl.getCollectionNum(
                ((TbUser) session.getAttribute(UserFinalTool.USER)).getUid());
    }

}
