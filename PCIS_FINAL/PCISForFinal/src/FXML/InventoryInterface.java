package FXML;

/**
 * An Interface for the Inventory class used in the PCIS program
 * 
 * @author Sean Roberts of Team 4
 * @since 11-19-2018
 */

public interface InventoryInterface {
	
	/**
	 * Reads the Wilmington Toner Database csv file for toner inventory,
	 * and creates an arrayList of Cartridges.
	 */
	
	public void readTonerFile ();
	
	/**
	 * Reads the printers csv file to find the printer with the given barcode/asset tag number
	 * 
	 * @param	barcode	The barcode for the printer to be found.
	 * @returns	The Printer object found by its barcode.
	 */
	
	public Printer findPrinter (int barcode);
	
	/**
	 * Reads the PrinterCartridge csv file to display the cartridge information for a given Printer object.
	 */
	
	public void findCartridge();

}