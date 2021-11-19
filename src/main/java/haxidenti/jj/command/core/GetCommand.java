package haxidenti.jj.command.core;

import haxidenti.jj.Scope;
import haxidenti.jj.Value;
import haxidenti.jj.command.Command;

public class GetCommand implements Command {
    @Override
    public void run(Scope scope) {
        Value val = scope.stack.pop();
        if (val == null || val.getNumber() == null) {
            scope.pushError("Value for set command is null!");
            return;
        }
        int num = val.getNumber().intValue();
        if (num < 0) {
            scope.pushError("Set cannot acess memory less than zero!");
            return;
        }
        scope.stack.push(scope.mem[num]);
    }
}
