package view.Parametres_View;

public interface Parametre_View {

	/******************** les méthodes *************************/
	public abstract void setChampsVides();
	public abstract boolean isChampVide();
	public abstract Object getInformations();
	public abstract void Test() throws ChampVide_Exception, OverInderSize_Exception, NoLettersOrNoDigital_Exception;
	public abstract Object RowToObject() throws SelectedRow_Exception;
}
