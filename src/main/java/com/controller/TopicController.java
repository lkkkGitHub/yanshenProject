package com.controller;

import com.pojo.TbTopic;
import com.pojo.TbUser;
import com.service.TopicService;
import com.tools.pojoexpansion.UserDidTopicUtil;
import com.tools.utils.JsonUtils;
import com.tools.utils.jedis.JedisClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.LinkedList;
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
    private JedisClient jedisClient;

    /**
     *
     */
    @Autowired
    private TopicService topicServiceImpl;


    /**
     * 查询所有类别的题目总数
     *
     * @return
     */
    @ResponseBody
    @RequestMapping("/getTopicNumAllClassify")
    public Map<Integer, Integer> getTopicNumAllClassify() {
        return topicServiceImpl.selectTopicNumAllClassify();
    }

    /**
     * 根据用户选择，分方法，个数，类别等获取题目信息
     *
     * @param topicNum    生成题目数量
     * @param topicType   题目的生成类型，随机，专项，错题
     * @param classifyIds 题目类型，可以传入一个数组，根据多个类型生成题目
     * @param session     获取用户信息
     * @param request     向页面输出题目数量为 0 的信息
     * @return 答题页面
     */
    @RequestMapping("/getTopicToExercise")
    public String getTopicToExercise(int topicNum, String topicType, int[] classifyIds,
                                     HttpSession session, HttpServletRequest request) {
        if (classifyIds == null) {
            classifyIds = new int[1];
            classifyIds[0] = 1;
        }
        TbUser user = (TbUser) session.getAttribute("user");
        UserDidTopicUtil userDidTopicUtil =
                JsonUtils.jsonToPojo(jedisClient.hget("UserDidTopicUtil",
                        (String) session.getAttribute("username")), UserDidTopicUtil.class);
        LinkedList<TbTopic> list = topicServiceImpl.getTopicToExercise(topicNum, topicType,
                userDidTopicUtil.getMap(), classifyIds, user.getUid());
        List<TbTopic> topicList = new ArrayList<>(list);
        if (topicList.size() == 0) {
            request.setAttribute("topicNumZeroMessage", "当前分类已经没有题目可以做了，换个类别或者做做错题把");
            return "home";
        } else {
            session.setAttribute("topicType", topicType);
            session.setAttribute("topicList", topicList);
            return "answer";
        }
    }

    /**
     * 根据传入的下一题题目编号，返回下一题的题目具体信息；
     * 根据传入的选项id，缓存用户当前题目所选的选项id
     * 想加一个未做完的题目，继续上一次题目的信息，加入redis缓存中，将用户的id作为键
     *
     * @param session      获取存在session中的数值
     * @param sequence     当前题目的id
     * @param sequenceNext 下一题需要显示的题目id -1时表示第一次加载题目信息
     * @param optionId     当前题目选中的选项id  -1时表示用户未填写答案
     * @return 下一题
     */
    @ResponseBody
    @RequestMapping("/getTopicPagination")
    public TbTopic getTopicPagination(HttpSession session, int sequence,
                                      int sequenceNext, int optionId) {
        String userName = (String) session.getAttribute("username");
        String topicType = (String) session.getAttribute("topicType");
        List<TbTopic> topicList = (ArrayList<TbTopic>) session.getAttribute("topicList");
        if (optionId != -1) {
            if (topicList.get(sequence).getOptionId() == null || topicList.get(sequence).getOptionId() != optionId) {
                topicList.get(sequence).setOptionId(optionId);
                session.setAttribute("topicList", topicList);
                saveNotDoneTopic(userName, topicType, topicList);
            }
        }
        if (sequenceNext == -1) {
            return topicList.get(sequence);
        } else {
            return topicList.get(sequenceNext);
        }
    }

    /**
     * 将用户未做完的题保存到redis中
     *
     * @return 添加成功返回true
     */
    public void saveNotDoneTopic(String userName, String topicType, List<TbTopic> topicList) {
        jedisClient.hset("notDoneTopic", userName, JsonUtils.objectToJson(topicList));
        jedisClient.hset("topicType", userName, topicType);
    }

    /**
     * 从缓存中获取做信息，实现断点续做
     *
     * @param session 设置session中的做题信息
     * @return 返回到回答问题界面
     */
    @RequestMapping("/getNotDoneTopic")
    public String getNotDoneTopic(HttpSession session) {
        String userName = (String) session.getAttribute("username");
        List<TbTopic> topicList = JsonUtils.jsonToList(jedisClient.hget("notDoneTopic", userName), TbTopic.class);
        String topicType = jedisClient.hget("topicType", userName);
        if (topicList != null && topicType != null) {
            session.setAttribute("topicList", topicList);
            session.setAttribute("topicType", topicType);
            session.removeAttribute("notDoneTopic");
            return "answer";
        } else {
            return "home";
        }
    }

    /**
     * 移除做题信息
     *
     * @param session 移除session中的信息
     * @return 返回到home页面
     */
    @RequestMapping("/removeNotDoneTopic")
    public String removeNotDoneTopic(HttpSession session) {
        session.removeAttribute("didTopicList");
        session.removeAttribute("topicType");
        session.removeAttribute("topicList");
        session.removeAttribute("notDoneTopic");
        jedisClient.hdel("notDoneTopic", (String) session.getAttribute("username"));
        jedisClient.hdel("topicType", (String) session.getAttribute("username"));
        return "home";
    }
}
