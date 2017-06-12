/**
* name: Deema Alrashdan
 */
package lifeform;

import gameplay.TimeObserver;

/**
 * Life Form class keeps track of the information associated with a simple life form.     
 */ 
public abstract class LifeForm implements TimeObserver
{
	protected String myName;
	protected int currentLifePoints;
	protected int attackStrength;
	public int time;
	
	/**
	 * Create an instance
	 * @param name the name of the life form
	 * @param points the current starting life points of the life form
	 * @param strength the damage that can do to another life form
	 */
	public LifeForm(String name, int points, int strength)
	{
		myName = name;
		if(points > 0)
		{
			currentLifePoints = points;
		}
		attackStrength = strength;
	}
	
	/**
	 * null by default 
	 */
       public LifeForm()
	   {    
	   }
	  
	/**
	 * @return the name of the life form
	 */
	public String getName()
	{
		return myName;
	}
	
	/**
	 *  @return the amount of current life points the life form has
	 */
	public int getCurrentLifePoints()
	{
		return currentLifePoints;
	}
	
	/**
	 * Take current life points
	 * @param damage
	 */
	public void takeHit(int damage) 
    {
        if (currentLifePoints > damage) 
        {
            currentLifePoints = currentLifePoints - damage;
        } else
        {
        	currentLifePoints = 0;
        }
    }
	
	/**
	 * How strong an attack possesses the life form
	 * @param entity
	 * @param attack_strength
	 */
	public void attack(LifeForm entity, int attackStrength)
	{
		if(currentLifePoints > 0)
		{
			entity.takeHit(attackStrength);
		}
	}
	
	/**
	 * Set the new value for the strength attack
	 * @param strength
	 */
	public void setAttackstrength(int strength)
	{
		attackStrength = strength;
	}
	
	/**
	 * Get the strength attack 
	 * @return attackStrength
	 */
	public int getAttackstrength()
	{
		return attackStrength;
	}
	
	/**
	 * updateTime to Update time 
	 * @param time
	 */
	public void updateTime(int time)
	{
		this.time = time;
	}
}