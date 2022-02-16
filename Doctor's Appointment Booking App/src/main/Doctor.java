package main;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * The Doctor class is used to store the days/times he/she is available for appointments. It has a String to store 
 * the name, an ArrayList of Strings to store the days he/she is available and then a HashMap which takes the day
 * as a key and then the value is an ArrayList of Strings that represent the times he/she is available for that day.
 * @author Daiki Naruke
 */
public class Doctor {

	private String name;
	private ArrayList<String> daysAvailable = new ArrayList<>();
	private HashMap<String, ArrayList<String>> timesAvailable = new HashMap<>();
	int i;

	/**
	 * This constructor takes a name as a parameter and sets the doctor's name to that.
	 * @param name The name of the doctor.
	 */
	public Doctor(String name)
	{
		this.name = name;
	}
	
	/**
	 * This sets the days a doctor is available for appointments. It takes a list of the days available as a parameter
	 * as a var args. It then takes each day in the list and adds it to an ArrayList of String called daysAvailable.
	 * @param daysAvailable A list of the days a doctor is available.
	 */
	public void setDaysAvailable(String ... daysAvailable)
	{
		for(String day: daysAvailable)
		{
			this.daysAvailable.add(day);
		}
	}
	
	/**
	 * This sets the times a doctor is available on a specific day. The day you want to set times for is passed in as
	 * an argument. Then the list of times you want to add for that day is taken as a var args. Uses a loop to loop
	 * through and add each time in the var args times array and adds it to an ArrayList of timesAvailable. Finally,
	 * it puts that ArrayList of times in the HashMap (this.timesAvailable) using the day passed in as the key.
	 * @param day The day you want to add times for
	 * @param times The times you want to add for that day
	 */
	public void setTimesAvailable(String day, String ... times)
	{
		ArrayList<String> timesAvailable = new ArrayList<>();
		for(String time: times)
		{
			timesAvailable.add(time);
		}
		this.timesAvailable.put(day, timesAvailable);
	}
	
	/**
	 * This allows you to book an appointment with the doctor. You pass in the day you want and the time you want for
	 * that day.
	 * @param day Day of appointment
	 * @param time Time of appointment
	 */
	public void bookAppointment(String day, String time)
	{
		try
		{
			i = 0;
			ArrayList<String> timesAvailable = this.timesAvailable.get(day);
			for(String t: timesAvailable)
			{
				if(t.equals(time))
				{
					System.out.println("You have booked an appointment with " + this.name + " on " + day + " at " + 
					time + ".");
					timesAvailable.remove(i);
					this.timesAvailable.replace(day, timesAvailable);
					return;
				}
				i++;
			}
			System.out.println(this.name + " is not available at this date and time.");
		}
		catch(NullPointerException e)
		{
			System.out.println(this.name + " is not available at this date and time.");
		}
	}
	
	/**
	 * Getter method to get the days the doctor is available
	 * @return An ArrayList of the days he/she is available
	 */
	public ArrayList<String> getDaysAvailable()
	{
		return this.daysAvailable;
	}
	
	/**
	 * Getter method to get the times the doctor is available for the day passed in.
	 * @param day The day you want to get the doctor's available times for.
	 * @return An ArrayList of the times the doctor is available on the day passed in.
	 */
	public ArrayList<String> getTimesAvailable(String day)
	{
		return this.timesAvailable.get(day);
	}
}