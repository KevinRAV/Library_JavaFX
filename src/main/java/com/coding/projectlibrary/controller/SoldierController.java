package com.coding.projectlibrary.controller;

import com.coding.projectlibrary.model.armee;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;

import java.net.URL;
import java.util.ResourceBundle;

public class SoldierController implements Initializable {

    @FXML
    private TreeView<String> treeviewTest;

    @FXML
    private TextField valueG;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

            TreeItem<String> Armee = new TreeItem<>("Armée");
            TreeItem<String> General = new TreeItem<>("General");
//            General.setValue(new armee(Integer.parseInt(valueG.getText()));
            treeviewTest.setRoot(Armee);
            TreeItem<String> Soldat = new TreeItem<>("Soldat");
            Armee.getChildren().addAll(General);
            General.getChildren().addAll(Soldat);
    }
}
