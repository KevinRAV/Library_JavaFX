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
import java.util.Arrays;
import java.util.List;
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

    @FXML
    private TextField valDecimal;

    @FXML
    private TextField valDecimal4;

    @FXML
    private TextField romanNum;

    @FXML
    private Label lblRoman;

    @FXML
    private TextField valHexa;

    @FXML
    private Button btnHexa;

    @FXML
    private Button btnRoman;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        btnHexa.setOnMouseClicked(e->{
            int hexaVal = Integer.parseInt(valDecimal.getText());
            String hexa = "";
            char[] hexchars ={'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
            while (hexaVal >0){
                hexa += hexchars[(hexaVal % 16)];
                hexaVal = hexaVal / 16;
                valHexa.setText(hexa);
            }
        });

        // Convertion d'un nombre decimal en une valeur binaire
        btnConvertir.setOnMouseClicked(e -> {
            int decimaltxt = Integer.parseInt(decimal.getText());
            String binaire= "";
            while(decimaltxt != 0){
                binaire = (decimaltxt % 2) + binaire;
                decimaltxt = decimaltxt / 2;
                valeurBinaire.setText(binaire);
            }
        });

//        btnConvertir1.setOnMouseClicked(e->{
//            int binaire = Integer.parseInt(valeurBinaire2.getText());
//
//
//            decimal2.setText();
//        });

//            int decimalInput = Integer.parseInt(decimal.getText());
//            String binaryInput = Integer.toBinaryString(decimalInput);
//            valeurBinaire.setText(String.valueOf(binaryInput));

            

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


        // Convertion d'un nombre decimal en nombre romain
        btnRoman.setOnMouseClicked(e -> {
            int decimal4Input = Integer.parseInt(valDecimal4.getText());
            int[] values = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
            String[] romanLiterals = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
            StringBuilder roman = new StringBuilder();

            for(int i=0;i<values.length;i++) {
                while(decimal4Input >= values[i]) {
                    decimal4Input -= values[i];
                    roman.append(romanLiterals[i]);
                    romanNum.setText(String.valueOf(roman));

                }
            }

        });














    }
}