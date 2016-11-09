package Reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

/**
 * Created by Владимир on 09.11.2016.
 */
public class BeanUtils {
    public static void assign(Object to, Object from) {
        Method[] fromMethods;
        Method[] toMethods;
        fromMethods = from.getClass().getMethods();
        toMethods = to.getClass().getMethods();
        for(Method fromMeth : fromMethods){
            for(Method toMeth : toMethods)
                if(doAllChecks(toMeth, fromMeth))
                    try{
                    toMeth.invoke(to, fromMeth.invoke(from));
                } catch (InvocationTargetException e) {
                        e.printStackTrace();
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
        }

    }

    private static boolean doAllChecks(Method to, Method from){
        if(isSetter(to) && isGetter(from) && isSame(to.getName(), from.getName()) && checkCompatibility(to, from))
            return true;
        return false;
    }

    private static boolean isSame(String to, String from){
        if (from.replaceAll("get","").equals(to.replaceAll("set", "")))
            return true;
        return false;
    }

    private static boolean isSetter(Method method){
        return method.getName().startsWith("set") == true ?
                true : false;
    }

    private static boolean isGetter(Method method){
        return method.getName().startsWith("get") == true ?
                true : false;
    }

    private static boolean checkCompatibility(Method to, Method from){
        if (from.getReturnType() == to.getParameterTypes()[0]
                && from.getParameterCount() == 0)
            return true;
        return false;
    }



}