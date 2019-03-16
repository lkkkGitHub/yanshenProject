package com.tools.finaltools;

/**
 * @author leike
 * @date 2019/3/13 21:47
 */
public class ReplyFinalTool {

    /**
     * redis key 前缀 回复的list集合
     */
    public static final String REPLY_LIST = "REPLY_LIST";

    /**
     * redis kye 回复的hset总key
     */
    public static final String REPLY = "REPLY";

    /**
     * 已读
     */
    public static final Integer IS_READ = 1;

    /**
     * 未读
     */
    public static final Integer NO_READ = 0;
}
