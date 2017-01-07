package kata.wordwrap;


import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StarterTest {

    @Test
    public void empty() throws Exception {
        assertEquals("", Starter.wrap("", 1));
    }

    @Test
    public void textLengthLessThenNumber() throws Exception {
        assertEquals("Hello", Starter.wrap("Hello", 10));
    }

    @Test
    public void wordWrapped() throws Exception {
        assertEquals("Hel\nlo", Starter.wrap("Hello", 3));
    }

    @Test
    public void wordMuchLongerThanColumn() throws Exception {
        assertEquals("He\nll\no", Starter.wrap("Hello", 2));
    }

    @Test
    public void simpleBreakBeforeSpace() throws Exception {
        assertEquals("Hello\nWorld", Starter.wrap("Hello World", 5));
    }

    @Test
    public void simpleBreakAfterSpace() throws Exception {
        assertEquals("Hello\nWorld", Starter.wrap("Hello World", 6));
    }

    @Ignore
    @Test
    public void twoLines1() throws Exception {
        assertEquals("Hello\nWorld!", Starter.wrap("Hello World!", 7));

    }

    @Ignore
    @Test
    public void twoLines2() throws Exception {
        assertEquals("Hello\nWorld!", Starter.wrap("Hello World!", 5));

    }


    @Ignore
    @Test
    public void wordsNotWrapped() throws Exception {
        assertEquals("Hello World!", Starter.wrap("Hello World!", 20));

    }

    @Ignore
    @Test
    public void wordsNotWrappedLengthEqNumber() throws Exception {
        assertEquals("Hello World!", Starter.wrap("Hello World!", 12));

    }

    @Ignore
    @Test
    public void threeWordsIntoTwoLines() throws Exception {
        assertEquals("Hello Amazing\nWorld!", Starter.wrap("Hello Amazing World!", 15));
    }

    @Ignore
    @Test
    public void twoWordsInLine() throws Exception {
        assertEquals("Hello Amazing\nWorld!", Starter.wrap("Hello Amazing World!", 15));
    }
}
