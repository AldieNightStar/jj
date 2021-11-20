package haxidenti.jj.command.core;

import haxidenti.jj.Scope;
import haxidenti.jj.Value;
import haxidenti.jj.command.Command;

public class AppendCommand implements Command {
    @Override
    public void run(Scope scope) {
        Value arr = scope.stack.pop();
        arr.add(scope.stack.pop());
    }
}
