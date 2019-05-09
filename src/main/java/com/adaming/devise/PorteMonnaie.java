package com.adaming.devise;

import java.util.HashMap;

public class PorteMonnaie {
	private HashMap<String, Integer> contenu;
	
	public HashMap<String, Integer> getContenu() {
		return contenu;
	}
	
	public PorteMonnaie() {
		contenu = new HashMap<String, Integer>();
	}
	
	public void ajouteSomme(SommeArgent sa) {
		if (contenu.containsKey(sa.getUnite())) {
			contenu.put(sa.getUnite(), contenu.get(sa.getUnite()) + sa.getQuantite());
		} else {
			contenu.put(sa.getUnite(), sa.getQuantite());
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((contenu == null) ? 0 : contenu.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PorteMonnaie other = (PorteMonnaie) obj;
		if (contenu == null) {
			if (other.contenu != null)
				return false;
		} else if (!contenu.equals(other.contenu))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "PorteMonnaie" + contenu;
	}
}
