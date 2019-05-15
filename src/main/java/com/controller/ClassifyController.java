package com.controller;

import com.pojo.TbClassify;
import com.service.ClassifyService;
import com.tools.utils.JsonUtils;
import com.tools.utils.jedis.JedisClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author lk
 * 2018/10/29 10:38
 * @description:
 *
 */
@Controller
@RequestMapping("/classify")
public class ClassifyController {

    /**
     * 类别serviceImpl
     */
    @Autowired
    private ClassifyService classifyServiceImpl;

    /**
     * 获取所有的类别信息
     *
     * @return 返回json数据的所有类别信息
     */
    @ResponseBody
    @RequestMapping("/getAllClassify")
    public List<TbClassify> getAllClassify() {
        return classifyServiceImpl.allClassify();
    }
}
