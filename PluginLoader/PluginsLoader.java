package PluginLoader;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by SBT-SAFONOV-VV on 16.11.2016.
 */
public class PluginsLoader {
    private final String path;
    private List<PluginLoader> loaders;

    public PluginsLoader(String path){
        loaders = new ArrayList<PluginLoader>();
        this.path = path;
    }

    public Class loadPlugin(String className, String pluginDir) {

        URL[] myUrls = new URL[1];
        try{
            myUrls[0] = new URL(path +"\\"+ pluginDir);
        } catch (MalformedURLException e) {
            e.printStackTrace();
            return null;
        }
        try (PluginLoader loader = new PluginLoader(myUrls)) {
            loaders.add(loader);

            Class loadedClass = loader.loadClass(className);
            return loadedClass;

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
