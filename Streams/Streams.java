package Streams;

import java.util.*;

/**
 * Created by SBT-SAFONOV-VV on 13.12.2016.
 */
public class Streams<T> {
    List<T> list;

    Streams(List<? extends T> list){
        this.list = new ArrayList();
        for(T o: list)
            this.list.add(o);
    }

    public static Streams of(List list) {
            return new Streams(list);
    }

    public Streams filter(Applyer<? super T> applyer) {
        for(T o: list)
            if(!applyer.apply(o))
                list.remove(o);
        return this;
    }

    public Streams transform(Transformer<? extends T> transformer) {
        List<? super T> list2 = new ArrayList<>();
        for(T o: list)
            list2.add(transformer.transform(o));
        return new Streams(list2);
    }

    public Map toMap(Mapper mapper) {
        Map map = new HashMap();
        for(T o: list)
            map.put(mapper.getKey(o), mapper.getValue(o));
        return map;
    }
}

