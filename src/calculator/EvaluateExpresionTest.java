
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class EvaluateExpresionTest {
	EvaluateExpresion evaluateExpExpresion;
  
	@Before
	public void setUp() throws Exception {
		evaluateExpExpresion = new EvaluateExpresion();
	}
	@After
	public void tearDown() throws Exception {
		evaluateExpExpresion = null;
	}

	/*@Test(expected=NullPointerException.class)
	public void testevaluateExpxpforNullException() throws Exception {
		evaluateExpExpresion.evaluateExpExp(null);
	}*/
/*	@Test(expected=Exception.class)
	public void testInvalidExpresionException() throws Exception {
		//Invalid  expression there should be space b/w operator b/w operand
		assertEquals(Integer.valueOf("0"), evaluateExpExpresion.evaluateExpExp("(12 * 4) + 2"));
		//Invalid  expression alphabets are not allowed
		evaluateExpExpresion.evaluateExpExp("a + 4 + 7");
		
	}*/	
	@Test
	public void testcalculateExpression() throws Exception {
		//assertEquals(Integer.valueOf("4"),evaluateExpExpresion.calculateExpression('+',4 , 0));
	}

/*	@Test
	public void testevaluateExpxp() throws Exception{
		//Valid expression and expected ouput
		assertEquals(Integer.valueOf("3"),evaluateExpExpresion.evaluateExpExp("( 6 / 2 )"));
		assertEquals(Integer.valueOf("4"), evaluateExpExpresion.evaluateExpExp("( 6 - 2 )"));
		assertEquals(Integer.valueOf("-10"), evaluateExpExpresion.evaluateExpExp(" 2 - 12 "));
		assertEquals(Integer.valueOf("212"), evaluateExpExpresion.evaluateExpExp("100 * 2 + 12"));
		assertEquals(Integer.valueOf("14"), evaluateExpExpresion.evaluateExpExp("( 2 + 12 )"));
		assertEquals(Integer.valueOf("113"), evaluateExpExpresion.evaluateExpExp("( 2 + 12 *9 ) + 24 - 21"));
		assertEquals(Integer.valueOf("2"), evaluateExpExpresion.evaluateExpExp("( 12 / 6 )"));
		assertEquals(Integer.valueOf("-6"), evaluateExpExpresion.evaluateExpExp(" - 6)"));
	}
		*/@Test
	    public void shouldParseNumbers() throws Exception {
	        assertEquals(3, evaluateExpExpresion.evaluateExp("3"), 0);
	    }

	    @Test
	    public void shouldParseFloats() throws Exception {
	   assertEquals(3.5, evaluateExpExpresion.evaluateExp("3.5"), 0);
	    }

	    @Test
	    public void shouldSupportAddition() throws Exception {
	        assertEquals(4, evaluateExpExpresion.evaluateExp("1 3 +"), 0);
	    }

	    @Test
	    public void shouldSupportMultiplication() throws Exception {
	        assertEquals(3, evaluateExpExpresion.evaluateExp("1 3 *"), 0);
	    }

	    @Test
	    public void shouldSupportSubtraction() throws Exception {
	        assertEquals(-2, evaluateExpExpresion.evaluateExp("1 3 -"), 0);
	    }

	    @Test
	    public void shouldSupportDivision() throws Exception {
	        assertEquals(0, evaluateExpExpresion.evaluateExp("1 1 1 * -"), 0);
	    }
	    
	    @Test
	    public void addSupportDivision()  {
	        assertEquals(0, evaluateExpExpresion.calculateExpression('+',4,7), 0);
	    }
}


