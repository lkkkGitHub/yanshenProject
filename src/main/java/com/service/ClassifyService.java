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

    List<TbClassify> allClassify();
}
