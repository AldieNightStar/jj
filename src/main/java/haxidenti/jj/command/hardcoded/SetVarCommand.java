package haxidenti.jj.command.hardcoded;

import haxidenti.jj.Scope;
import haxidenti.jj.Value;
import haxidenti.jj.command.Command;

public class SetVarCommand implements Command {

    private int n;

    public SetVarCommand(int n) {
        this.n = n;
    }

    @Override
    public void run(Scope scope) {
        scope.mem[n] = scope.stack.pop();
    }
}
