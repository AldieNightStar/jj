package haxidenti.jj.command.core;

import haxidenti.jj.Scope;
import haxidenti.jj.Value;
import haxidenti.jj.command.Command;

public class NumCommand implements Command {
    @Override
    public void run(Scope scope) {
        Float n = scope.stack.pop().getNumber();
        if (n == null) n = 0F;
        scope.stack.push(new Value(n.toString()));
    }
}
