package com.coding.projectlibrary.controller;

import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
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


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        mainPage.getChildren().removeAll(library);

        btnLibrary.setOnMouseClicked(e -> {

            mainPage.getChildren().add(library);
        }

        );
        mainPage.getChildren().removeAll(imc);

        btnImc.setOnMouseClicked(e -> {

            mainPage.getChildren().add(imc);
        });
    }


}

