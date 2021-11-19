package haxidenti.jj.command.core;

import haxidenti.jj.Scope;
import haxidenti.jj.Value;
import haxidenti.jj.command.Command;

public class Swap2Command implements Command {

    @Override
    public void run(Scope scope) {
        Value v1 = scope.stack.pop();
        Value v2 = scope.stack.pop();
        Value v3 = scope.stack.pop();
        Value v4 = scope.stack.pop();
        scope.stack.push(v3);
        scope.stack.push(v4);
        scope.stack.push(v1);
        scope.stack.push(v2);
    }
}
