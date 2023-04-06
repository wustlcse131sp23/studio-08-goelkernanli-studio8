package studio8;

import java.util.Objects;

public class Time {

	public static void main(String[] args) {

	}

	private int hour, minute;
	private boolean militaryTime;

	/**
	 * Time is the time
	 * 
	 * @param hour         is the hour
	 * @param minute       is the minute
	 * @param militaryTime is if we are using military time
	 */
	public Time(int hour, int minute, boolean militaryTime) {
		this.hour = hour;
		this.minute = minute;
		this.militaryTime = militaryTime;
	}

	/**
	 * returns the time in the desired format
	 */
	public String toString() {
		if (militaryTime)
			return hour + ":" + minute;
		if (hour > 12)
			return (hour - 12) + ":" + minute + " pm";
		if (hour == 0)
			return 12 + ":" + minute + " am";
		if (hour == 12)
			return hour + ":" + minute + " pm";
		return hour + ":" + minute + " am";
	}

	@Override
	public int hashCode() {
		return Objects.hash(hour, minute);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Time other = (Time) obj;
		return hour == other.hour && minute == other.minute;
	}
	
}