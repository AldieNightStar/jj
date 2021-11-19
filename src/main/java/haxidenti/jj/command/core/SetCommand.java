package haxidenti.jj.command.core;

import haxidenti.jj.Scope;
import haxidenti.jj.Value;
import haxidenti.jj.command.Command;

public class SetCommand implements Command {
    @Override
    public void run(Scope scope) {
        Value idVal = scope.stack.pop();
        Value toSetVal = scope.stack.pop();
        if (idVal == null || idVal.getNumber() == null) {
            scope.pushError("Value for set command is null!");
            return;
        }
        int id = idVal.getNumber().intValue();
        if (id < 0) {
            scope.pushError("Set cannot acess memory less than zero!");
            return;
        }
        scope.mem[id] = toSetVal;
    }
}
