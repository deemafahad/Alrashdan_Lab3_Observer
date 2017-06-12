/**
 *name: Deema Alrashdan
 */
package recovery;

import static org.junit.Assert.*;
import org.junit.Test;
import lifeform.Alien;

public class TestRecoveryLinear
{
	/** 
     * This test check there is no recovery when the alien is not hurt
     */
    @Test
    public void noRecoveryWhenNotHurt() 
    {
        RecoveryLinear rl = new RecoveryLinear(3);
        int maxLifePts = 30;
        int result = rl.calculateRecovery(maxLifePts, maxLifePts);
        assertEquals(maxLifePts, result);
    }
  
    /**
     * To full recovery amount Without hitting the max value
     */
    @Test
    public void RecoveryWhenReallyHurt() 
    {
        Alien alien1 = new Alien("Monster", 60, new RecoveryLinear(20));
        alien1.takeHit(20);
        alien1.recover();
        assertEquals(alien1.maxLifePoints, alien1.getCurrentLifePoints());
    }
    
    /**
     * Test the max life points from alien after is hurt and recover it
     * the life points don't be more bigger the maxlife points 
     * And when the current life points after the alien is hurt are less that 
     * max life points just have the correct result 
     * 
     */
    @Test
    public void RecoveryWhenAlittelHurt() 
    {
        Alien alien1 = new Alien("Monster", 60, new RecoveryLinear(25));
        alien1.takeHit(20);
        alien1.recover();
        assertEquals(alien1.maxLifePoints, alien1.getCurrentLifePoints());
        Alien alien2 = new Alien("Monster", 60, new RecoveryLinear(10));
        alien2.takeHit(20);
        alien2.recover();
        assertEquals(50, alien2.getCurrentLifePoints());
    }
    
    /**
     * Test check the at max life points are less than hurt 
     * the alien should has 0 points of life.
     */
    @Test
    public void RecoveryWhenDead() 
    {
        Alien alien1 = new Alien("Monster", 60, new RecoveryLinear(40));
        alien1.takeHit(65);
        alien1.recover();
        assertEquals(0, alien1.getCurrentLifePoints());
    }
}