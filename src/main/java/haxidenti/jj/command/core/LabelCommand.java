package haxidenti.jj.command.core;

import haxidenti.jj.Scope;
import haxidenti.jj.command.Command;

public class LabelCommand implements Command {

    public String labelName;

    public LabelCommand(String name) {
        this.labelName = name;
    }

    @Override
    public void run(Scope scope) {
        scope.labels.putIfAbsent(labelName, scope.programPointer);
    }
}
