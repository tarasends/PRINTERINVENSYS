package FXML;

/**
 * Create Printer objects for the PCIS (Printer Cartridge Inventory System)
 * 
 * @author Eric Arnold of Team 4
 * @since 11-19-2018 
 */

public class Printer {
	private int barcode;
	private String name;
	private String type;
	private String location;
	private String serialNumber;
	private String manufacturer;
	private String division;
	private String department;
	private String campus;
	private boolean status;

	/**
	 * Constructor
	 * Creates a Printer object
	 * 
	 * @param barcode	a barcode to identify the specific Printer
	 * @param name	a String detailing the name of the Printer
	 * @param type	a String detailing the type of Printer
	 * @param location	a String detailing the location of the Printer
	 * @param serialNumber	a String to hold the serial number to identify the specific Printer
	 * @param manufacturer	a String detailing the manufacturer of the Printer
	 * @param division	a String detailing the division of Del Tech the Printer is in
	 * @param department	a String detailing the department of Del Tech the Printer is in
	 * @param campus	a String detailing the Del Tech campus the Printer is in
	 * @param status	a boolean detailing whether or not the Printer is currently active
	 * @return	none
	 * @exception	none
	 */
	public Printer(int barcode, String name, String type, String location, String serialNumber, String manufacturer,
			String division, String department, String campus, String status) {

		this.barcode = barcode;
		this.name = name;
		this.type = type;
		this.location = location;
		this.serialNumber = serialNumber;
		this.manufacturer = manufacturer;
		this.division = division;
		this.department = department;
		this.campus = campus;

		if (status.equals("ACTIVE")) {
			this.status = true;
		} else {
			this.status = false;
		}
	}

	/**
	 * toString
	 * Used to create a String detailing the important data fields of the Printer
	 * 
	 * @param	none
	 * @returns a String detailing the name, barcode, and location of the Printer
	 * @exception	none
	 */
	
	public String toString() {
		return name + " barcode# " + barcode + " is located in room " + location;
	}

	/**
	 * fullInfo
	 * Used to create a String detailing all of the data fields for the Printer
	 * 
	 * @param	none
	 * @returns a String detailing all of the data fields for the Printer
	 * @exception	none
	 */
	
	public String fullInfo() {
		String toReturn = "barcode: " + barcode + "\n";
		toReturn += "name: " + name + "\n";
		toReturn += "type: " + type + "\n";
		toReturn += "location: " + location + "\n";
		toReturn += "serialNumber: " + serialNumber + "\n";
		toReturn += "manufacturer: " + manufacturer + "\n";
		toReturn += "division: " + division + "\n";
		toReturn += "department: " + department + "\n";
		toReturn += "campus: " + campus + "\n";

		if (this.status == true) {
			toReturn += "status: ACTIVE" + "\n";
		} else {
			toReturn += "status: INACTIVE" + "\n";
		}
		
		return toReturn;
	}

	public int getBarcode() {
		return barcode;
	}

	public void setBarcode(int barcode) {
		this.barcode = barcode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public String getDivision() {
		return division;
	}

	public void setDivision(String division) {
		this.division = division;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getCampus() {
		return campus;
	}

	public void setCampus(String campus) {
		this.campus = campus;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

}