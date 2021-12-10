package com.coding.projectlibrary.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TreeView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * The type Main controller.
 */
public class MainController implements Initializable {

    @FXML
    private Button btnImc;

    @FXML
    private Button btnLibrary;

    @FXML
    private Button btnSoldier;

    @FXML
    private Button btnConverter;

    @FXML
    private VBox mainPage;

    @FXML
    private AnchorPane library;

    @FXML
    private AnchorPane imc;

    @FXML
    private AnchorPane converter;

    @FXML
    private MenuItem menuQuit;

    @FXML
    private AnchorPane soldier;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try{
            // Page principale incluant toutes les fonctionnalitées
            mainPage.getChildren().removeAll(library, imc, converter, soldier);

            // Option quitter dans la page principale
            menuQuit.setOnAction(e->{
                System.out.println("APPLICATION FERMÉ");
                System.exit(0);
            });

            // Cache les pages precedente en fonction de la page actuelle
            btnLibrary.setOnMouseClicked(e -> {
                mainPage.getChildren().removeAll(imc, converter, soldier);
                mainPage.getChildren().add(library);
            });

            btnImc.setOnMouseClicked(e -> {
                mainPage.getChildren().removeAll(library, converter, soldier);
                mainPage.getChildren().add(imc);
            });

            btnSoldier.setOnMouseClicked(e -> {
                mainPage.getChildren().removeAll(library, converter, imc);
                mainPage.getChildren().add(soldier);
            });

            btnConverter.setOnMouseClicked(e -> {
                mainPage.getChildren().removeAll(library,imc, soldier);
                mainPage.getChildren().add(converter);
            });
        }catch (Exception e){
            System.out.println("error");
        }
    }
}


