package app.management.roleinfo.service;


import app.management.roleinfo.model.RoleInfo;

import java.util.List;

/**
 * Created by real on 2018/1/25.
 */
public interface RoleInfoService {

    RoleInfo getItem(String roleId);

    List<RoleInfo> getItems();
}
