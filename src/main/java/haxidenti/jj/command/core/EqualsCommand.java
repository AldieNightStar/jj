package haxidenti.jj.command.core;

import haxidenti.jj.Scope;
import haxidenti.jj.Value;
import haxidenti.jj.command.Command;

public class EqualsCommand implements Command {

    @Override
    public void run(Scope scope) {
        Value val1 = scope.stack.pop();
        Value val2 = scope.stack.pop();
        if (val1 == null || val2 == null) {
            scope.pushError("Values cannot be null!");
            return;
        }
        scope.flag = val1.equals(val2);
    }
}
