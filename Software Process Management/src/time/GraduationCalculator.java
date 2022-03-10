package time;

public class GraduationCalculator {
	/**

	* Method to determine the year of graduation for a program that is 5 terms

	* If students start in January, they graduate the next calendar year.

	* If they start in September, they graduate in two calendar years.

	* If the user enters some other startingMonth, the program throws an invalidStartMonthException

	* @param startingYear

	* @param startingMonth

	* @return

	* @throws InvalidStartingMonthException

	*/

	public static int whenWillIGraduate(int startingYear, String startingMonth) throws InvalidStartingMonthException{

	int gradYear =startingYear;

	if(startingMonth.equals("January"))

	{

	gradYear = startingYear+1;

	}

	else if (startingMonth.equals("September"))

	{

	gradYear = gradYear + 2;

	}

	else

	{

	throw new InvalidStartingMonthException();

	 

	}

	return gradYear;

	}
}
