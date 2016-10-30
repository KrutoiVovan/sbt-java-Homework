package Cache;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Makise on 30.10.2016.
 */
public class SimpleHandler<T> implements InvocationHandler {
    private Map<List<Object>, Object> myCache;
    Object currentObj;

    public SimpleHandler() {

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
                return doCachedAction(method, args);
            if (method.getAnnotations()[x].annotationType() == DropCache.class)
                dropCache(method, args);
        }
        return method.invoke(currentObj, args);
    }

    private void dropCache(Method method, Object[] args) {
        myCache.clear();
    }

    private Object doCachedAction(Method method, Object[] args) throws Throwable {
        List<Object> thisQuery = new ArrayList<>();
        thisQuery.add(method.getName());
        thisQuery.add(args);
        Object anws;
        if(myCache.containsKey(thisQuery))
            return myCache.get(thisQuery);
        anws = method.invoke(currentObj, args);
        myCache.put(thisQuery, anws);
        return anws;
    }
}
