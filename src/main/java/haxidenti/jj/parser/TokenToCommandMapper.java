package haxidenti.jj.parser;

import haxidenti.jj.Value;
import haxidenti.jj.command.Command;
import haxidenti.jj.command.core.CallCommand;
import haxidenti.jj.command.core.FlagCommand;
import haxidenti.jj.command.core.LabelCommand;
import haxidenti.jj.command.hardcoded.GetVarCommand;
import haxidenti.jj.command.hardcoded.GetVarThenCommand;
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
            return new FlagCommand(true, new CallCommand(token.value));
        } else if (token.type == Type.FLAG_INACTIVE_CALL) { // FLAG_INACTIVE_CALL
            return new FlagCommand(false, new CallCommand(token.value));
        } else if (token.type == Type.COMMENT) { // COMMENT
            return null; // Comments will be ignored
        } else if (token.type == Type.GETVAR) { // GETVAR
            return new GetVarCommand(token.value);
        } else if (token.type == Type.SETVAR) { // SETVAR
            return new SetVarCommand(token.value);
        } else if (token.type == Type.DEC_VAR) { // DEC_VAR
            return new GetVarThenCommand(token.value, f -> f - 1);
        } else if (token.type == Type.INC_VAR) { // INC_VAR
            return new GetVarThenCommand(token.value, f -> f + 1);
        }
        return null;
    }
}
