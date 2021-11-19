package haxidenti.jj.util;

import java.util.List;

public class ListUtil {
    public static  <T> T at(List<T> list, int id, T def) {
        if (list == null) return def;
        if (id < list.size()) {
            return list.get(id);
        }
        return def;
    }

    public static <T> T atArray(T[] arr, int id, T def) {
        if (id < arr.length && id > -1) {
            return arr[id];
        }
        return def;
    }
}
