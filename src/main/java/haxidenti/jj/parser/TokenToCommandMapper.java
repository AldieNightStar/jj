package haxidenti.jj.parser;

import haxidenti.jj.Value;
import haxidenti.jj.command.Command;
import haxidenti.jj.command.core.CallCommand;
import haxidenti.jj.command.core.FlagCommand;
import haxidenti.jj.command.core.LabelCommand;
import haxidenti.jj.command.hardcoded.GetVarCommand;
import haxidenti.jj.command.hardcoded.PushCommand;
import haxidenti.jj.command.hardcoded.SetVarCommand;
import haxidenti.jj.parser.Token.Type;

public class TokenToCommandMapper {
    public static Command map(Token token) {
        if (token.type == Type.NUM) { // NUM
            return new PushCommand(new Value(token.number));
        } else if (token.type == Type.CALL) { // VAR
            return new CallCommand(token.value);
        } else if (token.type == Type.LABEL) { // LABEL
            return new LabelCommand(token.value);
        } else if (token.type == Type.STRING) { // STRING
            return new PushCommand(new Value(token.value));
        } else if (token.type == Type.FLAG_CALL) { // FLAG_CALL
            return new FlagCommand(new CallCommand(token.value));
        } else if (token.type == Type.COMMENT) { // COMMENT
            return null; // Comments will be ignored
        } else if (token.type == Type.GETVAR) {
            return new GetVarCommand(token.number.intValue());
        } else if (token.type == Type.SETVAR) {
            return new SetVarCommand(token.number.intValue());
        }
        return null;
    }
}
