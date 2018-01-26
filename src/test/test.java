import app.Application;
import app.dao.entities.TestDept;
import app.dao.mappers.TestDeptMapper;
import org.junit.Assert;
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
    private TestDeptMapper testDeptMapper;

    @Test
    public void test1() {
        List<TestDept> testDepts = testDeptMapper.selectByExample(null);
        assert testDepts.size() < 0 : "集合size应该大于0";
    }
}
