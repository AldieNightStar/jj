package haxidenti.jj.command.core;

import haxidenti.jj.Scope;
import haxidenti.jj.command.Command;

public class FlagCommand implements Command {

    Command command;
    boolean success;

    public FlagCommand(boolean success, Command command) {
        this.command = command;
        this.success = success;
    }

    @Override
    public void run(Scope scope) {
        if ((success && scope.flag) || (!success && !scope.flag)) {
            command.run(scope);
        }
    }
}
