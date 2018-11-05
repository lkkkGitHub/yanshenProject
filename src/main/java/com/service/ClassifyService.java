package com.service;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.pojo.TbClassify;
import com.dao.TbClassifyDao;

/**
 * @author 疯自
 */
@Service
public interface ClassifyService {

    /**
     * 显示所有类别信息
     * 并加入redis进行缓存管理
     * @return 所有的类别信息，以及id
     */
    List<TbClassify> allClassify();
}
