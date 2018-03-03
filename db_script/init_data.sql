/*==============================================================*/
/* init data                                                    */
/*==============================================================*/

/*==============================================================*/
/* init sys_department                                          */
/*==============================================================*/
truncate table sys_department;

INSERT INTO "sys_department" ("department_id", "parent_id", "department_name", "short_name", "department_code", "department_level", "department_type", "remark", "order_num", "status", "create_date")
VALUES ('0101', '01', '销售公司', NULL, NULL, '2', 'c', NULL, NULL, 'y', '2018-01-30');
INSERT INTO "sys_department" ("department_id", "parent_id", "department_name", "short_name", "department_code", "department_level", "department_type", "remark", "order_num", "status", "create_date")
VALUES ('0101009', '0101', '信息部', NULL, NULL, '3', 'd', NULL, NULL, 'y', '2018-01-30');
INSERT INTO "sys_department" ("department_id", "parent_id", "department_name", "short_name", "department_code", "department_level", "department_type", "remark", "order_num", "status", "create_date")
VALUES ('01', '00', '铸锻集团', NULL, NULL, '1', 'g', NULL, NULL, 'y', '2018-01-30');

/*==============================================================*/
/* init sys_menu                                                */
/*==============================================================*/
truncate table sys_menu;

INSERT INTO "sys_menu" ("menu_id", "parent_id", "menu_type", "menu_level", "menu_name", "menu_code", "menu_path", "form_id", "menu_url", "remark", "order_num", "status", "create_date")
VALUES ('10', '00', 's', '1', '基础系统', NULL, NULL, NULL, NULL, NULL, NULL, 'y', '2018-01-30');
INSERT INTO "sys_menu" ("menu_id", "parent_id", "menu_type", "menu_level", "menu_name", "menu_code", "menu_path", "form_id", "menu_url", "remark", "order_num", "status", "create_date")
VALUES ('1001', '10', 'g', '2', '用户', NULL, NULL, NULL, 'sys/user', NULL, NULL, 'y', '2018-01-30');
INSERT INTO "sys_menu" ("menu_id", "parent_id", "menu_type", "menu_level", "menu_name", "menu_code", "menu_path", "form_id", "menu_url", "remark", "order_num", "status", "create_date")
VALUES ('1002', '10', 'g', '2', '部门', NULL, NULL, NULL, 'sys/dept', NULL, NULL, 'y', '2018-01-30');
INSERT INTO "sys_menu" ("menu_id", "parent_id", "menu_type", "menu_level", "menu_name", "menu_code", "menu_path", "form_id", "menu_url", "remark", "order_num", "status", "create_date")
VALUES ('20', '00', 's', '1', '表单系统', NULL, NULL, NULL, NULL, NULL, NULL, 'y', '2018-01-30');
INSERT INTO "sys_menu" ("menu_id", "parent_id", "menu_type", "menu_level", "menu_name", "menu_code", "menu_path", "form_id", "menu_url", "remark", "order_num", "status", "create_date")
VALUES ('30', '01', 'g', '2', '系统设置', NULL, NULL, NULL, NULL, NULL, NULL, 'y', '2018-01-30');
INSERT INTO "sys_menu" ("menu_id", "parent_id", "menu_type", "menu_level", "menu_name", "menu_code", "menu_path", "form_id", "menu_url", "remark", "order_num", "status", "create_date")
VALUES ('3002', '01', 'g', '2', 'XX设置', NULL, NULL, NULL, NULL, NULL, NULL, 'y', '2018-01-30');
INSERT INTO "sys_menu" ("menu_id", "parent_id", "menu_type", "menu_level", "menu_name", "menu_code", "menu_path", "form_id", "menu_url", "remark", "order_num", "status", "create_date")
VALUES ('2030102', '2010', 'm', '3', '表单设计', NULL, NULL, NULL, '/pages/forms/formDesigner.html', NULL, NULL, 'y',
        '2018-02-07');
INSERT INTO "sys_menu" ("menu_id", "parent_id", "menu_type", "menu_level", "menu_name", "menu_code", "menu_path", "form_id", "menu_url", "remark", "order_num", "status", "create_date")
VALUES
  ('2020101', '2010', 'm', '3', '表单定义', NULL, NULL, NULL, '/pages/forms/formList.html', NULL, NULL, 'y', '2018-01-30');
INSERT INTO "sys_menu" ("menu_id", "parent_id", "menu_type", "menu_level", "menu_name", "menu_code", "menu_path", "form_id", "menu_url", "remark", "order_num", "status", "create_date")
VALUES ('2010', '20', 'g', '2', '表单', NULL, NULL, NULL, '', NULL, NULL, 'y', '2018-01-30');

/*==============================================================*/
/* init sys_role                                                */
/*==============================================================*/
truncate table sys_role;
INSERT INTO "sys_role" ("role_id", "parent_id", "role_name", "description", "remark", "order_num", "status", "create_date")
VALUES ('01', '00', '集团CEO', NULL, NULL, NULL, 'y', '2018-01-30');
INSERT INTO "sys_role" ("role_id", "parent_id", "role_name", "description", "remark", "order_num", "status", "create_date")
VALUES ('0101', '01', '销售公司总经理', NULL, NULL, NULL, 'y', '2018-01-30');
INSERT INTO "sys_role" ("role_id", "parent_id", "role_name", "description", "remark", "order_num", "status", "create_date")
VALUES ('0101009', '0101', '销售公司信息总监', NULL, NULL, NULL, 'y', '2018-01-30');

/*==============================================================*/
/* init sys_user                                                */
/*==============================================================*/
truncate table sys_user;
INSERT INTO "sys_user" ("user_id", "user_name", "password", "question", "answer", "persion_name", "persion_sex", "mobile", "telephone", "email", "user_position", "img_url", "remark", "order_num", "status", "create_time")
VALUES ('10000', 'zhangsansan', '', NULL, NULL, '张三三', '男', '13940001001', NULL, 'zhuye0213@126.com', NULL, NULL,
        '他很懒什么都没写,这是系统帮他写的', NULL, 'y', NULL);


/*==============================================================*/
/* init sys_auth_menu_rel                                                */
/*==============================================================*/
truncate table sys_auth_menu_rel;
INSERT INTO "sys_auth_menu_rel" ("guid", "auth_id", "menu_id", "status", "operation_date")
VALUES ('7fd702d1-5d90-4366-99b5-45ea07e6e8d3', '10', '10', 'y', '2018-02-01');
INSERT INTO "sys_auth_menu_rel" ("guid", "auth_id", "menu_id", "status", "operation_date")
VALUES ('27f74f3e-6ede-4b89-a04d-dae8af190100', '20', '20', 'y', '2018-02-01');
INSERT INTO "sys_auth_menu_rel" ("guid", "auth_id", "menu_id", "status", "operation_date")
VALUES ('44c843eb-bdf4-41b1-aa7d-6576a5b501dc', '30', '30', 'y', '2018-02-01');
INSERT INTO "sys_auth_menu_rel" ("guid", "auth_id", "menu_id", "status", "operation_date")
VALUES ('88826504-b8d0-475d-89a0-3ad602810183', '3002', '3002', 'y', '2018-02-01');
INSERT INTO "sys_auth_menu_rel" ("guid", "auth_id", "menu_id", "status", "operation_date")
VALUES ('e9e83da4-3261-4498-b353-220edabe1c19', '1001', '1001', 'y', '2018-02-01');
INSERT INTO "sys_auth_menu_rel" ("guid", "auth_id", "menu_id", "status", "operation_date")
VALUES ('a9a484a0-2d12-473a-ae78-bb1b677ab5fd', '1002', '1002', 'y', '2018-02-01');
INSERT INTO "sys_auth_menu_rel" ("guid", "auth_id", "menu_id", "status", "operation_date")
VALUES ('3f56b3f7-f6f8-492e-8e7e-7458f8837768', '2020101', '2020101', 'y', '2018-02-01');
INSERT INTO "sys_auth_menu_rel" ("guid", "auth_id", "menu_id", "status", "operation_date")
VALUES ('28aef366-406f-42be-93ca-f6a4bc0d1a33', '2030102', '2030102', 'y', '2018-02-01');
INSERT INTO "sys_auth_menu_rel" ("guid", "auth_id", "menu_id", "status", "operation_date")
VALUES ('5932b63a-e60c-4037-96ac-e8d4df73eb7e', '2010', '2010', 'y', '2018-02-01');

/*==============================================================*/
/* init sys_authority                                                */
/*==============================================================*/
truncate table sys_authority;

INSERT INTO "sys_authority" ("auth_id", "parent_id", "authority_name", "descripthon", "remark", "order_num", "status", "create_date")
VALUES ('10', NULL, '基础系统权限', NULL, NULL, NULL, 'y', '2018-02-01');
INSERT INTO "sys_authority" ("auth_id", "parent_id", "authority_name", "descripthon", "remark", "order_num", "status", "create_date")
VALUES ('20', NULL, '表单系统权限', NULL, NULL, NULL, 'y', '2018-02-01');
INSERT INTO "sys_authority" ("auth_id", "parent_id", "authority_name", "descripthon", "remark", "order_num", "status", "create_date")
VALUES ('30', NULL, '系统设置权限', NULL, NULL, NULL, 'y', '2018-02-01');
INSERT INTO "sys_authority" ("auth_id", "parent_id", "authority_name", "descripthon", "remark", "order_num", "status", "create_date")
VALUES ('3002', NULL, 'XX设置权限', NULL, NULL, NULL, 'y', '2018-02-01');
INSERT INTO "sys_authority" ("auth_id", "parent_id", "authority_name", "descripthon", "remark", "order_num", "status", "create_date")
VALUES ('1001', NULL, '用户菜单权限', NULL, NULL, NULL, 'y', '2018-02-01');
INSERT INTO "sys_authority" ("auth_id", "parent_id", "authority_name", "descripthon", "remark", "order_num", "status", "create_date")
VALUES ('1002', NULL, '部门菜单权限', NULL, NULL, NULL, 'y', '2018-02-01');
INSERT INTO "sys_authority" ("auth_id", "parent_id", "authority_name", "descripthon", "remark", "order_num", "status", "create_date")
VALUES ('2020101', NULL, '表单定义权限', NULL, NULL, NULL, 'y', '2018-02-01');
INSERT INTO "sys_authority" ("auth_id", "parent_id", "authority_name", "descripthon", "remark", "order_num", "status", "create_date")
VALUES ('2030102', NULL, '表单设计权限', '', NULL, NULL, 'y', '2018-02-01');
INSERT INTO "sys_authority" ("auth_id", "parent_id", "authority_name", "descripthon", "remark", "order_num", "status", "create_date")
VALUES ('2010', NULL, '表单权限', NULL, NULL, NULL, 'y', '2018-02-01');

/*==============================================================*/
/* init sys_role_auth_rel                                                */
/*==============================================================*/
truncate table sys_role_auth_rel;
INSERT INTO "sys_role_auth_rel" ("guid", "role_id", "auth_id", "status", "operation_date")
VALUES ('fc3326ec-2aee-452f-ab11-2c07af633570', '0101009', '10', 'y', '2018-02-01');
INSERT INTO "sys_role_auth_rel" ("guid", "role_id", "auth_id", "status", "operation_date")
VALUES ('1861112f-5dd1-4409-99df-1466548b3c11', '0101009', '20', 'y', '2018-02-01');
INSERT INTO "sys_role_auth_rel" ("guid", "role_id", "auth_id", "status", "operation_date")
VALUES ('13e1d2f7-d25a-4bdb-8a45-866bbd347d4c', '0101009', '30', 'y', '2018-02-01');
INSERT INTO "sys_role_auth_rel" ("guid", "role_id", "auth_id", "status", "operation_date")
VALUES ('62709017-949d-4d3a-91b2-b8c8bde4cf32', '0101009', '3002', 'y', '2018-02-01');
INSERT INTO "sys_role_auth_rel" ("guid", "role_id", "auth_id", "status", "operation_date")
VALUES ('16c3f477-4b6a-4734-9667-9094899f4e6a', '0101009', '1001', 'y', '2018-02-01');
INSERT INTO "sys_role_auth_rel" ("guid", "role_id", "auth_id", "status", "operation_date")
VALUES ('a1203de3-3e4a-4112-9183-eeb96dfcc8e2', '0101009', '1002', 'y', '2018-02-01');
INSERT INTO "sys_role_auth_rel" ("guid", "role_id", "auth_id", "status", "operation_date")
VALUES ('48d4bb62-27f6-4f95-8ec3-8391490e0b0b', '0101009', '2020101', 'y', '2018-02-01');
INSERT INTO "sys_role_auth_rel" ("guid", "role_id", "auth_id", "status", "operation_date")
VALUES ('60612948-4ba0-4889-a0f9-c222472f4d62', '0101009', '2030102', 'y', '2018-02-01');
INSERT INTO "sys_role_auth_rel" ("guid", "role_id", "auth_id", "status", "operation_date")
VALUES ('096e9642-0240-4998-98eb-5f832f62fbc6', '0101009', '2010', 'y', '2018-02-07');

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
/* init sys_form_field_group                                                */
/*==============================================================*/
TRUNCATE TABLE sys_form_field_group CASCADE;
INSERT INTO "sys_form_field_group" ("group_id", "group_name", "status", "img", "order_num")
VALUES ('10', '基础控件', 'y', 'fa-truck', 0);
INSERT INTO "sys_form_field_group" ("group_id", "group_name", "status", "img", "order_num")
VALUES ('20', '布局控件', 'y', 'fa-qrcode', 0);
INSERT INTO "sys_form_field_group" ("group_id", "group_name", "status", "img", "order_num")
VALUES ('30', '系统控件', 'y', 'fa-cogs', 0);
INSERT INTO "sys_form_field_group" ("group_id", "group_name", "status", "img", "order_num")
VALUES ('40', '高级控件', 'y', 'fa-cubes', 0);
INSERT INTO "sys_form_field_group" ("group_id", "group_name", "status", "img", "order_num")
VALUES ('50', '其它控件', 'y', 'fa-sun-o', 0);


/*==============================================================*/
/* init sys_form_field                                                */
/*==============================================================*/
TRUNCATE TABLE sys_form_field CASCADE;
INSERT INTO "sys_form_field" ("field_id", "field_name", "column_type", "img", "status", "order_num", "group_id")
VALUES ('1001', '单行文本', 'VARCHAR', 'fa-font', 'y', 0, '10');
INSERT INTO "sys_form_field" ("field_id", "field_name", "column_type", "img", "status", "order_num", "group_id")
VALUES ('1002', '多行文本', 'TEXT', 'fa-indent', 'y', 0, '10');
INSERT INTO "sys_form_field" ("field_id", "field_name", "column_type", "img", "status", "order_num", "group_id")
VALUES ('1003', '日期', 'DATE', 'fa-calendar', 'y', 0, '10');
INSERT INTO "sys_form_field" ("field_id", "field_name", "column_type", "img", "status", "order_num", "group_id")
VALUES ('1004', '数字', 'NUMERIC', 'fa-html5', 'y', 0, '10');
INSERT INTO "sys_form_field" ("field_id", "field_name", "column_type", "img", "status", "order_num", "group_id")
VALUES ('1005', '单选框', 'VARCHAR', 'fa-dot-circle-o', 'y', 0, '10');
INSERT INTO "sys_form_field" ("field_id", "field_name", "column_type", "img", "status", "order_num", "group_id")
VALUES ('1006', '复选框', 'VARCHAR', 'fa-check-square-o', 'y', 0, '10');
INSERT INTO "sys_form_field" ("field_id", "field_name", "column_type", "img", "status", "order_num", "group_id")
VALUES ('1007', '下拉框', 'VARCHAR', 'fa-list-ul', 'y', 0, '10');
INSERT INTO "sys_form_field" ("field_id", "field_name", "column_type", "img", "status", "order_num", "group_id")
VALUES ('1008', '附件', 'VARCHAR', 'fa-paperclip', 'y', 0, '10');
INSERT INTO "sys_form_field" ("field_id", "field_name", "column_type", "img", "status", "order_num", "group_id")
VALUES ('1009', '地址', 'VARCHAR', 'fa-inbox', 'y', 0, '10');
INSERT INTO "sys_form_field" ("field_id", "field_name", "column_type", "img", "status", "order_num", "group_id")
VALUES ('1010', '位置', 'VARCHAR', 'fa-map-marker', 'y', 0, '10');
INSERT INTO "sys_form_field" ("field_id", "field_name", "column_type", "img", "status", "order_num", "group_id")
VALUES ('1011', '人员单选', 'VARCHAR', 'fa-user', 'y', 0, '10');
INSERT INTO "sys_form_field" ("field_id", "field_name", "column_type", "img", "status", "order_num", "group_id")
VALUES ('1012', '人员多选', 'VARCHAR', 'fa-users', 'y', 0, '10');
INSERT INTO "sys_form_field" ("field_id", "field_name", "column_type", "img", "status", "order_num", "group_id")
VALUES ('1013', '部门单选', 'VARCHAR', 'fa-th-large', 'y', 0, '10');
INSERT INTO "sys_form_field" ("field_id", "field_name", "column_type", "img", "status", "order_num", "group_id")
VALUES ('1014', '部门多选', 'VARCHAR', 'fa-th', 'y', 0, '10');
INSERT INTO "sys_form_field" ("field_id", "field_name", "column_type", "img", "status", "order_num", "group_id")
VALUES ('1015', '图片', 'VARCHAR', 'fa-image', 'y', 0, '10');
INSERT INTO "sys_form_field" ("field_id", "field_name", "column_type", "img", "status", "order_num", "group_id")
VALUES ('1016', '是/否', 'VARCHAR', 'fa-check-square', 'y', 0, '10');
INSERT INTO "sys_form_field" ("field_id", "field_name", "column_type", "img", "status", "order_num", "group_id")
VALUES ('2001', '分组标题', 'VARCHAR', 'fa-header', 'y', 0, '20');
INSERT INTO "sys_form_field" ("field_id", "field_name", "column_type", "img", "status", "order_num", "group_id")
VALUES ('2002', '一行两列', NULL, 'fa-columns', 'y', 0, '20');
INSERT INTO "sys_form_field" ("field_id", "field_name", "column_type", "img", "status", "order_num", "group_id")
VALUES ('2003', '描述说明', 'TEXT', 'fa-info', 'y', 0, '20');
INSERT INTO "sys_form_field" ("field_id", "field_name", "column_type", "img", "status", "order_num", "group_id")
VALUES ('2004', '子表', NULL, 'fa-book', 'y', 0, '20');
INSERT INTO "sys_form_field" ("field_id", "field_name", "column_type", "img", "status", "order_num", "group_id")
VALUES ('3001', '流水号', 'VARCHAR', 'fa-barcode', 'y', 0, '30');
INSERT INTO "sys_form_field" ("field_id", "field_name", "column_type", "img", "status", "order_num", "group_id")
VALUES ('3002', '创建人', 'VARCHAR', 'fa-child', 'y', 0, '30');
INSERT INTO "sys_form_field" ("field_id", "field_name", "column_type", "img", "status", "order_num", "group_id")
VALUES ('3003', '拥有者', 'VARCHAR', 'fa-drupal', 'y', 0, '30');
INSERT INTO "sys_form_field" ("field_id", "field_name", "column_type", "img", "status", "order_num", "group_id")
VALUES ('3004', '所属部门', 'VARCHAR', 'fa-sitemap', 'y', 0, '30');
INSERT INTO "sys_form_field" ("field_id", "field_name", "column_type", "img", "status", "order_num", "group_id")
VALUES ('3005', '创建时间', 'DATE', 'fa-calendar', 'y', 0, '30');
INSERT INTO "sys_form_field" ("field_id", "field_name", "column_type", "img", "status", "order_num", "group_id")
VALUES ('3006', '修改时间', 'DATE', 'fa-calendar-o', 'y', 0, '30');
INSERT INTO "sys_form_field" ("field_id", "field_name", "column_type", "img", "status", "order_num", "group_id")
VALUES ('4001', '关联表单', 'VARCHAR', 'fa-building-o', 'y', 0, '40');
INSERT INTO "sys_form_field" ("field_id", "field_name", "column_type", "img", "status", "order_num", "group_id")
VALUES ('4002', '关联属性', 'VARCHAR', 'fa-ticket', 'y', 0, '40');
INSERT INTO "sys_form_field" ("field_id", "field_name", "column_type", "img", "status", "order_num", "group_id")
VALUES ('4003', '关联表单多选', 'VARCHAR', 'fa-fax', 'y', 0, '40');
INSERT INTO "sys_form_field" ("field_id", "field_name", "column_type", "img", "status", "order_num", "group_id")
VALUES ('4004', '公式型控件', 'VARCHAR', 'fa-cog', 'y', 0, '40');
INSERT INTO "sys_form_field" ("field_id", "field_name", "column_type", "img", "status", "order_num", "group_id")
VALUES ('4005', '按钮', NULL, 'fa-circle-o-notch', 'y', 0, '40');

/*==============================================================*/
/* init sys_base_tab_tmpl                                                */
/*==============================================================*/
INSERT INTO "sys_base_tab_tmpl" ("id", "tab_name", "tab_column", "tab_col_type", "tab_col_length", "tab_col_small", "is_null", "is_key", "comment", "default_value", "order_num")
VALUES ('1b91d3b4-432e-45e8-8651-e6a9e3703b98', 'base_tab', 'id', 'varchar', 36, NULL, 'y', 'y', '唯一id',
                                                'uuid_generate_v4()', NULL);
INSERT INTO "sys_base_tab_tmpl" ("id", "tab_name", "tab_column", "tab_col_type", "tab_col_length", "tab_col_small", "is_null", "is_key", "comment", "default_value", "order_num")
VALUES
  ('ecf224eb-a3d4-4275-88cb-c61a574dcf74', 'base_tab', 'operation_persion', 'varchar', 255, NULL, NULL, NULL, '操作人',
                                           NULL, NULL);
INSERT INTO "sys_base_tab_tmpl" ("id", "tab_name", "tab_column", "tab_col_type", "tab_col_length", "tab_col_small", "is_null", "is_key", "comment", "default_value", "order_num")
VALUES ('40ef9092-61ec-4b8d-8e98-0ff6f42716a9', 'base_tab', 'operation_time', 'date', NULL, NULL, NULL, NULL, '操作时间',
                                                'current_date', NULL);
