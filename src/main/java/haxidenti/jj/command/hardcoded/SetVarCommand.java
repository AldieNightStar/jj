package haxidenti.jj.command.hardcoded;

import haxidenti.jj.Scope;
import haxidenti.jj.Value;
import haxidenti.jj.command.Command;

public class SetVarCommand implements Command {

    private String valName;

    public SetVarCommand(String valName) {
        this.valName = valName;
    }

    @Override
    public void run(Scope scope) {
        scope.mem.put(valName, scope.stack.pop());
    }
}
