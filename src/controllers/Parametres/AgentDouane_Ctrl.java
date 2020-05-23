package controllers.Parametres;

import model.entity.Agent_Douane;
import model.entity.ExisteOrNot_Exception;
import model.Utile;
import view.Parametres_View.AgentDouane_View;
import view.Parametres_View.ChampVide_Exception;
import view.Parametres_View.NoLettersOrNoDigital_Exception;
import view.Parametres_View.OverInderSize_Exception;
import view.Parametres_View.SelectedRow_Exception;

public class AgentDouane_Ctrl implements Parametre_Ctrl{

	// ********************* Les variables d'instance *********************//

	private Agent_Douane agent;
	private AgentDouane_View agent_View;

	// ************************** Le constructeur *************************//

	public AgentDouane_Ctrl() {

		initView();
		Utile.UpdateTable("select Nom_Agent as Nom, Prenom_Agent as Prenom, Phone_Agent as Mobile from Agent_Douane order by Nom_Agent , Prenom_Agent",
				agent_View.getTable());
		agent_View.getBtn_Ajouter().addActionListener(e -> Ajouter());
		agent_View.getBtn_Supprimer().addActionListener(e -> Supprimer());
		agent_View.getBtn_Modifier().addActionListener(e -> Modifier());
	}
	// *********************** Les methodes ***************************//

	// Role: initialise la fenètre du paramètre de agent

	public void initView() {
		agent_View = new AgentDouane_View();
	}

	public void Ajouter() {
		try {
			agent_View.Test();
			agent = agent_View.getInformations();
			agent.Ajouter();
			Utile.UpdateTable("select Nom_Agent as Nom, Prenom_Agent as Prenom, Phone_Agent as Mobile from Agent_Douane order by Nom_Agent , Prenom_Agent",
					agent_View.getTable());
			agent_View.setChampsVides();
		} catch (ChampVide_Exception e) {
		} catch (OverInderSize_Exception e3) {
		} catch (NoLettersOrNoDigital_Exception e4) {
		} catch (ExisteOrNot_Exception e1) {
		}/* finally {
			db.updateTable("select Nom_Declarante as Nom, Prenom_Declarante as Prenom, Phone_Declarante as Mobile from Agent_Douane order by Nom_Declarante , Prenom_Declarante",
					agent_View.getTable());
			agent_View.setChampsVides();
		}*/
	}

	public void Supprimer() {
		try {
			agent_View.Test();
			agent = agent_View.getInformations();
			agent.Supprimer();
			Utile.UpdateTable("select Nom_Agent as Nom, Prenom_Agent as Prenom, Phone_Agent as Mobile from Agent_Douane order by Nom_Agent , Prenom_Agent",
					agent_View.getTable());
			agent_View.setChampsVides();
		} catch (ChampVide_Exception e) {
		} catch (OverInderSize_Exception e3) {
		} catch (NoLettersOrNoDigital_Exception e4) {
		} catch (ExisteOrNot_Exception e1) {
		} /*finally {
			db.updateTable("select Nom_Declarante as Nom, Prenom_Declarante as Prenom, Phone_Declarante as Mobile from Agent_Douane order by Nom_Declarante , Prenom_Declarante",
					agent_View.getTable());
			agent_View.setChampsVides();
		}*/
	}

	public void Modifier() {
		try {
			agent_View.Test();
			agent = agent_View.RowToObject();
			agent.Modifier(agent_View.getInformations());
			Utile.UpdateTable("select Nom_Agent as Nom, Prenom_Agent as Prenom, Phone_Agent as Mobile from Agent_Douane order by Nom_Agent , Prenom_Agent ",
					agent_View.getTable());
			agent_View.setChampsVides();
		} catch (ChampVide_Exception e) {
		} catch (OverInderSize_Exception e3) {
		} catch (NoLettersOrNoDigital_Exception e4) {
		} catch (ExisteOrNot_Exception e1) {
		} catch (SelectedRow_Exception e2) {
		} /*finally {
			db.updateTable("select Nom_Declarante as Nom, Prenom_Declarante as Prenom, Phone_Declarante as Mobile from Agent_Douane order by Nom_Declarante , Prenom_Declarante ",
					agent_View.getTable());
		}*/
	}

}
