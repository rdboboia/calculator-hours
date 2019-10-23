package rdboboia.calculator.hours;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalTime;

import org.junit.jupiter.api.Test;

class HoursDifferenceCalculatorTest {
	
	@Test
	public void getHourDiffNullParamsTest() {
		assertThrows(NullPointerException.class, () -> HoursDifferenceCalculator.getHourDiff(null, null));
	}
	
	@Test
	public void getHourDiffStartHourTest() {
		assertThrows(NullPointerException.class, () -> HoursDifferenceCalculator.getHourDiff(null, LocalTime.now()));
	}
	
	@Test
	public void getHourDiffNullEndHourTest() {
		assertThrows(NullPointerException.class, () -> HoursDifferenceCalculator.getHourDiff(LocalTime.now(), null));
	}
	
	@Test
	public void getHourDiffEarlierStartHourTest() {
		LocalTime time = LocalTime.of(10, 00, 00);
		
		assertEquals(LocalTime.of(01, 00), HoursDifferenceCalculator.getHourDiff(time, time.plusHours(1)));
		assertNotEquals(LocalTime.of(02, 00), HoursDifferenceCalculator.getHourDiff(time, time.plusHours(1)));
	}
	
	@Test
	public void getHourDiffEarlierStartHourOverMidnightTest() {
		LocalTime time = LocalTime.of(23, 30, 00);
		
		assertEquals(LocalTime.of(01, 00), HoursDifferenceCalculator.getHourDiff(time, time.plusHours(1)));
		assertNotEquals(LocalTime.of(02, 00), HoursDifferenceCalculator.getHourDiff(time, time.plusHours(1)));
	}
	
	@Test
	public void getHourDiffLaterStartHourTest() {
		LocalTime time = LocalTime.of(10, 00, 00);
		
		assertEquals(LocalTime.of(19, 00), HoursDifferenceCalculator.getHourDiff(time.plusHours(5), time));
		assertNotEquals(LocalTime.of(02, 00), HoursDifferenceCalculator.getHourDiff(time.plusHours(5), time));
		assertNotEquals(LocalTime.of(05, 00), HoursDifferenceCalculator.getHourDiff(time.plusHours(5), time));
	}
	
	@Test
	public void getHourDiffLaterStartHourOverMidnightTest() {
		LocalTime time = LocalTime.of(23, 30, 00);
		
		assertEquals(LocalTime.of(19, 00), HoursDifferenceCalculator.getHourDiff(time.plusHours(5), time));
		assertNotEquals(LocalTime.of(02, 00), HoursDifferenceCalculator.getHourDiff(time.plusHours(5), time));
		assertNotEquals(LocalTime.of(05, 00), HoursDifferenceCalculator.getHourDiff(time.plusHours(5), time));
	}
}