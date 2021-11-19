package haxidenti.jj;

import haxidenti.jj.command.Command;
import haxidenti.jj.util.ListUtil;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        if (args.length < 1) {
            usage();
            return;
        }
        String fileName = ListUtil.atArray(args, 0, "main.jj");

        byte[] bytes = Files.readAllBytes(new File(fileName).toPath());
        String str = new String(bytes);

        List<Command> code = Program.compile(str);
        Program.run(code, new HashMap<>());
    }

    static void usage() {
        System.out.println("Usage:");
        System.out.println("\tJJ [FILE]");
        System.out.println("\t\tFILE - File name to run");
        System.out.println();
    }
}
