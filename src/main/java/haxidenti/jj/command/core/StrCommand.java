package haxidenti.jj.command.core;

import haxidenti.jj.Scope;
import haxidenti.jj.Value;
import haxidenti.jj.command.Command;

public class StrCommand implements Command {
    @Override
    public void run(Scope scope) {
        Float number = scope.stack.pop().getNumber();
        if (number == null) {
            scope.pushError("Number is not present");
        }
        scope.stack.push(new Value("" + number));
    }
}
