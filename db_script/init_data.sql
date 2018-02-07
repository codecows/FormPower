/*==============================================================*/
/* init data                                                    */
/*==============================================================*/

/*==============================================================*/
/* init sys_department                                          */
/*==============================================================*/
truncate table sys_department;

INSERT INTO "sys_department"("department_id", "parent_id", "department_name", "short_name", "department_code", "department_level", "department_type", "remark", "order_num", "status", "create_date") VALUES ('0101', '01', '销售公司', NULL, NULL, '2', 'c', NULL, NULL, 'Y', '2018-01-30');
INSERT INTO "sys_department"("department_id", "parent_id", "department_name", "short_name", "department_code", "department_level", "department_type", "remark", "order_num", "status", "create_date") VALUES ('0101009', '0101', '信息部', NULL, NULL, '3', 'd', NULL, NULL, 'Y', '2018-01-30');
INSERT INTO "sys_department"("department_id", "parent_id", "department_name", "short_name", "department_code", "department_level", "department_type", "remark", "order_num", "status", "create_date") VALUES ('01', '00', '铸锻集团', NULL, NULL, '1', 'g', NULL, NULL, 'Y', '2018-01-30');

/*==============================================================*/
/* init sys_menu                                                */
/*==============================================================*/
truncate table sys_menu;

INSERT INTO "sys_menu"("menu_id", "parent_id", "menu_type", "menu_level", "menu_name", "menu_code", "menu_path", "form_id","menu_url", "remark", "order_num", "status", "create_date") VALUES ('01', '00', 's', '1', '基础系统', NULL, NULL, NULL,NULL, NULL, NULL, 'Y', '2018-01-30');
INSERT INTO "sys_menu"("menu_id", "parent_id", "menu_type", "menu_level", "menu_name", "menu_code", "menu_path", "form_id","menu_url", "remark", "order_num", "status", "create_date") VALUES ('02', '00', 's', '1', '表单系统', NULL, NULL, NULL,NULL, NULL, NULL, 'Y', '2018-01-30');
INSERT INTO "sys_menu"("menu_id", "parent_id", "menu_type", "menu_level", "menu_name", "menu_code", "menu_path", "form_id","menu_url", "remark", "order_num", "status", "create_date") VALUES ('001', '01', 'g', '2', '系统设置', NULL, NULL, NULL,NULL, NULL, NULL, 'Y', '2018-01-30');
INSERT INTO "sys_menu"("menu_id", "parent_id", "menu_type", "menu_level", "menu_name", "menu_code", "menu_path", "form_id","menu_url", "remark", "order_num", "status", "create_date") VALUES ('002', '01', 'g', '2', 'XX设置', NULL, NULL, NULL,NULL, NULL, NULL, 'Y', '2018-01-30');
INSERT INTO "sys_menu"("menu_id", "parent_id", "menu_type", "menu_level", "menu_name", "menu_code", "menu_path", "form_id","menu_url", "remark", "order_num", "status", "create_date") VALUES ('1001', '001', 'm', '3', '用户', NULL, NULL, NULL,'sys/user', NULL, NULL, 'Y', '2018-01-30');
INSERT INTO "sys_menu"("menu_id", "parent_id", "menu_type", "menu_level", "menu_name", "menu_code", "menu_path", "form_id","menu_url", "remark", "order_num", "status", "create_date") VALUES ('1002', '001', 'm', '3', '部门', NULL, NULL, NULL,'sys/dept', NULL, NULL, 'Y', '2018-01-30');
INSERT INTO "sys_menu"("menu_id", "parent_id", "menu_type", "menu_level", "menu_name", "menu_code", "menu_path", "form_id","menu_url", "remark", "order_num", "status", "create_date") VALUES ('1003', '002', 'm', '3', '表单定义', NULL, NULL, NULL,'sys/fdef', NULL, NULL, 'Y', '2018-01-30');
INSERT INTO "sys_menu"("menu_id", "parent_id", "menu_type", "menu_level", "menu_name", "menu_code", "menu_path", "form_id","menu_url", "remark", "order_num", "status", "create_date") VALUES ('1004', '002', 'm', '3', '表单设计', NULL, NULL, NULL,'sys/fdeg', NULL, NULL, 'Y', '2018-01-30');

/*==============================================================*/
/* init sys_role                                                */
/*==============================================================*/
truncate table sys_role;
INSERT INTO "sys_role"("role_id", "parent_id", "role_name", "description", "remark", "order_num", "status", "create_date") VALUES ('01', '00', '集团CEO', NULL, NULL, NULL, 'Y', '2018-01-30');
INSERT INTO "sys_role"("role_id", "parent_id", "role_name", "description", "remark", "order_num", "status", "create_date") VALUES ('0101', '01', '销售公司总经理', NULL, NULL, NULL, 'Y', '2018-01-30');
INSERT INTO "sys_role"("role_id", "parent_id", "role_name", "description", "remark", "order_num", "status", "create_date") VALUES ('0101009', '0101', '销售公司信息总监', NULL, NULL, NULL, 'Y', '2018-01-30');

/*==============================================================*/
/* init sys_user                                                */
/*==============================================================*/
truncate table sys_user;
INSERT INTO "sys_user"("user_id", "user_name", "password", "question", "answer", "persion_name", "persion_sex", "mobile", "telephone", "email", "user_position", "img_url", "remark", "order_num", "status", "create_time") VALUES ('10000', 'zhangsansan', '', NULL, NULL, '张三三', '男', '13940001001', NULL, 'zhuye0213@126.com', NULL, NULL, '他很懒什么都没写,这是系统帮他写的', NULL, 'Y', NULL);


/*==============================================================*/
/* init sys_auth_menu_rel                                                */
/*==============================================================*/
truncate table sys_auth_menu_rel;
INSERT INTO "sys_auth_menu_rel"("guid", "auth_id", "menu_id", "status", "operation_date") VALUES ('7fd702d1-5d90-4366-99b5-45ea07e6e8d3', '4a656945-29a3-4492-a779-3f74b79989a7', '01', 'y', '2018-02-01');
INSERT INTO "sys_auth_menu_rel"("guid", "auth_id", "menu_id", "status", "operation_date") VALUES ('27f74f3e-6ede-4b89-a04d-dae8af190100', 'ceff10c2-5807-432d-b677-00d04772526b', '02', 'y', '2018-02-01');
INSERT INTO "sys_auth_menu_rel"("guid", "auth_id", "menu_id", "status", "operation_date") VALUES ('44c843eb-bdf4-41b1-aa7d-6576a5b501dc', 'fc2edea6-c3a0-4cab-8b0a-994efcdc1270', '001', 'y', '2018-02-01');
INSERT INTO "sys_auth_menu_rel"("guid", "auth_id", "menu_id", "status", "operation_date") VALUES ('88826504-b8d0-475d-89a0-3ad602810183', 'b70b659b-b72d-4c37-ad5f-1bdbede9a51b', '002', 'y', '2018-02-01');
INSERT INTO "sys_auth_menu_rel"("guid", "auth_id", "menu_id", "status", "operation_date") VALUES ('e9e83da4-3261-4498-b353-220edabe1c19', 'c3ca4a1c-d9e3-488d-b8de-99602dee0ed4', '1001', 'y', '2018-02-01');
INSERT INTO "sys_auth_menu_rel"("guid", "auth_id", "menu_id", "status", "operation_date") VALUES ('a9a484a0-2d12-473a-ae78-bb1b677ab5fd', '6a01720e-9c72-4189-81e2-3c562e4cc105', '1002', 'y', '2018-02-01');
INSERT INTO "sys_auth_menu_rel"("guid", "auth_id", "menu_id", "status", "operation_date") VALUES ('3f56b3f7-f6f8-492e-8e7e-7458f8837768', '99498870-68ea-4c6b-8118-3b2c5d355af3', '1003', 'y', '2018-02-01');
INSERT INTO "sys_auth_menu_rel"("guid", "auth_id", "menu_id", "status", "operation_date") VALUES ('28aef366-406f-42be-93ca-f6a4bc0d1a33', '778b11cb-9365-404a-9a74-f2b2c360cf5c', '1004', 'y', '2018-02-01');

/*==============================================================*/
/* init sys_authority                                                */
/*==============================================================*/
truncate table sys_authority;

INSERT INTO "sys_authority"("auth_id", "parent_id", "authority_name", "descripthon", "remark", "order_num", "status", "create_date") VALUES ('4a656945-29a3-4492-a779-3f74b79989a7', NULL, '基础系统权限', NULL, NULL, NULL, 'Y', '2018-02-01');
INSERT INTO "sys_authority"("auth_id", "parent_id", "authority_name", "descripthon", "remark", "order_num", "status", "create_date") VALUES ('ceff10c2-5807-432d-b677-00d04772526b', NULL, '表单系统权限', NULL, NULL, NULL, 'Y', '2018-02-01');
INSERT INTO "sys_authority"("auth_id", "parent_id", "authority_name", "descripthon", "remark", "order_num", "status", "create_date") VALUES ('fc2edea6-c3a0-4cab-8b0a-994efcdc1270', NULL, '系统设置权限', NULL, NULL, NULL, 'Y', '2018-02-01');
INSERT INTO "sys_authority"("auth_id", "parent_id", "authority_name", "descripthon", "remark", "order_num", "status", "create_date") VALUES ('b70b659b-b72d-4c37-ad5f-1bdbede9a51b', NULL, 'XX设置权限', NULL, NULL, NULL, 'Y', '2018-02-01');
INSERT INTO "sys_authority"("auth_id", "parent_id", "authority_name", "descripthon", "remark", "order_num", "status", "create_date") VALUES ('c3ca4a1c-d9e3-488d-b8de-99602dee0ed4', NULL, '用户菜单权限', NULL, NULL, NULL, 'Y', '2018-02-01');
INSERT INTO "sys_authority"("auth_id", "parent_id", "authority_name", "descripthon", "remark", "order_num", "status", "create_date") VALUES ('6a01720e-9c72-4189-81e2-3c562e4cc105', NULL, '部门菜单权限', NULL, NULL, NULL, 'Y', '2018-02-01');
INSERT INTO "sys_authority"("auth_id", "parent_id", "authority_name", "descripthon", "remark", "order_num", "status", "create_date") VALUES ('99498870-68ea-4c6b-8118-3b2c5d355af3', NULL, '表单定义权限', NULL, NULL, NULL, 'Y', '2018-02-01');
INSERT INTO "sys_authority"("auth_id", "parent_id", "authority_name", "descripthon", "remark", "order_num", "status", "create_date") VALUES ('778b11cb-9365-404a-9a74-f2b2c360cf5c', NULL, '表单设计权限', '', NULL, NULL, 'Y', '2018-02-01');

/*==============================================================*/
/* init sys_role_auth_rel                                                */
/*==============================================================*/
truncate table sys_role_auth_rel;
INSERT INTO "sys_role_auth_rel"("guid", "role_id", "auth_id", "status", "operation_date") VALUES ('fc3326ec-2aee-452f-ab11-2c07af633570', '0101009', '4a656945-29a3-4492-a779-3f74b79989a7', 'y', '2018-02-01');
INSERT INTO "sys_role_auth_rel"("guid", "role_id", "auth_id", "status", "operation_date") VALUES ('1861112f-5dd1-4409-99df-1466548b3c11', '0101009', 'ceff10c2-5807-432d-b677-00d04772526b', 'y', '2018-02-01');
INSERT INTO "sys_role_auth_rel"("guid", "role_id", "auth_id", "status", "operation_date") VALUES ('13e1d2f7-d25a-4bdb-8a45-866bbd347d4c', '0101009', 'fc2edea6-c3a0-4cab-8b0a-994efcdc1270', 'y', '2018-02-01');
INSERT INTO "sys_role_auth_rel"("guid", "role_id", "auth_id", "status", "operation_date") VALUES ('62709017-949d-4d3a-91b2-b8c8bde4cf32', '0101009', 'b70b659b-b72d-4c37-ad5f-1bdbede9a51b', 'y', '2018-02-01');
INSERT INTO "sys_role_auth_rel"("guid", "role_id", "auth_id", "status", "operation_date") VALUES ('16c3f477-4b6a-4734-9667-9094899f4e6a', '0101009', 'c3ca4a1c-d9e3-488d-b8de-99602dee0ed4', 'y', '2018-02-01');
INSERT INTO "sys_role_auth_rel"("guid", "role_id", "auth_id", "status", "operation_date") VALUES ('a1203de3-3e4a-4112-9183-eeb96dfcc8e2', '0101009', '6a01720e-9c72-4189-81e2-3c562e4cc105', 'y', '2018-02-01');
INSERT INTO "sys_role_auth_rel"("guid", "role_id", "auth_id", "status", "operation_date") VALUES ('48d4bb62-27f6-4f95-8ec3-8391490e0b0b', '0101009', '99498870-68ea-4c6b-8118-3b2c5d355af3', 'y', '2018-02-01');
INSERT INTO "sys_role_auth_rel"("guid", "role_id", "auth_id", "status", "operation_date") VALUES ('60612948-4ba0-4889-a0f9-c222472f4d62', '0101009', '778b11cb-9365-404a-9a74-f2b2c360cf5c', 'y', '2018-02-01');

/*==============================================================*/
/* init sys_user_department_rel                                                */
/*==============================================================*/
truncate table sys_user_department_rel;

INSERT INTO "sys_user_department_rel"("guid", "user_id", "department_id", "status", "operation_date") VALUES ('c3d4f535-df09-4398-8a17-b847a557c78d', '10000', '0101009', 'y', '2018-02-01');

/*==============================================================*/
/* init sys_user_role_rel                                                */
/*==============================================================*/
truncate table sys_user_role_rel;

INSERT INTO "sys_user_role_rel"("guid", "user_id", "role_id", "status", "operation_date") VALUES ('7639211c-530c-4013-aadc-c0f81cd4fef5', '10000', '0101009', 'y', '2018-02-01');

/*==============================================================*/
/* init sys_form_control_groups                                                */
/*==============================================================*/
truncate table sys_form_control_groups cascade;
INSERT INTO "sys_form_control_groups" ("group_id", "group_name", "status", "img", "order_num")
VALUES ('10', '基础控件', 'y', 'icon-briefcase', 0);
INSERT INTO "sys_form_control_groups" ("group_id", "group_name", "status", "img", "order_num")
VALUES ('20', '布局控件', 'y', 'icon-layers', 0);
INSERT INTO "sys_form_control_groups" ("group_id", "group_name", "status", "img", "order_num")
VALUES ('30', '系统控件', 'y', 'icon-wrench', 0);
INSERT INTO "sys_form_control_groups" ("group_id", "group_name", "status", "img", "order_num")
VALUES ('40', '高级控件', 'y', 'icon-rocket', 0);
INSERT INTO "sys_form_control_groups" ("group_id", "group_name", "status", "img", "order_num")
VALUES ('50', '其它控件', 'y', 'icon-puzzle', 0);


/*==============================================================*/
/* init sys_from_controls                                                */
/*==============================================================*/
truncate table sys_from_controls cascade;
INSERT INTO "sys_from_controls" ("control_id", "control_name", "img", "status", "order_num", "group_id")
VALUES ('1001', '单行文本', 'fa-font', 'y', 0, '10');
INSERT INTO "sys_from_controls" ("control_id", "control_name", "img", "status", "order_num", "group_id")
VALUES ('1002', '多行文本', 'fa-indent', 'y', 0, '10');
INSERT INTO "sys_from_controls" ("control_id", "control_name", "img", "status", "order_num", "group_id")
VALUES ('1003', '日期', 'fa-calendar', 'y', 0, '10');
INSERT INTO "sys_from_controls" ("control_id", "control_name", "img", "status", "order_num", "group_id")
VALUES ('1004', '数字', 'fa-html5', 'y', 0, '10');
INSERT INTO "sys_from_controls" ("control_id", "control_name", "img", "status", "order_num", "group_id")
VALUES ('1005', '单选框', 'fa-dot-circle-o', 'y', 0, '10');
INSERT INTO "sys_from_controls" ("control_id", "control_name", "img", "status", "order_num", "group_id")
VALUES ('1006', '复选框', 'fa-check-square-o', 'y', 0, '10');
INSERT INTO "sys_from_controls" ("control_id", "control_name", "img", "status", "order_num", "group_id")
VALUES ('1007', '下拉框', 'fa-list-ul', 'y', 0, '10');
INSERT INTO "sys_from_controls" ("control_id", "control_name", "img", "status", "order_num", "group_id")
VALUES ('1008', '附件', 'fa-paperclip', 'y', 0, '10');
INSERT INTO "sys_from_controls" ("control_id", "control_name", "img", "status", "order_num", "group_id")
VALUES ('1009', '地址', 'fa-inbox', 'y', 0, '10');
INSERT INTO "sys_from_controls" ("control_id", "control_name", "img", "status", "order_num", "group_id")
VALUES ('1010', '位置', 'fa-map-marker', 'y', 0, '10');
INSERT INTO "sys_from_controls" ("control_id", "control_name", "img", "status", "order_num", "group_id")
VALUES ('1011', '人员单选', 'fa-user', 'y', 0, '10');
INSERT INTO "sys_from_controls" ("control_id", "control_name", "img", "status", "order_num", "group_id")
VALUES ('1012', '人员多选', 'fa-users', 'y', 0, '10');
INSERT INTO "sys_from_controls" ("control_id", "control_name", "img", "status", "order_num", "group_id")
VALUES ('1013', '部门单选', 'fa-th-large', 'y', 0, '10');
INSERT INTO "sys_from_controls" ("control_id", "control_name", "img", "status", "order_num", "group_id")
VALUES ('1014', '部门多选', 'fa-th', 'y', 0, '10');
INSERT INTO "sys_from_controls" ("control_id", "control_name", "img", "status", "order_num", "group_id")
VALUES ('1015', '图片', 'fa-image', 'y', 0, '10');
INSERT INTO "sys_from_controls" ("control_id", "control_name", "img", "status", "order_num", "group_id")
VALUES ('1016', '是/否', 'fa-check-square', 'y', 0, '10');
INSERT INTO "sys_from_controls" ("control_id", "control_name", "img", "status", "order_num", "group_id")
VALUES ('2001', '分组标题', 'fa-header', 'y', 0, '20');
INSERT INTO "sys_from_controls" ("control_id", "control_name", "img", "status", "order_num", "group_id")
VALUES ('2002', '一行两列', 'fa-columns', 'y', 0, '20');
INSERT INTO "sys_from_controls" ("control_id", "control_name", "img", "status", "order_num", "group_id")
VALUES ('2003', '描述说明', 'fa-info', 'y', 0, '20');
INSERT INTO "sys_from_controls" ("control_id", "control_name", "img", "status", "order_num", "group_id")
VALUES ('2004', '子表', 'fa-book', 'y', 0, '20');
INSERT INTO "sys_from_controls" ("control_id", "control_name", "img", "status", "order_num", "group_id")
VALUES ('3001', '流水号', 'fa-barcode', 'y', 0, '30');
INSERT INTO "sys_from_controls" ("control_id", "control_name", "img", "status", "order_num", "group_id")
VALUES ('3002', '创建人', 'icon-user-follow', 'y', 0, '30');
INSERT INTO "sys_from_controls" ("control_id", "control_name", "img", "status", "order_num", "group_id")
VALUES ('3003', '拥有者', 'icon-user-following', 'y', 0, '30');
INSERT INTO "sys_from_controls" ("control_id", "control_name", "img", "status", "order_num", "group_id")
VALUES ('3004', '所属部门', 'fa-sitemap', 'y', 0, '30');
INSERT INTO "sys_from_controls" ("control_id", "control_name", "img", "status", "order_num", "group_id")
VALUES ('3005', '创建时间', 'fa-calendar', 'y', 0, '30');
INSERT INTO "sys_from_controls" ("control_id", "control_name", "img", "status", "order_num", "group_id")
VALUES ('3006', '修改时间', 'fa-calendar-o', 'y', 0, '30');
INSERT INTO "sys_from_controls" ("control_id", "control_name", "img", "status", "order_num", "group_id")
VALUES ('4001', '关联表单', 'fa-building-o', 'y', 0, '40');
INSERT INTO "sys_from_controls" ("control_id", "control_name", "img", "status", "order_num", "group_id")
VALUES ('4002', '关联属性', 'fa-ticket', 'y', 0, '40');
INSERT INTO "sys_from_controls" ("control_id", "control_name", "img", "status", "order_num", "group_id")
VALUES ('4003', '关联表单多选', 'fa-fax', 'y', 0, '40');
INSERT INTO "sys_from_controls" ("control_id", "control_name", "img", "status", "order_num", "group_id")
VALUES ('4004', '公式型控件', 'icon-calculator', 'y', 0, '40');
INSERT INTO "sys_from_controls" ("control_id", "control_name", "img", "status", "order_num", "group_id")
VALUES ('4005', '按钮', 'fa-circle-o-notch', 'y', 0, '40');
