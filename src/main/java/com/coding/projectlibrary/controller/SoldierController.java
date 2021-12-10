package com.coding.projectlibrary.controller;

import com.coding.projectlibrary.model.armee;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeView;

import java.net.URL;
import java.util.ResourceBundle;

public class SoldierController implements Initializable {

    @FXML
    private TreeView<?> treeviewTest;

    @FXML
    private TextField valueG;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        treeviewTest.setOnMouseClicked(e->{
            valueG.getText();

        });
    }
}
