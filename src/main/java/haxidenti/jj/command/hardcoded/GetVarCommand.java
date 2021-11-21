package haxidenti.jj.command.hardcoded;

import haxidenti.jj.Scope;
import haxidenti.jj.command.Command;

public class GetVarCommand implements Command {

    private int n;

    public GetVarCommand(int n) {
        this.n = n;
    }

    @Override
    public void run(Scope scope) {
        scope.stack.push(scope.mem[n]);
    }
}
