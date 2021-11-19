package haxidenti.jj.command.core;

import haxidenti.jj.Scope;
import haxidenti.jj.Value;
import haxidenti.jj.command.Command;

import java.util.function.Consumer;

public class PrintCommand implements Command {

    public Consumer<String> printer;

    public PrintCommand(Consumer<String> printer) {
        this.printer = printer;
    }

    @Override
    public void run(Scope scope) {
        Value val = scope.stack.pop();
        if (val == null) {
            return;
        }
        String string = val.getString();
        Float number = val.getNumber();
        if (string != null) {
            printer.accept(string);
        } else {
            printer.accept("" + number);
        }
    }
}
