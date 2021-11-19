package haxidenti.jj.command.core;

import haxidenti.jj.Scope;
import haxidenti.jj.Value;
import haxidenti.jj.command.Command;
import haxidenti.jj.util.ValueUtil;

public class GotoCommand implements Command {
    @Override
    public void run(Scope scope) {
        // Get string. If no string, then number
        Value val = scope.stack.pop();
        if (val ==  null) {
            scope.pushError("Value is null");
            return;
        }
        Integer lab = ValueUtil.getLabel(val, scope);
        if (lab != null) {
            scope.programPointer = lab;
            scope.skipProgramPointerIncrease = true;
        } else {
            scope.pushError("GOTO label not found!");
        }
    }
}
