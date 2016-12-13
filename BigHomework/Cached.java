package BigHomework;

/**
 * Created by Makise on 30.10.2016.
 */
public @interface Cached {
    boolean CacheOnDisk() default false;
    int cachedArgument() default -1;
    int maxOutput() default -1;
    String key() default "file.txt";
    boolean addToZip() default false;

}
