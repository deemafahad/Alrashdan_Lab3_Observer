/**
 * name: Deema Alrashdan
 */
package exceptions;
/**
 * Exception class to handle the non negative recovery rate
 */
public class MyNewException extends Exception
{
	private static final long serialVersionUID = 1L;
	
	/**
	 * MyNewException Print exception
	 * @param m
	 */
	public MyNewException(String m) 
	{	 
        System.out.println(m);
    }
}