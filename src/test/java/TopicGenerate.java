
import com.pojo.TbOption;

import java.util.ArrayList;

import com.dao.TbOptionDao;
import com.dao.TbTopicDao;
import com.pojo.TbClassify;
import com.pojo.TbTopic;
import com.service.ClassifyService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author leike
 * @date 2019/3/31 20:41
 */
public class TopicGenerate extends TestUtils {

    @Autowired
    private ClassifyService classifyServiceImpl;

    @Autowired
    private TbTopicDao tbTopicDao;

    @Autowired
    private TbOptionDao tbOptionDao;

    @Test
    public void generate() {
        List<TbClassify> classifyList = classifyServiceImpl.allClassify();
        TbTopic tbTopic = new TbTopic();
        TbOption tbOption = new TbOption();
        String head;
        for (TbClassify tbClassify : classifyList) {
            head = tbClassify.getClassifyName();
            for (int i = 0; i < 50; i++) {
                tbTopic.setAnalysis(getString(head, 1, i, null));
                tbTopic.setTopicComment(getString(head, 2, i, null));
                tbTopic.setClassifyId(tbClassify.getClassifyId());
                tbTopicDao.insertSelective(tbTopic);
                for (int j = 0; j < 4; j++) {
                    if (j == 3) {
                        tbOption.setCorrect(1);
                    } else {
                        tbOption.setCorrect(0);
                    }
                    tbOption.setOptionComment(getString(head, 3, i, j));
                    tbOption.setTopicId(tbTopic.getTopicId());
                    tbOptionDao.insertSelective(tbOption);
                }
                tbTopic.setTopicId(null);
            }
        }
    }

    private String getString(String head, Integer type, Integer i, Integer j) {
        StringBuffer buffer = new StringBuffer(head);
        if (type.equals(1)) {
            buffer.append(" ").append(i + 1).append(" topic analysis");
        } else if (type.equals(2)) {
            buffer.append(" ").append(i + 1).append(" topic comment");
        } else {
            buffer.append(" ").append(i + 1).append(" option comment ").append(j + 1);
        }
        return buffer.toString();
    }
}
