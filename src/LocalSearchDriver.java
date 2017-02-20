
import java.util.Scanner;
// code to provide an easy way for TAs to run your code
// feel free to add choices if appropriate

public class LocalSearchDriver {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter 1 for Hill Climbing without shoulder moves, 2 for Hill Climbing with shoulder moves, 3 for Genetic Algorithm.");
		int choice = input.nextInt();
		if (choice == 1)
		{
			

		}
		else if (choice == 2)
		{
			// code to do Hill Climbing with shoulder moves here
			
		}
		else if (choice == 3)
		{
			// code to do Genetic Algorithm here 
		}
		else 
			System.out.println("Bad choice");
	}
}
