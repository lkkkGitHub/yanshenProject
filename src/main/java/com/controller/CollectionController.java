package com.controller;

import com.pojo.TbUser;
import com.service.CollectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * @author lk
 * 2018/11/30 15:33
 */
@Controller
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
    @ResponseBody
    @RequestMapping("/insertCollection")
    public boolean insertCollection(HttpSession session, Integer topicId,
                                    @RequestParam(required = false) Integer deleteFlag, Integer flag) {
        if (flag == 0) {
            return collectionServiceImpl.insertCollection(((TbUser) session.getAttribute("user")).getUid()
                    , topicId);
        } else {
            return collectionServiceImpl.deleteCollection(((TbUser) session.getAttribute("user")).getUid()
                    , topicId, deleteFlag);
        }
    }

    /**
     * 在查询是否关注的时候，不返回true false，返回deleteFlag和null，有数据就返回deleteFlag区分是否收藏
     * 收藏取消收藏，即更新数据库字段
     * 没有数据返回null，表示没有收藏，插入收藏，
     */

    /**
     * 检查用户是否之前关注了该题目，以及是否关注
     * @param session 获取用户id
     * @param topicId 题目id
     * @return 之前已经关注，0 表示已经收藏， 1 表示没有收藏 ；没有关注返回-1
     */
    @ResponseBody
    @RequestMapping("/checkCollection")
    public Integer checkCollection(HttpSession session, Integer topicId) {
        return collectionServiceImpl.checkCollection(((TbUser) session.getAttribute("user")).getUid()
                    , topicId);
    }

}
