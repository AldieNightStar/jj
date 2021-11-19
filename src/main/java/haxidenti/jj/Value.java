package haxidenti.jj;

import java.util.ArrayList;
import java.util.List;

import static haxidenti.jj.util.ListUtil.at;

public class Value {
    private Float number;
    private String str = null;
    private List<Value> values;

    public Value(float n) {
        this.number = n;
    }

    public Value(String s) {
        this.str = s;
    }

    public Value(List<Value> values) {
        this.values = values;
    }

    public void add(Value value) {
        if (values == null) {
            values = new ArrayList<>();
        }
        values.add(value);
    }

    public void clear() {
        values.clear();
    }

    public String getString() {
        return str;
    }

    public Float getNumber() {
        return number;
    }

    public Value get(int i) {
        return at(values, i, null);
    }

    public int len() {
        if (values == null) {
            return 0;
        }
        return values.size();
    }
}
