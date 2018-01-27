package app.services.impl;

import app.comn.PageModel;
import app.comn.ServiceException;
import app.dao.mappers.SysRoleMapper;
import app.model.Role;
import app.services.RoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by real on 2018/1/27.
 */
@Service
public class RoleServiceImpl implements RoleService {

    @Resource
    private SysRoleMapper sysRoleMapper;

    @Override
    public Role getItem(String key) {
        return null;
    }

    @Override
    public List<Role> getItems() {
        return null;
    }

    @Override
    public PageModel<Role> getItemsByPage(int pageNum, int pageSize) {
        return null;
    }

    @Override
    public void addItem(Role item) throws ServiceException {

    }

    @Override
    public void delItem(String key) throws ServiceException {

    }

    @Override
    public void updateItem(Role item) throws ServiceException {

    }

    @Override
    public void addItems(List<Role> items) throws ServiceException {

    }

    @Override
    public void delItems(List<String> keys) throws ServiceException {

    }

    @Override
    public void updateItems(List<Role> items) throws ServiceException {

    }

    @Override
    public long recordCount(String key) {
        return 0;
    }
}
