package com.coding.projectlibrary.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.ResourceBundle;

public class ConverterController implements Initializable {

    @FXML
    private Label binaire;

    @FXML
    private Label binaire1;

    @FXML
    private Button btnConvertir;

    @FXML
    private Button btnConvertir1;

    @FXML
    private HBox containerAll;

    @FXML
    private AnchorPane converter;

    @FXML
    private TextField decimal;

    @FXML
    private TextField decimal2;

    @FXML
    private TextField valeurBinaire;

    @FXML
    private TextField valeurBinaire2;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        // Convertir d'un nombre decimal à un nombre binaire
        btnConvertir.setOnMouseClicked(e -> {
            int decimalInput = Integer.parseInt(decimal.getText());
            String binaryInput = Integer.toBinaryString(decimalInput);
            valeurBinaire.setText(String.valueOf(binaryInput));

//            int binary[] = new int[40];
//            int index = 0;
//            int decimal = 0;
//            while(decimalInput > 0){
//                binary[index++] = decimalInput%2;
//                decimalInput = decimalInput/2;
//            }
//            for(int i = index-1;i >= 0;i--){
//                valeurBinaire.setText(String.valueOf(binary[i]));
//            }
//            System.out.println();//new line
        });

        //Convertir un nombre binaire en un nombre decimal

//        btnConvertir.setOnMouseClicked(e -> {
//
//            int binaireInput = Integer.parseInt(valeurBinaire.getText());
//            int decimalInput = Integer.parseInt(decimal.getText());
//
//            if(binaireInput <= 0)
//            {
//                decimal.setText(String.valueOf(""));
//            }
//            else
//            {
//                if  (binaireInput%2 != 0) //see if the remainder is odd or even ie. 1 or 0
//                {
//                    decimal.setText(String.valueOf((binaireInput/2) + '1')); // if the remainder is 1 then send back through and add 1 to the String
//                }
//                else
//                {
//                    decimal.setText(String.valueOf((binaireInput/2) + '0')); // if the remainder is 0 append a zero to the String
//                }
//            }

















    }
}