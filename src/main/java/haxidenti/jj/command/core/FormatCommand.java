package haxidenti.jj.command.core;

import haxidenti.jj.Scope;
import haxidenti.jj.Value;
import haxidenti.jj.command.Command;

public class FormatCommand implements Command {
    @Override
    public void run(Scope scope) {
        Value val = scope.stack.pop();
        boolean nullErr = false;
        boolean noStr = false;
        if (val == null) {
            nullErr = true;
        }
        if (val.getString() == null) {
            noStr = true;
        }
        if (nullErr || noStr) {
            scope.pushError("FormatString is empty or null");
            return;
        }
    }
}
