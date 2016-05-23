/**
 * Created by marks on 22/05/2016.
 */
import org.junit.*;
import static org.junit.Assert.*;
import com.company.*;

public class DateDiffTest {

    @Test
    public void testDateParser() {
        DateTriple triple = DateDiff.parseDate("01/02/2003");
        assertEquals(triple.day, 1);
        assertEquals(triple.month, 2);
        assertEquals(triple.year, 2003);

    }

    @Test
    public void testIsLeapYear2000() {
        assertTrue(DateDiff.isLeapYear(2000));

    }

    @Test
    public void testIsLeapYear2004() {
        assertTrue(DateDiff.isLeapYear(2004));
    }

    @Test
    public void testIsLeapYear1900() {
        assertEquals(false, DateDiff.isLeapYear(1900));
    }

    @Test
    public void testIsLeapYear1977() {
        assertEquals(false, DateDiff.isLeapYear(1977));
    }

    @Test
    public void testBasicDate() {
        assertEquals(1, DateDiff.getDaysBetween("01/02/2003", "02/02/2003"));
    }

    @Test
    public void testMonthDate() {
        assertEquals(1, DateDiff.getDaysBetween("31/01/2003", "01/02/2003"));

    }

    @Test
    public void testWithinYearDate() {
        assertEquals(106, DateDiff.getDaysBetween("01/03/2003", "15/06/2003"));

    }

    @Test
    public void testLeapyear() {
        assertEquals(38, DateDiff.getDaysBetween("01/02/2016", "10/03/2016"));

    }

    @Test
    public void testAcrossYears() {
        assertEquals(403, DateDiff.getDaysBetween("01/02/2015", "10/03/2016"));

    }

    @Test
    public void testBigGap() {
        assertEquals(42406, DateDiff.getDaysBetween("01/02/1900", "10/03/2016"));

    }

    @Test
    public void testSameDay() {
        assertEquals(0, DateDiff.getDaysBetween("01/02/2016", "01/02/2016"));

    }

    @Test
    public void testCompare() {
        DateTriple start = new DateTriple(1, 2, 2015);
        DateTriple end = new DateTriple(1, 2, 2016);
        assertEquals(1, DateTriple.compare(start, end));
        assertEquals(-1, DateTriple.compare(end, start));
        assertEquals(0, DateTriple.compare(end, end));
    }

    @Test
    public void testSmallerEndYear()
    {
        assertEquals(365, DateDiff.getDaysBetween("01/02/2016", "01/02/2015"));
        assertEquals(1, DateDiff.getDaysBetween("02/02/2016", "01/02/2016"));
    }

    @Test
    public void testShortYear()
    {
        assertEquals(366, DateDiff.getDaysBetween("01/02/16", "01/02/17"));
    }

    @Test
    public void testShortYearMillenial()
    {
        assertEquals(1, DateDiff.getDaysBetween("31/12/99", "01/01/00"));
    }

    @Test
    public void testYearHistorical()
    {
        assertEquals(1, DateDiff.getDaysBetween("31/12/0099", "01/01/0100"));
    }
}