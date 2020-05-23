package controllers;

import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import org.apache.commons.collections.map.HashedMap;
import controllers.Parametres.Declarant_Ctrl;
import model.DBHelper;
import model.Utile;
import model.entity.BonVisite;
import model.entity.Dossier;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;
import view.BonVisite_View;
import view.View;
import view.Parametres_View.EntrepriseInfo_View;

public class BonVisite_Ctrl {
	// ------------------- Les variables d'instance et déclarations  -----------------------//
	private BonVisite_View bonVisite_View;
	private View view;
	private int idDossier,IdDeclarant;
	private String sql,sql2;
	private String Transit,NameDeclarant;
	private Dossier dossier;
	private BonVisite bonVisite;
	private BonVisite bon;
	private boolean modifier = false;

	// -------------------------- Le constructeur --------------------------//
	public BonVisite_Ctrl(View view) {
		this.view = view;
		bon = new BonVisite();
		initController();
	}
	// -------------------------- Les methodes --------------------------//
	public void initController() {
		initView();
		bonVisite_View.getReturne().addActionListener(e -> returne());
		bonVisite_View.getFraude().addActionListener(e -> fraude());
		bonVisite_View.getPrint_btn().addActionListener(e -> Print());
		bonVisite_View.getLegale().addActionListener(e -> legale());
		bonVisite_View.getBtnValider().addActionListener(e -> valider());
		bonVisite_View.getNouveauDeclarant().addActionListener(e -> AddDeclarant());
		bonVisite_View.getTable().addMouseListener(RowSelected);
		bonVisite_View.getPrint_btn().setEnabled(false);
	}
	//*************************************************************//

	public void initView() {
		bonVisite_View = new BonVisite_View();
		view.setContentPane(bonVisite_View.getContentPane());
		view.setVisible(true);
	}
	//*************************************************************//
	public void AddDeclarant(){
		new Declarant_Ctrl();
	}
	//*************************************************************//
	public void upDate() {

		if (bon.existes("bon_visite")) {
			bonVisite_View.DisableBtn();
			BonVisite bon2 = new BonVisite(bon.getIdDossier());
			Transit = bon2.getTransit();
			NameDeclarant = bon2.getDeclarant();
			IdDeclarant = bon2.getIdDeclarant();
			bonVisite_View.getTextField_AgantDouane().setText(bon2.getAgentDouane());
			bonVisite_View.getTextField_transit().setText(Transit);
			bonVisite_View.getTxtChoisir().setText(NameDeclarant);
		}
		sql = "SELECT  NoConteneur AS 'N°Conteneur',Fraude AS 'Etat' FROM Dossier_Conteneur where idDossier="
				+ (idDossier);
		Utile.UpdateTable(sql, bonVisite_View.getTable());
		Utile.Table_Non_Edit(bonVisite_View.getTable());
	}

	//*************************************************************//
	private void returne() {
		if (modifier) {
			int result = JOptionPane.showOptionDialog(null, "Voulez-vous annuler les modifications apport\u00E9es ?",
					"", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null,
					new String[] { "oui", "non" }, "default");
			if (result == JOptionPane.OK_OPTION) {
				legale();
				new Dossier_Ctrl(view);
			}

		} else {
			new Dossier_Ctrl(view);
		}
	}
	//*************************************************************//
	MouseAdapter RowSelected = new MouseAdapter() {
		public void mouseClicked(MouseEvent arg0) {
			int ligne = bonVisite_View.getTable().getSelectedRow();
			String code = bonVisite_View.getTable().getModel().getValueAt(ligne, 0).toString();
			String fraude = (bonVisite_View.getTable().getModel().getValueAt(ligne, 1).toString());
			if (!bon.existes("bon_visite")) {
				String LEGALE = "LEGALE";
				String FRAUDE = "FRAUDE";
				if (bonVisite_View.champVide()) {
					JOptionPane.showMessageDialog(null, "VEUILLEZ REMPLIR TOUS LES CHAMPS");
				} else {
					if (fraude.equals(FRAUDE)) {
						sql2 = "update dossier_conteneur set Fraude='" + LEGALE + "' where NoConteneur='" + code + "';";
					} else {
						sql2 = "update dossier_conteneur set Fraude='" + FRAUDE + "' where NoConteneur='" + code + "';";
					}
					try {
						modifier = true;
						DBHelper.setPreparedStatement(DBHelper.getConnect().prepareStatement(sql2));
						DBHelper.getPreparedStatement().execute();
					} catch (SQLException e) {
						e.printStackTrace();
						JOptionPane.showMessageDialog(null, "PROBLEME DE BASE DE DONNEES");
					}
					upDate();
				}
			}
		}
	};
	//*************************************************************//
	public void fraude() {
		if (bonVisite_View.champVide()) {
			JOptionPane.showMessageDialog(null, "VEUILLEZ REMPLIR TOUS LES CHAMPS");
		} else {
			String sql2 = "update dossier_conteneur set Fraude='FRAUDE' where idDossier='" + idDossier + "';";

			try {
				DBHelper.setPreparedStatement(DBHelper.getConnect().prepareStatement(sql2));
				DBHelper.getPreparedStatement().execute();
			} catch (SQLException e) {
				e.printStackTrace();
				JOptionPane.showMessageDialog(null, "PROBLEME DE BASE DE DONNEES");
			}
			upDate();
		}
	}
	//*************************************************************//
	public void legale() {

		if (bonVisite_View.champVide()) {
			JOptionPane.showMessageDialog(null, "VEUILLEZ REMPLIR TOUS LES CHAMPS");
		} else {
			String sql2 = "update dossier_conteneur set Fraude='LEGALE' where idDossier='" + idDossier + "';";
			try {
				DBHelper.setPreparedStatement(DBHelper.getConnect().prepareStatement(sql2));
				DBHelper.getPreparedStatement().execute();
			} catch (SQLException e) {
				e.printStackTrace();
				JOptionPane.showMessageDialog(null, "PROBLEME DE BASE DE DONNEES");
			}
			upDate();
		}
	}
	//*************************************************************//
	public void valider() {
		modifier = false;
		if (bonVisite_View.champVide()) {
			JOptionPane.showMessageDialog(null, "VEUILLEZ REMPLIR TOUS LES CHAMPS");
		} else {

			bonVisite = new BonVisite(idDossier, null, bonVisite_View.getTextField_transit().getText(),
					Utile.getIdFromCombo(bonVisite_View.getTxtChoisir().getText()),
					Utile.getTextFromCombo(bonVisite_View.getTxtChoisir().getText()),
					bonVisite_View.getTextField_AgantDouane().getText());
			bonVisite.inserer("bon_visite");
			if (bonVisite.existes("bon_visite")) {

				bonVisite_View.DisableBtn();
				Transit = bonVisite.getTransit();
				NameDeclarant=bonVisite.getDeclarant();
				IdDeclarant = bonVisite.getIdDeclarant();
			}

		}
	}
	//*************************************************************//
	public void Print() {
		try {

			String report = "Impression/BonVisite.jrxml";
			JasperDesign jd = JRXmlLoader.load(report);
			HashedMap parameters = new HashedMap();
			////// Entete //////////
			 parameters.put("SrcLogo", EntrepriseInfo_View.info.getEntete());
			 parameters.put("RC", EntrepriseInfo_View.info.getRC());
			 parameters.put("NIF", EntrepriseInfo_View.info.getNIF());
			 parameters.put("NIS", EntrepriseInfo_View.info.getNIS());
			 parameters.put("FAX", EntrepriseInfo_View.info.getFAX());
			 parameters.put("MOBILE", EntrepriseInfo_View.info.getMobile());
			 parameters.put("EMAIL", EntrepriseInfo_View.info.getEmail());
			 parameters.put("Adresse", EntrepriseInfo_View.info.getAdresse());
			 parameters.put("Capitale", EntrepriseInfo_View.info.getCapitale());
			/////////////////////////////////////////////////////////////
			parameters.put("Transit", Transit);
			parameters.put("Declarant", NameDeclarant);
			parameters.put("Id_Declarant", IdDeclarant);
			parameters.put("IdDossier", idDossier);

			if(Dossier.isDstr(idDossier))
				parameters.put("DSTR_OT", "DSTR");
			else
				parameters.put("DSTR_OT", "OT");

			JasperReport jr = JasperCompileManager.compileReport(jd);
			@SuppressWarnings("unchecked")
			JasperPrint jp = JasperFillManager.fillReport(jr, parameters, DBHelper.getConnect());

			JasperViewer reportViewer = new JasperViewer(jp, false);
			reportViewer.setTitle("Bon De Visite");
			reportViewer.setIconImage(Toolkit.getDefaultToolkit().getImage(View.class.getResource("/img/icon.png")));
			reportViewer.setVisible(true);
		} catch (Exception e) {

			System.out.print(e.getMessage());
		}
	}

	//*************************************************************//
	// ----------------------- Les getters & setters ------------------------//
	public BonVisite getBon() {
		return bon;
	}

	public void setBon(BonVisite bon) {
		this.bon = bon;
	}

	public BonVisite_View getBonVisite_View() {
		return bonVisite_View;
	}

	public void setBonVisite_View(BonVisite_View bonVisite_View) {
		this.bonVisite_View = bonVisite_View;
	}

	public Dossier getDossier() {
		return dossier;
	}

	public void setDossier(Dossier dossier) {
		this.dossier = dossier;
	}

	public int getIdDossier() {
		return idDossier;
	}

	public void setIdDossier(int idDossier) {
		this.idDossier = idDossier;
	}
}
