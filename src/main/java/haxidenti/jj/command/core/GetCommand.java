package haxidenti.jj.command.core;

import haxidenti.jj.Scope;
import haxidenti.jj.Value;
import haxidenti.jj.command.Command;

public class GetCommand implements Command {
    @Override
    public void run(Scope scope) {
        Value val = scope.stack.pop();
        if (val == null || val.getString() == null) {
            scope.pushError("Value for set command is null!");
            return;
        }
        String name = val.getString();
        if (name.length() < 1) {
            scope.pushError("Set cannot acess memory with key which is empty");
            return;
        }
        scope.stack.push(scope.mem.get(name));
    }
}
