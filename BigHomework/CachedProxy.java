package BigHomework;

import java.io.File;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by Makise on 30.10.2016.
 */
public class CachedProxy<T> implements InvocationHandler {
    private Map<List<Object>, Object> myCache;
    T currentObj;

    public CachedProxy() {

    }

    public T cache(T calc) {
        currentObj = calc;
        return (T) Proxy.newProxyInstance(calc.getClass().getClassLoader(),
                calc.getClass().getInterfaces(),
                this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        for (int x = 0; x < method.getAnnotations().length; x++) {

            if (method.getAnnotations()[x].annotationType() == Cached.class)
                return doCachedAction(method, args,
                        (Cached)method.getAnnotations()[x]);

            if (method.getAnnotations()[x].annotationType() == DropCache.class)
                dropCache(method, args);
        }
        return method.invoke(currentObj, args);
    }

    private void dropCache(Method method, Object[] args) {
        myCache.clear();
    }

    private Object doCachedAction(Method method, Object[] args, Cached annotation) throws Throwable {
        List<Object> thisQuery = new ArrayList<>();
        thisQuery.add(method.getName());
        thisQuery.add(args);
        Object anws;
        if (annotation.CacheOnDisk()) {
            try (DiskCache diskCache = new DiskCache(annotation.key())) {
                if (diskCache.contains(thisQuery))
                    return diskCache.getCache(thisQuery);
                anws = method.invoke(currentObj, args);
                DiskCache.put(thisQuery, anws);
                return anws;
            } catch (IOException e){
                System.out.println("Couldnt Create output file!");
            }
        }
        if (myCache.containsKey(thisQuery))
            return myCache.get(thisQuery);
        anws = method.invoke(currentObj, args);
        myCache.put(thisQuery, anws);
        return anws;
    }
}
