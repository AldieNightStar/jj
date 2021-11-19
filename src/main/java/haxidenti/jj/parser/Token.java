package haxidenti.jj.parser;

public class Token {
    public String value;
    public int size;
    public Type type;
    public Float number;

    public Token(String value, int size, Type type) {
        this.value = value;
        this.size = size;
        this.type = type;
    }

    public Token(Float value, int size, Type type) {
        this.number = value;
        this.size = size;
        this.type = type;
    }

    enum Type {
        STRING, LABEL, CALL, NUM, FLAG_CALL, COMMENT
    }
}
