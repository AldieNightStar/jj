package haxidenti.jj.parser;

import haxidenti.jj.command.Command;
import haxidenti.jj.parser.Token.Type;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Parser {
    public static List<Token> parse(String text) {
        List<Token> tokens = new ArrayList<>();
        int textSize = text.length();
        int pos = 0;
        while (true) {
            if (pos >= textSize) {
                break;
            }
            Token stringTok = parseString(text.substring(pos));
            if (stringTok != null) {
                pos += stringTok.size;
                tokens.add(stringTok);
                continue;
            }
            Token etcTok = parseEtc(text.substring(pos));
            if (etcTok != null) {
                pos += etcTok.size;
                tokens.add(etcTok);
                continue;
            }
            // Other is skipping
            pos += 1;
        }
        return tokens;
    }

    public static List<Command> toCode(List<Token> tokens) {
        return tokens.stream()
                .map(TokenToCommandMapper::map)
                .collect(Collectors.toList());
    }

    public static List<Command> parseAndConvert(String str) {
        return toCode(parse(str));
    }

    public static Token parseString(String text) {
        if (!(text.startsWith("\"") || text.startsWith("'") || text.startsWith("`"))) {
            return null;
        }
        char first = text.charAt(0);
        StringBuilder sb = new StringBuilder(32);

        char[] chars = text.substring(1).toCharArray();
        boolean esc = false;
        for (char c : chars) {
            if (esc) {
                esc = false;
                if (c == 'n') {
                    c = '\n';
                } else if (c == 't') {
                    c = '\t';
                } else if (c == '0') {
                    c = '\0';
                } else if (c == 'r') {
                    c = '\r';
                }
                sb.append(c);
                continue;
            }
            if (c == '\\') {
                esc = true;
                continue;
            }
            if (c == first) {
                break;
            }
            sb.append(c);
        }

        if (sb.length() < 1) {
            return null;
        }
        String str = sb.toString();
        return new Token(str, str.length() + 2, Type.STRING);
    }

    public static Token parseEtc(String text) {
        StringBuilder sb = new StringBuilder(32);
        char[] chars = text.toCharArray();
        for (char c : chars) {
            if (c == ' ' || c == '\r' || c == '\t' || c == '\n') {
                break;
            }
            sb.append(c);
        }
        String etc = sb.toString();
        int size = etc.length();

        if (size < 1) {
            return null;
        }

        if (etc.startsWith(":")) {
            return new Token(etc.substring(1), size, Type.LABEL);
        }
        if (etc.startsWith("?")) {
            return new Token(etc.substring(1), size, Type.FLAG_CALL);
        }

        try {
            Float f = Float.parseFloat(etc);
            return new Token(f, size, Type.NUM);
        } catch (NumberFormatException e) {
        }

        return new Token(etc, size, Type.CALL);
    }
}
