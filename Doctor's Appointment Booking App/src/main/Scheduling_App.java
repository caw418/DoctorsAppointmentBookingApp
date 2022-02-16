package main;

import java.util.InputMismatchException;
import java.util.Scanner;


/**
 * This is the actual app you use to schedule appointments with doctors.
 * @author Daiki Naruke
 */
public class Scheduling_App {

	static Scanner console = new Scanner(System.in);
	
	/**
	 * Creates doctor objects and sets the days and times they are available. Then taking input from the user the 
	 * app knows rather to check for available appointments for the doctor they want or to book an appointment for
	 * the specified doctor.
	 */
	public static void main(String[] args) {
		
		Doctor Abby = new Doctor("Abby");
		Doctor Laura = new Doctor("Laura");
		Doctor Dave = new Doctor("Dave");
		Abby.setDaysAvailable("Monday", "Wednesday", "Friday");
		Abby.setTimesAvailable("Monday", "11:30 am", "12:30 pm", "2:30 pm");
		Abby.setTimesAvailable("Wednesday", "1:00 pm", "2:00 pm", "3:00 pm");
		Abby.setTimesAvailable("Friday", "9:00 am", "10:00 am", "11:00 am");
		Laura.setDaysAvailable("Tuesday", "Thursday");
		Laura.setTimesAvailable("Tuesday", "1:00 pm", "2:00 pm", "3:00 pm");
		Laura.setTimesAvailable("Thursday", "10:00 am", "11:00 am", "1:00 pm", "2:00 pm");
		Dave.setDaysAvailable("Monday", "Tuesday", "Wednesday");
		Dave.setTimesAvailable("Monday", "10:30 am", "11:30 am", "12:30 pm", "2:30 pm");
		Dave.setTimesAvailable("Tuesday", "1:30 pm", "2:30 pm", "3:30 pm");
		Dave.setTimesAvailable("Wednesday", "9:00 am", "10:00 am", "11:00 am", "1:30 pm", "2:30 pm");
		int userInput;
		String day;
		String time;
		
		do
		{
			System.out.println("1 - View Available Appointment By Doctor");
			System.out.println("2 - Book Appointment");
			try
			{
				userInput = console.nextInt();
			}
			catch(InputMismatchException e)
			{
				System.out.println("Please enter a valid option.");
				break;
			}
			switch(userInput)
			{
			case 1:
				System.out.println("Which doctor would you like to view timeslots for?");
				System.out.println("1 - Dr. Abby");
				System.out.println("2 - Dr. Laura");
				System.out.println("3 - Dr. Dave");
				try
				{
					userInput = console.nextInt();
				}
				catch(InputMismatchException e)
				{
					System.out.println("Please enter a valid option.");
					break;
				}
				switch(userInput)
				{
				case 1:
					for(String d: Abby.getDaysAvailable())
					{
						System.out.println("[" + d + "]");
						System.out.println(Abby.getTimesAvailable(d));
					}
					break;
				case 2:
					for(String d: Laura.getDaysAvailable())
					{
						System.out.println("[" + d + "]");
						System.out.println(Laura.getTimesAvailable(d));
					}
					break;
				case 3:
					for(String d: Dave.getDaysAvailable())
					{
						System.out.println("[" + d + "]");
						System.out.println(Dave.getTimesAvailable(d));
					}
					break;
				default: System.out.println("Choose a valid option.");
				}
				break;
			case 2:
				System.out.println("Which doctor would you like to book an appointment with?");
				System.out.println("1 - Dr. Abby");
				System.out.println("2 - Dr. Laura");
				System.out.println("3 - Dr. Dave");
				try
				{
					userInput = console.nextInt();
				}
				catch(InputMismatchException e)
				{
					System.out.println("Please enter a valid option.");
					break;
				}
				switch(userInput)
				{
				case 1:
					System.out.println("Which day?");
					day = console.next();
					System.out.println("What time?");
					time = console.next() + console.nextLine();
					Abby.bookAppointment(day, time);
					break;
				case 2:
					System.out.println("Which day?");
					day = console.next();
					System.out.println("What time?");
					time = console.next() + console.nextLine();
					Laura.bookAppointment(day, time);
					break;
				case 3: 
					System.out.println("Which day?");
					day = console.next();
					System.out.println("What time?");
					time = console.next() + console.nextLine();
					Dave.bookAppointment(day, time);
					break;
				default:
					System.out.println("Please enter a valid option.");
				}
				break;
			default:
				System.out.println("Please enter a valid option.");
			}
			System.out.println("Select another option? 1 - Yes, 2 - No");
			try
			{
				userInput = console.nextInt();
			}
			catch(InputMismatchException e)
			{
				System.out.println("Please enter a valid option.");
				break;
			}
		}
		while(userInput == 1);
	}
}