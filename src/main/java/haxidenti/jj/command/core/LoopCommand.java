package haxidenti.jj.command.core;

import haxidenti.jj.Scope;
import haxidenti.jj.command.Command;
import haxidenti.jj.util.ValueUtil;

public class LoopCommand implements Command {
    @Override
    public void run(Scope scope) {
        Float number = ValueUtil.getNumber(scope.stack.pop());
        if (number == null) {
            scope.pushError("Can't find number for loop");
            return;
        }
        if (scope.loopPointer == null) {
            scope.pushError("Loop pointer is null. Use 'start' to set.");
            return;
        }
        if (number > 0) {
            scope.programPointer = scope.loopPointer;
            scope.skipProgramPointerIncrease = true;
        }
    }
}
