package telran.time.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import telran.time.DayOfWeek;

public class DayOfWeekTests {
	private static final String YOM_RISHON =  "éåí øàùåï";
	private static final String SHABBAT = "ùáú";
	private static final String OTHER_YOM = "other";
	
	String getHebrewDayOfWeek(DayOfWeek weekDay) {
		switch(weekDay) {
		case SUN: return YOM_RISHON;
		case SHABBAT: return SHABBAT;
		default: return OTHER_YOM;
		}
	}

	@Test
	void hebrewDayTest() {
		assertEquals(YOM_RISHON, getHebrewDayOfWeek(DayOfWeek.SUN));
		assertEquals(SHABBAT, getHebrewDayOfWeek(DayOfWeek.SHABBAT));
	}
	@Test
	void calueOfTest() {
		assertEquals("FRI", DayOfWeek.FRI.toString());
	}
	@Test
	void valueOfTest() {
		assertEquals(DayOfWeek.SHABBAT, DayOfWeek.valueOf(SHABBAT));
	}
	@Test
	void compareToTest() {
		assertTrue(DayOfWeek.SHABBAT.compareTo(DayOfWeek.SUN) > 0);
	}
	@Test
	void pluseDaysTest() {
		assertEquals(DayOfWeek.SHABBAT, DayOfWeek.THU.pluseDays(2));
		assertEquals(DayOfWeek.THU, DayOfWeek.THU.pluseDays(7));
		assertEquals(DayOfWeek.SHABBAT, DayOfWeek.THU.pluseDays(1003));
	}
	@Test
	void betweenTest() {
		assertEquals(2, DayOfWeek.between(DayOfWeek.THU, DayOfWeek.SHABBAT));
		assertEquals(6, DayOfWeek.between(DayOfWeek.THU, DayOfWeek.WED));
		assertEquals(7, DayOfWeek.between(DayOfWeek.SHABBAT, DayOfWeek.SHABBAT));
	}

}
