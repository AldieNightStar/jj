package haxidenti.jj.command.core;

import haxidenti.jj.Scope;
import haxidenti.jj.Value;
import haxidenti.jj.command.Command;

public class DuplicateCommand implements Command {

    int times;

    public DuplicateCommand(int times) {
        this.times = times;
    }

    @Override
    public void run(Scope scope) {
        Value v = scope.stack.pop();
        for (int i = 0; i < times; i++) {
            scope.stack.push(v);
        }
    }
}
