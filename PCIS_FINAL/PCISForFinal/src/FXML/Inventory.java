/**
 * The Inventory class holds an arrayList of cartridges 
 * and features a function to find cartridges for a specific printer.
 * 
 * @author Eric Arnold
 * @author Sean Roberts
 * @version 1.0
 * @since 2018-11-20
 */
package FXML;

import java.io.File;
//import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import org.json.JSONException;
import org.json.JSONObject;

//import javax.swing.text.BadLocationException;

public class Inventory {

	private Printer currentPrinter;
	private ArrayList<Cartridge> cartridgeList = new ArrayList<>();

	// String inputFile = "Wilmington Toner Database.xlsx";

	public Inventory() {

	}

	/**
	 * findPrinter is a method that takes in a barcode and combs through the
	 * printers.csv file to find and return a printer object created with the
	 * appropriate data.
	 * 
	 * @param code
	 *            an integer repesenting a barcode for a printer
	 * @return printer a Printer object
	 * @exception FileNotFoundException
	 *                in case of the file not being read properly.
	 */
	public Printer findPrinter(int code) {
		File file = new File("printers.csv");

		try {
			Scanner scanner = new Scanner(file);

			while (scanner.hasNextLine()) {
				String Line = scanner.nextLine();
				String[] stringArray = Line.split(",");

				if (stringArray[0].equals(String.valueOf(code))) {

					Printer printer = new Printer(Integer.parseInt(stringArray[0]), stringArray[1], stringArray[2],
							stringArray[3], stringArray[4], stringArray[5], stringArray[6], stringArray[7],
							stringArray[8], stringArray[9]);

					currentPrinter = printer;
					scanner.close();
					return printer;
				}
			}

			System.out.println("There is no Printer in our files with that barcode");
			scanner.close();
			return null;

		} catch (FileNotFoundException e) {
			System.out.println("File not found");
			return null;
		}
	}

	/**
	 * readTonerFile is a method that reads through the toner database csv file and
	 * puts the contents of the file into a list
	 * 
	 * @param nothing
	 * @return nothing
	 * @exception FileNotFoundException
	 *                in case the file is not able to be read.
	 * @throws IOException
	 *             in case of FileNotFoundException
	 * 
	 */
	public void readTonerFile() throws IOException {
		File file = new File("Wilmington Toner Database.csv");

		try {
			Scanner scanner = new Scanner(file);

			boolean flag = false;

			while (scanner.hasNextLine()) {
				Boolean toOrder;
				String Line = scanner.nextLine();
				String[] stringArray = Line.split(",");

				if (stringArray.length > 0) {

					if (!stringArray[0].equals("")) {

						if (flag == true) {

							if (stringArray[6].equals("YES")) {
								toOrder = true;
							} else {
								toOrder = false;
							}

							Cartridge cartridge = new Cartridge(stringArray[0], stringArray[1], stringArray[2],
									Integer.parseInt(stringArray[3]), Integer.parseInt(stringArray[4]),
									Integer.parseInt(stringArray[5]), toOrder, Integer.parseInt(stringArray[7]));

							cartridgeList.add(cartridge);
						} else {
							flag = true;
						}
					}
				}
			}

			scanner.close();

		} catch (FileNotFoundException e) {
			System.out.println("File not found");
		}
	}

	/**
	 * findCartridges uses the currentPrinter object and the cartridges list to sort
	 * through the data and find a matching cartridge for the printer.
	 * 
	 * @param nothing
	 * @return nothing
	 * @throws IOException 
	 * @exception FileNotFoundException
	 *                in case the file PrinterCartridge.csv is unable to be read.
	 */
	public String findCartridges() throws IOException {
		
		String consolePrint = "";
		String consolePrintString = "";
		String returnString = "";
		
		JSONObject obj = new JSONObject ();
		try {
			obj.put("Current Printer", currentPrinter.fullInfo());
			obj.put("Cartridge List", cartridgeList.toString());
			
			FileWriter file = new FileWriter("PCISJSON.json");
			file.write(obj.toString());
			file.close();
			
		} catch (JSONException e) {
			e.printStackTrace();
		}

		// Find cartridge names from PrinterCatridge list
		ArrayList<String> cartridges = new ArrayList<String>();
		File file = new File("PrinterCartridge.csv");

		try {
			Scanner scanner = new Scanner(file);

			while (scanner.hasNextLine()) {
				String Line = scanner.nextLine();
				String[] stringArray = Line.split(",");

				if (stringArray[0].equals(currentPrinter.getName())) {
					for (int i = 1; i < stringArray.length; i++) {
						cartridges.add(stringArray[i]);
					}
				}
			}

			consolePrint += "The cartridges for " + currentPrinter.getName() + " are: " + "\n" + cartridges + "\n\n";

			scanner.close();

			// Find the Cartridges in the cartridge list using the found name.

			for (int i = 0; i < cartridges.size(); i++) {

				boolean flag = false;

				for (int j = 0; j < cartridgeList.size(); j++) {

					if (cartridges.get(i).equals(cartridgeList.get(j).getCartridgeModel())) {

						consolePrintString += "cartridge model: " + cartridgeList.get(j).getCartridgeModel()
								+ " - current stock: " + cartridgeList.get(j).getMaxStock();
						
						
						flag = true;
					}
				}

				if (flag == false) {
					consolePrintString += cartridges.get(i) + " could not be found in our cartridge inventory\n";
				}
			}
			returnString += consolePrint + consolePrintString;
			return returnString;

		} catch (FileNotFoundException e) {
			return "File not found";
		}
	}

	public Printer getCurrentPrinter() {
		return currentPrinter;
	}

	public void setCurrentPrinter(Printer currentPrinter) {
		this.currentPrinter = currentPrinter;
	}

	public ArrayList<Cartridge> getCartridgeList() {
		return cartridgeList;
	}

	public void setCartridgeList(ArrayList<Cartridge> cartridgeList) {
		this.cartridgeList = cartridgeList;
	}
}
