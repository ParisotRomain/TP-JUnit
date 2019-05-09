package com.adaming.devise;

import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;


public class PorteMonnaieTest {
	private SommeArgent  m5EUR;
	private SommeArgent  m10EUR;
	private SommeArgent  m5USD;
	
	private PorteMonnaie pm5EUR;
	private PorteMonnaie pm10EUR;
	private PorteMonnaie pm5EUR5USD;

	@Before
	public void testInit() {
		m5EUR=  new  SommeArgent(5,  "EUR");
		m10EUR=  new  SommeArgent(10,  "EUR");
		m5USD=  new  SommeArgent(5,  "USD");
		
		pm5EUR = new PorteMonnaie();
		pm5EUR.ajouteSomme(m5EUR);
		pm10EUR =  new PorteMonnaie();
		pm10EUR.ajouteSomme(m10EUR);
		pm5EUR5USD = new PorteMonnaie();
		pm5EUR5USD.ajouteSomme(m5EUR);
		pm5EUR5USD.ajouteSomme(m5USD);
	}
	
	@Test
	public void testAjouteSomme() {
		System.out.println("Test de la fonction ajouteSomme() : ");
		System.out.println("\t" + pm5EUR + " + " + m5EUR + " = " + pm10EUR + " ?");

		pm5EUR.ajouteSomme(m5EUR);
		Assert.assertTrue(pm10EUR.equals(pm5EUR));
	}
	
	@Test
	public void testAjouteSommeDistincte() {
		System.out.println("Test de la fonction ajouteSomme() avec des unités distinctes : ");
		System.out.println("\t" + pm5EUR + " + " + m5USD + " = " + pm5EUR5USD + " ?");
		
		pm5EUR.ajouteSomme(m5USD);
		Assert.assertTrue(pm5EUR.equals(pm5EUR5USD));
	}

}
