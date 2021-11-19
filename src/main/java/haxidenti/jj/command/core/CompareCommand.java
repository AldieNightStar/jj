package haxidenti.jj.command.core;

import haxidenti.jj.Scope;
import haxidenti.jj.Value;
import haxidenti.jj.command.Command;

import java.util.function.BiPredicate;

public class CompareCommand implements Command {

    BiPredicate<Value, Value> biPredicate;

    public CompareCommand(BiPredicate<Value, Value> biPredicate) {
        this.biPredicate = biPredicate;
    }

    @Override
    public void run(Scope scope) {
        Value val1 = scope.stack.pop();
        Value val2 = scope.stack.pop();
        scope.flag = biPredicate.test(val2, val1);
    }
}
