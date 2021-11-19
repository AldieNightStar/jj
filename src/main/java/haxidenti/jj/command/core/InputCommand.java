package haxidenti.jj.command.core;

import haxidenti.jj.Scope;
import haxidenti.jj.Value;
import haxidenti.jj.command.Command;

import java.util.Scanner;

public class InputCommand implements Command {

    private Scanner scanner = new Scanner(System.in);

    @Override
    public void run(Scope scope) {
        String line = scanner.nextLine();
        scope.stack.push(new Value(line));
    }
}
