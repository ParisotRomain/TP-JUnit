package com.adaming.devise;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SommeArgentTest {
	private SommeArgent  m12EUR;
	private SommeArgent  m14EUR;
	private SommeArgent  m14USD;
	private static int i = 0;

	@Before
	public void testInit() {
		//		i++;
		//		System.out.println(i + "e passage AVANT une methode de test");

		m12EUR=  new  SommeArgent(12,  "EUR");
		m14EUR=  new  SommeArgent(14,  "EUR");
		m14USD=  new  SommeArgent(14,  "USD");
	}

	@Test
	public void testAdd() throws UniteDistincteException {
		System.out.println("Test de la fonction add() : ");

		SommeArgent result;

		result = m12EUR.add(m14EUR);
		SommeArgent expected = new SommeArgent(26,  "EUR");

		System.out.println("\t" + m12EUR + " + " + m14EUR + " = " + expected + " ?");

		Assert.assertTrue(expected.equals(result));

	}

	@Test(expected = UniteDistincteException.class)
	public void testAddDistincte() throws UniteDistincteException {
		System.out.println("Test de la fonction add() avec unités distinctes : ");

		SommeArgent result;

		result = m12EUR.add(m14USD);
		SommeArgent expected = new SommeArgent(25,  "EUR"); // 14USD = 12,5087EUR

		System.out.println("\t" + m12EUR + " + " + m14USD + " = " + expected + " ?");

		Assert.assertTrue(expected.equals(result));

	}

	@Test
	public void testEquals() {
		System.out.println("Test de la fonction equals() : ");

		System.out.println("\t" + m12EUR + " = " + null + " ?");
		Assert.assertTrue(!m12EUR.equals(null));
		System.out.println("\t" + m12EUR + " = " + m12EUR + " ?");
		Assert.assertEquals(m12EUR, m12EUR);
		System.out.println("\t" + m12EUR + " = 12 EUR ?");
		Assert.assertEquals(m12EUR, new SommeArgent(12, "EUR"));
		System.out.println("\t" + m12EUR + " != " + m14EUR + " ?");
		Assert.assertTrue(!m12EUR.equals(m14EUR));
		System.out.println("\t" + m14USD + " != " + m14EUR + " ?");
		Assert.assertTrue(!m14USD.equals(m14EUR));
	}

	@After
	public void testFinal() {
		//		System.out.println(i + "e passage APRES une methode de test");
	}
}
