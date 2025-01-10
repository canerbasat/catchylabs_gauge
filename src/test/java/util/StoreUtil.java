package util;

import java.util.concurrent.ConcurrentHashMap;

public class StoreUtil {

    private static final ThreadLocal<ConcurrentHashMap<String, Object>> map = ThreadLocal.withInitial(ConcurrentHashMap::new);



    public static synchronized void put(String key, Object value) {
        if (key != null && value != null) {
            map.get().put(key, value);
        }
    }

    public static synchronized Object remove(Object key) {return key != null ? map.get().remove(key) : null;
    }

    public static synchronized void remove() {
        map.remove();
    }

    public static synchronized Object get(Object key) {
        try {

            Object value = key != null ? map.get().get(key) : null;
            return value;
        } catch (Exception e) {
            System.err.println("Error retrieving object from map:");
            e.printStackTrace();
            return null;
        }
    }
    public static synchronized void clear() {
        map.get().clear();
    }
}
