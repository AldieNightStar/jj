package haxidenti.jj;

import static haxidenti.jj.util.ListUtil.atArray;

public class Stack {

    public int max;
    public Value[] values;
    public int ptr = 0;

    public Stack(int max) {
        this.max = max;
        this.values = new Value[max];
    }

    public void push(Value value) {
        if (ptr < 0) ptr = 0;
        if (ptr > (max-1)) {
            return;
        }
        values[ptr++] = value;
    }

    public Value pop() {
        if (ptr < 1) {
            ptr = 0;
        }
        return atArray(values, --ptr, null);
    }

    public Value last() {
        return atArray(values, ptr-1, null);
    }

}
