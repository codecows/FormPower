package app.user.service.impl;

import app.comn.PageModel;
import app.comn.ServiceException;
import app.user.converter.UserInformationConverter;
import app.dao.entities.UserInformation;
import app.dao.mappers.UserInformationMapper;
import app.user.model.UserInfo;
import app.user.service.UserInformationService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserInformationServiceImpl implements UserInformationService {

    @Resource
    private UserInformationMapper userInformationMapper;

    @Resource
    private UserInformationConverter userInformationConverter;

    @Override
    public UserInfo getItem(String key) {

        UserInformation userInformation = userInformationMapper.selectByPrimaryKey(key);
        UserInfo userInfo = userInformationConverter.convert2Model(userInformation);

        return userInfo;
    }

    @Override
    public List<UserInfo> getItems() {
        return null;
    }

    @Override
    public PageModel<UserInfo> getItemsByPage(int pageNum, int pageSize) {
        return null;
    }

    @Override
    public void addItem(UserInfo item) throws ServiceException {

    }

    @Override
    public void delItem(String key) throws ServiceException {

    }

    @Override
    public void updateItem(UserInfo item) throws ServiceException {

    }

    @Override
    public void addItems(List<UserInfo> items) throws ServiceException {

    }

    @Override
    public void delItems(List<String> keys) throws ServiceException {

    }

    @Override
    public void updateItems(List<UserInfo> items) throws ServiceException {

    }

    @Override
    public long recordCount(String key) {
        return 0;
    }
}
