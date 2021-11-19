package haxidenti.jj.command.core;

import haxidenti.jj.Scope;
import haxidenti.jj.Value;
import haxidenti.jj.command.Command;

public class RememberCommand implements Command {

    private boolean toForget;

    public RememberCommand(boolean toForget) {
        this.toForget = false;
    }

    @Override
    public void run(Scope scope) {
        Value val = null;
        if (!toForget) val = scope.stack.pop();
        scope.remembered = val;
    }
}
