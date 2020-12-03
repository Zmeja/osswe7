package de.hfu;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest
{
	/**
     * Tested Util.istErstesHalbjahr(1)
     */
    @Test
    public void testIstErstesHalbjahr()
    {
        assertTrue( Util.istErstesHalbjahr(1) );
        assertTrue( Util.istErstesHalbjahr(2) );
        assertTrue( Util.istErstesHalbjahr(3) );
        assertTrue( Util.istErstesHalbjahr(4) );
        assertFalse( Util.istErstesHalbjahr(7) );
        assertFalse( Util.istErstesHalbjahr(8) );
        assertFalse( Util.istErstesHalbjahr(11) );
    }
    
    /**
     * Tested die Queue Klasse
     */
    @Test
    public void testQueue()
    {
    	Queue aQueue = new Queue(3);
    	//assertThrows(aQueue.dequeue()); Can't use because JUnit 4.13+
    	aQueue.enqueue(1);
    	assertEquals(aQueue.dequeue(), 1);
    	aQueue.enqueue(3);
    	aQueue.enqueue(5);
    	assertEquals(aQueue.dequeue(), 3);
    	assertEquals(aQueue.dequeue(), 5);
    	aQueue.enqueue(1);
    	aQueue.enqueue(2);
    	aQueue.enqueue(3);
    	aQueue.enqueue(4);
    	assertEquals(aQueue.dequeue(), 1);
    	assertEquals(aQueue.dequeue(), 2);
    	assertEquals(aQueue.dequeue(), 4);
    }
    
    /**
     * 
     */
    @Test(expected=IllegalArgumentException.class)
    public void testQueueException()
    {
    	Queue aQueue = new Queue(-1);
    }
    
    /**
     * 
     */
    @Test(expected=IllegalStateException.class)
    public void testQueueException2()
    {
    	Queue aQueue = new Queue(3);
    	aQueue.dequeue();
    }
    
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }
}
