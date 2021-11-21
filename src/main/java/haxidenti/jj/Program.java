package haxidenti.jj;

import haxidenti.jj.command.Command;
import haxidenti.jj.command.core.*;
import haxidenti.jj.parser.Parser;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import static haxidenti.jj.util.ListUtil.at;

public class Program {

    public static List<Command> compile(String s) {
        return Parser.parseAndConvert(s);
    }

    public static void run(List<Command> code, Map<String, Command> commands) {
        Scope scope = createScope(code, commands);
        int codeLen = code.size();
        while (scope.programPointer < codeLen) {
            Command cmd = at(code, scope.programPointer, null);
            cmd.run(scope);
            if (!scope.skipProgramPointerIncrease) {
                scope.programPointer += 1;
            } else {
                scope.skipProgramPointerIncrease = false;
            }
            if (scope.stopTheExecution) {
                break;
            }
        }
    }

    public static Scope createScope(List<Command> code, Map<String, Command> commands) {
        Scope scope = new Scope();
        scope.stack = new Stack(5000);
        scope.programPointer = 0;
        scope.code = code;
        scope.commands = new HashMap<>(64);
        scope.commands.putAll(commands);
        scope.labels = new HashMap<>(64);
        scope.errors = new Stack(1000);
        scope.callStack = new Stack(5000);
        return initLabels(initCommands(scope));
    }

    static Scope initLabels(Scope scope) {
        for (int i = 0; i < scope.code.size(); i++) {
            Command command = scope.code.get(i);
            if (command instanceof LabelCommand) {
                LabelCommand lab = (LabelCommand) command;
                final int pos = i;
                scope.labels.putIfAbsent(lab.labelName, pos);
            }
        }
        return scope;
    }

    static Scope initCommands(Scope scope) {
        // Stack related commands
        scope.commands.put("dup", new DuplicateCommand(1));
        scope.commands.put("2dup", new DuplicateCommand(2));
        scope.commands.put("3dup", new DuplicateCommand(3));
        scope.commands.put("4dup", new DuplicateCommand(4));
        scope.commands.put("swap", new SwapCommand());
        scope.commands.put("2swap", new Swap2Command());
        scope.commands.put("drop", s -> s.stack.pop());
        scope.commands.put("2drop", s -> {
            s.stack.pop();
            s.stack.pop();
        });

        // Console commands
        scope.commands.put("print", new PrintCommand(System.out::print));
        scope.commands.put("println", new PrintCommand(System.out::println));
        scope.commands.put("printError", new PrintCommand(System.err::println));
        scope.commands.put("input", new InputCommand());

        // String/float works
        scope.commands.put("str", new StrCommand());
        scope.commands.put("num", new NumCommand());
        scope.commands.put("concat", new ConcatCommand());

        // Working with lists
        scope.commands.put("append", new AppendCommand());
        scope.commands.put("at", new AtCommand());

        // Math
        scope.commands.put("add", new MathCommand((a, b) -> a + b));
        scope.commands.put("sub", new MathCommand((a, b) -> a - b));
        scope.commands.put("div", new MathCommand((a, b) -> a / b));
        scope.commands.put("mul", new MathCommand((a, b) -> a * b));
        scope.commands.put("mod", new MathCommand((a, b) -> (float) (a.intValue() % b.intValue())));

        // Inc / Dec
        scope.commands.put("inc", new ModifyNumberCommand(n -> n + 1));
        scope.commands.put("2inc", new ModifyNumberCommand(n -> n + 2));
        scope.commands.put("3inc", new ModifyNumberCommand(n -> n + 3));
        scope.commands.put("4inc", new ModifyNumberCommand(n -> n + 4));
        scope.commands.put("dec", new ModifyNumberCommand(n -> n - 1));
        scope.commands.put("2dec", new ModifyNumberCommand(n -> n - 2));
        scope.commands.put("3dec", new ModifyNumberCommand(n -> n - 3));
        scope.commands.put("4dec", new ModifyNumberCommand(n -> n - 4));

        // GOTO
        scope.commands.put("goto", new GotoCommand());
        scope.commands.put("loc", new LocCommand());
        scope.commands.put("call", new GotoCallCommand());
        scope.commands.put("ret", new ReturnCommand());
        scope.commands.put("declare", new DeclareCommand());

        // Errors
        scope.commands.put("newError", s -> s.errors.push(s.stack.pop()));
        scope.commands.put("lastError", s -> s.stack.push(s.errors.last()));
        scope.commands.put("popError", s -> s.stack.push(s.errors.pop()));
        scope.commands.put("dropError", s -> s.errors.pop());
        scope.commands.put("errorCount", s -> s.stack.push(new Value(s.errors.ptr)));

        // Logic
        scope.commands.put("==", new EqualsCommand());
        scope.commands.put("<", new CompareNumberCommand((a, b) -> a < b));
        scope.commands.put(">", new CompareNumberCommand((a, b) -> a > b));
        scope.commands.put("<=", new CompareNumberCommand((a, b) -> a <= b));
        scope.commands.put(">=", new CompareNumberCommand((a, b) -> a >= b));

        scope.commands.put("negate", new NegateCommand());
        scope.commands.put("dropFlag", s -> s.flag = false);

        // Memory
        scope.commands.put("set", new SetCommand());
        scope.commands.put("get", new GetCommand());

        return scope;
    }

}
