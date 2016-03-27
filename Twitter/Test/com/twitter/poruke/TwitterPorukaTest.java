/**
 * 
 */
package com.twitter.poruke;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Andjela
 *
 */
public class TwitterPorukaTest {
	TwitterPoruka tp;
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		tp = new TwitterPoruka();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		tp = null;
	}
	
	/**
	 * Test method for {@link com.twitter.poruke.TwitterPoruka#setKorisnik(java.lang.String)}.
	 */
	@Test
	public void testSetKorisnik(){
		tp.setKorisnik("Andjela Babic");
		assertEquals("Andjela Babic", tp.getKorisnik());
	}
	
	@Test (expected = java.lang.RuntimeException.class) 
	public void testSetKorisnikNull() {
		tp.setKorisnik(null);
	}
	
	@Test (expected = java.lang.RuntimeException.class) 
	public void testSetKorisnikPrazanString() {
		tp.setKorisnik("");
	}
	/**
	 * Test method for {@link com.twitter.poruke.TwitterPoruka#setPoruka(java.lang.String)}.
	 */
	@Test
	public void testSetPoruka() {
		tp.setPoruka("Fla lala");
		assertEquals("Fla lala", tp.getPoruka());
	}
	
	@Test (expected = java.lang.RuntimeException.class) 
	public void testSetPorukaNull(){
		tp.setPoruka(null);
	}
	
	@Test (expected = java.lang.RuntimeException.class)
	public void testSetPorukaPreko140(){
		String s ="";
		for (int i = 0; i < 10; i++) {
			s += "Old pirates, yes, they rob I";
		}
		tp.setPoruka(s);
	}
	
	/**
	 * Test method for {@link com.twitter.poruke.TwitterPoruka#toString()}.
	 */
	@Test
	public void testToString() {
		tp.setKorisnik("Andjela");
		tp.setPoruka("porukica");
		assertEquals("KORISNIK:Andjela PORUKA:porukica", tp.toString());
	}

}