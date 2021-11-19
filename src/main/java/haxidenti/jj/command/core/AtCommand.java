package haxidenti.jj.command.core;

import haxidenti.jj.Scope;
import haxidenti.jj.Value;
import haxidenti.jj.command.Command;

public class AtCommand implements Command {
    @Override
    public void run(Scope scope) {
        Value arr = scope.stack.pop();
        Value index = scope.stack.pop();

        if (index == null || index.getNumber() == null) {
            scope.pushError("Index isn't present!");
            return;
        }
        Value valInArr = arr.get(index.getNumber().intValue());

        scope.stack.push(arr);
        scope.stack.push(valInArr);
    }
}
