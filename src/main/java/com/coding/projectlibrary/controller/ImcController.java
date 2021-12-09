package com.coding.projectlibrary.controller;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

public class ImcController implements Initializable {

    @FXML
    private Button btnCalculez;

    @FXML
    private Label cm;

    @FXML
    private HBox containerAll;

    @FXML
    private VBox containerDroite;

    @FXML
    private VBox containerGauche;

    @FXML
    private Label imC;

    @FXML
    private Label kg;

    @FXML
    private Label comment;

    @FXML
    private TextField valeurCm;

    @FXML
    private TextField valeurKg;

    @FXML
    private TextField resultatImc;

    @FXML
    private ImageView imageImc;

    @FXML
    private AnchorPane imc;



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        valeurKg.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue,
                                String newValue) {
                if (!newValue.matches("\\d*")) {
                    valeurKg.setText(newValue.replaceAll("[^\\d]", ""));
                }
            }
        });

        valeurCm.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue,
                                String newValue) {
                if (!newValue.matches("\\d*")) {
                    valeurCm.setText(newValue.replaceAll("[^\\d]", ""));
                }
            }
        });

        btnCalculez.setOnMouseClicked(e->{

            float valeurK = Float.parseFloat(valeurKg.getText());
            float valeurC = Float.parseFloat(valeurCm.getText());
            float imc =(valeurK / (valeurC  * valeurC ))*10000;


            if (imc < 18.5){
                comment.setText(String.valueOf("Vous êtes en situation de sous poids : "+imc));
//                imageImc.setImage();
            }else if(imc>= 18.5  &&  imc <= 24.9 ){
                comment.setText(String.valueOf("Vous êtes en situation normale : "+imc));
            }else if(imc >= 25  &&  imc <= 29.9 ){
                comment.setText(String.valueOf("Vous êtes en situation surpoids : "+imc));
            }else if(imc>= 30  &&  imc <= 34.9 ){
                comment.setText(String.valueOf("Vous êtes en situation d'obésité : "+imc));
            }else if(imc > 35 ){
                comment.setText(String.valueOf("Vous êtes en situation d'obésité severe : "+imc));
            }
            resultatImc.setText(String.valueOf(imc));

        });
    }
}
