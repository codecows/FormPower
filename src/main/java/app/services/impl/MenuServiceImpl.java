package app.services.impl;

import app.comn.PageModel;
import app.comn.ServiceException;
import app.converter.MenuConverter;
import app.dao.entities.SysMenus;
import app.dao.entities.SysMenusExample;
import app.dao.mappers.SysMenusMapper;
import app.model.Menu;
import app.services.MenuService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class MenuServiceImpl implements MenuService {
    private final static Logger logger = LoggerFactory.getLogger(MenuServiceImpl.class);
    @Resource
    private SysMenusMapper menusMapper;
    @Resource
    private MenuConverter menuConverter;


    @Override
    public Menu getItem(String key) {
        return null;
    }

    @Override
    public List<Menu> getItems() {
        return null;
    }

    @Override
    public PageModel<Menu> getItemsByPage(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        SysMenusExample exam = new SysMenusExample();
        //查询条件
        exam.createCriteria().andIsenabledIsNull();
        //执行查询
        Page<SysMenus> page = (Page<SysMenus>) menusMapper.selectByExample(exam);
        List<Menu> menus = menuConverter.convert2ModelList(page);
        PageModel<Menu> pageModel = new PageModel<>(menus, 8,
                page.getPageNum(),
                page.getPageSize(),
                page.getPages(),
                page.size(),
                page.getTotal(),
                page.getStartRow()
        );
        return pageModel;
    }

    @Override
    public void addItem(Menu item) throws ServiceException {

    }

    @Override
    public void delItem(String key) throws ServiceException {

    }

    @Override
    public void updateItem(Menu item) throws ServiceException {

    }

    @Override
    public void addItems(List<Menu> items) throws ServiceException {

    }

    @Override
    public void delItems(List<String> keys) throws ServiceException {

    }

    @Override
    public void updateItems(List<Menu> items) throws ServiceException {

    }

    @Override
    public boolean exist(String key) {
        return false;
    }
}
