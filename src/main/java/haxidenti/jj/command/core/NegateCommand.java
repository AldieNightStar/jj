package haxidenti.jj.command.core;

import haxidenti.jj.Scope;
import haxidenti.jj.command.Command;

public class NegateCommand implements Command {
    @Override
    public void run(Scope scope) {
        scope.flag = !scope.flag;
    }
}
