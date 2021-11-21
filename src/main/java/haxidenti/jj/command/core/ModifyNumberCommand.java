package haxidenti.jj.command.core;

import haxidenti.jj.Scope;
import haxidenti.jj.Value;
import haxidenti.jj.command.Command;

import java.util.function.Function;

public class ModifyNumberCommand implements Command {

    Function<Float, Float> mod;

    public ModifyNumberCommand(Function<Float, Float> mod) {
        this.mod = mod;
    }

    @Override
    public void run(Scope scope) {
        Value v = scope.stack.pop();
        if (v == null || v.getNumber() == null) {
            scope.pushError("Can't find any number: null");
            return;
        }
        scope.stack.push(new Value(mod.apply(v.getNumber())));
    }
}
