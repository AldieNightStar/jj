package haxidenti.jj.command.core;

import haxidenti.jj.Scope;
import haxidenti.jj.Value;
import haxidenti.jj.command.Command;

import java.util.function.BiFunction;

public class MathCommand implements Command {
    private final BiFunction<Float, Float, Float> f;

    public MathCommand(BiFunction<Float, Float, Float> f) {
        this.f = f;
    }

    @Override
    public void run(Scope scope) {
        Value val2 = scope.stack.pop();
        Value val1 = scope.stack.pop();
        if (val1 == null || val2 == null) {
            scope.pushError("Values for number is not present");
            return;
        }
        Float v1 = val1.getNumber();
        Float v2 = val2.getNumber();
        if (v1 == null || v2 == null) {
            scope.pushError("Values for Math operation has null numbers.");
            return;
        }
        scope.stack.push(new Value(f.apply(v1, v2)));
    }
}
