/**
 * name: Deema Alrashdan
 */
package environment;
import lifeform.LifeForm;

/**
 *  Cell class Keeps track of a LifeForm, 
 *  can be added on to keep track of other objects as well.
 */
public class Cell
{
	public LifeForm lf;
	
	/**
	 * @return the LifeForm in this Cell.
	 */
	public LifeForm getLifeForm()
	{
		return lf;
	}
	
	/**
	 * Tries to add the LifeForm to the Cell. Will not add if a LifeForm is already present.
	 * @return true if the LifeForm was added to the Cell, false otherwise.
	 */
	public boolean addLifeForm(LifeForm entity)
	{
		if(lf == null)
		{
			lf = entity;
			return true;
		}else
		{
			return false;
		}
	}
	
	 /**
     * Remove LifeForm from the cell 
     * return the LifeForm that removed, null if is not exist
     */
    public LifeForm removeLifeForm() {
        LifeForm temp;
        if (lf != null) {
            temp = lf;
            lf = null;
            return temp;
        } else
            return null;
    }
}