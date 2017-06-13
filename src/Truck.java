import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Truck extends Auto {

	// Data Members
	private boolean hasCupHolders;
	public boolean has4WD;
	public int towCapacity;

	// Constructors
	public Truck(String M, String Mo, int Y, double B, boolean S) {
		super(M, Mo, Y, B, S);
		this.hasCupHolders = this.getCupHolders();
		this.has4WD = this.get4WD();
		this.towCapacity = this.gettowCapacity();
	}

	// Getters & Setters
	public boolean getCupHolders() {
		Random rgn = new Random();
		double randomdouble = rgn.nextDouble();
		double num = 1;
		num = randomdouble;
		if (num <= 0.5) {
			return true;
		}
		return false;

	}

	public boolean get4WD() {
		Random rgn = new Random();
		double randomdouble = rgn.nextDouble();
		double num = 1;
		num = randomdouble;
		if (num <= 0.66) {
			return true;
		}
		return false;
	}

	public int gettowCapacity() {
		int randomint = (int) ((int) 2 + (Math.random() * 7));
		return randomint;

	}

	public String printAuto() {
		String str = super.printAuto();
		String specials = "";
		if (this.hasCupHolders) {
			specials += "Cup Holders\n";
		} else if (this.has4WD) {
			specials += "4 wheel drive\n";
		}

		return str + "\n " + "Special Features:\n" + specials
				+ this.gettowCapacity() + " " + "tow Capacity";
	}

	public static String main(String[] args) {
		System.out.println("This is a String:");
		Scanner s = new Scanner(System.in);
		String choice = "";
		try {
			choice = s.next();
		} catch (InputMismatchException ime) {
			s.nextLine();
			System.out.println("Bad input type!");
		}
		if (StdIn.readString().equals(choice)) {
			s.close();
			return choice;
		} else {
			System.out.println("Wrong input value");
		}
		return choice;

	}

}
