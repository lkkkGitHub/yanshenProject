package com.tools.utils;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;


/**
 * @author lk
 * 2018/9/7 8:37
 * @description: 通过邮箱发送验证码，同时向后台返回验证码
 */
public class SendEmail {

    /**
     * 生成随机验证码
     *
     * @return 验证码
     */
    public static String achieveCode() {
        String[] beforeShuffle = new String[]{"2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F",
                "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "a",
                "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v",
                "w", "x", "y", "z"};
        List<String> list = Arrays.asList(beforeShuffle);
        Collections.shuffle(list);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i));
        }
        String afterShuffle = sb.toString();
        String result = afterShuffle.substring(3, 9);
        return result;
    }

    /**
     * 通过邮箱发送验证码，同时返回生成的验证码
     *
     * @param email 接受验证码的邮箱
     * @return 验证码
     */
    public static String sendEamilCode(String email, String sendFlag) {
        HtmlEmail send = new HtmlEmail();
        // 获取随机验证码
        String resultCode = achieveCode();
        try {
            send.setHostName("smtp.qq.com");
            //端口号
            send.setSmtpPort(465);
            //开启SSL加密
            send.setSSLOnConnect(true);
            send.setCharset("utf-8");
            //接收者的QQEamil
            send.addTo(email);
            //第一个参数是发送者的QQEamil   第二个参数是发送者QQ昵称
            send.setFrom("963087276@qq.com", "疯自");
            //第一个参数是发送者的QQEamil   第二个参数是刚刚获取的授权码
            send.setAuthentication("963087276@qq.com", "puuyqttsagdzbcce");
            if ("register".equals(sendFlag)) {
                //Eamil的标题
                send.setSubject("注册u唱");
                //Eamil的内容
                send.setMsg("欢迎注册岩生答题系统，此次注册验证码:   " + resultCode + "   请妥善保管"
                        + "   验证码三分钟内有效，三分钟内不重复发送");
            } else if ("changePassword".equals(sendFlag)) {
                send.setSubject("修改密码");
                send.setMsg("欢迎使用岩生答题系统，您正在修改密码，此次验证码：          " + resultCode + "    请妥善保管"
                        + "   验证码三分钟内有效，三分钟内不重复发送");
            }
            //发送
            send.send();
        } catch (EmailException e) {
            e.printStackTrace();
        }//同等验证码
        return resultCode;
    }

}
