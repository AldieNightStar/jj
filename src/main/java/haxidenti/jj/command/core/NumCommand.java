package haxidenti.jj.command.core;

import haxidenti.jj.Scope;
import haxidenti.jj.Value;
import haxidenti.jj.command.Command;

public class NumCommand implements Command {
    @Override
    public void run(Scope scope) {
        Value val = scope.stack.pop();
        float n = Float.parseFloat(val.getString());
        scope.stack.push(new Value(n));
    }
}
