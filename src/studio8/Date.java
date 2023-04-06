package studio8;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Objects;

public class Date {

	public static void main(String[] args) {
		/*
		 * Date k = new Date(1, 1, 1, true); System.out.println(k.toString()); Date kk =
		 * new Date(2, 1, 1, false); System.out.println(kk.toString()); Time x = new
		 * Time(1, 1, true); System.out.println(x.toString()); Time xx = new Time(2, 2,
		 * false); System.out.println(xx.toString());
		 * 
		 * System.out.println(k.equals(kk)+" "+x.equals(xx));
		 * System.out.println(k.hashCode()==kk.hashCode());
		 */

		/*
		 * LinkedList<Date> list = new LinkedList<Date>(); for (int i = 1; i <=5; i++)
		 * list.add(new Date(i,i,i, Math.random()>.5)); list.add(new Date(1,1,1, true));
		 * list.add(new Date(1,1,1, false)); System.out.print(list);
		 */

		/*
		 * HashSet<Date> set = new HashSet<Date>(); for (int i = 1; i <= 5; i++)
		 * set.add(new Date(i, i, i, Math.random() > .5)); set.add(new Date(1, 1, 1,
		 * true)); set.add(new Date(1, 1, 1, false)); System.out.println(set);
		 */

		LinkedList<appointment> appointment = new LinkedList<appointment>();
		for (int i = 1; i <= 5; i++)
			appointment.add(new appointment(new Date(i, i, i, Math.random() > .5), new Time(i, i, Math.random() > .5)));

		calendar x = new calendar(appointment);
		System.out.print(x.toString());
	}

	private int month, day, year;
	private boolean holiday;

	/**
	 * Creates a new date with a month day and year. Also checks if the date is a
	 * holiday
	 * 
	 * @param month
	 * @param day
	 * @param year
	 * @param holiday
	 */
	public Date(int month, int day, int year, boolean holiday) {
		this.month = month;
		this.day = day;
		this.year = year;
		this.holiday = holiday;
	}

	/**
	 * returns the date and if the date is a holiday
	 */
	public String toString() {
		if (holiday)
			return month + "/" + day + "/" + year + " is a holiday.";
		return month + "/" + day + "/" + year + " is not a holiday.";
	}

	@Override
	public int hashCode() {
		return Objects.hash(day, month, year);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Date other = (Date) obj;
		return day == other.day && month == other.month && year == other.year;
	}
}

class appointment {

	private Date date;
	private Time time;

	public appointment(Date date, Time time) {
		this.date = date;
		this.time = time;
	}

	@Override
	public int hashCode() {
		return Objects.hash(date, time);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		appointment other = (appointment) obj;
		return Objects.equals(date, other.date) && Objects.equals(time, other.time);
	}

	@Override
	public String toString() {
		return "appointment [date=" + date + ", time=" + time + "]";
	}
}

class calendar {
	private LinkedList<appointment> apo;

	public calendar(LinkedList<appointment> apo) {
		this.apo = apo;
	}

	@Override
	public String toString() {
		String ret = "";
		//for (appointment i : apo)
		//	ret += (i.toString() + ", ");
		for (int i = 0; i < apo.size(); i++) {
			ret += (apo.get(i).toString() + ", ");
		}
		return ret;
	}

}