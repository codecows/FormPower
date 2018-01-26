package app.services.impl;

import app.comn.ConstantPage;
import app.comn.PageModel;
import app.comn.ServiceException;
import app.converter.MenuConverter;
import app.dao.entities.SysMenu;
import app.dao.entities.SysMenuExample;
import app.dao.mappers.SysMenuMapper;
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
    private SysMenuMapper menusMapper;
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
        SysMenuExample exam = new SysMenuExample();
        //查询条件
        exam.createCriteria().andStatusEqualTo("1");
        //执行查询
        Page<SysMenu> page = (Page<SysMenu>) menusMapper.selectByExample(exam);
        List<Menu> menus = menuConverter.convert2ModelList(page);
        PageModel<Menu> pageModel = new PageModel<>(menus, ConstantPage.NAVIGATE_SIZE,
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
    public long recordCount(String key) {
        return 0;
    }

}
