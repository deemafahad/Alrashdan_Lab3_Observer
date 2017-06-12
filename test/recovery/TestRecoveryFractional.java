/**
 * name : Deema Alrashdan
 */
package recovery;
 
import static org.junit.Assert.*;
import org.junit.Test;
import lifeform.Alien;
 
public class TestRecoveryFractional 
{
    /**
     * This test check there is no recovery when the alien is not hurt.
     */
    @Test
    public void noRecoveryWhenNotHurt() 
    {
        RecoveryFractional rf = new RecoveryFractional(.5);
        int maxLifePts = 30;
        int result = rf.calculateRecovery(maxLifePts, maxLifePts);
        assertEquals(maxLifePts, result);
    }
 
    /**
     * Test check the at max life point without any hurt stays to alien 
     * at the max life point after recovery
     */
    @Test
    public void RecoveryWhenReallyHurt() 
    {
        Alien alien1 = new Alien("Monster", 100, new RecoveryFractional(.5));
        alien1.takeHit(40);
        alien1.recover();
        assertEquals(90, alien1.getCurrentLifePoints());
    }
 
    /**
     ** Test the max life points from alien after is hurt and recover it
     * the life points don't be more bigger the maxlife points 
     * And when the current life points after the alien is hurt are less that 
     * max life points just have the correct result 
     */
    @Test
    public void RecoveryWhenAlittelHurt() 
    {
        Alien alien1 = new Alien("Monster", 100, new RecoveryFractional(.5));
        alien1.takeHit(10);
        alien1.recover();
        assertEquals(alien1.maxLifePoints, alien1.getCurrentLifePoints());    
    }
 
    /**
     * Test check the at max life points are less than hurt 
     * the alien should has 0 points of life.
     */
    @Test
    public void RecoveryWhenDead()
    {
        Alien alien1 = new Alien("Monster", 100, new RecoveryFractional(.5));
        alien1.takeHit(105);
        alien1.recover();
        assertEquals(0, alien1.getCurrentLifePoints());
    }
}