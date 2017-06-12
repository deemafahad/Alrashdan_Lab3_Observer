/**
 * name: Deema Alrashdan
 */
package lifeform;

public class MockLifeForm extends LifeForm 
{
    /**
     * Initial the name and points. This class will let us 
     * able to create an object from LifeForm class
     * since LifeForm class is abstract class so, we need mock class to
     * test its methods
     */
	public MockLifeForm(String name, int points, int strength)
	{
		super(name, points, strength);
	}
}