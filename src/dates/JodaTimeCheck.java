package dates;

import org.joda.time.DateTime;
import org.joda.time.Days;
import org.joda.time.LocalDate;

public class JodaTimeCheck {

	public static void main(String[] args) {

		LocalDate date = new LocalDate()
				.withYear(2014)
				.withMonthOfYear(6)
				.withDayOfMonth(10);

		System.out.println(date);
		System.out.println(getDaysTill(date));

		showDiscountDate();

//        daysToNewYear

	}

	private static void test() {
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

	private static int getDaysTill(LocalDate date) {
		LocalDate now = new LocalDate();
		Days d = Days.daysBetween(now, date);
		return d.getDays();
	}

	private static void showDiscountDate() {
		LocalDate now = new LocalDate();
		LocalDate date1 = now.plusDays(31);
		LocalDate date2 = now.plusDays(45);
		System.out.println("Data ranges with discount: " + date1 + " - " + date2);
	}

}
