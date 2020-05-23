package model.table;

public class Dos_Cont_Model {

	private String Marque;
	private String NumConteneur;
	private String NoPlomb;
	private String TypeConteneur;
	private String TypeMarchandise;
	private String Poids;
	private String Valeur;

	public Dos_Cont_Model(String marque,String numConteneur,String noPlomb, String typeConteneur, String typeMarchandise
			, String poids, String valeur) {
		Marque = marque;
		NumConteneur = numConteneur;
		NoPlomb = noPlomb;
		TypeConteneur = typeConteneur;
		TypeMarchandise = typeMarchandise;
		Poids = poids;
		Valeur = valeur;
	}


	public String getNumConteneur() {
		return NumConteneur;
	}

	public void setNumConteneur(String numConteneur) {
		NumConteneur = numConteneur;
	}

	public String getTypeConteneur() {
		return TypeConteneur;
	}

	public void setTypeConteneur(String typeConteneur) {
		TypeConteneur = typeConteneur;
	}

	public String getTypeMarchandise() {
		return TypeMarchandise;
	}

	public void setTypeMarchandise(String typeMarchandise) {
		TypeMarchandise = typeMarchandise;
	}

	public String getMarque() {
		return Marque;
	}

	public String getNoPlomb() {
		return NoPlomb;
	}

	public String getPoids() {
		return Poids;
	}

	public String getValeur() {
		return Valeur;
	}

}
