package controllers;

import java.awt.Toolkit;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import javax.swing.JOptionPane;
import org.apache.commons.collections.map.HashedMap;
import model.DBHelper;
import model.Utile;
import model.entity.BonVisite;
import model.entity.Dossier;
import model.entity.Facture;
import model.entity.Facture_Designation;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;
import view.Facture_View;
import view.View;
import view.Parametres_View.EntrepriseInfo_View;

public class Facture_Ctrl {
	// ------------------- Les variables d'instance et déclarations  -----------------------//
	private Facture_View facture_View;
	private View view;
	private int IdDossier;
	private Facture facture;
	private Dossier dossier;
	private BonVisite bon_visite;
	// -------------------------- Le constructeur --------------------------//
	public Facture_Ctrl(View view, int IdDosSelcted) {
		this.view = view;
		IdDossier = IdDosSelcted;
		facture = new Facture(IdDossier);
		initController();
		dossier = new Dossier(IdDossier);
		bon_visite = new BonVisite(IdDossier);
	}
	// -------------------------- Les methodes --------------------------//
	public void initController() {
		initView();
		facture_View.getBtnValider().addActionListener(e -> Ajouter_Facture());
		facture_View.getBtnPrint().addActionListener(e -> Print());
		facture_View.getReturne().addActionListener(e -> returne());
	}
	//*************************************************************//
	public void initView() {
		facture_View = new Facture_View();
		view.setContentPane(facture_View.getContentPane());
		view.setVisible(true);
	}
	//*************************************************************//
	public void upDate() {
		if (facture.existes()) {
			facture_View.DisableBtn();
			facture.SetFacture_info(IdDossier);
			facture_View.SetFacture_View_Info(facture);
			facture_View.getTable().setModel(Facture_Designation.RecuperModel(IdDossier));
			Utile.Entete_Table(facture_View.getTable());
			Utile.Centrer_Table(facture_View.getTable());
		}
		facture_View.afficherDossier(dossier, bon_visite);
	}
	//*************************************************************//
	private void Ajouter_Facture() {
		if (!facture_View.champVide()) {
			Facture.Insert_Facture(IdDossier, facture_View.RecupereInfo());
			Facture_Designation.Insert_Facture_Designation(IdDossier, facture_View.getTable());
			Dossier.MettreAjour(IdDossier);
			upDate();
		} else
			JOptionPane.showMessageDialog(null, "Veuillez Remplissez les champs vides");
	}
	//*************************************************************//
	public void Print() {
		try {
			String report = "Impression/Facture.jrxml";
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
			////////////////////////////////////////////////////////////
			parameters.put("Gros", Facture_View.txtGros.getText());
			parameters.put("Article", Facture_View.txtArticle.getText());
			parameters.put("Nb_TC", Facture_View.fieldNbTc.getText());
			parameters.put("TotalHT", Facture_View.field_THT.getText());
			parameters.put("TVA%", Facture_View.field_TTva.getText());
			// parameters.put("Timbre", Facture_View.txtDateDarrive.getText());
			parameters.put("TotalDeb", Facture_View.field_totalDebour.getText());
			parameters.put("NetPayer", Facture_View.field_TTC.getText());
			/////////////////////////////////////////////////////////////
			parameters.put("Ncheque", facture_View.fieldCheque.getText());
			parameters.put("effectue_cheque", facture_View.fieldEffectue.getText());
			/////////////////////////////////////////////////////////////
			parameters.put("SOMME", Facture_View.sommeTXT.getText());
			parameters.put("NoFacture", IdDossier + "_17");
			parameters.put("Type_TC", Utile.getAllTypeTC(IdDossier));
			parameters.put("Num_TC", Utile.getAllNoTC(IdDossier));
			parameters.put("Date_Entree", Facture_View.txtDateDarrive.getText());
			parameters.put("Date_Sortie", dossier.getDate_Fermeture());
			parameters.put("NbJours",
					getDateDiff(dossier.getDate_Arrive(), dossier.getDate_Fermeture(), TimeUnit.DAYS));
			parameters.put("Ndossier", IdDossier);

			JasperReport jr = JasperCompileManager.compileReport(jd);
			@SuppressWarnings("unchecked")
			JasperPrint jp = JasperFillManager.fillReport(jr, parameters, DBHelper.getConnect());

			JasperViewer reportViewer = new JasperViewer(jp, false);
			reportViewer.setTitle("Facture");
			reportViewer.setIconImage(Toolkit.getDefaultToolkit().getImage(View.class.getResource("/img/icon.png")));
			reportViewer.setVisible(true);
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
	}
	//*************************************************************//
	public static long getDateDiff(Date date1, Date date2, TimeUnit timeUnit) {
		long diffInMillies = date2.getTime() - date1.getTime();
		return timeUnit.convert(diffInMillies, TimeUnit.MILLISECONDS);
	}
	//*************************************************************//
	private void returne() {
		new Dossier_Ctrl(view);
	}
}
