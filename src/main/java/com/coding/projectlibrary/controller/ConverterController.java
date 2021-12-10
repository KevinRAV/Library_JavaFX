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
            while (hexaVal > 0){
                hexa += hexchars[(hexaVal % 16)];
                hexaVal = hexaVal / 16;
                valHexa.setText(hexa);
            }
        });

// Convertir d'un nombre decimal à un nombre binaire
        btnConvertir.setOnMouseClicked(e -> {
            int decimaltxt = Integer.parseInt(decimal.getText());
            String binaire= "";
            while(decimaltxt != 0){
                binaire = (decimaltxt % 2) + binaire;//prend first binaire value
                decimaltxt = decimaltxt / 2;//
                valeurBinaire.setText(binaire);
            }
        });

        btnConvertir1.setOnMouseClicked(e->{
            String binaire2 = valeurBinaire2.getText();
            int total =0;
            for (int i = 0; i < binaire2.length(); i++) {
                if (binaire2.charAt(i) == '1') {
                    int longueur = binaire2.length() - 1 - i;
                    total += Math.pow(2, longueur);
                }
            }
            System.out.println(total);
            decimal2.setText(String.valueOf(total));
        });
        // Conversion d'un nombre decimal en nombre romain
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