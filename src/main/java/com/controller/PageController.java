package com.controller;

import com.tools.finaltools.PagerFinalTool;
import com.tools.finaltools.TopicFinalTool;
import com.tools.finaltools.UserFinalTool;
import com.tools.utils.jedis.JedisClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;


/**
 * @author lk
 * 2018/10/24 11:53
 * @description: 进行jsp页面跳转
 */
@Controller
public class PageController {

    @Autowired
    private JedisClient jedisClient;

    /**
     * 检查用户是否存在未完成的题目
     *
     * @param page
     * @param session
     * @return
     */
    @RequestMapping("/{page}")
    public String page(@PathVariable(value = "page") String page, HttpSession session) {
        if ((PagerFinalTool.HOME).equals(page)) {
            String notDoneTopic = jedisClient.hget(TopicFinalTool.NOTDONE_TOPIC, (String) session.getAttribute(UserFinalTool.USER_NAME));
            if (notDoneTopic !=null){
                session.setAttribute(TopicFinalTool.NOTDONE_TOPIC, "1");
            }
        }
        return page;
    }

    @RequestMapping("/")
    public String pageLogin() {
        return "index";
    }
}
