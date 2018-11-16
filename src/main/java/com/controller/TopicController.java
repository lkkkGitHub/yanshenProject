package com.controller;

import com.pojo.TbTopic;
import com.pojo.TbUser;
import com.service.TopicService;
import com.tools.pojoexpansion.UserDidTopicUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import static java.lang.String.valueOf;

/**
 * @author lk
 * 2018/11/5 14:56
 * @description:
 */
@Controller
@RequestMapping("/topic")
public class TopicController {

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
     * @return 答题页面
     */
    @RequestMapping("/getTopicToExercise")
    public String getTopicToExercise(int topicNum, String topicType, int[] classifyIds, HttpSession session) {
        if (classifyIds == null) {
            classifyIds = new int[1];
            classifyIds[0] = 1;
        }
        TbUser user = (TbUser) session.getAttribute("user");
        UserDidTopicUtil userDidTopicUtil = (UserDidTopicUtil) session.getAttribute("UserDidTopicUtil");
        LinkedList<TbTopic> list = topicServiceImpl.getTopicToExercise(topicNum, topicType,
                userDidTopicUtil.getMap(), classifyIds, user.getUid());
        List<TbTopic> topicList = new ArrayList<>(list);
        session.setAttribute("topicList", topicList);
        return "answer";
    }

    /**
     * 根据传入的下一题题目编号，返回下一题的题目具体信息；
     * 根据传入的选项id，缓存用户当前题目所选的选项id
     * 想加一个未做完的题目，继续上一次题目的信息，加入redis缓存中，将用户的id作为键
     *
     * @param session 获取存在session中的数值
     * @param sequence 当前题目的id
     * @param sequenceNext 下一题需要显示的题目id -1时表示第一次加载题目信息
     * @param optionId 当前题目选中的选项id  -1时表示用户未填写答案
     * @return 下一题
     */
    @ResponseBody
    @RequestMapping("/getTopicPagination")
    public TbTopic getTopicPagination(HttpSession session, int sequence,
                                      int sequenceNext, int optionId) {
        List<TbTopic> topicList = (ArrayList<TbTopic>) session.getAttribute("topicList");
        if (optionId != -1) {
            if (topicList.get(sequence).getOptionId() == null || topicList.get(sequence).getOptionId() != optionId) {
                topicList.get(sequence).setOptionId(optionId);
                session.setAttribute("topicList", topicList);
            }
        }
        if (sequenceNext == -1) {
            return topicList.get(sequence);
        } else {
            return topicList.get(sequenceNext);
        }
    }
}
