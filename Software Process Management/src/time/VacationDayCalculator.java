package time;

public class VacationDayCalculator {
	/**

	* This method takes in the number of years you have been working and the salary band and returns the

	* vacation days entitlement

	* @param yearsWorking - number of years working from 0-25

	* @param salaryBand - range is 1-10

	* @return the number of vacation days as an int

	*/

	public static int calculateVacationDays(int yearsWorking, int salaryBand)

	{

	return 1*yearsWorking + salaryBand*4;
}
}
