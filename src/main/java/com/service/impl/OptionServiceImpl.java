package com.service.impl;

import com.service.OptionService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.pojo.TbOption;
import com.dao.TbOptionDao;

/**
 * @author 疯自
 */
@Service
public class OptionServiceImpl implements OptionService {

    @Resource
    private TbOptionDao tbOptionDao;

}
