package haxidenti.jj.command.core;

import haxidenti.jj.Scope;
import haxidenti.jj.Value;
import haxidenti.jj.command.Command;
import haxidenti.jj.util.ValueUtil;

public class DeclareCommand implements Command {

    @Override
    public void run(Scope scope) {
        Value val = scope.stack.pop();
        if (val == null || val.getString() == null) {
            scope.pushError("Value for declaring is null!");
            return;
        }
        Integer lab = ValueUtil.getLabel(val, scope);
        if (lab == null) {
            scope.pushError("Label is not found for declaring");
            return;
        }
        scope.commands.put(val.getString(), sc -> {
            sc.callStack.push(new Value(sc.programPointer + 1));
            sc.programPointer = lab;
            sc.skipProgramPointerIncrease = true;
        });
    }
}
