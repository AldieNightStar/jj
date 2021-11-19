package haxidenti.jj;

import haxidenti.jj.command.Command;

import java.util.List;
import java.util.Map;

public class Scope {
    public Stack stack;
    public int programPointer;
    public List<Command> code;
    public Map<String, Command> commands;
    public Map<String, Integer> labels;
    public boolean skipProgramPointerIncrease = false;
    public boolean stopTheExecution = false;
    public Value remembered;
    public Stack errors;
    public Stack callStack;
    public boolean flag;

    public void pushError(String err) {
        this.errors.push(new Value(err));
        System.err.println("ERR: " + err);
    }
}
