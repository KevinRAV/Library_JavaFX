package com.coding.projectlibrary.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TreeView;

public class SoldierController implements Initializable {

    @FXML
    private TreeView<?> treeViewArme;


}

/*
JE VEUX Pouvoir créer une armée composée de généraux et de
soldats
• AFIN DE pouvoir connaitre l’état de mes troupes
• Critères d'acceptation :
Un treeView me permettra de créer à partir de la racine(Armée) un/des général(aux) et à partir d’un général avoir la possibilité de
créer des soldats.
 */
