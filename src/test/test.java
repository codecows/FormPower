import app.Application;
import app.dao.complex.DemoEntity;
import app.dao.complex.DemoMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class test {
    @Resource
    private DemoMapper demoMapper;

    @Test
    public void test1() {
        List<DemoEntity> userInfos = demoMapper.getUserInfos();
        assert userInfos.size() > 0 : "集合size应该大于0";
    }
}
