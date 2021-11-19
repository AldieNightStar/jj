package haxidenti.jj.command.core;

import haxidenti.jj.Scope;
import haxidenti.jj.command.Command;

public class RemindCommand implements Command {
    @Override
    public void run(Scope scope) {
        scope.stack.push(scope.remembered);
    }
}
