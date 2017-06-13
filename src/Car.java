import java.util.Random;

public class Car extends Auto {

	// Data Members
	private boolean hasCupholders;
	private boolean hasLeatherseats;
	private boolean hasGps;
	private boolean hasDVDPlayers;

	// Constructor
	public Car(String M, String Mo, int Y, double B, boolean S) {
		super(M, Mo, Y, B, S);
		this.hasCupholders = this.getCupholders();
		this.hasLeatherseats = this.getLeatherseats();
		this.hasGps = this.getGps();
		this.hasDVDPlayers = this.getDVDPlayers();

	}

	// Getters & Setters
	public boolean getCupholders() {
		Random rgn = new Random();
		double randomdouble = rgn.nextDouble();
		double num = 1;
		num = randomdouble;
		if (num <= 0.5) {
			return true;
		}
		return false;
	}

	public boolean getLeatherseats() {
		Random rgn = new Random();
		double randomdouble = rgn.nextDouble();
		double num = 1;
		num = randomdouble;
		if (num <= 0.33) {
			return true;
		}
		return false;
	}

	public boolean getGps() {
		Random rgn = new Random();
		double randomdouble = rgn.nextDouble();
		double num = 1;
		num = randomdouble;
		if (num <= 0.25) {
			return true;
		}
		return false;

	}

	public boolean getDVDPlayers() {
		Random rgn = new Random();
		double randomdouble = rgn.nextDouble();
		double num = 1;
		num = randomdouble;
		if (num <= 0.20) {
			return true;
		}
		return false;
	}

	public String printAuto() {
		String str = super.printAuto();
		String specials = "";
		if (this.hasCupholders) {
			specials += "Cup Holders\n";
		} else if (this.hasDVDPlayers) {
			specials += "DVD Players\n";
		} else if (this.hasGps) {
			specials += "Gps\n";
		} else if (this.hasLeatherseats) {
			specials += "Leather Seats\n";
		}
		return str + "\n" + "Special Features:\n" + specials;
	}

	public static void main(String[] args) {
		int randomint = (int) ((int) 2 + (Math.random() * 7));
		System.out.println(randomint + " " + "tow Capacity");

	}
}
