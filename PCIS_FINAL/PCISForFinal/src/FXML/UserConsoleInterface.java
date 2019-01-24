package FXML;

/**
 * An Interface for the User Console class used in the PCIS program
 * 
 * @author Tara McKaskle (TEAM 4)
 * @version 1.0
 * @since 11-06-2018
 */

public interface UserConsoleInterface {

	/*
	 * Clears all the text and label prompt fields
	 */
	
	public void clearFields();
	
	/*
	 * Writes to file only if both text fields are filled
	 */
	
	public void createFile();
	
	/*
	 * Creates the file with comments and names the file the room number 
	 */
	
	public void writeToFile ();

	/*
	 * Finds the printer from the barcode input
	 */
	
	public void printFind();

}
