package FXML;

/**
 * CSC 214 - 402
 * 11/21/2018
 * Create Cartridge objects for the PCIS (Printer Cartridge Inventory System)
 * 
 * @author Matt Chandler of Team 4
 * @since 11-19-2018
 */

public class Cartridge {

	private String printerModel;
	private String brand;
	private String cartridgeModel;
	private int printerCount;
	private int minStock;
	private int curStock;
	private boolean order = false;
	private int needed;

	/**
	 * Constructor
	 * Creates a Cartridge object
	 * 
	 * @param printerModel	a String detailing the model name of the Printer that goes with the Cartridge
	 * @param brand	a String detailing the brand of the Cartridge
	 * @param cartridgeModel	a String detailing the model name of the Cartridge
	 * @param printerCount	how many Printers in stock take the Cartridge
	 * @param minStock	the minimum amount of Cartridges in stock before more need to be ordered
	 * @param maxStock	the current amount of Cartridges in stock the last time the stock was checked
	 * @param order	a boolean detailing whether more of this Cartridge type need to be ordered
	 * @param needed	the amount of this Cartridge that need to be ordered
	 * @return	none
	 * @exception	none
	 */
	public Cartridge (String printerModel, String brand, String cartridgeModel,
						int printerCount, int minStock, int maxStock, boolean order, int needed) {
		super();
		this.printerModel = printerModel;
		this.brand = brand;
		this.cartridgeModel = cartridgeModel;
		this.printerCount = printerCount;
		this.minStock = minStock;
		this.curStock = maxStock;
		this.order = order;
		this.needed = needed;
	}

	public Cartridge()
	{
		//Overloaded constructor
	}
	public String getPrinterModel()
	{
		return printerModel;
	}
	public void setPrinterModel(String printerModel)
	{
		this.printerModel = printerModel;
	}
	public String getBrand()
	{
		return brand;
	}
	public void setBrand(String brand)
	{
		this.brand = brand;
	}
	public String getCartridgeModel()
	{
		return cartridgeModel;
	}
	public void setCartridgeModel(String cartridgeModel)
	{
		this.cartridgeModel = cartridgeModel;
	}
	public int getPrinterCount()
	{
		return printerCount;
	}
	public void setPrinterCount(int printerCount)
	{
		this.printerCount = printerCount;
	}
	public int getMinStock()
	{
		return minStock;
	}
	public void setMinStock(int minStock)
	{
		this.minStock = minStock;
	}
	public int getMaxStock()
	{
		return curStock;
	}
	public void setMaxStock(int maxStock)
	{
		this.curStock = maxStock;
	}
	public boolean isOrder()
	{
		return order;
	}
	public void setOrder(boolean order)
	{
		this.order = order;
	}
	public int getNeeded()
	{
		return needed;
	}
	public void setNeeded(int needed)
	{
		this.needed = needed;
	}

	/**
	 * toString
	 * Used to create a String detailing all of the data fields for the Cartridge
	 * 
	 * @param	none
	 * @returns a String detailing all of the data fields for the Cartridge
	 * @exception	none
	 */
	
	@Override
	public String toString() {
		return "PrinterModel: " 		+ printerModel 
				+ " - Brand: " 			+ brand 
				+ " - cartridgeModel: "	+ cartridgeModel
				+ " - printerCount: " 	+ printerCount 
				+ " - minStock: " 		+ minStock 
				+ " - curStock: " 		+ curStock 
				+ " - order: "			+ order 
				+ " - needed: " 		+ needed;
	}

	/**
	 * toBooleanObject
	 * Used to create a Boolean to flag whether more of the cartridge needs to be ordered
	 * 
	 * @param	str	a String to be checked for boolean setting
	 * @returns a Boolean detailing whether more cartridges need to be ordered
	 * @exception	none
	 */
	
	public static Boolean toBooleanObject(String str) {
		if ("true".equalsIgnoreCase(str)) {
			return Boolean.TRUE;
		} else if ("false".equalsIgnoreCase(str)) {
			return Boolean.FALSE;
		} else if ("on".equalsIgnoreCase(str)) {
			return Boolean.TRUE;
		} else if ("off".equalsIgnoreCase(str)) {
			return Boolean.FALSE;
		} else if ("yes".equalsIgnoreCase(str)) {
			return Boolean.TRUE;
		} else if ("no".equalsIgnoreCase(str)) {
			return Boolean.FALSE;
		}

		return null;
	}
}