import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class NumberToOrdinalTest {
	private NumberToOrdinal numberToOrdinal;
	@Before
	public  void setUpBeforeClass() throws Exception {
		 this.numberToOrdinal = new NumberToOrdinal();
	}
	@Test
	public void testgetNumberToOrdinal() throws Exception{
		assertEquals("0th", numberToOrdinal.getNumberToOrdinal(-1));
		assertEquals("12th", numberToOrdinal.getNumberToOrdinal(12));
				assertEquals("13th", numberToOrdinal.getNumberToOrdinal(13));
						assertEquals("11th", numberToOrdinal.getNumberToOrdinal(11));
		assertEquals("0th", numberToOrdinal.getNumberToOrdinal(0));
		assertEquals("-20th", numberToOrdinal.getNumberToOrdinal(-20));
		assertEquals("3rd",numberToOrdinal.getNumberToOrdinal(3));
		assertEquals("50020131st",numberToOrdinal.getNumberToOrdinal(50020131));
    	assertEquals("5020132nd",numberToOrdinal.getNumberToOrdinal(5020132));
    	assertEquals("500000210th",numberToOrdinal.getNumberToOrdinal(500000210));
    	assertEquals("21st", numberToOrdinal.getNumberToOrdinal(new Integer("21")));
	}
	
	@Test(expected=NumberFormatException.class)
	public void testgetNumberToOrdinalFail() throws Exception{
		 numberToOrdinal.getNumberToOrdinal(new Integer("21a1"));
	     numberToOrdinal.getNumberToOrdinal(new Integer(""));
	}
}
