/**
 * name: Deema Alrashdan
 */
package lifeform;
import exceptions.MyNewException;
import recovery.RecoveryBehavior;
import recovery.RecoveryNone;

/**
 *  This class is a subclass of LifeFoem. This allows it to inherit all of LifeForm's methods
 *  and instance variables, but it can only access those methods and instance variables
 *  that are not private
 */
public class Alien extends LifeForm 
{
	protected RecoveryBehavior recoveryBehavior;
	public int maxLifePoints = super.getCurrentLifePoints();
	//Assign recovery rate for each alien to know when it can recover 
    private int recoveryRate;
    protected int recovery;
	
	/** 
	 * Create Alien with none recovery with a strength attack of 10
	 * @param name
	 * @param life
	 */
	public Alien(String name, int life)
	{
		super(name, life, 10);
		recovery = 0;
		recoveryBehavior = new RecoveryNone();
	}
	
	/**
	 * Create Alien with recovery
	 * @param name Alien
	 * @param life
	 * @param rb
	 */
	public Alien(String name, int life, RecoveryBehavior rb)
	{
		super(name, life,10);
		recoveryBehavior = rb;
	}
	
	/**
	 * Create Alien with recovery behavior and rate recovery
	 * @param name Alien
	 * @param life
	 * @param rb
	 * @param recoveryrate
	 */
	public Alien(String name, int life, RecoveryBehavior rb, int recoveryrate) throws MyNewException
	{
        super();
        if (recoveryrate < 0) 
        {
            throw new MyNewException("Recovery rate can not be negative");
        }else if(recoveryrate >= 0) 
        {
            this.myName = name;
            this.currentLifePoints = life;
            this.attackStrength = 10;
            recoveryBehavior = rb;
            recoveryRate = recoveryrate;
            maxLifePoints = this.getCurrentLifePoints();
        }
	}
	
	/**
     * setRecoveryRate to Update the recoveryrate
     * @param rate
     */
    public void setRecoveryRate(int r) 
    {
        recoveryRate = r;
    }
 
    /**
     * getRecoveryRate to Return the recoveryrate
     * @return
     */
    public int getRecoveryRate() 
    {
        return recoveryRate;
    }
    
	/**
	 * Recover Points
	 */
	 public void recover()
	    {
	        setCurrentLifePoints(recoveryBehavior.calculateRecovery(super.getCurrentLifePoints(), maxLifePoints));
	    }
	
	/**
	 * Update life points after recover
	 * @param life
	 */
    public void setCurrentLifePoints(int life) 
    {
        super.currentLifePoints = life;
    }
}