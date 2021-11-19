package haxidenti.jj.command.core;

import haxidenti.jj.Scope;
import haxidenti.jj.Value;
import haxidenti.jj.command.Command;

public class PushCommand implements Command {

    private Value value;

    public PushCommand(Value val) {
        this.value = val;
    }

    @Override
    public void run(Scope scope) {
        scope.stack.push(value);
    }
}
