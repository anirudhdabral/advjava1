package mavenassignment;

import java.util.*;
import Sort.*;

public class Main {
	
	private static void displayError(String error) {
		System.out.println(error + "\n");
	}

	private static void displayMessage(String message) {
		System.out.print(message);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int sortType = 0;
		String color, size, gender, response;
		FileTask task = new FileTask();
		Timer t = new Timer();
		t.schedule(task, 0, 3000);

		while (true) {
			displayMessage("\nColor: ");
			color = sc.nextLine().toUpperCase();
			displayMessage("Size: ");
			size = sc.nextLine().toUpperCase();
			displayMessage("Gender (M/F): ");
			gender = sc.nextLine().toUpperCase();
			displayMessage("Sort by:\n" + "\t1. price\n" + "\t2. rating\n" + "\t3. both\n" + "\t4. none\n");
			try {
				sortType = sc.nextInt();
				sc.nextLine();
			} catch (InputMismatchException e) {
				displayError("Choose the option number only!");
				sc.nextLine();
				continue;
			}
			switch (sortType) {
			case 1:
				Collections.sort(task.list, new SortByPrice());
				break;
			case 2:
				Collections.sort(task.list, new SortByRating());
				break;
			case 3:
				Collections.sort(task.list, new SortByBoth());
				break;
			case 4:
				break;
			default:
				displayError("Invalid option");
				continue;
			}

			if (task.list.isEmpty()) {
				displayError("No files found");
			} else {
				boolean flag= false;
				for (Tshirts item : task.list) {
					if (item.getColor().toUpperCase().equals(color) && item.getSize().toUpperCase().equals(size)
							&& item.getGender().toUpperCase().equals(gender)) {
						System.out.println(item);
						flag = true;
					}
				}
				if(!flag) {
					displayError("No match found");
				}
				
			}

			displayMessage("\nDo you want to search again (y/n):");
			response = sc.nextLine();
			if (response.toUpperCase().equals("N")) {
				break;
			}
		}
		sc.close();
		System.exit(0);

	}

}
