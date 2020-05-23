package controllers;

import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import org.apache.commons.collections.map.HashedMap;
import controllers.Parametres.Camion_Ctrl;
import controllers.Parametres.Chauffeur_Ctrl;
import model.DBHelper;
import model.Utile;
import model.entity.BonSortie;
import model.entity.BonVisite;
import model.entity.Dossier;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;
import view.BonSortie_View;
import view.View;
import view.Parametres_View.EntrepriseInfo_View;

public class BonSortie_Ctrl {

	// ------------------- Les variables d'instance et déclarations  -----------------------//
    private BonSortie_View bonSortie_View;
    private View view;
    private int idDossier;
    private String sql;
    private Dossier dossier;
    private BonSortie bonSortie;
	// -------------------------- Le constructeur --------------------------//
    public BonSortie_Ctrl(View view, BonVisite bonVisite) {
        this.view = view;
        bonSortie = new BonSortie();
        bonSortie.setIdDossier(bonVisite.getIdDossier());
        bonSortie.setIdDeclarant(bonVisite.getIdDeclarant());
        bonSortie.setAgentDouane(bonVisite.getAgentDouane());
        bonSortie.setTransit(bonVisite.getTransit());
        bonSortie.setDeclarant(bonVisite.getDeclarant());
        initController();
    }
	// -------------------------- Les methodes --------------------------//
    public void initController() {
        initView();
        bonSortie_View.getReturne().addActionListener(e -> returne());
        bonSortie_View.getPrint_btn().addActionListener(e -> Print());
        bonSortie_View.getBtnValider().addActionListener(e -> valider());
        bonSortie_View.getNouveauchauffeur().addActionListener(e -> new Chauffeur_Ctrl());
        bonSortie_View.getBtnNouveauCamion().addActionListener(e -> new Camion_Ctrl());
        bonSortie_View.getSauvegarder().addActionListener(e -> sauvegarder());
        bonSortie_View.getTable().addMouseListener(RowSelected);
        bonSortie_View.getPrint_btn().setEnabled(false);
        if (bonSortie.existes("bon_sortie")) { bonSortie_View.DisableBtn(); }
    }
	//*************************************************************//
    public void initView() {
        bonSortie_View = new BonSortie_View();
        view.setContentPane(bonSortie_View.getContentPane());
        view.setVisible(true);
    }
	//*************************************************************//
    public void upDate() {
        sql = "SELECT  NoConteneur AS 'N° Conteneur' FROM Dossier_Conteneur where idDossier=" + (idDossier)
                + " && Fraude='LEGALE';";

        Utile.UpdateTable(sql, bonSortie_View.getTable());
        Utile.Table_Non_Edit(bonSortie_View.getTable());
    }
	//*************************************************************//
    MouseAdapter RowSelected = new MouseAdapter() {
        public void mouseClicked(MouseEvent arg0) {

            int ligne = bonSortie_View.getTable().getSelectedRow();
            String code = bonSortie_View.getTable().getModel().getValueAt(ligne, 0).toString();
            bonSortie_View.getTable().setDragEnabled(false);

            String sql2 = "SELECT * FROM dossier_conteneur WHERE NoConteneur=?";
            try {
                DBHelper.setPreparedStatement(DBHelper.getConnect().prepareStatement(sql2));
                DBHelper.getPreparedStatement().setString(1, code);
                DBHelper.setResultSet(DBHelper.getPreparedStatement().executeQuery());
                if ((DBHelper.getResultSet().next())) {

                    int idTypeTc=DBHelper.getResultSet().getInt("idType_Conteneur");
                    int idChauf = DBHelper.getResultSet().getInt("idChauffeur");
                    int idCamion = DBHelper.getResultSet().getInt("idCamion");
                    String typeTc=Utile.GetTypeTCById(idTypeTc);
                    bonSortie_View.getTextFieldNumConteneur().setText(code);
                    bonSortie_View.getTextFieldTypeConteneur().setText(typeTc);
                    String txt;
                    txt = Utile.convertir(idChauf, "idChauffeur", "Nom_Chauffeur", "chauffeur");
                    if (!txt.equals("")) {
                        bonSortie_View.getTextFieldChauffeur().setText(
                                idChauf + " " + Utile.convertir(idChauf, "idChauffeur", "Nom_Chauffeur", "chauffeur"));
                    } else {
                        bonSortie_View.getTextFieldChauffeur().setText(" Choisir ...");
                    }
                    bonSortie_View.getTextFieldNumTel()
                            .setText(Utile.convertir(idChauf, "idChauffeur", "Phone_Chauffeur", "chauffeur"));
                    txt = Utile.convertir(idCamion, "idCamion", "Matricule", "camion");
                    if (!txt.equals("")) {
                        bonSortie_View.getTextFieldCamion()
                                .setText(Utile.convertir(idCamion, "idCamion", "Matricule", "camion"));
                    } else {
                        bonSortie_View.getTextFieldCamion().setText(" Choisir ...");
                    }
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
    };

	//*************************************************************//

    private void returne() {
        new Dossier_Ctrl(view);
    }
	//*************************************************************//
    private void sauvegarder() {
        int idChauffeur = 0;
        int idCamion = 0;
        String code;

        if (bonSortie_View.champVide()) {
            JOptionPane.showMessageDialog(null, "Veuillez remplir tous les champs !");
        } else {
            idChauffeur=Utile.getIdFromCombo(bonSortie_View.getTextFieldChauffeur().getText());
            idCamion = Utile.getIdFromCombo((bonSortie_View.getTextFieldCamion().getText()));
            code = bonSortie_View.getTextFieldNumConteneur().getText();

            String sql4 = "UPDATE dossier_conteneur SET idCamion= " + idCamion + " , idChauffeur= " + idChauffeur
                    + "  WHERE NoConteneur='" + code + "';";
            try {
                DBHelper.setPreparedStatement(DBHelper.getConnect().prepareStatement(sql4));
                DBHelper.getPreparedStatement().execute();
            } catch (SQLException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "PROBLEME DE BASE DE DONNEES");
            }
        }
    }
	//*************************************************************//
    public void Print(){
        try {

            String report = "Impression/BonSortie.jrxml";
            JasperDesign jd = JRXmlLoader.load(report);
            HashedMap parameters = new HashedMap();
             parameters.put("SrcLogo", EntrepriseInfo_View.info.getEntete());
             parameters.put("RC", EntrepriseInfo_View.info.getRC());
             parameters.put("NIF", EntrepriseInfo_View.info.getNIF());
             parameters.put("NIS", EntrepriseInfo_View.info.getNIS());
             parameters.put("FAX", EntrepriseInfo_View.info.getFAX());
             parameters.put("MOBILE", EntrepriseInfo_View.info.getMobile());
             parameters.put("EMAIL", EntrepriseInfo_View.info.getEmail());
             parameters.put("Adresse", EntrepriseInfo_View.info.getAdresse());
             parameters.put("Capitale", EntrepriseInfo_View.info.getCapitale());
            parameters.put("Transit", bonSortie.getTransit());
            parameters.put("Declarant", bonSortie.getDeclarant());
            parameters.put("Id_Declarant",bonSortie.getIdDeclarant());
            parameters.put("IdDossier", idDossier);
            parameters.put("Entreprise", Dossier.GetEntreprise(idDossier));

            JasperReport jr = JasperCompileManager.compileReport(jd);
            @SuppressWarnings("unchecked")
            JasperPrint jp = JasperFillManager.fillReport(jr, parameters, DBHelper.getConnect());

            JasperViewer reportViewer = new JasperViewer(jp, false);
            reportViewer.setTitle("Bon De Sortie");
            reportViewer.setIconImage(Toolkit.getDefaultToolkit().getImage(View.class.getResource("/img/icon.png")));
            reportViewer.setVisible(true);

        } catch (Exception e) {
            System.out.print(e.getMessage());
        }
    }
	//*************************************************************//
    public void valider() {
        if (bonSortie_View.champVide()) {
            JOptionPane.showMessageDialog(null, "VEUILLEZ REMPLIR TOUS LES CHAMPS");
        } else {
            bonSortie.inserer("bon_sortie");
            if (bonSortie.existes("bon_sortie")) {
                bonSortie_View.getSauvegarder().setEnabled(false);
                bonSortie_View.getNouveauchauffeur().setEnabled(false);
                bonSortie_View.getBtnNouveauCamion().setEnabled(false);
                bonSortie_View.getBtnValider().setEnabled(false);
                bonSortie_View.getPrint_btn().setEnabled(true);
                bonSortie_View.getComboBoxCamion().setEnabled(false);
                bonSortie_View.getComboBoxChauffeur().setEnabled(false);
            }
        }
    }
	// ********************* Les getters & setters *********************//

    public BonSortie getBonSortie() {
        return bonSortie;
    }

    public void setBonSortie(BonSortie bonSortie) {
        this.bonSortie = bonSortie;
    }

    public int getIdDossier() {
        return idDossier;
    }

    public void setIdDossier(int idDossier) {
        this.idDossier = idDossier;
    }

    public BonSortie_View getBonSortie_View() {
        return bonSortie_View;
    }

    public void setBonSortie_View(BonSortie_View bonSortie_View) {
        this.bonSortie_View = bonSortie_View;
    }

    public Dossier getDossier() {
        return dossier;
    }

    public void setDossier(Dossier dossier) {
        this.dossier = dossier;
    }
}
