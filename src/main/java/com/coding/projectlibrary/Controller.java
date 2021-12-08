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
import java.util.NoSuchElementException;
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
//La colonne min est 1 et la max 5
        int getRange = Integer.parseInt(txtRange.getText());
        int getColonne = Integer.parseInt(txtColonne.getText());

        if(getRange < 1 || getRange > 7 || getColonne < 1 || getColonne > 5) {
            System.out.println("error Range et Colonne");
        }else{
            tablist = tabContainer.getItems();
            tablist.add(tabs);
            tabContainer.setItems(tablist);
        }
    }

    public void ajoutTab() {
        btnAjout.setOnMouseClicked(action->{
            containerAll.getChildren().removeAll(containerGauche, containerDroite);
            containerAll.getChildren().addAll(containerGauche, containerDroite);
        });
    }

    public void removeTab() {
        int getSelectedIndex = tabContainer.getSelectionModel().getSelectedIndex();
        tabContainer.getItems().remove(getSelectedIndex);
    }

    public void updateTab(){
        int getSelectedIndex = tabContainer.getSelectionModel().getSelectedIndex();
        tabContainer.getItems().remove(getSelectedIndex);
        Tab tabs = new Tab(txtTitre.getText(), txtAuteur.getText(), Integer.parseInt(txtParution.getText()), Integer.parseInt(txtColonne.getText()), Integer.parseInt(txtRange.getText()), txtResume.getText());
        tablist = tabContainer.getItems();
        tablist.add(getSelectedIndex, tabs);
        tabContainer.setItems(tablist);
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
        //tabContainer.setEditable(true);
        colName.setCellValueFactory(new PropertyValueFactory<Tab, String>("titre"));
        colAuteur.setCellValueFactory(new PropertyValueFactory<Tab, String>("auteur"));
        colParution.setCellValueFactory(new PropertyValueFactory<Tab, Integer>("parution"));
        colColonne.setCellValueFactory(new PropertyValueFactory<Tab, Integer>("colonne"));
        colRange.setCellValueFactory(new PropertyValueFactory<Tab, Integer>("range"));
        colResume.setCellValueFactory(new PropertyValueFactory<Tab, String>("resume"));
    }
}
