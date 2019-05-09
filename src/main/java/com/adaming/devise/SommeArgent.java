package com.adaming.devise;

public class SommeArgent {
	private int quantite;
	private String unite;

	public SommeArgent(int amount, String currency) {
		quantite = amount;
		unite = currency;
	}

	public int getQuantite() {
		return quantite;
	}

	public String getUnite() {
		return unite;
	}

	public  SommeArgent  add(SommeArgent  m) throws UniteDistincteException {
		if (!m.getUnite().equals(this.getUnite())) {
			throw new UniteDistincteException(this, m);
		}
		else return new SommeArgent(getQuantite()+m.getQuantite(), getUnite());
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + quantite;
		result = prime * result + ((unite == null) ? 0 : unite.hashCode());
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
		SommeArgent other = (SommeArgent) obj;
		if (quantite != other.quantite)
			return false;
		if (unite == null) {
			if (other.unite != null)
				return false;
		} else if (!unite.equals(other.unite))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return quantite + " " + unite;
	}
}
