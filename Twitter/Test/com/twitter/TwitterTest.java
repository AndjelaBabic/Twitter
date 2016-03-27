/**
 * 
 */
package com.twitter;

import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.twitter.poruke.TwitterPoruka;

/**
 * @author Andjela
 *
 */
public class TwitterTest {
	Twitter t;
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	t = new Twitter();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	t = null;
	}

	/**
	 * Test method for {@link com.twitter.Twitter#vratiSvePoruke()}.
	 */
	@Test
	public void testVratiSvePoruke() {
		t.unesi("Filip", "Poruka1");
		t.unesi("Nikola", "Poruka2");
		TwitterPoruka tp = new TwitterPoruka();
		tp.setKorisnik("Filip");
		tp.setPoruka("Poruka1");
		TwitterPoruka tp2 = new TwitterPoruka();
		tp2.setKorisnik("Nikola");
		tp2.setPoruka("Poruka2");
		assertEquals(tp.toString(), t.vratiSvePoruke().get(0).toString());
		assertEquals(tp2.toString(), t.vratiSvePoruke().getLast().toString());
	}

	/**
	 * Test method for {@link com.twitter.Twitter#unesi(java.lang.String, java.lang.String)}.
	 */
	@Test
	public void testUnesi() {
		t.unesi("AndjelaBabic", "Probna poruka");
		TwitterPoruka tp = new TwitterPoruka();
		tp.setKorisnik("AndjelaBabic");
		tp.setPoruka("Probna poruka");
		assertEquals(tp.toString(), t.vratiSvePoruke().getLast().toString());
	}
	
	@Test
	public void testUnesiVise() {
		t.unesi("AndjelaBabic", "Probna poruka");
		t.unesi("AndjelaBabic", "Druga poruka");
		TwitterPoruka tp = new TwitterPoruka();
		tp.setKorisnik("AndjelaBabic");
		tp.setPoruka("Probna poruka");
		TwitterPoruka tp2 = new TwitterPoruka();
		tp2.setKorisnik("AndjelaBabic");
		tp2.setPoruka("Druga poruka");
		assertEquals(tp.toString(), t.vratiSvePoruke().getFirst().toString());
		assertEquals(tp2.toString(), t.vratiSvePoruke().getLast().toString());
		
	}

	/**
	 * Test method for {@link com.twitter.Twitter#vratiPoruke(int, java.lang.String)}.
	 */
	@Test
	public void testVratiPoruke() {
		TwitterPoruka[] niz = new TwitterPoruka[2];
		t.unesi("AndjelaBabic", "Lesi zemlja nebo");
		t.unesi("AndjelaBabic", "Neispunjeni san");
		t.unesi("AndjelaBabic", "Klopka nebo lesi");
		niz = t.vratiPoruke(2, "nebo");
		TwitterPoruka[] drugiNiz = {t.vratiSvePoruke().getFirst(), t.vratiSvePoruke().getLast()};
		assertArrayEquals(drugiNiz, niz);
	}
	/**
	 * Ako nema onoga sto zelimo da pronadjemo u listi
	 */
	@Test
	public void testVratiPorukePrazanNiz(){
		TwitterPoruka[] niz = new TwitterPoruka[3];
		t.unesi("AndjelaBabic", "Lesi zemlja nebo");
		t.unesi("AndjelaBabic", "Neispunjeni san");
		t.unesi("AndjelaBabic", "Klopka nebo lesi");
		niz = t.vratiPoruke(3, "P.S.");
		TwitterPoruka[] drugiNiz = new TwitterPoruka[3];
		assertArrayEquals(drugiNiz, niz);
	}
	
	@Test (expected=java.lang.RuntimeException.class)
	public void testVratiPorukeNull() {
		TwitterPoruka[] nove = new TwitterPoruka[56];
		nove = t.vratiPoruke(56, null);
	}
	
	@Test (expected=java.lang.RuntimeException.class)
	public void testVratiPorukePrazanString() {
		TwitterPoruka[] nove = new TwitterPoruka[56];
		nove = t.vratiPoruke(56, "");
	}

}
