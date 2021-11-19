package haxidenti.jj.command.core;

import haxidenti.jj.Scope;
import haxidenti.jj.Value;
import haxidenti.jj.command.Command;

public class SwapCommand implements Command {

    @Override
    public void run(Scope scope) {
        Value v1 = scope.stack.pop();
        Value v2 = scope.stack.pop();
        scope.stack.push(v1);
        scope.stack.push(v2);
    }
}
