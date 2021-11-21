package haxidenti.jj.command.core;

import haxidenti.jj.Scope;
import haxidenti.jj.command.Command;
import haxidenti.jj.util.ValueUtil;

public class GotoCommand implements Command {
    @Override
    public void run(Scope scope) {
        Integer lab = ValueUtil.getLabel(scope.stack.pop(), scope);
        if (lab != null) {
            scope.programPointer = lab;
            scope.skipProgramPointerIncrease = true;
        } else {
            scope.pushError("GOTO label not found!");
        }
    }
}
