package com.coding.projectlibrary;

import javafx.beans.binding.Bindings;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.io.File;
import java.net.URL;
import java.util.Calendar;
import java.util.NoSuchElementException;
import java.util.ResourceBundle;
import javafx.application.HostServices;
import javafx.application.Application;
import javafx.application.HostServices;

public class Controller implements Initializable {

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
    private MenuItem menuQuit;

    @FXML
    private TextField getURL;

    @FXML
    private ImageView imgCover;


    public static ObservableList<Tab> tablist;

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
        menuQuit.setOnAction(e->{
            System.out.println("APPLICATION FERMÉ");
            System.exit(0);
        });
        tabContainer.setOnMouseClicked(e->{
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
                        lblError.setText("INSÉRER UN TRUC");
                    } else{
                        lblError.setText("");
                        tablist = tabContainer.getItems();
                        tablist.add(tabs);
                        tabContainer.setItems(tablist);
                    }
                }catch(Exception error){
                    lblError.setText("REMPLISSEZ LES TRUCS");
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
                containerAll.getChildren().removeAll(containerGauche, containerDroite);
                containerAll.getChildren().addAll(containerGauche, containerDroite);
            });
            containerAll.getChildren().removeAll(containerGauche, containerDroite);
        });

        btnRemove.setOnAction(event ->{
            btnRemove.setOnMouseClicked(e->{
                int getSelectedIndex = tabContainer.getSelectionModel().getSelectedIndex();
                tabContainer.getItems().remove(getSelectedIndex);
            });
        });

        btnUpdate.setOnAction(event->{
            btnUpdate.setOnMouseClicked(e->{
                Tab tab = tabContainer.getSelectionModel().getSelectedItem();
                tab.setTitre(txtTitre.getText());
                tab.setAuteur(txtAuteur.getText());
                tab.setParution(Integer.parseInt(txtParution.getText()));
                tab.setColonne(Integer.parseInt(txtColonne.getText()));
                tab.setRange(Integer.parseInt(txtRange.getText()));
                tab.setResume(txtResume.getText());
                tab.setUrl(getURL.getText());
                tabContainer.refresh();
            });
        });
    }
}

