/**
 * Created by marks on 22/05/2016.
 */
import org.junit.*;
import static org.junit.Assert.*;

public class DateDiffTest {

    @Test
    public void testDateParser()
    {
        int dateTriplet [] = DateDiff.parseDate("01/02/2003");
        assertEquals(dateTriplet[0], 1);
        assertEquals(dateTriplet[1], 2);
        assertEquals(dateTriplet[2], 2003);

    }
    @Test
    public void testIsLeapYear2000()
    {
        assertTrue(DateDiff.isLeapYear(2000));

    }
    @Test
    public void testIsLeapYear2004()
    {
        assertTrue(DateDiff.isLeapYear(2004));
    }
    @Test
    public void testIsLeapYear1900()
    {
        assertEquals(false,DateDiff.isLeapYear(1900));
    }
    @Test
    public void testIsLeapYear1977()
    {
        assertEquals(false,DateDiff.isLeapYear(1977));
    }

    @Test
    public void testBasicDate()
    {
        assertEquals(1, DateDiff.getDaysBetween("01/02/2003", "02/02/2003"));
    }

    @Test
    public void testMonthDate()
    {
        assertEquals(1, DateDiff.getDaysBetween("31/01/2003", "01/02/2003"));

    }
    @Test
    public void testWithinYearDate()
    {
        assertEquals(106, DateDiff.getDaysBetween("01/03/2003", "15/06/2003"));

    }
    @Test
    public void testLeapyear()
    {
        assertEquals(38, DateDiff.getDaysBetween("01/02/2016", "10/03/2016"));

    }

    @Test
    public void testAcrossYears()
    {
        assertEquals(403, DateDiff.getDaysBetween("01/02/2015", "10/03/2016"));

    }

    @Test
    public void testBigGap()
    {
        assertEquals(42406, DateDiff.getDaysBetween("01/02/1900", "10/03/2016"));

    }

}



