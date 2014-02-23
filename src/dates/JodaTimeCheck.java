package dates;

import org.joda.time.DateTime;
import org.joda.time.Days;
import org.joda.time.LocalDate;

public class JodaTimeCheck {

	public static void main(String[] args) {
		DateTime dateTime = new DateTime();
		System.out.println(dateTime.toString());

		LocalDate localDate = new LocalDate();
		System.out.println(localDate.toString());

		System.out.println(daysToNewYear(localDate).getDays());

	}

	private static Days daysToNewYear(LocalDate fromDate) {
		LocalDate newYear = fromDate.plusYears(1).withDayOfYear(1);
		System.out.println(newYear.toString());
		return Days.daysBetween(fromDate, newYear);
	}

}
