package app.temp.controller;

import app.temp.pojo.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
@RequestMapping("temp/user")
public class UserTempController {
    @RequestMapping(path = "getUsers", method = GET)
   public UserPojo getUserPojos(String userId) {
        //TODO 部门与公司 是同一张表 通过编码长度来区别
        //TODO 01 铸锻集团
        //TODO 0101 销售公司
        //TODO 0101009  信息部
        DeptPojo deptPojo = new DeptPojo();
        deptPojo.setDeptId("01010090001");
        deptPojo.setDeptName("信息部");
        deptPojo.setParId("0101");
        deptPojo.setStatus("Y");
        //TODO 与部门同理
        //TODO 01 集团CEO
        //TODO 0101 销售公司总经理
        //TODO 0101009  销售公司信息总监
        RolePojo rolePojo = new RolePojo();
        rolePojo.setRoleId("0101009");
        rolePojo.setRoleName("信息总监");
        rolePojo.setParId("0101");
        rolePojo.setStatus("Y");

        List<MenuScenePojo> roleScenes=new ArrayList<>();
        MenuScenePojo menuScenePojo1= new MenuScenePojo();
        MenuScenePojo menuScenePojo2 = new MenuScenePojo();
        List<MenuGroupPojo> menuGroups1 = new ArrayList<>();
        List<MenuGroupPojo> menuGroups2 = new ArrayList<>();
        MenuGroupPojo menuGroupPojo1 = new MenuGroupPojo();
        MenuGroupPojo menuGroupPojo2 = new MenuGroupPojo();
        MenuGroupPojo menuGroupPojo3 = new MenuGroupPojo();
        MenuGroupPojo menuGroupPojo4 = new MenuGroupPojo();
        menuGroups1.add(menuGroupPojo1);
        menuGroups1.add(menuGroupPojo2);
        menuGroups2.add(menuGroupPojo3);
        menuGroups2.add(menuGroupPojo4);

        List<MenuPojo> menuPojos1 = new ArrayList<>();
        List<MenuPojo> menuPojos2 = new ArrayList<>();



        List<RolePojo> rolePojos = new ArrayList<>();

        MenuPojo menuPojo1 = new MenuPojo();
        MenuPojo menuPojo2 = new MenuPojo();
        MenuPojo menuPojo3 = new MenuPojo();
        MenuPojo menuPojo4 = new MenuPojo();

        menuPojos1.add(menuPojo1);
        menuPojos1.add(menuPojo2);
        menuPojos2.add(menuPojo3);
        menuPojos2.add(menuPojo4);

        menuScenePojo1.setSceneId("01");
        menuScenePojo1.setSceneName("基础系统");
        menuScenePojo1.setStatus("Y");

        menuGroups1.add(menuGroupPojo1);
        menuGroups1.add(menuGroupPojo2);
        menuScenePojo1.setMenuGroups(menuGroups1);

        menuScenePojo2.setSceneId("02");
        menuScenePojo2.setSceneName("表单系统");
        menuScenePojo2.setStatus("Y");

        menuGroups2.add(menuGroupPojo3);
        menuGroups2.add(menuGroupPojo4);

        roleScenes.add(menuScenePojo1);
        roleScenes.add(menuScenePojo2);
        rolePojo.setMenuScenePojos(roleScenes);

        menuGroupPojo1.setGroupId("001");
        menuGroupPojo1.setGroupName("系统设置");
        menuGroupPojo1.setStatus("Y");
        menuGroupPojo1.setMenus(menuPojos1);
        menuGroupPojo2.setGroupId("002");
        menuGroupPojo2.setGroupName("XX设置");
        menuGroupPojo2.setStatus("Y");
        menuGroupPojo2.setMenus(menuPojos2);


        menuPojo1.setMenuId("1001");
        menuPojo1.setMenuName("用户");
        menuPojo1.setStatus("Y");
        menuPojo1.setMenuType("3");
        menuPojo1.setUrl("sys/user");
        menuPojo1.setGroupId(menuGroupPojo1.getGroupId());
        menuPojo1.setGroupName(menuGroupPojo1.getGroupName());
        menuPojo1.setSceneId(menuScenePojo1.getSceneId());
        menuPojo1.setSceneName(menuScenePojo1.getSceneName());

        menuPojo2.setMenuId("1002");
        menuPojo2.setMenuName("部门");
        menuPojo2.setStatus("Y");
        menuPojo2.setMenuType("3");
        menuPojo2.setUrl("sys/dept");
        menuPojo2.setGroupId(menuGroupPojo1.getGroupId());
        menuPojo2.setGroupName(menuGroupPojo1.getGroupName());
        menuPojo2.setSceneId(menuScenePojo1.getSceneId());
        menuPojo2.setSceneName(menuScenePojo1.getSceneName());


        menuPojo3.setMenuId("1003");
        menuPojo3.setMenuName("表单定义");
        menuPojo3.setStatus("Y");
        menuPojo3.setMenuType("3");
        menuPojo3.setUrl("sys/form");
        menuPojo3.setGroupId(menuGroupPojo3.getGroupId());
        menuPojo3.setGroupName(menuGroupPojo3.getGroupName());
        menuPojo3.setSceneId(menuScenePojo2.getSceneId());
        menuPojo3.setSceneName(menuScenePojo2.getSceneName());

        menuPojo4.setMenuId("1004");
        menuPojo4.setMenuName("表单设计");
        menuPojo4.setStatus("Y");
        menuPojo4.setMenuType("S");
        menuPojo4.setUrl("sys/dept");
        menuPojo4.setGroupId(menuGroupPojo3.getGroupId());
        menuPojo4.setGroupName(menuGroupPojo3.getGroupName());
        menuPojo4.setSceneId(menuScenePojo2.getSceneId());
        menuPojo4.setSceneName(menuScenePojo2.getSceneName());


        rolePojos.add(rolePojo);

        UserPojo userPojo = new UserPojo();

        userPojo.setUserId("10000");
        userPojo.setUserName("zhangsansan");
        userPojo.setPersionName("张三三");
        userPojo.setDeptPojo(deptPojo);
        userPojo.setRolePojos(rolePojos);
        userPojo.setStatus("Y");
        userPojo.setMobile("13940001001");
        userPojo.setEmail("zhuye0213@126.com");
        userPojo.setRemark("他很懒什么都没写,这是系统帮他写的");
        //TODO 你看看生成的JSON数据吧
        //TODO 六哥你保重~
        return userPojo;
    }
}
