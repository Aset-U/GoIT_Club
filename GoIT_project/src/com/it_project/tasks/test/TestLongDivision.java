package com.it_project.tasks.test;
import com.it_project.tasks.task3.Divider;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestLongDivision {
	
	@Test
	public void testGetLongDivision(){
		Divider divider = new Divider();
		
		String number1 = "477";
		String number2 = "8";
		
		String expected = "  477 | 8" +
				  "\n" +  "      |--------- " +
				  "\n" +  " -40  | 59.625" +
				  "\n" +  " ----" +
				  "\n" +  "  77" +
				  "\n" +  " -72" +
				  "\n" +  " ---- " +
				  "\n" +  "   50" +
				  "\n" +  "  -48" +
				  "\n" +  "  ---- " + 
				  "\n" +  "    20" + 
				  "\n" +  "   -16" +
				  "\n" +  "   ---- " + 
				  "\n" +  "     40" + 
				  "\n" +  "    -40" +
				  "\n" +  "    ---- " + 
				  "\n" +  "      0";
		
		String actual = divider.getLongDivision(number1, number2);
		assertEquals(expected, actual);
	}
	
	@Test (expected = IndexOutOfBoundsException.class)
	public void testDivisorForIndexOutOfBoundsException(){
		Divider divider = new Divider();	
		String number1 = "1";
		String number2 = "1000000";
		String actual = divider.getLongDivision(number1, number2);
		fail("test for IndexOutOfBoundsException");
	
			
	}
	
	@Test (expected = ArrayIndexOutOfBoundsException.class)
	public void testDivisorForArrayIndexOutOfBoundsException(){
		Divider divider = new Divider();	
		String number1 = "1";
		String number2 = "111111111";
		String actual = divider.getLongDivision(number1, number2);
		fail("test for ArrayIndexOutOfBoundsException");
	}
}
