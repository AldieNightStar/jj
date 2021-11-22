package haxidenti.jj.command.hardcoded;

import haxidenti.jj.Scope;
import haxidenti.jj.command.Command;

public class GetVarCommand implements Command {

    private String valName;

    public GetVarCommand(String valName) {
        this.valName = valName;
    }

    @Override
    public void run(Scope scope) {
        scope.stack.push(scope.mem.get(valName));
    }
}
