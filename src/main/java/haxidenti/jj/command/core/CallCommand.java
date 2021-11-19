package haxidenti.jj.command.core;

import haxidenti.jj.Scope;
import haxidenti.jj.command.Command;

public class CallCommand implements Command {

    String whatToCall;

    public CallCommand(String whatToCall) {
        this.whatToCall = whatToCall;
    }

    @Override
    public void run(Scope scope) {
        Command cmd = scope.commands.get(whatToCall);
        if (cmd == null) {
            scope.pushError("No such command: " + whatToCall);
            return;
        }
        cmd.run(scope);
    }
}
