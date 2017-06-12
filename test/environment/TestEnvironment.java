/**
 *name : Deema Alrashdan
 */
package environment;

import static org.junit.Assert.*;
import org.junit.Test;
import lifeform.LifeForm;
import lifeform.MockLifeForm;
/**
 * The test cases for the Environment class
 */
public class TestEnvironment 
{
	/**
	 * At initialization, the Environment should be empty and not contain a
	 * LifeForm
	 */
		@Test
		public void testInitialization()
		{
			Environment e = new Environment(1,1);
			assertNull(e.theCells[0][0].getLifeForm());
		}
		
		/**
		 * Checks to see if we add the LifeForm held that
		 * addLifeForm properly responds to this change.
		 */
		@Test
		public void testAddLifeForm()
		{
			boolean success;
			Environment e = new Environment(2,3);
			LifeForm entity = new MockLifeForm("Bob", 40,10);
			//border case 1,2
			success = e.addLifeForm(entity, 1, 2);
			assertTrue(success); 
			assertEquals(entity, e.theCells[1][2].getLifeForm());	
	        //border case 0,2 row and col valid and lifeform doesn't exist
			success = e.addLifeForm(entity,0, 2);
			assertTrue(success);
	        //border case 0,0 row and col valid and lifeform exist
			success = e.addLifeForm(entity,0, 2);
			assertFalse(success); 		
		}
		
		/**
		 * Checks to see if we add and remove the LifeForm held that
		 * removeLifeForm properly responds to this change.
		 */
		@Test
		public void testRemoveLifeForm()
		{
			boolean success;
			Environment e = new Environment(2,3);
			LifeForm entity = new MockLifeForm("Bob", 40,10);
			LifeForm entityDeleted;
			//border case 1,2 entity exists and valid row and col
			success = e.addLifeForm(entity, 1, 2);
			assertTrue(success);
			entityDeleted = e.removeLifeForm(1, 2); 
			assertEquals(entityDeleted, entity);
			assertNull(e.theCells[1][2]);
			//border case 1,2 cell empty and valid row and col
			entityDeleted = e.removeLifeForm(1, 2); 
			assertEquals(e.theCells[1][2], null);
	        assertEquals(entityDeleted, null);
		}		
}