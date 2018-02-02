package app.temp.controller;

//
//@RestController
//@RequestMapping("temp/user")
//public class UserTempController {
//    @RequestMapping(path = "getUsers", method = GET)
//   public UserPojo getUserPojos(String userId) {
//        //TODO 部门与公司 是同一张表 通过编码长度来区别
//        //TODO 01 铸锻集团
//        //TODO 0101 销售公司
//        //TODO 0101009  信息部
//        DeptPojo deptPojo = new DeptPojo();
//        deptPojo.setDeptId("01010090001");
//        deptPojo.setDeptName("信息部");
//        deptPojo.setParId("0101");
//        deptPojo.setStatus("Y");
//        //TODO 与部门同理
//        //TODO 01 集团CEO
//        //TODO 0101 销售公司总经理
//        //TODO 0101009  销售公司信息总监
//        RolePojo rolePojo = new RolePojo();
//        rolePojo.setRoleId("0101009");
//        rolePojo.setRoleName("信息总监");
//        rolePojo.setParId("0101");
//        rolePojo.setStatus("Y");
//
//        List<MenuSystemPojo> roleScenes=new ArrayList<>();
//        MenuSystemPojo menuScenePojo1= new MenuSystemPojo();
//        MenuSystemPojo menuScenePojo2 = new MenuSystemPojo();
//        List<MenuGroupPojo> menuGroups1 = new ArrayList<>();
//        List<MenuGroupPojo> menuGroups2 = new ArrayList<>();
//        MenuGroupPojo menuGroupPojo1 = new MenuGroupPojo();
//        MenuGroupPojo menuGroupPojo2 = new MenuGroupPojo();
//        MenuGroupPojo menuGroupPojo3 = new MenuGroupPojo();
//        MenuGroupPojo menuGroupPojo4 = new MenuGroupPojo();
//        menuGroups1.add(menuGroupPojo1);
//        menuGroups1.add(menuGroupPojo2);
//        menuGroups2.add(menuGroupPojo3);
//        menuGroups2.add(menuGroupPojo4);
//
//        List<MenuItemPojo> menuPojos1 = new ArrayList<>();
//        List<MenuItemPojo> menuPojos2 = new ArrayList<>();
//
//
//
//        List<RolePojo> rolePojos = new ArrayList<>();
//
//        MenuItemPojo menuPojo1 = new MenuItemPojo();
//        MenuItemPojo menuPojo2 = new MenuItemPojo();
//        MenuItemPojo menuPojo3 = new MenuItemPojo();
//        MenuItemPojo menuPojo4 = new MenuItemPojo();
//
//        menuPojos1.add(menuPojo1);
//        menuPojos1.add(menuPojo2);
//        menuPojos2.add(menuPojo3);
//        menuPojos2.add(menuPojo4);
//
//        menuScenePojo1.setSceneId("01");
//        menuScenePojo1.setSceneName("基础系统");
//        menuScenePojo1.setStatus("Y");
//
//        menuGroups1.add(menuGroupPojo1);
//        menuGroups1.add(menuGroupPojo2);
//        menuScenePojo1.setMenuGroups(menuGroups1);
//
//        menuScenePojo2.setSceneId("02");
//        menuScenePojo2.setSceneName("表单系统");
//        menuScenePojo2.setStatus("Y");
//
//        menuGroups2.add(menuGroupPojo3);
//        menuGroups2.add(menuGroupPojo4);
//
//        roleScenes.add(menuScenePojo1);
//        roleScenes.add(menuScenePojo2);
//        rolePojo.setMenuScenePojos(roleScenes);
//
//        menuGroupPojo1.setGroupId("001");
//        menuGroupPojo1.setGroupName("系统设置");
//        menuGroupPojo1.setStatus("Y");
//        menuGroupPojo1.setMenus(menuPojos1);
//        menuGroupPojo2.setGroupId("002");
//        menuGroupPojo2.setGroupName("XX设置");
//        menuGroupPojo2.setStatus("Y");
//        menuGroupPojo2.setMenus(menuPojos2);
//
//
//        menuPojo1.setMenuId("1001");
//        menuPojo1.setMenuName("用户");
//        menuPojo1.setStatus("Y");
//        menuPojo1.setMenuType("3");
//        menuPojo1.setUrl("sys/user");
//        menuPojo1.setGroupId(menuGroupPojo1.getGroupId());
//        menuPojo1.setGroupName(menuGroupPojo1.getGroupName());
//        menuPojo1.setSystemId(menuScenePojo1.getSceneId());
//        menuPojo1.setSystemName(menuScenePojo1.getSceneName());
//
//        menuPojo2.setMenuId("1002");
//        menuPojo2.setMenuName("部门");
//        menuPojo2.setStatus("Y");
//        menuPojo2.setMenuType("3");
//        menuPojo2.setUrl("sys/dept");
//        menuPojo2.setGroupId(menuGroupPojo1.getGroupId());
//        menuPojo2.setGroupName(menuGroupPojo1.getGroupName());
//        menuPojo2.setSystemId(menuScenePojo1.getSceneId());
//        menuPojo2.setSystemName(menuScenePojo1.getSceneName());
//
//
//        menuPojo3.setMenuId("1003");
//        menuPojo3.setMenuName("表单定义");
//        menuPojo3.setStatus("Y");
//        menuPojo3.setMenuType("3");
//        menuPojo3.setUrl("sys/form");
//        menuPojo3.setGroupId(menuGroupPojo3.getGroupId());
//        menuPojo3.setGroupName(menuGroupPojo3.getGroupName());
//        menuPojo3.setSystemId(menuScenePojo2.getSceneId());
//        menuPojo3.setSystemName(menuScenePojo2.getSceneName());
//
//        menuPojo4.setMenuId("1004");
//        menuPojo4.setMenuName("表单设计");
//        menuPojo4.setStatus("Y");
//        menuPojo4.setMenuType("S");
//        menuPojo4.setUrl("sys/dept");
//        menuPojo4.setGroupId(menuGroupPojo3.getGroupId());
//        menuPojo4.setGroupName(menuGroupPojo3.getGroupName());
//        menuPojo4.setSystemId(menuScenePojo2.getSceneId());
//        menuPojo4.setSystemName(menuScenePojo2.getSceneName());
//
//
//        rolePojos.add(rolePojo);
//
//        UserPojo userPojo = new UserPojo();
//
//        userPojo.setUserId("10000");
//        userPojo.setUserName("zhangsansan");
//        userPojo.setPersionName("张三三");
//        userPojo.setDeptPojo(deptPojo);
//        userPojo.setRolePojos(rolePojos);
//        userPojo.setStatus("Y");
//        userPojo.setMobile("13940001001");
//        userPojo.setEmail("zhuye0213@126.com");
//        userPojo.setRemark("他很懒什么都没写,这是系统帮他写的");
//        //TODO 你看看生成的JSON数据吧
//        //TODO 六哥你保重~
//        return userPojo;
//    }
//}
