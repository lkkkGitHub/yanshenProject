package com.controller;

import com.pojo.TbClassify;
import com.service.TopicService;
import com.tools.utils.JsonUtils;
import com.tools.utils.jedis.JedisClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author lk
 * 2018/11/5 14:56
 * @description:
 */
@Controller
@RequestMapping("/topic")
public class TopicController {

    @Autowired
    private TopicService topicServiceImpl;

    @Autowired
    private JedisClient jedisClient;

    @ResponseBody
    @RequestMapping("/getTopicNumAllClassify")
    public Map<Integer, Integer> getTopicNumAllClassify() {
        Integer integer = JsonUtils.jsonToPojo(jedisClient.hget("classifyTopicNum", "1"), Integer.class);
        Map<Integer, Integer> map = null;
        if (integer == null) {
            map = topicServiceImpl.selectTopicNumAllClassify();
            for (Map.Entry<Integer, Integer> entry: map.entrySet()) {
                jedisClient.hset("classifyTopicNum", String.valueOf(entry.getKey()),
                        String.valueOf(entry.getValue()));
            }
        } else {
            map = new HashMap<>(6);
            for (int i = 0; i < 6; i++) {
                map.put(i + 1, JsonUtils.jsonToPojo(
                        jedisClient.hget("classifyTopicNum", String.valueOf(i + 1)), Integer.class));
            }
        }
        return map;
    }
}
