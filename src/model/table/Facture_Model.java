package model.table;

public class Facture_Model {

	private int Code;
	private String Designation;
	private int VOL_QT;
	private int Nbre;
	private float PrixUnite;
	private float PrixHT;
	private float Debours;
	private String Observation;

	public Facture_Model(int code, String designation, int qte, int nbre, float prixUnite, float prixHT, float debours,
			String observation) {
		Code = code;
		Designation = designation;
		VOL_QT = qte;
		Nbre = nbre;
		PrixUnite = prixUnite;
		PrixHT = prixHT;
		Debours = debours;
		Observation = observation;
	}

	public int getCode() {
		return Code;
	}

	public void setCode(int code) {
		Code = code;
	}

	public String getDesignation() {
		return Designation;
	}

	public void setDesignation(String designation) {
		Designation = designation;
	}

	public int getQte() {
		return VOL_QT;
	}

	public void setQte(int qte) {
		VOL_QT = qte;
	}

	public int getNbre() {
		return Nbre;
	}

	public void setNbre(int nbre) {
		Nbre = nbre;
	}

	public float getPrixUnite() {
		return PrixUnite;
	}

	public void setPrixUnite(float prixUnite) {
		PrixUnite = prixUnite;
	}

	public float getPrixHT() {
		return PrixHT;
	}

	public void setPrixHT(float prixHT) {
		PrixHT = prixHT;
	}

	public float getDebours() {
		return Debours;
	}

	public void setDebours(float debours) {
		Debours = debours;
	}

	public String getObservation() {
		return Observation;
	}

	public void setObservation(String observation) {
		Observation = observation;
	}

}
