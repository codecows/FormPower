package app.system.widgetinfo.conterver;

import app.base.converter.ConverterBase;
import app.system.widgetinfo.entities.WidgetInfoEntity;
import app.system.widgetinfo.model.WidgetInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class WidgetInfoConverter extends ConverterBase<WidgetInfo, WidgetInfoEntity> {
    @Override
    public WidgetInfo convert2Model(WidgetInfoEntity widgetInfoEntity) {
        WidgetInfo widgetInfo = new WidgetInfo();
        BeanUtils.copyProperties(widgetInfoEntity, widgetInfo);
        return widgetInfo;
    }

    @Override
    public WidgetInfoEntity convert2Entity(WidgetInfo widgetInfo) {
        WidgetInfoEntity widgetInfoEntity = new WidgetInfoEntity();
        BeanUtils.copyProperties(widgetInfo, widgetInfoEntity);
        return widgetInfoEntity;
    }

}
