package app.system.widgetinfo.service.impl;

import app.system.widgetinfo.entities.FieldAttributeEntity;
import app.system.widgetinfo.entities.WidgetInfoEntity;
import app.system.widgetinfo.entities.WidgetsEntity;
import app.system.widgetinfo.mappers.WidgetInfoMapper;
import app.system.widgetinfo.model.FieldAttribute;
import app.system.widgetinfo.model.WidgetInfo;
import app.system.widgetinfo.model.Widgets;
import app.system.widgetinfo.service.WidgetInfoSercice;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by real on 2018/2/6.
 */
@Service
public class WidgetInfoServiceImpl implements WidgetInfoSercice {

    @Resource
    private WidgetInfoMapper widgetInfoMapper;


    @Override
    public List<WidgetInfo> getItems() {

        //获取所有组的所有控件信息，不包括控件的属性值
        List<WidgetInfoEntity> widgetInfoEntities = widgetInfoMapper.selectByStatus("y", "y");

        ArrayList<WidgetInfo> widgetInfos = new ArrayList<>();
        for (WidgetInfoEntity widgetInfoEntitie : widgetInfoEntities) {
            WidgetInfo widgetInfo = new WidgetInfo();
            BeanUtils.copyProperties(widgetInfoEntitie, widgetInfo);

            ArrayList<Widgets> widgetsList = new ArrayList<>();
            for (WidgetsEntity widgetsEntity : widgetInfoEntitie.getWidgets()) {
                Widgets widgets = new Widgets();
                BeanUtils.copyProperties(widgetsEntity, widgets);
                widgetsList.add(widgets);
            }
            widgetInfo.setWidgets(widgetsList);
            widgetInfos.add(widgetInfo);
        }


        //List<WidgetInfo> widgetInfos = widgetInfoConverter.convert2ModelList(widgetInfoEntities);

        return widgetInfos;
    }

    @Override
    public FieldAttribute getControlAttributes(String controlId, String status) {
        FieldAttributeEntity fieldAttributeEntity = widgetInfoMapper.selectWidgetByFieldId(controlId, status);
        FieldAttribute fieldAttribute = new FieldAttribute();
        BeanUtils.copyProperties(fieldAttributeEntity, fieldAttribute);

        return fieldAttribute;
    }


}
