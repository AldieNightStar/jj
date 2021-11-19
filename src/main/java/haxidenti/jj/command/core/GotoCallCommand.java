package haxidenti.jj.command.core;

import haxidenti.jj.Scope;
import haxidenti.jj.Value;
import haxidenti.jj.command.Command;
import haxidenti.jj.util.ValueUtil;

public class GotoCallCommand implements Command {

    @Override
    public void run(Scope scope) {
        Value val = scope.stack.pop();
        if (val == null) {
            scope.pushError("Value is null!");
            return;
        }
        Integer labId = ValueUtil.getLabel(val, scope);

        if (labId != null) {
            int ptr = scope.programPointer + 1;
            scope.callStack.push(new Value(ptr));
            scope.programPointer = labId;
            scope.skipProgramPointerIncrease = true;
        } else {
            scope.pushError("Label not found!");
        }
    }
}
