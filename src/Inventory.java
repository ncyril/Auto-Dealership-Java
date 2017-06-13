/**
 * 
 * @author nigelcyril
 *
 */

public class Inventory {
	// Data Members
	private Auto[] inventory;

	// Constructor
	public Inventory() {
		inventory = new Auto[6];
		inventory[0] = new Car("Cadilac", "ATS-V", 2014, 16000, true);
		inventory[1] = new Car("BMW", "228", 2014, 32000, true);
		inventory[2] = new Car("KIA", "K900", 2014, 21000, true);
		inventory[3] = new Truck("Toyata", "Camry", 2014, 20000, true);
		inventory[4] = new Truck("Ford", "Raptor", 2014, 25000, true);
		inventory[5] = new Truck("Lexus", "LX", 2009, 12000, false);
	}

	// Prints Car and Truck List
	public void PrintInventory() {
		for (int i = 0; i < inventory.length; i++) {

			System.out.println(i + ")" + " " + inventory[i].printAuto());
		}
	}

	// Tells the user if the car is available to purchase
	public void printActiveInventory() {
		for (int i = 0; i < inventory.length; i++) {
			if (inventory[i].isForSale()) {
				System.out.println(i + ")" + " " + inventory[i].printAuto());
				System.out.println("This is for sale");
			}
		}
	}

	// Tells the user if they can buy this car
	public void printOldInventory() {
		for (int i = 0; i < inventory.length; i++) {
			if (inventory[i].isForSale() == false) {
				System.out.println(i + ")" + " " + inventory[i].printAuto());
				System.out.println("This has been sold");

			}
		}
	}

	// Input in console to add new vehicles
	public void AddInventory(Auto a) {
		Auto[] temp = new Auto[inventory.length + 1];
		for (int i = 0; i < inventory.length; i++) {
			temp[i] = inventory[i];
		}
		inventory = temp;
		inventory[temp.length - 1] = a;

	}

	public int getMenuOption(int min, int max) {

		// Catches Illegal Argument from the user
		if (min > max) {
			throw new IllegalArgumentException();
		}

		int option = min;
		String input;
		while (true) {
			System.out.print("Please select option between " + min + " and "
					+ max + ":");
			try {
				input = StdIn.readLine();
				option = Integer.parseInt(input);
			} catch (java.lang.NumberFormatException e) {
				System.out.println("\nPlease enter a valid integer.");
				continue;
			}

			if ((option >= min) && (option <= max)) {
				return option;
			}
			System.out.println("Invalid selection.");

		}
	}

	// Indicates if user input is valid
	public String notACarString(String input, String input2) {
		String Input;
		while (true) {
			System.out.println("Car or Truck?");
			Input = StdIn.readLine();
			Input = Input.toLowerCase();
			input = input.toLowerCase();
			input2 = input2.toLowerCase();
			if (Input.equals(input) || Input.equals(input2)) {
				return Input;
			} else {
				System.out.println("Please enter a valid string");

			}
		}

	}

	public int MenuOption() {

		StdOut.println("1) Print Inventory");
		StdOut.println("2) Add new Auto");
		StdOut.println("3) Sell Auto");
		StdOut.println("4) Test Drive Auto");
		StdOut.println("5) Change Price");
		StdOut.println("6) Exit Program");
		return this.getMenuOption(1, 6);

	}

	// Options
	public int inventoryOption() {

		StdOut.println("1) Print Entire Inventory");
		StdOut.println("2) Print Active Inventory");
		StdOut.println("3) Print Old Inventory");
		return this.getMenuOption(1, 3);

	}

	public void NewAuto() {

		String CT = this.notACarString("Car", "Truck");
		StdOut.println("Make:");
		String M = StdIn.readString();
		StdOut.println("Model:");
		String Mo = StdIn.readString();
		StdIn.readLine();
		int Y = this.getMenuOption(1900, 2016);
		StdOut.println("Base Pice");
		double BP = this.getMenuOption(0, 1000000000);
		if (CT.equals("car")) {
			this.AddInventory(new Car(M, Mo, Y, BP, true));
		} else if (CT.equals("truck")) {
			this.AddInventory(new Truck(M, Mo, Y, BP, true));

		}

	}

	public void sellAuto() {
		while (true) {
			StdOut.println("Please select an auto index");
			int userInt = this.getMenuOption(0, inventory.length - 1);
			System.out.println(inventory[userInt].printAuto());
			if (!inventory[userInt].isForSale()) {
				System.out.println("This car has already been sold");
				continue;

			} else {
				StdOut.println("Is this what you were looking for?");
				String userString = StdIn.readString();
				StdIn.readLine();

				if ((userString.equals("yes") || userString.equals("y"))) {
					inventory[userInt].sell();
				} else {
					System.out.println("Please either enter Yes or y");
				}
				break;
			}
		}

	}

	public void testDriveAuto() {
		while (true) {

			StdOut.println(" please select an auto index");
			int userInt = this.getMenuOption(0, inventory.length - 1);
			if (!inventory[userInt].isForSale()) {
				System.out.println("This car is not available to test drive");
				continue;

			} else {
				System.out.println(inventory[userInt].printAuto());
			}

			// StdOut.println("How long do u want to drive for?");
			int userI = this.getMenuOption(0, 15);
			// StdIn.readLine();
			userI += inventory[userInt].increaseMiles(userI);
			System.out.println("You have driven" + " " + userI + " " + "miles");
			break;
		}
	}

	public void changePrice() {

		StdOut.println(" Please select auto index");
		int userInt = this.getMenuOption(0, inventory.length - 1);
		System.out.println(inventory[userInt].printAuto());
		System.out.println("Base Price:" + " " + "$"
				+ inventory[userInt].getBasePrice() + " " + ","
				+ "Percent MarkUp" + " "
				+ inventory[userInt].getPercentMarkup() + " " + ","
				+ "Retail Price" + " " + "$"
				+ inventory[userInt].getRetailPrice());
		while (true) {
			StdOut.println(" Percentage Markup Change:");
			double UserInt = StdIn.readDouble();
			StdIn.readLine();
			if (UserInt <= 0) {
				System.out.println("Insuffiecent Integer");
				continue;

			} else {
				inventory[userInt].setPercentMarkup(UserInt);
				System.out.println("$" + inventory[userInt].getRetailPrice());
				break;
			}
		}
	}

	public void runInv() {
		while (true) {
			int option = this.MenuOption();
			if (option == 1) {
				int option2 = this.inventoryOption();
				if (option2 == 1) {
					this.PrintInventory();
				} else if (option2 == 2) {
					this.printActiveInventory();
				} else if (option2 == 3) {
					this.printOldInventory();
				}
			} else if (option == 2) {
				this.NewAuto();
			} else if (option == 3) {
				this.sellAuto();
			} else if (option == 4) {
				this.testDriveAuto();

			} else if (option == 5) {
				this.changePrice();

			} else {
				System.out.println("Thanks for coming!!");
				System.exit(0);

			}
		}

	}

	public void run() {
		StdOut.println("\n Welcome to Cyril Auto Imporeium!!");
		while (true) {
			this.runInv();
		}
	}

	public static void main(String[] args) {
		Inventory inv = new Inventory();
		inv.run();
	}

}
