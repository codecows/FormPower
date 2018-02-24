/*==============================================================*/
/* create tables                                                */
/*==============================================================*/

DROP TABLE IF EXISTS sys_authority;

DROP TABLE IF EXISTS sys_company;

DROP TABLE IF EXISTS sys_department;

DROP TABLE IF EXISTS sys_group;

DROP TABLE IF EXISTS sys_group_auth_rel;

DROP TABLE IF EXISTS sys_group_role_rel;

DROP TABLE IF EXISTS sys_role;

DROP TABLE IF EXISTS sys_role_auth_rel;

DROP TABLE IF EXISTS sys_user;

DROP TABLE IF EXISTS sys_user_auth_rel;

DROP TABLE IF EXISTS sys_user_department_rel;

DROP TABLE IF EXISTS sys_user_group_rel;

DROP TABLE IF EXISTS sys_user_role_rel;

DROP TABLE IF EXISTS sys_menu;

DROP TABLE IF EXISTS sys_auth_menu_rel;

DROP TABLE IF EXISTS sys_company_dept_rel;

DROP TABLE IF EXISTS sys_code;

DROP TABLE IF EXISTS sys_form_control_groups CASCADE;

DROP TABLE IF EXISTS sys_from_controls CASCADE;

DROP TABLE IF EXISTS sys_form_def;

/*==============================================================*/
/* Table: sys_auth_menu_rel                                     */
/*==============================================================*/
CREATE TABLE sys_auth_menu_rel (
  guid           VARCHAR(36) NOT NULL DEFAULT uuid_generate_v4(),
  auth_id        VARCHAR(36) NULL,
  menu_id        VARCHAR(36) NULL,
  status         VARCHAR(2)  NULL,
  operation_date DATE        NULL,
  CONSTRAINT PK_SYS_AUTH_MENU_REL PRIMARY KEY (guid)
);

COMMENT ON TABLE sys_auth_menu_rel IS
'权限菜单关联表';

COMMENT ON COLUMN sys_auth_menu_rel.guid IS
'关系ID';

COMMENT ON COLUMN sys_auth_menu_rel.auth_id IS
'权限ID';

COMMENT ON COLUMN sys_auth_menu_rel.menu_id IS
'菜单ID';

COMMENT ON COLUMN sys_auth_menu_rel.status IS
'状态';

COMMENT ON COLUMN sys_auth_menu_rel.operation_date IS
'操作时间';

/*==============================================================*/
/* Table: sys_authority                                         */
/*==============================================================*/
CREATE TABLE sys_authority (
  auth_id        VARCHAR(36)  NOT NULL DEFAULT uuid_generate_v4(),
  parent_id      VARCHAR(36)  NULL,
  authority_name VARCHAR(100) NULL,
  descripthon    VARCHAR(400) NULL,
  remark         TEXT         NULL,
  order_num      NUMERIC      NULL,
  status         VARCHAR(2)   NULL,
  create_date    DATE         NULL,
  CONSTRAINT PK_SYS_AUTHORITY PRIMARY KEY (auth_id)
);

COMMENT ON TABLE sys_authority IS
'权限表';

COMMENT ON COLUMN sys_authority.auth_id IS
'权限ID';

COMMENT ON COLUMN sys_authority.parent_id IS
'上级ID';

COMMENT ON COLUMN sys_authority.authority_name IS
'权限名称';

COMMENT ON COLUMN sys_authority.descripthon IS
'描述';

COMMENT ON COLUMN sys_authority.remark IS
'备注';

COMMENT ON COLUMN sys_authority.order_num IS
'排序码';

COMMENT ON COLUMN sys_authority.status IS
'状态';

COMMENT ON COLUMN sys_authority.create_date IS
'创建时间';

/*==============================================================*/
/* Table: sys_company                                           */
/*==============================================================*/
CREATE TABLE sys_company (
  company_id     VARCHAR(36)  NOT NULL DEFAULT uuid_generate_v4(),
  company_name   VARCHAR(400) NULL,
  com_short_name VARCHAR(50)  NULL,
  company_level  VARCHAR(10)  NULL,
  company_code   VARCHAR(100) NULL,
  corporation    VARCHAR(100) NULL,
  address        VARCHAR(400) NULL,
  telephone      VARCHAR(20)  NULL,
  remark         TEXT         NULL,
  order_num      NUMERIC      NULL,
  status         VARCHAR(2)   NULL,
  create_date    DATE         NULL,
  CONSTRAINT PK_SYS_COMPANY PRIMARY KEY (company_id)
);

COMMENT ON TABLE sys_company IS
'公司表';

COMMENT ON COLUMN sys_company.company_id IS
'公司ID';

COMMENT ON COLUMN sys_company.company_name IS
'公司名称';

COMMENT ON COLUMN sys_company.com_short_name IS
'公司简称';

COMMENT ON COLUMN sys_company.company_level IS
'层级';

COMMENT ON COLUMN sys_company.company_code IS
'公司代码';

COMMENT ON COLUMN sys_company.corporation IS
'法人代表';

COMMENT ON COLUMN sys_company.address IS
'地址';

COMMENT ON COLUMN sys_company.telephone IS
'电话';

COMMENT ON COLUMN sys_company.remark IS
'备注';

COMMENT ON COLUMN sys_company.order_num IS
'排序码';

COMMENT ON COLUMN sys_company.status IS
'状态';

COMMENT ON COLUMN sys_company.create_date IS
'创建时间';

/*==============================================================*/
/* Table: sys_department                                        */
/*==============================================================*/
CREATE TABLE sys_department (
  department_id    VARCHAR(36)  NOT NULL DEFAULT uuid_generate_v4(),
  parent_id        VARCHAR(36)  NULL,
  department_name  VARCHAR(400) NULL,
  short_name       VARCHAR(50)  NULL,
  department_code  VARCHAR(50)  NULL,
  department_level VARCHAR(2)   NULL,
  department_type  VARCHAR(36)  NULL,
  remark           TEXT         NULL,
  order_num        NUMERIC      NULL,
  status           VARCHAR(2)   NULL,
  create_date      DATE         NULL,
  CONSTRAINT PK_SYS_DEPARTMENT PRIMARY KEY (department_id)
);

COMMENT ON TABLE sys_department IS
'部门表';

COMMENT ON COLUMN sys_department.department_id IS
'部门ID';

COMMENT ON COLUMN sys_department.parent_id IS
'上级ID';

COMMENT ON COLUMN sys_department.department_name IS
'部门名称';

COMMENT ON COLUMN sys_department.short_name IS
'部门简称';

COMMENT ON COLUMN sys_department.department_code IS
'部门编码';

COMMENT ON COLUMN sys_department.department_level IS
'部门等级';

COMMENT ON COLUMN sys_department.department_type IS
'部门类型';

COMMENT ON COLUMN sys_department.remark IS
'备注';

COMMENT ON COLUMN sys_department.order_num IS
'排序码';

COMMENT ON COLUMN sys_department.status IS
'状态';

COMMENT ON COLUMN sys_department.create_date IS
'创建时间';

/*==============================================================*/
/* Table: sys_group                                             */
/*==============================================================*/
CREATE TABLE sys_group (
  group_id    VARCHAR(36)  NOT NULL DEFAULT uuid_generate_v4(),
  parent_id   VARCHAR(36)  NULL,
  group_name  VARCHAR(100) NULL,
  remark      TEXT         NULL,
  order_num   NUMERIC      NULL,
  status      VARCHAR(2)   NULL,
  create_date DATE         NULL,
  CONSTRAINT PK_SYS_GROUP PRIMARY KEY (group_id)
);

COMMENT ON TABLE sys_group IS
'用户组表';

COMMENT ON COLUMN sys_group.group_id IS
'组ID';

COMMENT ON COLUMN sys_group.parent_id IS
'上级组ID';

COMMENT ON COLUMN sys_group.group_name IS
'组名称';

COMMENT ON COLUMN sys_group.remark IS
'备注';

COMMENT ON COLUMN sys_group.order_num IS
'排序码';

COMMENT ON COLUMN sys_group.status IS
'状态';

COMMENT ON COLUMN sys_group.create_date IS
'创建时间';

/*==============================================================*/
/* Table: sys_group_auth_rel                                    */
/*==============================================================*/
CREATE TABLE sys_group_auth_rel (
  guid           VARCHAR(36) NOT NULL DEFAULT uuid_generate_v4(),
  group_id       VARCHAR(36) NULL,
  auth_id        VARCHAR(36) NULL,
  status         VARCHAR(2)  NULL,
  operation_date DATE        NULL,
  CONSTRAINT PK_SYS_GROUP_AUTH_REL PRIMARY KEY (guid)
);

COMMENT ON TABLE sys_group_auth_rel IS
'组权限关系表';

COMMENT ON COLUMN sys_group_auth_rel.guid IS
'关系ID';

COMMENT ON COLUMN sys_group_auth_rel.group_id IS
'组ID';

COMMENT ON COLUMN sys_group_auth_rel.auth_id IS
'权限ID';

COMMENT ON COLUMN sys_group_auth_rel.status IS
'状态';

COMMENT ON COLUMN sys_group_auth_rel.operation_date IS
'操作时间';

/*==============================================================*/
/* Table: sys_group_role_rel                                    */
/*==============================================================*/
CREATE TABLE sys_group_role_rel (
  guid           VARCHAR(36) NOT NULL DEFAULT uuid_generate_v4(),
  group_id       VARCHAR(36) NULL,
  role_id        VARCHAR(36) NULL,
  status         VARCHAR(2)  NULL,
  operation_date DATE        NULL,
  CONSTRAINT PK_SYS_GROUP_ROLE_REL PRIMARY KEY (guid)
);

COMMENT ON TABLE sys_group_role_rel IS
'组角色关系表';

COMMENT ON COLUMN sys_group_role_rel.guid IS
'关系ID';

COMMENT ON COLUMN sys_group_role_rel.group_id IS
'组ID';

COMMENT ON COLUMN sys_group_role_rel.role_id IS
'角色ID';

COMMENT ON COLUMN sys_group_role_rel.status IS
'状态';

COMMENT ON COLUMN sys_group_role_rel.operation_date IS
'操作时间';

/*==============================================================*/
/* Table: sys_menu                                              */
/*==============================================================*/
CREATE TABLE sys_menu (
  menu_id     VARCHAR(36)  NOT NULL DEFAULT uuid_generate_v4(),
  parent_id   VARCHAR(36)  NULL,
  menu_type   VARCHAR(2)   NULL,
  menu_level  VARCHAR(2)   NULL,
  menu_name   VARCHAR(100) NULL,
  menu_code   VARCHAR(50)  NULL,
  menu_path   VARCHAR(400) NULL,
  form_id     VARCHAR(36)  NULL,
  menu_url    VARCHAR(400) NULL,
  remark      TEXT         NULL,
  order_num   NUMERIC      NULL,
  status      VARCHAR(2)   NULL,
  create_date DATE         NULL,
  CONSTRAINT PK_SYS_MENU PRIMARY KEY (menu_id)
);

COMMENT ON TABLE sys_menu IS
'系统菜单表';

COMMENT ON COLUMN sys_menu.menu_id IS
'菜单ID';

COMMENT ON COLUMN sys_menu.parent_id IS
'上级菜单ID';

COMMENT ON COLUMN sys_menu.menu_type IS
'菜单类型：1系统，2模块，3菜单';

COMMENT ON COLUMN sys_menu.menu_level IS
'菜单级别';

COMMENT ON COLUMN sys_menu.menu_name IS
'菜单名称';

COMMENT ON COLUMN sys_menu.menu_code IS
'菜单编码';

COMMENT ON COLUMN sys_menu.menu_path IS
'菜单路径:上级菜单路径+本级菜单编码';

COMMENT ON COLUMN sys_menu.form_id IS
'表单ID';

COMMENT ON COLUMN sys_menu.menu_url IS
'对应URL';

COMMENT ON COLUMN sys_menu.remark IS
'备注';

COMMENT ON COLUMN sys_menu.order_num IS
'排序码';

COMMENT ON COLUMN sys_menu.status IS
'状态';

COMMENT ON COLUMN sys_menu.create_date IS
'创建时间';

/*==============================================================*/
/* Table: sys_role                                              */
/*==============================================================*/
CREATE TABLE sys_role (
  role_id     VARCHAR(36)  NOT NULL DEFAULT uuid_generate_v4(),
  parent_id   VARCHAR(36)  NULL,
  role_name   VARCHAR(100) NULL,
  description VARCHAR(400) NULL,
  remark      TEXT         NULL,
  order_num   NUMERIC      NULL,
  status      VARCHAR(2)   NULL,
  create_date DATE         NULL,
  CONSTRAINT PK_SYS_ROLE PRIMARY KEY (role_id)
);

COMMENT ON TABLE sys_role IS
'角色表';

COMMENT ON COLUMN sys_role.role_id IS
'角色ID';

COMMENT ON COLUMN sys_role.parent_id IS
'上级角色';

COMMENT ON COLUMN sys_role.role_name IS
'角色名称';

COMMENT ON COLUMN sys_role.description IS
'描述';

COMMENT ON COLUMN sys_role.remark IS
'备注';

COMMENT ON COLUMN sys_role.order_num IS
'排序码';

COMMENT ON COLUMN sys_role.status IS
'状态';

COMMENT ON COLUMN sys_role.create_date IS
'创建时间';

/*==============================================================*/
/* Table: sys_role_auth_rel                                     */
/*==============================================================*/
CREATE TABLE sys_role_auth_rel (
  guid           VARCHAR(36) NOT NULL DEFAULT uuid_generate_v4(),
  role_id        VARCHAR(36) NULL,
  auth_id        VARCHAR(36) NULL,
  status         VARCHAR(2)  NULL,
  operation_date DATE        NULL,
  CONSTRAINT PK_SYS_ROLE_AUTH_REL PRIMARY KEY (guid)
);

COMMENT ON TABLE sys_role_auth_rel IS
'角色权限关系表';

COMMENT ON COLUMN sys_role_auth_rel.guid IS
'关系ID';

COMMENT ON COLUMN sys_role_auth_rel.role_id IS
'角色ID';

COMMENT ON COLUMN sys_role_auth_rel.auth_id IS
'权限ID';

COMMENT ON COLUMN sys_role_auth_rel.status IS
'状态';

COMMENT ON COLUMN sys_role_auth_rel.operation_date IS
'操作时间';

/*==============================================================*/
/* Table: sys_user                                              */
/*==============================================================*/
CREATE TABLE sys_user (
  user_id       VARCHAR(36)  NOT NULL DEFAULT uuid_generate_v4(),
  user_name     VARCHAR(64)  NULL,
  password      VARCHAR(100) NULL,
  question      VARCHAR(100) NULL,
  answer        VARCHAR(100) NULL,
  persion_name  VARCHAR(10)  NULL,
  persion_sex   VARCHAR(2)   NULL,
  mobile        VARCHAR(50)  NULL,
  telephone     VARCHAR(50)  NULL,
  email         VARCHAR(100) NULL,
  user_position VARCHAR(50)  NULL,
  img_url       VARCHAR(100) NULL,
  remark        TEXT         NULL,
  order_num     NUMERIC      NULL,
  status        VARCHAR(2)   NULL,
  create_time   DATE         NULL,
  CONSTRAINT PK_SYS_USER PRIMARY KEY (user_id)
);

COMMENT ON TABLE sys_user IS
'系统用户表';

COMMENT ON COLUMN sys_user.user_id IS
'用户ID';

COMMENT ON COLUMN sys_user.user_name IS
'登录名称';

COMMENT ON COLUMN sys_user.password IS
'密码';

COMMENT ON COLUMN sys_user.question IS
'重置密码问题';

COMMENT ON COLUMN sys_user.answer IS
'重置密码答案';

COMMENT ON COLUMN sys_user.persion_name IS
'用户姓名';

COMMENT ON COLUMN sys_user.persion_sex IS
'用户性别';

COMMENT ON COLUMN sys_user.mobile IS
'移动电话';

COMMENT ON COLUMN sys_user.telephone IS
'办公电话';

COMMENT ON COLUMN sys_user.email IS
'电子邮箱';

COMMENT ON COLUMN sys_user.user_position IS
'职位名称';

COMMENT ON COLUMN sys_user.img_url IS
'头像';

COMMENT ON COLUMN sys_user.remark IS
'备注';

COMMENT ON COLUMN sys_user.order_num IS
'排序码';

COMMENT ON COLUMN sys_user.status IS
'状态';

COMMENT ON COLUMN sys_user.create_time IS
'创建时间';

/*==============================================================*/
/* Table: sys_user_auth_rel                                     */
/*==============================================================*/
CREATE TABLE sys_user_auth_rel (
  guid           VARCHAR(36) NOT NULL DEFAULT uuid_generate_v4(),
  user_id        VARCHAR(36) NULL,
  auth_id        VARCHAR(36) NULL,
  status         VARCHAR(2)  NULL,
  operation_date DATE        NULL,
  CONSTRAINT PK_SYS_USER_AUTH_REL PRIMARY KEY (guid)
);

COMMENT ON TABLE sys_user_auth_rel IS
'用户权限关系表';

COMMENT ON COLUMN sys_user_auth_rel.guid IS
'关系ID';

COMMENT ON COLUMN sys_user_auth_rel.user_id IS
'组ID';

COMMENT ON COLUMN sys_user_auth_rel.auth_id IS
'权限ID';

COMMENT ON COLUMN sys_user_auth_rel.status IS
'状态';

COMMENT ON COLUMN sys_user_auth_rel.operation_date IS
'操作时间';

/*==============================================================*/
/* Table: sys_user_department_rel                               */
/*==============================================================*/
CREATE TABLE sys_user_department_rel (
  guid           VARCHAR(36) NOT NULL DEFAULT uuid_generate_v4(),
  user_id        VARCHAR(36) NULL,
  department_id  VARCHAR(36) NULL,
  status         VARCHAR(2)  NULL,
  operation_date DATE        NULL,
  CONSTRAINT PK_SYS_USER_DEPARTMENT_REL PRIMARY KEY (guid)
);

COMMENT ON TABLE sys_user_department_rel IS
'用户部门关系表';

COMMENT ON COLUMN sys_user_department_rel.guid IS
'关系ID';

COMMENT ON COLUMN sys_user_department_rel.user_id IS
'组ID';

COMMENT ON COLUMN sys_user_department_rel.department_id IS
'部门ID';

COMMENT ON COLUMN sys_user_department_rel.status IS
'状态';

COMMENT ON COLUMN sys_user_department_rel.operation_date IS
'操作时间';

/*==============================================================*/
/* Table: sys_user_group_rel                                    */
/*==============================================================*/
CREATE TABLE sys_user_group_rel (
  guid           VARCHAR(36) NOT NULL DEFAULT uuid_generate_v4(),
  user_id        VARCHAR(36) NULL,
  group_id       VARCHAR(36) NULL,
  status         VARCHAR(2)  NULL,
  operation_date DATE        NULL,
  CONSTRAINT PK_SYS_USER_GROUP_REL PRIMARY KEY (guid)
);

COMMENT ON TABLE sys_user_group_rel IS
'用户组关系表';

COMMENT ON COLUMN sys_user_group_rel.guid IS
'关系ID';

COMMENT ON COLUMN sys_user_group_rel.user_id IS
'组ID';

COMMENT ON COLUMN sys_user_group_rel.group_id IS
'组ID';

COMMENT ON COLUMN sys_user_group_rel.status IS
'状态';

COMMENT ON COLUMN sys_user_group_rel.operation_date IS
'操作时间';

/*==============================================================*/
/* Table: sys_user_role_rel                                     */
/*==============================================================*/
CREATE TABLE sys_user_role_rel (
  guid           VARCHAR(36) NOT NULL DEFAULT uuid_generate_v4(),
  user_id        VARCHAR(36) NULL,
  role_id        VARCHAR(36) NULL,
  status         VARCHAR(2)  NULL,
  operation_date DATE        NULL,
  CONSTRAINT PK_SYS_USER_ROLE_REL PRIMARY KEY (guid)
);

COMMENT ON TABLE sys_user_role_rel IS
'用户角色关系表';

COMMENT ON COLUMN sys_user_role_rel.guid IS
'关系ID';

COMMENT ON COLUMN sys_user_role_rel.user_id IS
'组ID';

COMMENT ON COLUMN sys_user_role_rel.role_id IS
'权限ID';

COMMENT ON COLUMN sys_user_role_rel.status IS
'状态';

COMMENT ON COLUMN sys_user_role_rel.operation_date IS
'操作时间';

/*==============================================================*/
/* Table: sys_company_dept_rel                                  */
/*==============================================================*/
CREATE TABLE sys_company_dept_rel (
  guid           VARCHAR(36) NOT NULL DEFAULT uuid_generate_v4(),
  company_id     VARCHAR(36) NULL,
  department_id  VARCHAR(36) NULL,
  status         VARCHAR(2)  NULL,
  operation_date DATE        NULL,
  CONSTRAINT PK_SYS_COMPANY_DEPT_REL PRIMARY KEY (guid)
);

COMMENT ON TABLE sys_company_dept_rel IS
'公司部门关联表';

COMMENT ON COLUMN sys_company_dept_rel.guid IS
'关系ID';

COMMENT ON COLUMN sys_company_dept_rel.company_id IS
'公司ID';

COMMENT ON COLUMN sys_company_dept_rel.department_id IS
'部门ID';

COMMENT ON COLUMN sys_company_dept_rel.status IS
'状态';

COMMENT ON COLUMN sys_company_dept_rel.operation_date IS
'操作时间';


/*==============================================================*/
/* Table: sys_code                                              */
/*==============================================================*/
CREATE TABLE sys_code (
  id          VARCHAR(36)  NOT NULL DEFAULT uuid_generate_v4(),
  code_num    VARCHAR(36)  NULL,
  code_name   VARCHAR(100) NULL,
  parent_num  VARCHAR(36)  NULL,
  c_type      VARCHAR(50)  NULL,
  c_type_name VARCHAR(36)  NULL,
  order_num   NUMERIC      NULL,
  CONSTRAINT PK_SYS_CODE PRIMARY KEY (id)
);

COMMENT ON TABLE sys_code IS
'系统公共代码表';

COMMENT ON COLUMN sys_code.id IS
'唯一ID';

COMMENT ON COLUMN sys_code.code_num IS
'代码编号';

COMMENT ON COLUMN sys_code.code_name IS
'代码名称';

COMMENT ON COLUMN sys_code.parent_num IS
'上级编号';

COMMENT ON COLUMN sys_code.c_type IS
'代码类型编号';

COMMENT ON COLUMN sys_code.c_type_name IS
'代码类型名称';

COMMENT ON COLUMN sys_code.order_num IS
'排序号';


/*==============================================================*/
/* Table: sys_form_control_groups                                              */
/*==============================================================*/
CREATE TABLE "public"."sys_form_control_groups" (
  "group_id"   VARCHAR(30) COLLATE "pg_catalog"."default" NOT NULL,
  "group_name" VARCHAR(50) COLLATE "pg_catalog"."default",
  "img"        VARCHAR(50) COLLATE "pg_catalog"."default",
  "order_num"  NUMERIC,
  "status"     VARCHAR(1) COLLATE "pg_catalog"."default"
);


COMMENT ON COLUMN "public"."sys_form_control_groups"."group_id" IS '组ID';

COMMENT ON COLUMN "public"."sys_form_control_groups"."group_name" IS '组名称';

COMMENT ON COLUMN "public"."sys_form_control_groups"."img" IS '图标';

COMMENT ON COLUMN "public"."sys_form_control_groups"."order_num" IS '排序号';

COMMENT ON COLUMN "public"."sys_form_control_groups"."status" IS '状体';

COMMENT ON TABLE "public"."sys_form_control_groups" IS '控件组';
-- ----------------------------
-- Primary Key structure for table sys_form_control_groups
-- ----------------------------
ALTER TABLE "public"."sys_form_control_groups"
  ADD CONSTRAINT "sys_form_control_groups_pkey" PRIMARY KEY ("group_id");


/*==============================================================*/
/* Table: sys_from_controls                                              */
/*==============================================================*/
CREATE TABLE "public"."sys_from_controls" (
  "control_id"   VARCHAR(20) COLLATE "pg_catalog"."default" NOT NULL,
  "control_name" VARCHAR(50) COLLATE "pg_catalog"."default",
  "img"          VARCHAR(200) COLLATE "pg_catalog"."default",
  "status"       VARCHAR(1) COLLATE "pg_catalog"."default",
  "order_num"    NUMERIC,
  "group_id"     VARCHAR COLLATE "pg_catalog"."default"
);
COMMENT ON COLUMN "public"."sys_from_controls"."control_id" IS '控件ID';
COMMENT ON COLUMN "public"."sys_from_controls"."control_name" IS '空间名称';
COMMENT ON COLUMN "public"."sys_from_controls"."img" IS '图标';
COMMENT ON COLUMN "public"."sys_from_controls"."status" IS '状态';
COMMENT ON COLUMN "public"."sys_from_controls"."order_num" IS '排序号';
COMMENT ON COLUMN "public"."sys_from_controls"."group_id" IS '所属组ID';
COMMENT ON TABLE "public"."sys_from_controls" IS '控件表';

-- ----------------------------
-- Primary Key structure for table sys_from_controls
-- ----------------------------
ALTER TABLE "public"."sys_from_controls"
  ADD CONSTRAINT "sys_from_controls_pkey" PRIMARY KEY ("control_id");

-- ----------------------------
-- Foreign Keys structure for table sys_from_controls
-- ----------------------------
ALTER TABLE "public"."sys_from_controls"
  ADD CONSTRAINT "sys_from_controls_group_id_fkey" FOREIGN KEY ("group_id") REFERENCES "sys_form_control_groups" ("group_id") ON DELETE NO ACTION ON UPDATE NO ACTION;

/*==============================================================*/
/* Table: sys_form_def                                              */
/*==============================================================*/
CREATE TABLE sys_form_def (
  form_id           VARCHAR(36) NOT NULL DEFAULT uuid_generate_v4(),
  form_name         VARCHAR(64) NULL,
  remark            TEXT        NULL,
  order_num         NUMERIC     NULL,
  status            VARCHAR(2)  NULL,
  operation_time    DATE        NULL,
  operation_persion VARCHAR(64) NULL,
  CONSTRAINT PK_sys_form_def PRIMARY KEY (form_id)
);

COMMENT ON TABLE sys_form_def IS
'表单定义表';

COMMENT ON COLUMN sys_form_def.form_id IS
'表单ID';

COMMENT ON COLUMN sys_form_def.form_name IS
'表单名称';

COMMENT ON COLUMN sys_form_def.remark IS
'备注';

COMMENT ON COLUMN sys_form_def.order_num IS
'排序码';

COMMENT ON COLUMN sys_form_def.status IS
'状态';

COMMENT ON COLUMN sys_form_def.operation_time IS
'操作时间';

COMMENT ON COLUMN sys_form_def.operation_persion IS
'操作人';
