import app.Application;
import app.dao.complex.DemoEntity;
import app.dao.complex.DemoMapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
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
        DemoEntity userInfo = demoMapper.getUserInfo("001");
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            String s = objectMapper.writeValueAsString(userInfo);
            System.out.println(s);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        assert userInfo != null : "集合size应该大于0";
    }
}
