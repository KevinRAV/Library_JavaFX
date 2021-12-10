package com.coding.projectlibrary.controller;

import com.coding.projectlibrary.model.Tab;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import java.net.URL;
import java.util.Calendar;
import java.util.ResourceBundle;

/**
 * The type Library controller.
 */
public class LibraryController implements Initializable {

    @FXML
    private Button btnAjout;

    @FXML
    private Button btnRemove;

    @FXML
    private Button btnUpdate;

    @FXML
    private Button btnValidez;

    @FXML
    private TableColumn<Tab, String> colAuteur;

    @FXML
    private TableColumn<Tab, Integer> colColonne;

    @FXML
    private TableColumn<Tab, String> colName;

    @FXML
    private TableColumn<Tab, Integer> colParution;

    @FXML
    private TableColumn<Tab, Integer> colRange;

    @FXML
    private TableColumn<Tab, String> colResume;

    @FXML
    private TableView<Tab> tabContainer;

    @FXML
    private TableColumn<Tab, String> imgUrl;

    @FXML
    private TextField txtAuteur;

    @FXML
    private TextField txtColonne;

    @FXML
    private TextField txtParution;

    @FXML
    private TextField txtRange;

    @FXML
    private TextArea txtResume;

    @FXML
    private TextField txtTitre;

    @FXML
    private HBox containerAll;

    @FXML
    private VBox containerDroite;

    @FXML
    private VBox containerGauche;

    @FXML
    private Label lblError;

    @FXML
    private TextField getURL;

    @FXML
    private ImageView imgCover;

    /**
     * The Tablist.
     */
    public static ObservableList<Tab> tablist;

    // Initialization du tableau
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        containerAll.getChildren().removeAll(containerGauche, containerDroite);
        colName.setCellValueFactory(new PropertyValueFactory<Tab, String>("titre"));
        colAuteur.setCellValueFactory(new PropertyValueFactory<Tab, String>("auteur"));
        colParution.setCellValueFactory(new PropertyValueFactory<Tab, Integer>("parution"));
        colColonne.setCellValueFactory(new PropertyValueFactory<Tab, Integer>("colonne"));
        colRange.setCellValueFactory(new PropertyValueFactory<Tab, Integer>("range"));
        colResume.setCellValueFactory(new PropertyValueFactory<Tab, String>("resume"));
        imgUrl.setCellValueFactory(new PropertyValueFactory<Tab, String>("url"));

        tabContainer.setOnMouseClicked(e->{
            //Récupère les informations d'un livre depuis une ligne
            try{
                Tab tab = tabContainer.getSelectionModel().getSelectedItem();
                txtTitre.setText(tab.getTitre());
                txtAuteur.setText(tab.getAuteur());
                txtParution.setText(String.valueOf(tab.getParution()));
                txtColonne.setText(String.valueOf(tab.getColonne()));
                txtRange.setText(String.valueOf(tab.getRange()));
                txtResume.setText(tab.getResume());
                getURL.setText(tab.getUrl());
            }catch(Exception errors){
                System.out.println("ERROR TABVIEW");
            }
        });

        btnValidez.setOnAction(event ->{
            btnValidez.setOnMouseClicked(e->{
                //Récupère les informations entrées par l'utilisateur
                try{
                    Tab tabs = new Tab(txtTitre.getText(), txtAuteur.getText(), Integer.parseInt(txtParution.getText()),
                            Integer.parseInt(txtColonne.getText()), Integer.parseInt(txtRange.getText()), txtResume.getText(), getURL.getText());
                    String getTitre = txtTitre.getText();
                    String getAuteur = txtAuteur.getText();
                    int getParution = Integer.parseInt(txtParution.getText());
                    int getColonne = Integer.parseInt(txtColonne.getText());
                    int getRange = Integer.parseInt(txtRange.getText());
                    String getResume = txtResume.getText();
                    int year = Calendar.getInstance().get(Calendar.YEAR);

                // Gestion d'erreures
                    if(getTitre.trim().isEmpty()){
                        lblError.setText("VEUILLEZ INSÉRER UN TITRE");
                    }else if(getAuteur.trim().isEmpty()){
                        lblError.setText("VEUILLEZ INSÉRER UN AUTEUR");
                    } else if(getRange < 1 || getRange > 7 ) {
                        lblError.setText("INSÉRER UNE RANGÉE VALIDE");
                    }else if(getColonne < 1 || getColonne > 5 ){
                        lblError.setText("INSÉRER UNE COLONNE VALIDE");
                    }else if(getParution > year ){
                        lblError.setText("MET UNE DATE VALIDE");
                    }else if(getResume.trim().isEmpty()){
                        lblError.setText("RÉSUMÉ MANQUANTE");
                    } else{
                        lblError.setText("");
                        tablist = tabContainer.getItems();
                        tablist.add(tabs);
                        tabContainer.setItems(tablist);
                    }
                }catch(Exception error){
                    lblError.setText("INFORMATION MANQUANTE");
                }
                try{
                    Image image = new Image(getURL.getText());
                    imgCover.setImage(image);
                }catch (Exception img){
                    System.out.println("error img");
                }
            });
        });

        btnAjout.setOnAction(event ->{
            btnAjout.setOnMouseClicked(e->{
                //Permet d'afficher le formulaire
                containerAll.getChildren().removeAll(containerGauche, containerDroite);
                containerAll.getChildren().addAll(containerGauche, containerDroite);
            });
            containerAll.getChildren().removeAll(containerGauche, containerDroite);
        });

        btnRemove.setOnAction(event ->{
            //Efface un livre sélectionné dans le tableau
            btnRemove.setOnMouseClicked(e->{
                int getSelectedIndex = tabContainer.getSelectionModel().getSelectedIndex();
                tabContainer.getItems().remove(getSelectedIndex);
            });
        });

        btnUpdate.setOnAction(event->{
            btnUpdate.setOnMouseClicked(e->{
                //Récupère un livre selectionné dans le tableau et permet à l'utilisateur de le modifier
                Tab tab = tabContainer.getSelectionModel().getSelectedItem();
                try{
                    String getTitre = txtTitre.getText();
                    String getAuteur = txtAuteur.getText();
                    int getParution = Integer.parseInt(txtParution.getText());
                    int getColonne = Integer.parseInt(txtColonne.getText());
                    int getRange = Integer.parseInt(txtRange.getText());
                    String getResume = txtResume.getText();
                    int year = Calendar.getInstance().get(Calendar.YEAR);

                    if(getTitre.trim().isEmpty()){
                        lblError.setText("VEUILLEZ INSÉRER UN TITRE");
                    }else if(getAuteur.trim().isEmpty()){
                        lblError.setText("VEUILLEZ INSÉRER UN AUTEUR");
                    } else if(getRange < 1 || getRange > 7 ) {
                        lblError.setText("INSÉRER UNE RANGÉE VALIDE");
                    }else if(getColonne < 1 || getColonne > 5 ){
                        lblError.setText("INSÉRER UNE COLONNE VALIDE");
                    }else if(getParution > year ){
                        lblError.setText("MET UNE DATE VALIDE");
                    }else if(getResume.trim().isEmpty()) {
                        lblError.setText("RÉSUMÉ MANQUANTE");
                    }else {
                        lblError.setText("");
                        tab.setTitre(txtTitre.getText());
                        tab.setAuteur(txtAuteur.getText());
                        tab.setParution(Integer.parseInt(txtParution.getText()));
                        tab.setColonne(Integer.parseInt(txtColonne.getText()));
                        tab.setRange(Integer.parseInt(txtRange.getText()));
                        tab.setResume(txtResume.getText());
                        tab.setUrl(getURL.getText());
                    }
                }catch(Exception error){
                    lblError.setText("INFORMATION MANQUANTE");
                }
                tabContainer.refresh();
            });
        });
    }
}

