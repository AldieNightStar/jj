package haxidenti.jj.command.core;

import haxidenti.jj.Scope;
import haxidenti.jj.command.Command;
import haxidenti.jj.util.ValueUtil;

import java.util.function.BiPredicate;

public class CompareNumberCommand implements Command {

    private final BiPredicate<Float, Float> biPredicate;

    public CompareNumberCommand(BiPredicate<Float, Float> biPredicate) {
        this.biPredicate = biPredicate;
    }

    @Override
    public void run(Scope scope) {
        Float n1 = ValueUtil.getNumber(scope.stack.pop());
        Float n2 = ValueUtil.getNumber(scope.stack.pop());
        if (n1 == null || n2 == null) {
            scope.pushError("Numbers should be present!");
            return;
        }
        scope.flag = biPredicate.test(n1, n2);
    }
}
