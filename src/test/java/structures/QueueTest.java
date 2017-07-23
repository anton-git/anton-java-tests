package structures;

import org.junit.Assert;
import org.junit.Test;

public class QueueTest {

    Queue<Integer> queue = new Queue<>();

    @Test
    public void test() throws Exception {
        Assert.assertEquals(0, queue.getSize());
        queue.put(4);
        Assert.assertEquals(Integer.valueOf(4), queue.getFirst());

        queue.put(5);
        queue.put(6);
        queue.put(7);
        Assert.assertEquals(Integer.valueOf(5), queue.getFirst());
        Assert.assertEquals(Integer.valueOf(6), queue.getFirst());
        Assert.assertEquals(Integer.valueOf(7), queue.getFirst());

        queue.getFirst();


    }
}
