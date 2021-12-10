package com.coding.projectlibrary.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.ResourceBundle;

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


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        mainPage.getChildren().removeAll(library, imc, converter);

        menuQuit.setOnAction(e->{
            System.out.println("APPLICATION FERMÉ");
            System.exit(0);
        });

        btnLibrary.setOnMouseClicked(e -> {
            mainPage.getChildren().removeAll(imc);
            mainPage.getChildren().removeAll(converter);
            mainPage.getChildren().add(library);
        });

        btnImc.setOnMouseClicked(e -> {
            mainPage.getChildren().removeAll(library);
            mainPage.getChildren().removeAll(converter);
            mainPage.getChildren().add(imc);
        });

        btnImc.setOnMouseClicked(e -> {

                }

        btnConverter.setOnMouseClicked(e -> {
            mainPage.getChildren().removeAll(library);
            mainPage.getChildren().removeAll(imc);
            mainPage.getChildren().add(converter);
        });
    }


}


