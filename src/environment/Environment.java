/**
  * name: Deema Alrashdan
  */
package environment;

import lifeform.LifeForm;

/**
 * Environment class keeps tracks of a small word of cells in which LifeForm can exist
 * These cells are arranged in a simple grids
 */
public class Environment
{   // 2D array of cells
	Cell[][] theCells = new Cell[2][3];
	private int rows;
	private int cols;
	public Environment(int row, int col)
	{
		rows = row;
		cols = col;
		for (int i = 0; i < row; i++) 
		{
            for (int j = 0; j < col; j++)
            {
            	 theCells[i][j] = new Cell();
            }    
		}
	}
	
	/**
	 * Tries to add the Cell to the Environment. Will not add if a
	 * Cell is empty, and the row and col are bigger than rows and cols and
	 * row and col are more less than 0
	 * @param LifeForm the entity of LifeForm
	 * @param row the number of rows
	 * @param col the number of columns
	 * @return true if the Cell was added to the Environment, false otherwise
	 */
	public boolean addLifeForm(LifeForm entity, int row, int col)
	{
		if((theCells[row][col].getLifeForm() != entity) && row >= 0 && row < rows && col >= 0 && col < cols)
		{
			theCells[row][col].addLifeForm(entity);
			return true;
		}
		else
		{
			return false;
		}
	}
	
	/**
	 * Tries to remove the Cell to the Environment. Will not remove if the Cell is empty
	 * row and col are more less than 0
	 * @param row the number of rows
	 * @param col the number of columns
	 * @returns the LifeForm removed to the Environment, null if no LifeForm in the Cell
	 */
	public LifeForm removeLifeForm(int row, int col)
	{
		LifeForm lifeFormC = null;
		if (theCells[row][col] != null  && row >= 0 && row < rows && col >= 0 && col < cols) {
			lifeFormC = theCells[row][col].getLifeForm();
            theCells[row][col] = null;
            return lifeFormC;
        } 
		else
            return lifeFormC;
	}
}