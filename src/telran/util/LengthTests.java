package telran.util;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LengthTests {

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void testFloat() {
		float a= 3.14f;
		float b = a/3;
		float c = b*3;
		System.out.println("a="+a+"  b="+b+"  c="+c);
		assertEquals(a, c, 0.0001f);
		assertEquals(a, c, Length.getPrecision());
		assertFalse(a==c);
		assertFalse(Float.compare(a,c)==0);
	}
	
	@Test
	void testEqualsObject() {
		//TODO
		Length len1 = new Length(20, LengthUnit.MM);
		Length len2 = new Length(2, LengthUnit.CM);
		assertTrue(len1.equals(len2));
		assertTrue(len2.equals(len1));
		// Done
	}

	@Test
	void testCompareTo() {
		//TODO
		assertEquals(0, new Length(2000, LengthUnit.MM).compareTo(new Length(2, LengthUnit.M)));
		assertTrue(new Length(1980, LengthUnit.MM).compareTo(new Length(2, LengthUnit.M))<0);
		assertTrue(new Length(1980, LengthUnit.MM).compareTo(new Length(196, LengthUnit.CM))>0);
		// Done
	}

	@Test
	void testConvert() {
		//TODO
		assertEquals(new Length(250f, LengthUnit.CM), 
				new Length(2.5f, LengthUnit.M).convert(LengthUnit.CM));
		// Done
	}

	@Test
	void testToString() {
		//TODO
		assertEquals("4.0000FT", new Length(4f, LengthUnit.FT).toString());	
		assertEquals("2.5000M", new Length(2.5f, LengthUnit.M).toString());	
		// Done
	}
	@Test
	void testBetween() {
		//TODO
		assertEquals( new Length(1f, LengthUnit.MM),
		LengthUnit.MM.between(new Length(1f, LengthUnit.CM), new Length(9f, LengthUnit.MM)));
		// Done
	}

}
