/**
 * name: Deema Alrashdan
 */
package environment;

import static org.junit.Assert.*;
import org.junit.Test;
import lifeform.LifeForm;
import lifeform.MockLifeForm;

/**
 * The test cases for the Cell class
 */
public class TestCell 
{
/**
 * At initialization, the Cell should be empty and not contain a LifeForm
 */
	@Test
	public void testInitialization()
	{
		Cell cell = new Cell();
		assertNull(cell.getLifeForm());
	}

/**
 * Checks to see if we change the LifeForm held that
 * getLifeForm properly will respond to this change.
 */
	@Test
	public void TestSetLifeForm()
	{
		LifeForm bob = new MockLifeForm("Bob", 40,10);
		LifeForm dd= new MockLifeForm("ddd", 40,5);
		Cell c = new Cell();
		// The cell is empty so, this should work
		boolean success = c.addLifeForm(bob);
		assertTrue(success);
		assertEquals(bob, c.getLifeForm());
		// The cell is not empty so this should fail
		success = c.addLifeForm(dd);
		assertFalse(success);
		assertEquals(bob, c.getLifeForm());
	}
	
	/**
     * Test if the removed LifeForm is equal null or not show what the is the
     * removed LifeForm
     */
    @Test
    public void TestRemoveLifeForm() 
    {
        LifeForm bob = new MockLifeForm("Bob", 40,10);
        Cell cell = new Cell();
        // In case, the cell is not empty,so should remove the LifeForm in this cell
        boolean success = cell.addLifeForm(bob);
        assertTrue(success);
        LifeForm remove = cell.removeLifeForm();
        // this cell is empty, so this should work
        assertNull(cell.getLifeForm());
        assertEquals(bob, remove);
        // In case, the cell is empty,so should return null
        LifeForm remove2 = cell.removeLifeForm();
        // this cell is empty, so this should work
        assertNull(cell.getLifeForm());
        assertEquals(remove2, null);
    }
}