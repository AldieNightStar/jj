package haxidenti.jj.util;

import haxidenti.jj.Scope;
import haxidenti.jj.Value;

public class ValueUtil {
    public static Integer getLabel(Value val, Scope scope) {
        if (val == null) {
            return null;
        }
        String s = val.getString();
        if (s != null) {
            Integer id = scope.labels.get(s);
            if (id != null) {
                return id;
            } else {
                return null;
            }
        } else {
            Float id = val.getNumber();
            if (id == null) {
                return null;
            }
            return id.intValue();
        }
    }

    public static Float getNumber(Value value) {
        if (value == null) {
            return null;
        }
        return value.getNumber();
    }
}
