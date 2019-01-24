package FXML;

/**
 * Enables the User Interaction for PCIS (Printer Cartridge Inventory System)
 * 
 * @author Tara McKaskle (TEAM 4)
 * @version 1.0
 * @since 11-06-2018
 */

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;
import javafx.stage.StageStyle;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.io.*;

public class UserConsole {

	@FXML
	public Label lblBarCode;
	@FXML
	public Label lblComments;
	@FXML
	public Label lblPrompt;
	@FXML
	public Label lblRoomNumber;
	@FXML
	public Label lblPrintOut;
	@FXML
	public TextField txtBarCode;
	@FXML
	public TextField txtComments;
	@FXML
	public TextField txtRoomNumber;
	
	/**
	 * clearFields gives the option to clear all fields in the console
	 * 
	 * @param none
	 * @return none
	 * @exception none
	 */
	public void clearFields() {
		lblPrompt.setText("");
		txtBarCode.setText("");
		txtComments.setText("");
		txtRoomNumber.setText("");
		lblPrintOut.setText("");
	}

	
	/**
	 * createFile makes sure both fields must be filled in order to create or save file
	 * if the room number is empty, it notifies the user that they must input a room number
	 * the comment field does not get cleared, just notified to input a room number
	 * 
	 * @param none
	 * @return none
	 * @exception none
	 */


	public void createFile() {

		if ((!txtRoomNumber.getText().equals("")) 
				&& (!txtComments.getText().equals(""))) {

			writeToFile();
			lblPrompt.setText("File Saved");
			txtComments.setText("");

		} else if ((txtRoomNumber.getText().equals(""))
				|| (txtComments.getText().equals(""))) {

			lblPrompt.setText("MISSING FIELDS");
		}
	}

	/**
	 * writeToFile takes the comment field and saves or creates a file based off the room number input
	 * the name of the file saved is the room number input
	 * the text from the comment field is saved with a date and time stamp header
	 * 
	 * @exception IOException if the comments cannot be written to or file can not be closed.
	 */

	public void writeToFile() {

		try {

			BufferedWriter br = new BufferedWriter(new FileWriter
					(txtRoomNumber.getText() + ".txt", true));
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			Date date = new Date();
			br.newLine();
			br.write(formatter.format(date));
			br.newLine();
			br.write(txtComments.getText());
			br.newLine();
			br.close();

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
		}
	}

	/**
	 * printFind uses the barcode input and then uses the Inventory class to find the number
	 * 
	 * @param none
	 * @return none
	 * @exception Exception is thrown when the number input is not found in the file
	 */

	public void printFind() {

		Alert alert = new Alert(Alert.AlertType.ERROR);
		alert.initStyle(StageStyle.UTILITY);
		alert.setTitle("ERROR!");
		alert.setHeaderText(null);

		try {

			int assetTag = Integer.parseInt(txtBarCode.getText());


			if (assetTag > 0) {

				lblPrompt.setText("Number Accepted.");
				Inventory inventorycheck = new Inventory();
				inventorycheck.readTonerFile();
				inventorycheck.findPrinter(assetTag);
				String display = inventorycheck.findCartridges();
				lblPrintOut.setText(display);

			} else {
				txtBarCode.setText("");
				lblPrompt.setText("");
				alert.setContentText("Input must be number.");
				alert.showAndWait();
			}

		} catch (Exception e) {
			txtBarCode.setText("");
			lblPrompt.setText("");
			alert.setContentText("No record found for the barcode entered.");
			alert.showAndWait();
		} 
	}
} // end User Console

