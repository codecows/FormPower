package app.dao.complex;

import app.dao.entities.SysUser;
import app.dao.entities.TestDept;
import app.dao.entities.TestMenus;
import app.dao.entities.TestUsers;

import java.util.List;

public class DemoEntity extends TestUsers{
    private TestDept testDept ;
    private List<TestMenus> testMenus;

    public TestDept getTestDept() {
        return testDept;
    }

    public void setTestDept(TestDept testDept) {
        this.testDept = testDept;
    }

    public List<TestMenus> getTestMenus() {
        return testMenus;
    }

    public void setTestMenus(List<TestMenus> testMenus) {
        this.testMenus = testMenus;
    }
}
