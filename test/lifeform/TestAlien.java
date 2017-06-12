/**
 *name: Deema Alrashdan
 */
package lifeform;
import static org.junit.Assert.*;
import org.junit.Test;
import exceptions.MyNewException;
import gameplay.SimpleTimer;
import recovery.RecoveryLinear;

public class TestAlien
{
	/*
	* Start Section for Observer Pattern Tests
	*/
	/**
	 * testDefaultAttack Check get the attack strength of alien, is 10
	 */
	@Test
	public void testDefaultAttack()
	{
		Alien alien;
		alien = new Alien("Alien", 40);
		assertEquals(10, alien.getAttackstrength());
	}
	
	/**
     * testSetRecoveryRateInConstructor Check set recovery rate in Constructor
     * @throws MyNewException
     */
    @Test
    public void testSetRecoveryRateInConstructor() throws MyNewException 
    {
        Alien alien = new Alien("Alien", 40, new RecoveryLinear(5), 2);
        assertEquals(2, alien.getRecoveryRate());
    }
	
    /**
     * testSetRecoveryRateInSetter Check set recovery rate in setter
     * @throws MyNewException 
     */
    @Test
    public void testSetRecoveryRateInSetter() throws MyNewException 
    {
    	Alien alien = new Alien("Alien", 40, new RecoveryLinear(5), 2);
    	alien.setRecoveryRate(5);
        assertEquals(5, alien.getRecoveryRate());
    }
    
    /**
     * testRecoveryRateAtZero Check test recovery rate at 0
     * @throws MyNewException
     */
    @Test
    public void testRecoveryRateAtZero() throws MyNewException 
    {
        Alien alien = new Alien("Alien", 40, new RecoveryLinear(5), 0);
        alien.takeHit(20);
        SimpleTimer sT = new SimpleTimer();
        sT.addTimeObserver(alien);
        sT.setRound(2);
        sT.timeChanged();
        assertEquals(alien.time, sT.getRound());
        alien.recover();
        assertEquals(25, alien.currentLifePoints);
    }
    
    /**
     * testRecoveryRateGreaterZero test recover at rate > 0
     * @throws MyNewException
     */
    @Test 
    public void testRecoveryRateGreaterZero() throws MyNewException 
    {
        Alien alien = new Alien("Alien", 40, new RecoveryLinear(5), 2);
        alien.takeHit(20);
        SimpleTimer st = new SimpleTimer();
        st.addTimeObserver(alien);
        st.setRound(2);
        //have time passed
        st.timeChanged();
        assertEquals(alien.time, st.getRound());
        alien.recover();
        assertEquals(25, alien.currentLifePoints);
    }
    
    /**
     * testTwoRecoveryRate test recover at 2 different rates > 0
     * @throws MyNewException
     */
    @Test
    public void testTwoRecoveryRate() throws MyNewException 
    {
        // Alien
        Alien alien = new Alien("Alien", 40, new RecoveryLinear(5), 3);
        alien.takeHit(20);
        SimpleTimer s = new SimpleTimer();
        s.addTimeObserver(alien);
        s.setRound(7);
        s.timeChanged();
        assertEquals(alien.time,s.getRound());
        alien.recover();
        assertEquals(25, alien.currentLifePoints);
        //Predator
        Alien predator = new Alien("Predator", 40, new RecoveryLinear(5), 4);
        predator.takeHit(20);
        SimpleTimer ss = new SimpleTimer();
        ss.addTimeObserver(predator);
        ss.setRound(19);
        ss.timeChanged();
        assertEquals(predator.time, ss.getRound());
        predator.recover();
        assertEquals(25, predator.currentLifePoints);
    }
    
    /**
     * Test Remove the observer no recovery when time pass
     * @throws MyNewException
     */
    @Test 
    public void TestRemoveObserver() throws MyNewException 
    {
    	Alien alien = new Alien("Alien", 40, new RecoveryLinear(5), 2);
        alien.takeHit(20);
        SimpleTimer st = new SimpleTimer();
        st.addTimeObserver(alien);
        st.setRound(2);
        //have time passed
        st.timeChanged();
        assertEquals(alien.time, st.getRound());
        alien.recover();
        assertEquals(25, alien.currentLifePoints);
        // RemoveObserver
        st.removeTimeObserver(alien);
        st.setRound(4);
        st.timeChanged();
        assertEquals(25, alien.currentLifePoints);
    }
    
    /**
     * testIfRecoveryRateIsNegative throws exceptions if recovery rate < 0
     * @throws MyNewException
     */
    @Test(expected = MyNewException.class)
    public void testIfRecoveryRateIsNegative() throws MyNewException 
    {
        Alien alien = new Alien("Alien", 40, new RecoveryLinear(5), -1);
        assertEquals(40, alien.currentLifePoints);
    }
    
	/*
	* Start Section for Strategy Pattern Tests
	*/

    /**
     * Test when alien hurt with none recovery.
     */
    @Test
    public void testAlienWithNoneRecovery() 
    {
        Alien Alien1;
        Alien1 = new Alien("Monster",20);
        assertEquals("Monster", Alien1.getName());
        assertEquals(20,Alien1.getCurrentLifePoints());
    }
    
    /**
     * Test when alien hurt with recovery (linear)
     */
    @Test
    public void testAlienWithRecovery() 
    {
    	 Alien alien1 = new Alien("Monster", 100, new RecoveryLinear(10));
         alien1.takeHit(40);
         alien1.recover();
         assertEquals(70, alien1.getCurrentLifePoints());
    }
}