package app.converter;

import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

public abstract class ConverterBase<T, K> implements Converter<T, K> {

    public abstract T convert2Model(K k);

    public abstract K convert2Entity(T t);

    public final List<T> convert2ModelList(List<K> kList) {
        ArrayList<T> ts = new ArrayList<>();
        if (CollectionUtils.isEmpty(kList)) {
            return ts;
        }
        kList.forEach(p -> ts.add(convert2Model(p)));
        return ts;
    }

    public final List<K> convert2EntityList(List<T> tList) {
        ArrayList<K> ts = new ArrayList<>();
        if (CollectionUtils.isEmpty(tList)) {
            return ts;
        }
        tList.forEach(p -> ts.add(convert2Entity(p)));
        return ts;
    }
}
