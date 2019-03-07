package com.tools.utils.websocket.controller;


import com.pojo.TbUser;
import com.tools.utils.websocket.entity.Message;
import com.tools.utils.websocket.websocket.MyWebSocketHandler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.socket.TextMessage;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Date;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

@Controller
@RequestMapping("/msg")
public class MsgController {

    @Autowired
    MyWebSocketHandler handler;

    private ConcurrentMap<String, TbUser> users = new ConcurrentHashMap<>();

    // 模拟一些数据
    @ModelAttribute
    public void setReqAndRes() {
        TbUser u1 = new TbUser();
        u1.setUid("5a7f9026662b402bb5cd1063078dfe78");
        u1.setUname("lkkk12");
        users.put(u1.getUid(), u1);

        TbUser u2 = new TbUser();
        u2.setUid("56c5d3e5e3d143cbaaadd3f3dadb48d3");
        u2.setUname("lkk123");
        users.put(u2.getUid(), u2);

    }

    // 用户登录
    @RequestMapping(value = "login", method = RequestMethod.POST)
    public ModelAndView doLogin(TbUser user, HttpServletRequest request) {
        request.getSession().setAttribute("uid", user.getUid());
        request.getSession().setAttribute("name", users.get(user.getUid()).getUname());
        return new ModelAndView("redirect:talk");
    }

    // 跳转到交谈聊天页面
    @RequestMapping(value = "talk", method = RequestMethod.GET)
    public ModelAndView talk() {
        return new ModelAndView("talk");
    }

    // 跳转到发布广播页面
    @RequestMapping(value = "broadcast", method = RequestMethod.GET)
    public ModelAndView broadcast() {
        return new ModelAndView("broadcast");
    }

//    // 发布系统广播（群发）
//    @ResponseBody
//    @RequestMapping(value = "broadcast", method = RequestMethod.POST)
//    public void broadcast(String text) throws IOException {
//        Message msg = new Message();
//        msg.setDate(new Date());
//        msg.setFrom(-1L);
//        msg.setFromName("系统广播");
//        msg.setTo(0L);
//        msg.setText(text);
//        handler.broadcast(new TextMessage(new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create().toJson(msg)));
//    }
//
//    // 发布系统广播（群发）
//    @ResponseBody
//    @RequestMapping(value = "test", method = RequestMethod.GET)
//    public void test(@RequestParam("text") String text) throws IOException {
//        Message msg = new Message();
//        msg.setDate(new Date());
//        msg.setFrom(-1L);
//        msg.setFromName("系统广播");
//        msg.setTo(0L);
//        msg.setText(text);
//
//        String output = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create().toJson(msg);
//        System.out.println("output:" + output);
//        handler.broadcast(new TextMessage(output));
//    }

}
