package haxidenti.jj;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StackTest {

    @Test
    public void stackTest() {
        Stack stack = new Stack(10);
        stack.push(new Value(32));
        stack.push(new Value(64));

        assertEquals(64, stack.last().getNumber());

        assertEquals(64, stack.pop().getNumber());
        assertEquals(32, stack.pop().getNumber());
        assertNull(stack.pop());
    }

}