package app.services;

import app.comn.PageModel;
import app.comn.ServiceException;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface BaseService<T> {
    T getItem(String key);

    List<T> getItems();

    PageModel<T> getItemsByPage(int pageNum, int pageSize);

    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, timeout = 36000, rollbackFor = Exception.class)
    void addItem(T item) throws ServiceException;

    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, timeout = 36000, rollbackFor = Exception.class)
    void delItem(String key) throws ServiceException;

    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, timeout = 36000, rollbackFor = Exception.class)
    void updateItem(T item) throws ServiceException;

    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, timeout = 36000, rollbackFor = Exception.class)
    void addItems(List<T> items) throws ServiceException;

    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, timeout = 36000, rollbackFor = Exception.class)
    void delItems(List<String> keys) throws ServiceException;

    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, timeout = 36000, rollbackFor = Exception.class)
    void updateItems(List<T> items) throws ServiceException;


    boolean exist(String key);
}
