package haxidenti.jj.command.core;

import haxidenti.jj.Scope;
import haxidenti.jj.Value;
import haxidenti.jj.command.Command;

public class ReturnCommand implements Command {
    @Override
    public void run(Scope scope) {
        Value value = scope.callStack.pop();
        if (value == null || value.getNumber() == null) {
            return;
        }
        scope.programPointer = value.getNumber().intValue();
        scope.skipProgramPointerIncrease = true;
    }
}
