/**
 * name: Deema Alrashdan
 */
package lifeform;

/**
 *  This class is a subclass of LifeFoem. This allows it to inherit all of LifeForm's methods
 *  and instance variables, but it can only access those methods and instance variables
 *  that are not private
 */
public class Human extends LifeForm
{
	private int armorPoints = 0;
	
	/**
	 * Create Human with a strength attack of 5
	 * @param name
	 * @param life
	 * @param armor
	 */
	public Human(String name, int life, int armor)
	{
		super(name, life, 5);
		setArmorPoints(armor);
	}
	
	/**
	 * get the armor points
     */
	public int getArmorPoints()
	{
		return armorPoints;
	}
	
	/**
	 * Update the armor points if is under 0 ,set value 0 to armor points
	 * @param armor
	 */
	public void setArmorPoints(int armor)
	{
		if (armor >= 0) 
        {
            armorPoints = armor;
        } else
        {
        	 armorPoints = 0;
        } 
	}
	
	/**
	 * override the takehit method
	 * when human is attacked.
	 * If armor is bigger than strength, rest the strength to armor.
	 * If strength is bigger than armor, damage will store the points for quit to life points
	 * and rest the damage to currentLifePoints
	 * If currentLifePoints of human are less than 0, the human die ,so currentLifePoints will be equal 0
	 * If Not update currentLifePoints
	 * If armor is equal strength, the armor points will be equal zero
	 * @param strength
	 */
	@Override
	public void takeHit(int strength)
	{
		int damage = 0;
		if(this.armorPoints > strength)
		{
			this.armorPoints -= strength; 
		}else if(this.armorPoints < strength)
		{
			damage = strength - this.armorPoints;
			this.currentLifePoints -= damage;
			if(this.currentLifePoints < 0)
			{
				super.currentLifePoints = 0;
			}else
			{
				super.currentLifePoints = this.currentLifePoints;
			}
			this.armorPoints = 0;
		}else if(this.armorPoints == strength)
		{
			this.armorPoints = 0;
		}
	}
}