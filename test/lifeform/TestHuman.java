/**
 * name: Deema Alrashdan
 */
package lifeform;

import static org.junit.Assert.*;
import org.junit.Test;

public class TestHuman 
{
	/*
	* Start Section for Observer Pattern Tests
	*/
	
	/**
	 * Default attack strength of 5
	 */
	@Test
	public void testDefaultAttack()
	{
		Human human = new Human("human", 40, 20);
		assertEquals(5, human.getAttackstrength());
	}
	
	/**
	 * Armor absorbs all damage using takeHit when damage is less than armor 
	 */
	@Test
	public void testArmorAbsorbsAllDamage()
	{
		LifeForm l1, l2;
		l1 = new Human("human", 40, 20);
		l2 = (Alien) new Alien("alien", 50);
		l2.attack(l1, 10);
		assertEquals(10, ((Human) l1).getArmorPoints());
		assertEquals(40, l1.getCurrentLifePoints());
	}
	
	/**
	 * Armor reduces damage using takeHit when damage>armor>0
	 */
	@Test
	public void testArmorReducesDamage()
	{
		LifeForm l1, l2;
		l1 = new Human("human", 40, 20);
		l2 = (Alien) new Alien("alien", 50);
		// CurrentLifePoints are > 0 after attack
		l2.attack(l1, 30);
		assertEquals(0, ((Human) l1).getArmorPoints());
		assertEquals(30, l1.getCurrentLifePoints());
		// CurrentLifePoints are < 0 after attack
		l2.attack(l1, 40);
		assertEquals(0, ((Human) l1).getArmorPoints());
		assertEquals(0, l1.getCurrentLifePoints());
	}
	
	/**
	 * Armor absorbs all damage using takeHit when damage = armor
	 */
	@Test
	public void testArmorAbsorbsAllDamageWhenDamageEqualsArmor()
	{
		LifeForm l1, l2;
		l1 = new Human("human", 40, 20);
		l2 = (Alien) new Alien("alien", 50);
		l2.attack(l1, 20);
		assertEquals(0, ((Human) l1).getArmorPoints());
		assertEquals(40, l1.getCurrentLifePoints());
	}
	
	/*
	* Start Section for Strategy Pattern Tests
	*/
	/**
     * Test the armor points that should not under 0 points
     * if is under 0 points, assign the value of 0
     */
    @Test
    public void testInitialization() 
    {
        Human Human1;
        Human1 = new Human("Bob", 40, 20);
        assertEquals("Bob", Human1.getName());
        assertEquals(40,Human1.getCurrentLifePoints());
    }
    
    /**
     * Test the get armor points
     * if is under 0 should set the value 0 to armor points
     */
    @Test
    public void TestSetAndGetArmor()
    {
        Human Human1;
        Human1 = new Human("Bob", 40, 20);
        //get the armor points value, should be 20
        assertEquals(20, Human1.getArmorPoints());
        // get the armor points value, should be 0
        Human1 = new Human("Bob", 40, -10);
        assertEquals(Human1.getArmorPoints(), 0);  
    }
}