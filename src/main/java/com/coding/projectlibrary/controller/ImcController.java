package com.coding.projectlibrary.controller;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
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

    private Image normal = new Image("file:src/main/java/com/coding/projectlibrary/image/normal.png");
    private Image souspoids = new Image("file:src/main/java/com/coding/projectlibrary/image/SousPoids.png");
    private Image surpoids = new Image("file:src/main/java/com/coding/projectlibrary/image/Surpoids.png");
    private Image obesite = new Image("file:src/main/java/com/coding/projectlibrary/image/Obesite.png");
    private Image obesiteSevere = new Image("file:src/main/java/com/coding/projectlibrary/image/ObesiteSevere.png");



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
            float imc = Math.round((valeurK / (valeurC  * valeurC ))*10000);


            if (imc < 18.5){
                comment.setText(String.valueOf("Vous êtes en sous poids : "+imc));
                imageImc.setImage(souspoids);
            }else if(imc>= 18.5  &&  imc <= 24.9 ){
                comment.setText(String.valueOf("Vous êtes de corpulance normale : "+imc));
                imageImc.setImage(normal);
            }else if(imc >= 25  &&  imc <= 29.9 ){
                comment.setText(String.valueOf("Vous êtes en surpoids : "+imc));
                imageImc.setImage(surpoids);
            }else if(imc>= 30  &&  imc <= 34.9 ){
                comment.setText(String.valueOf("Vous êtes en situation d'obésité : "+imc));
                imageImc.setImage(obesite);
            }else if(imc > 35 ){
                comment.setText(String.valueOf("Vous êtes en situation d'obésité severe : "+imc));
                imageImc.setImage(obesiteSevere);
            }
            resultatImc.setText(String.valueOf(imc));

        });
    }
}
