/**
 * name: Deema Alrashdan
 */
package lifeform;

import static org.junit.Assert.*;
import org.junit.Test;

/**
 * Tests the functionality provided by the LifeForm class
 */
public class TestLifeForm 
{
	/*
	* Start Section for Observer Pattern Tests
	*/
	
	/**
	 * testGetAttackStrength returns present attack strength of the LifeForm
	 */
	@Test
	public void testGetAttackStrength()
	{
		LifeForm entity;
		entity = new MockLifeForm("Bob",40,10);
		assertEquals(10, entity.getAttackstrength());
	}
	
	/**
	 * testAttackHurtLifeForm check if works the attack method to hurt a life form
	 * entity2 attack with 40 points of strength to entity1 and the entity2 has 0 points of life
	 */
	@Test
	public void testAttackHurtLifeForm()
	{
		LifeForm entity1, entity2;
		entity1 = new MockLifeForm("E1",40,10);
		entity2 = new MockLifeForm("E2",30,5);
		entity2.attack(entity1, 40);	
		assertEquals(0, entity1.getCurrentLifePoints());	
	}
	
	/**
	 * testLifeFormWithNotLifeCanNotAttack check if LifeForm dead can not
	 * attack to another LifeForm 
	 */
	@Test
	public void testLifeFormWithNotLifeCanNotAttack()
	{
		LifeForm e1, e2;
		e1 = new MockLifeForm("E1",40,10);
		e2 = new MockLifeForm("E2",0,5);
		e2.attack(e1, 40);	
		assertEquals(40, e1.getCurrentLifePoints());
	}
	
	/**
     * testUpdateTime can track passage of time
     */
    @Test
    public void testUpdateTime()
    {
        LifeForm entity1; 
        entity1 = new MockLifeForm("Bob", 40,5);
        entity1.updateTime(5);
        assertEquals(5,entity1.time);
    }
    
    /**
	 * testSetAttackStrength check the Set attack strength of the LifeForm
	 */
	@Test
	public void testSetAttackStrength()
	{
		LifeForm entity;
		entity = new MockLifeForm("Bob",40,10);
		entity.setAttackstrength(20);
		assertEquals(20, entity.getAttackstrength());
	}
	
	/*
	* Start Section for Strategy Pattern Tests
	*/
	
	/**
	 * When a LifeForm is created, it should define its name and how many life
     * points it has
	 */
	@Test
	public void testInitialization() 
	{
		LifeForm entity;
		entity = new MockLifeForm("Bob",40,5);
		assertEquals("Bob",entity.getName());
		assertEquals(40, entity.getCurrentLifePoints());
	}
	
	/**
	 *when a LifeForm has a damage take points of life if
	 *are bigger than damage. otherwise the life points are zero. 
	 */
	@Test
    public void testTakeHit() 
    {
        LifeForm entity ; 
        entity = new MockLifeForm("Bob", 40,5);
        entity.takeHit(15);
        assertEquals(entity.getCurrentLifePoints(),25);
        entity.takeHit(30);
        assertEquals(entity.getCurrentLifePoints(),0); 
        entity.takeHit(10);
        assertEquals(entity.getCurrentLifePoints(),0); 
    }
}