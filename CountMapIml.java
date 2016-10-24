import java.util.HashMap;
import java.util.Map;

/**
 * Created by Vladimir on 20.10.2016.
 */
public class CountMapIml<T> implements CountMap<T> {

    private HashMap<T, Integer> map;
    public CountMapIml (){
        map = new HashMap<T, Integer>();
    }
    @Override
    public void add(T o) {
        if(map.get(o) == null)
            map.put(o, 1);
        else map.put(o, map.get(o) + 1);
    }

    @Override
    public int getCount(T o) {
        return map.get(o);
    }

    @Override
    public int remove(T o) {
        map.remove(o);
        return 0;
    }

    @Override
    public int size() {
        return map.size();
    }

    @Override
    public void addAll(CountMap<? extends T> source) {
        for(Object o: source.toMap().keySet())
            this.add((T)o);
    }

    @Override
    public Map toMap() {
        Map<? super T, Integer> newMap = new HashMap<>();
        for(T o: map.keySet())
            newMap.put(o, map.get(o));
        return newMap;
    }

    @Override
    public void toMap(Map<? super T, Integer> destination) {
        for(T o: map.keySet())
            destination.put(o, map.get(o));
    }
}
