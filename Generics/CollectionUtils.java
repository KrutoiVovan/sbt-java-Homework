import javax.xml.soap.Node;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Vladimir on 20.10.2016.
 */
public class CollectionUtils {

    public static<T> void addAll(List<? extends T> source, List<? super T> destination) {

        destination.addAll(source);

    }



    public static<T> List newArrayList() {
        return new ArrayList<T>();
    }



    public static<T> int indexOf(List<? extends T> source, T o) {
        return source.indexOf(o);
    }



    public static<T> List<? super T> limit(List<? extends T> source, int size) {
        List<? super T> list = new ArrayList<>();
        if(source.size() < size){
            for(int i = 0; i < source.size(); i++)
                list.add(i, source.get(i));
        }
        else for(int i = 0; i < size; i++) list.add(i, source.get(i));
        return list;
    }



    public static <T>void add(List<? super T> source, T o) {
        source.add(o);
    }



    public static <T>void removeAll(List<? extends T> removeFrom, List<? extends T> c2) {
        removeFrom.removeAll(c2);
    }



    public static <T>boolean containsAll(List<? extends T> c1, List<? extends T> c2) {
        return c1.containsAll(c2);
    }



    public static <T>boolean containsAny(List<? extends T> c1, List<? super T> c2) {
        for(Object o: c2)
            if(c1.contains(o)) return true;
        return false;
    }



    public static <T extends Comparable<T>> List<? super T> range(List<? extends T> list, T min, T max) {
        List<? super T> list2 = new ArrayList<>();
        for(T o : list)
            if ((o.compareTo(min) > 0) && (o.compareTo(max) < 0))
                list2.add(o);
        return list2;
    }



    public static <T>List<? super T> range(List<? extends T> list, Object min, Object max, Comparator comparator) {
        List<? super T> list2 = new ArrayList<>();
        for(T o : list)
            if ((comparator.compare(o, min) > 0) && (comparator.compare(o, max) < 0))
                list2.add(o);
        return list2;
    }



}