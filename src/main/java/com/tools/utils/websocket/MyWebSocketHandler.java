package com.tools.utils.websocket;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;

import javax.servlet.http.HttpSession;
import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;


/**
 * webSocket
 *
 * @author leike
 * @date 2019-03-07
 */
@ServerEndpoint(value = "/websocket", configurator = GetHttpSessionConfigurator.class)
@Component
@EnableWebSocketMessageBroker
public class MyWebSocketHandler {


    private static ConcurrentHashMap<String, Session> sessionMap = new ConcurrentHashMap<>();

    private static HttpSession httpSession;

    @OnOpen
    public void onOpen(Session session, EndpointConfig config) {
        httpSession = (HttpSession) config.getUserProperties().get(HttpSession.class.getName());
        sessionMap.put((String) httpSession.getAttribute("uid"), session);
        Set<Map.Entry<String, Session>> set = sessionMap.entrySet();
        System.out.println("在线人数：" + set.size());
        sendMessageToAll("系统提示：", httpSession.getAttribute("uid") + "上线啦！");
    }

    /**
     * 消息处理类，处理前端发来的消息
     *
     * @param msg
     * @return
     */
    public static HashMap<String, String> getMessage(String msg) {
        HashMap<String, String> map = new HashMap<String, String>();
        String msgString = msg.toString();
        String m[] = msgString.split(",");
        map.put("toName", m[1]);
        map.put("content", m[2]);
        return map;
    }

    /**
     * 发送信息给指定用户
     *
     * @param
     * @param message
     * @return
     */
    public boolean sendMessageToUser(String uid, String message) {
        javax.websocket.Session session = sessionMap.get(uid);
        System.out.println("sendMessageTo:" + session);
        if (!session.isOpen()) {
            return false;
        }
        try {
            session.getBasicRemote().sendText(message);
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    /**
     * 广播给所有人
     *
     * @param message
     */
    public static void sendMessageToAll(String fromName, String message) {
        Set<Map.Entry<String, Session>> set = sessionMap.entrySet();
        System.out.println("在线人数：" + set.size());
        for (Map.Entry<String, Session> i : set) {
            try {
                i.getValue().getBasicRemote().sendText(fromName + ":" + message);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @OnClose
    public void onClose(Session session, CloseReason closeReason) {
        sessionMap.remove(session.getId());
        Set<Map.Entry<String, Session>> set = sessionMap.entrySet();
        System.out.println("游客" + session.getId() + "退出");
        System.out.println("在线人数：" + set.size());
        sendMessageToAll("系统提示：", "游客" + session.getId() + "退出");
    }

    @OnError
    public void error(Session session, java.lang.Throwable throwable) {
        sessionMap.remove(session.getId());
        System.err.println("session " + session.getId() + " error:" + throwable);
    }

}
