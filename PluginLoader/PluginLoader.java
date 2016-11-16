package PluginLoader;

import java.net.URL;
import java.net.URLClassLoader;

/**
 * Created by SBT-SAFONOV-VV on 16.11.2016.
 */
public class PluginLoader extends URLClassLoader {

    private String className;

    public PluginLoader(URL[] urls) {
        super(urls);
    }
    public PluginLoader(URL[] urls, String className) {
        super(urls);
        this.className = className;
    }

    @Override
    public Class<?> loadClass(String s) throws ClassNotFoundException {
        if (s.equals(className)) {
            Class loadedClass = this.findClass(s);
            if(loadedClass == null)
                throw new ClassNotFoundException();
            return loadedClass;
        }

        return super.loadClass(s);
    }

}
