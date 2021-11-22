package haxidenti.jj.command.core;

import haxidenti.jj.Scope;
import haxidenti.jj.Value;
import haxidenti.jj.command.Command;

public class SetCommand implements Command {
    @Override
    public void run(Scope scope) {
        Value idVal = scope.stack.pop();
        Value toSetVal = scope.stack.pop();
        if (idVal == null || idVal.getString() == null) {
            scope.pushError("Value for set command is null!");
            return;
        }
        String name = idVal.getString();
        if (name.length() < 1) {
            scope.pushError("Set cannot access memory less than zero!");
            return;
        }
        scope.mem.put(name, toSetVal);
    }
}
