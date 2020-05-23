package model.table;

public class Bon_Visite_Model {

	private String NumConteneur;
	private Boolean Fraude;

	public Bon_Visite_Model(String numConteneur) {
		NumConteneur = numConteneur;
	}

	public String getNumConteneur() {
		return NumConteneur;
	}

	public void setNumConteneur(String numConteneur) {
		NumConteneur = numConteneur;
	}

	public Boolean getFraude() {
		return Fraude;
	}

	public void setFraude(Boolean fraude) {
		Fraude = fraude;
	}

}
