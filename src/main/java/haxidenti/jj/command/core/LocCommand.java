package haxidenti.jj.command.core;

import haxidenti.jj.Scope;
import haxidenti.jj.Value;
import haxidenti.jj.command.Command;

public class LocCommand implements Command {
    @Override
    public void run(Scope scope) {
        Value val = scope.stack.pop();
        if (val == null) {
            return;
        }
        Integer labelPos = scope.labels.get(val.getString());
        if (labelPos == null) {
            return;
        }
        scope.stack.push(new Value(labelPos));
    }
}
