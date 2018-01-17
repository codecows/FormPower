package app.converter;

import java.util.List;

public interface Converter<T, K> {

    T convert2Model(K k);

    K convert2Entity(T t);

    List<T> convert2ModelList(List<K> kList);

    List<K> convert2EntityList(List<T> tList);
}
