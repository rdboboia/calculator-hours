package rdboboia.calculator.hours;

import java.time.LocalTime;

public interface HoursDifferenceCalculator {
	public static LocalTime getHourDiff(LocalTime startTime, LocalTime endTime) {
		int startTimeSeconds = startTime.getHour() * 3600 + startTime.getMinute() * 60 + startTime.getSecond();
		int endTimeSeconds = endTime.getHour() * 3600 + endTime.getMinute() * 60 + endTime.getSecond();
		
		int diffSeconds = endTimeSeconds - startTimeSeconds;
		if (diffSeconds < 0) {
			diffSeconds += 24 * 3600;
		}
		
		return LocalTime.ofSecondOfDay(diffSeconds);
	}	
}