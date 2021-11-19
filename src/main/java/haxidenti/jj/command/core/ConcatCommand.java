package haxidenti.jj.command.core;

import haxidenti.jj.Scope;
import haxidenti.jj.Value;
import haxidenti.jj.command.Command;

public class ConcatCommand  implements Command {
    @Override
    public void run(Scope scope) {
        Value value1 = scope.stack.pop();
        Value value2 = scope.stack.pop();

        if (value1 == null || value2 == null) {
            scope.pushError("Can't concat. One of values is null");
            return;
        }

        if (value1.getString() == null || value2.getString() == null) {
            scope.pushError("Can't concat. One of values is not a string.");
            return;
        }

        scope.stack.push(new Value(value1.getString() + value2.getString()));
    }
}
