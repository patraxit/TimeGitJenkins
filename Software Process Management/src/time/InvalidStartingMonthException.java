package time;

@SuppressWarnings("serial")
public class InvalidStartingMonthException extends Exception {
	public InvalidStartingMonthException()

	{

	super("Must start in September or January");

	}
}
