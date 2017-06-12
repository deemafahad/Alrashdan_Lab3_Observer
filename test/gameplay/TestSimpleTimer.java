/**
 * name: Deema Alrashdan
 */
package gameplay;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * This class will test all the methods in SimpelTimer
 */
public class TestSimpleTimer {
	
	/**
	 * testInitialization
	 */
	@Test
	public void testInitialization()
	{
		SimpleTimer st = new SimpleTimer();
        assertEquals(0,st.getRound());
        assertEquals(0,st.theObservers.size());
        assertTrue(st instanceof Timer);
	}
	
	/**
	 * testUpdatesTime to updates the time
	 */
	@Test
	public void testUpdatesTime()
	{
		SimpleTimer st = new SimpleTimer();
		MockSimpleTimerObserver mocksimpletimer = new MockSimpleTimerObserver();
        assertEquals(st.getRound(),mocksimpletimer.myTime);
        st.addTimeObserver(mocksimpletimer);
        assertEquals(st.getRound(),mocksimpletimer.myTime);   
        st.round=1;
        st.timeChanged();
        assertEquals(st.getRound(),mocksimpletimer.myTime);  
	}
	
	/**
    * testAddObservers to add observer
    */
    @Test
    public void testAddObservers() 
    {
        SimpleTimer st= new SimpleTimer();
        MockSimpleTimerObserver mocksimpletimer2 = new MockSimpleTimerObserver();
        st.addTimeObserver(mocksimpletimer2);
        assertEquals(1,st.getObservers().size());
        assertEquals(mocksimpletimer2,st.getObservers().get(0));
    }
    
    /**
     * testRemoveObservers to remove observer
     */
    @Test
    public void testRemoveObservers() 
    {
        SimpleTimer st= new SimpleTimer();
        MockSimpleTimerObserver mocksimpletimer3 = new MockSimpleTimerObserver();
        st.addTimeObserver(mocksimpletimer3);
        assertEquals(1,st.getObservers().size());
        assertEquals(mocksimpletimer3,st.getObservers().get(0));
        //remove
        st.removeTimeObserver(mocksimpletimer3);
        assertEquals(0,st.getObservers().size());
    }
    
    /**
     * testObserverTimeUpdates to make Observer receives the time update
     */
    @Test
    public void testObserverTimeUpdates()
    {
        SimpleTimer st= new SimpleTimer();
        MockSimpleTimerObserver mockSt = new MockSimpleTimerObserver();
        st.addTimeObserver(mockSt);
        st.round=5;
        st.timeChanged();
        assertEquals(5,mockSt.myTime);
    }
    
    /**
    * testSimpleTimerAsThread to test update time correctly as Thread
    * @throws InterruptedException
    */   
    @Test
    public void testSimpleTimerAsThread() throws InterruptedException
    {
        SimpleTimer st= new SimpleTimer();
        MockSimpleTimerObserver mocksimpletimer = new MockSimpleTimerObserver();
        st.addTimeObserver(mocksimpletimer);
        st.round = 0;
        st.start();
        //So we are 1/4th a second different
        Thread.sleep(250);
        for(int x = 0; x < 5; x++)
        {
            st.setRound(x);
            //assumes round starts at 0
            assertEquals(x,st.getRound());
            //wait for the next time change
            Thread.sleep(1000);
        }
    }
}

/**
 * MockSimpleTimerObserver uses a mock object to test observable
 */
class MockSimpleTimerObserver implements TimeObserver
{
	public int myTime = 0;
	public void updateTime(int time)
	{
		myTime = time;
	}
}