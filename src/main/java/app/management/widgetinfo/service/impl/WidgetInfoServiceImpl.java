package app.management.widgetinfo.service.impl;

import app.management.widgetinfo.conterver.WidgetInfoConverter;
import app.management.widgetinfo.entities.WidgetInfoEntity;
import app.management.widgetinfo.mappers.WidgetInfoMapper;
import app.management.widgetinfo.model.WidgetInfo;
import app.management.widgetinfo.service.WidgetInfoSercice;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by real on 2018/2/6.
 */
@Service
public class WidgetInfoServiceImpl implements WidgetInfoSercice {

    @Resource
    private WidgetInfoMapper widgetInfoMapper;

    @Resource
    private WidgetInfoConverter widgetInfoConverter;

    @Override
    public List<WidgetInfo> getItems() {

        List<WidgetInfoEntity> widgetInfoEntities = widgetInfoMapper.selectByStatus("y", "y");
        List<WidgetInfo> widgetInfos = widgetInfoConverter.convert2ModelList(widgetInfoEntities);

        return widgetInfos;
    }
}
