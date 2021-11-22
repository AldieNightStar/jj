package haxidenti.jj.command.hardcoded;

import haxidenti.jj.Scope;
import haxidenti.jj.Value;
import haxidenti.jj.command.Command;
import haxidenti.jj.util.ValueUtil;

import java.util.function.Function;

public class GetVarThenCommand implements Command {

    String varName;
    Function<Float, Float> func;

    public GetVarThenCommand(String varName, Function<Float, Float> f) {
        this.varName = varName;
        this.func = f;
    }

    @Override
    public void run(Scope scope) {
        Float number = ValueUtil.getNumber(scope.mem.get(varName));
        if (number == null) {
            scope.pushError("GETVAR_THEN func: Value not found or it isn't a number");
            return;
        }
        scope.stack.push(new Value(number));
        number = func.apply(number);
        scope.mem.put(varName, new Value(number));
    }
}
