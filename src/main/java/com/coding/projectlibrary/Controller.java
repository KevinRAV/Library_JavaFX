package com.coding.projectlibrary;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.ResourceBundle;

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

    public static ObservableList<Tab> tablist;

    @FXML
    private void handleButtonAction(ActionEvent event) {
        if(event.getSource() == btnAjout){
            ajoutTab();
        }else if(event.getSource() == btnRemove){
            removeTab();
        }else if(event.getSource() == btnUpdate){
            updateTab();
        }else if(event.getSource() == btnValidez){
            validezTab();
        }
    }

    public void validezTab(){
        Tab tabs = new Tab(txtTitre.getText(), txtAuteur.getText(), Integer.parseInt(txtParution.getText()), Integer.parseInt(txtColonne.getText()), Integer.parseInt(txtRange.getText()), txtResume.getText());
        tablist = tabContainer.getItems();
        tablist.add(tabs);
        tabContainer.setItems(tablist);
    }

    public void ajoutTab() {
        btnAjout.setOnMouseClicked(action->{
            containerAll.getChildren().addAll(containerGauche, containerDroite);
        });
    }

//        containerCentral.getChildren().removeAll(formvoiture, formvelo);
//        btnVoiture.setOnMouseClicked(actionVoitureForm -> {
//            containerCentral.getChildren().removeAll(formvoiture, formvelo);
//            containerCentral.getChildren().add(formvoiture);
//        });
//
//        btnVelo.setOnMouseClicked(actionVeloForm -> {
//            containerCentral.getChildren().removeAll(formvoiture, formvelo);
//            containerCentral.getChildren().add(formvelo);
//        });

    public void removeTab() {
        int getSelectedIndex = tabContainer.getSelectionModel().getSelectedIndex();
        tabContainer.getItems().remove(getSelectedIndex);
    }

    public void updateTab(){
        colName.setCellFactory(TextFieldTableCell.forTableColumn());
        colName.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Tab, String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<Tab, String> event) {
                Tab tab = event.getRowValue();
                tab.setTitre(event.getNewValue());
            }
        });

//        tabID.setTitre(txtTitre.getText());
//        tabID.setAuteur(txtAuteur.getText());
//        tabID.setParution(Integer.parseInt(txtParution.getText()));
//        tabID.setColonne(Integer.parseInt(txtColonne.getText()));
//        tabID.setRange(Integer.parseInt(txtRange.getText()));
//        tabID.setResume(txtResume.getText());
//        tabContainer.getItems().add(tabContainer.getSelectionModel().getSelectedIndex(), tabID);
//        tabContainer.getItems().remove(tabContainer.getSelectionModel().getSelectedIndex() - 1);

    }

    @FXML
    private void handleMouseAction(MouseEvent event) {
        Tab tab = tabContainer.getSelectionModel().getSelectedItem();
        txtTitre.setText(tab.getTitre());
        txtAuteur.setText(tab.getAuteur());
        txtParution.setText(String.valueOf(tab.getParution()));
        txtColonne.setText(String.valueOf(tab.getColonne()));
        txtRange.setText(String.valueOf(tab.getRange()));
        txtResume.setText(tab.getResume());
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        containerAll.getChildren().removeAll(containerGauche, containerDroite);
        tabContainer.setEditable(true);
        colName.setCellValueFactory(new PropertyValueFactory<Tab, String>("titre"));
        colAuteur.setCellValueFactory(new PropertyValueFactory<Tab, String>("auteur"));
        colParution.setCellValueFactory(new PropertyValueFactory<Tab, Integer>("parution"));
        colColonne.setCellValueFactory(new PropertyValueFactory<Tab, Integer>("colonne"));
        colRange.setCellValueFactory(new PropertyValueFactory<Tab, Integer>("range"));
        colResume.setCellValueFactory(new PropertyValueFactory<Tab, String>("resume"));
    }
}
