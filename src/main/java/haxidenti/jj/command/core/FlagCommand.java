package haxidenti.jj.command.core;

import haxidenti.jj.Scope;
import haxidenti.jj.command.Command;

public class FlagCommand implements Command {

    Command command;

    public FlagCommand(Command command) {
        this.command = command;
    }

    @Override
    public void run(Scope scope) {
        if (scope.flag) {
            command.run(scope);
        }
    }
}
