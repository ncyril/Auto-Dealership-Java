public class Auto {

	// Data Members
	private String make;
	private String model;
	private int year;
	protected double basePrice;
	private double percentMarkup;
	protected int miles;
	private boolean isForSale;

	// Constructor
	public Auto(String M, String Mo, int Y, double B, boolean S) {
		this.isForSale = S;
		this.percentMarkup = 1.10;
		this.make = M;
		this.model = Mo;
		this.year = Y;
		this.basePrice = B;
		this.miles = this.setMiles();
	}

	// Getters & Setters
	public String getMake() {
		return this.make;
	}

	public String getModel() {
		return this.model;
	}

	public int getYear() {
		return this.year;
	}

	public double getBasePrice() {
		return this.basePrice;
	}

	public double getRetailPrice() {
		return this.basePrice * this.percentMarkup;
	}

	public void setPercentMarkup(double UserInput) {
		this.percentMarkup = UserInput;
	}

	public double getPercentMarkup() {
		return this.percentMarkup;
	}

	private int setMiles() {
		return (int) ((int) 500 + (Math.random() * 2001));

	}

	public int increaseMiles(int newMiles) {
		return this.miles + newMiles;
	}

	public boolean isForSale() {
		return this.isForSale;
	}

	public boolean sell() {
		return this.isForSale = false;
	}

	public String printAuto() {
		return "The" + " " + this.getYear() + " " + this.getMake() + " "
				+ this.getModel() + "\n" + "----------------" + "\n" + "Miles:"
				+ " " + this.miles + "\n Retail price is $"
				+ this.getRetailPrice();
	}

}
