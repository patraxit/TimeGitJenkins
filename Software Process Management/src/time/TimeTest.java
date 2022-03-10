package time;

import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class TimeTest {

	
	@Test
	void testGetTotalSecondsGood() {
		int seconds = Time.getTotalSeconds("05:05:05");
		assertTrue("The seconds were not calculated properly",seconds==18305);
	}
	
	@Test
	void testGetTotalSecondsBad() {
	assertThrows(StringIndexOutOfBoundsException.class,
			()->{
				System.out.println();
				Time.getTotalSeconds("10:00");
			}
			);	
	}
	
	@ParameterizedTest
	@ValueSource(strings = {"05:00:00", "05:59:59"})
	void testGetTotalSecondsBoundary(String candidate) {
		int seconds = Time.getTotalSeconds(candidate);
		assertTrue("The seconds were not calculated properly", seconds==18000||seconds==21599);

	}

	@Test
	void testGetSecondsGood() {
		int seconds = Time.getSeconds("05:05:05");
		assertTrue("The seconds were not calculated properly",seconds==05);
	}
	
	@Test
	void testGetSecondsBad() {
	assertThrows(StringIndexOutOfBoundsException.class,
			()->{
				System.out.println();
				Time.getSeconds("10:00");
			}
			);	
	}
	
	@ParameterizedTest
	@ValueSource(strings = {"05:00:00", "05:59:59"})
	void testGetSecondsBoundary(String candidate) {
		int seconds = Time.getSeconds(candidate);
		assertTrue("The seconds were not calculated properly", seconds==0||seconds==59);

	}


	@Test
	void testGetTotalMinutesGood() {
		int minutes = Time.getTotalMinutes("05:05:00");
		assertTrue("The minutes were not calculated properly",minutes==5);
	}
	
	@Test
	void testGetTotalMinutesBad() {
	assertThrows(StringIndexOutOfBoundsException.class,
			()->{
				System.out.println();
				Time.getTotalMinutes("00");
			}
			);	
	}
	
	@ParameterizedTest
	@ValueSource(strings = {"00:00:00", "00:59:00"})
	void testGetTotalMinutesBoundary(String candidate) {
		int minutes = Time.getTotalMinutes(candidate);
		assertTrue("The minutes were not calculated properly", minutes==00||minutes==59);

	}


	@Test
	void testGetTotalHoursGood() {
		int hours = Time.getTotalHours("05:00:00");
		assertTrue("The hours were not calculated properly",hours==5);
	}
	
	@Test
	void testGetTotalHoursBad() {
	assertThrows(StringIndexOutOfBoundsException.class,
			()->{
				System.out.println();
				Time.getTotalHours("");
			}
			);	
	}
	
	@ParameterizedTest
	@ValueSource(strings = {"00:00:00", "24:59:59"})
	void testGetTotalHoursBoundary(String candidate) {
		int hours = Time.getTotalHours(candidate);
		assertTrue("The hours were not calculated properly", hours==00||hours==24);

	}
	
	@Test
	void testGetMiliSecondsGood() {
		int Miliseconds = Time.getMiliseconds("05:05:05:005");
		assertTrue("The Miliseconds were not calculated properly",Miliseconds==5);
	}
	
	@Test
	void testGetMiliSecondsBad() {
	assertThrows(StringIndexOutOfBoundsException.class,
			()->{
				System.out.println();
				Time.getMiliseconds("05:05");
			}
			);	
	}
	
	@ParameterizedTest
	@ValueSource(strings = {"05:05:05:001", "05:05:05:999"})
	void testGetMiliSecondsBoundary(String candidate) {
		int Miliseconds = Time.getMiliseconds(candidate);
		assertTrue("The seconds were not calculated properly", Miliseconds==1||Miliseconds==999);

	}
	
	@Test
	void testGraduationYearGood() throws InvalidStartingMonthException {
		int year = GraduationCalculator.whenWillIGraduate(2020, "January");
		assertTrue("The year was not calculated properly",year==2021);
	}
	
	@Test
	void testGraduationYearBad() {
		assertThrows(InvalidStartingMonthException.class,
				()->{
					System.out.println();
					GraduationCalculator.whenWillIGraduate(2020, "February");
				}
				);	
		}
	
	@ParameterizedTest
	@CsvSource( {"0,1"})
	void testVacationDaysBoundary(int days, int salary) {
		int calculate = VacationDayCalculator.calculateVacationDays(days, salary);
		assertTrue("The vacation days were not calculated properly", calculate==4);

	}
	
	@ParameterizedTest
	@CsvSource( {"0,1"})
	void testVacationDsaysBoundary(int days, int salary) {
		int calculate = VacationDayCalculator.calculateVacationDays(days, salary);
		assertTrue("The vacation days were not calculated properly", calculate==4);

	}

}
