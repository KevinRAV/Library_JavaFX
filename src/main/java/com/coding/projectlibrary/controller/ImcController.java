package com.coding.projectlibrary.controller;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
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
    private AnchorPane imc;



//    @FXML
//    private void handleButtonAction(ActionEvent event) {
//        if(event.getSource() == btnCalculez){
//            double valeurKg =0;
//            double valeurCm = 0;
//            double imc = valeurKg / (valeurCm  * valeurCm );
//
//            switch ((int) imc){
//
//                case 1:
//                    if (imc < 18.5)
//                        System.out.println("Vous êtes en situation de sous poids : "+imc);
//                case 2:
//                    if (18.5 >= imc  &&  imc <= 24.9 )
//                        System.out.println("Vous êtes en situation normale : "+imc);
//                case 3:
//                    if (25 >= imc  &&  imc <= 29.9 )
//                        System.out.println("Vous êtes en situation surpoids : "+imc);
//                case 4:
//                    if (30 >= imc  &&  imc <= 34.9 )
//                        System.out.println("Vous êtes en situation d'obésité : "+imc);
//                default:
//                    if (imc > 35 )
//                        System.out.println("Vous êtes en situation d'obésité severe : "+imc);
//            }
//
//
//        }
//    }



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
//
//            switch (imc){
//
//                case 1:
//                    if (imc < 18.5)
//                        System.out.println("Vous êtes en situation de sous poids : "+imc);
//                case 2:
//                    if (18.5 >= imc  &&  imc <= 24.9 )
//                        System.out.println("Vous êtes en situation normale : "+imc);
//                case 3:
//                    if (25 >= imc  &&  imc <= 29.9 )
//                        System.out.println("Vous êtes en situation surpoids : "+imc);
//                case 4:
//                    if (30 >= imc  &&  imc <= 34.9 )
//                        System.out.println("Vous êtes en situation d'obésité : "+imc);
//                default:
//                    if (imc > 35 )
//                        System.out.println("Vous êtes en situation d'obésité severe : "+imc);
//            System.out.println(imc);
//            }
//        });



//    //Geter
//    public Integer getImc() {
//        return this.imc; ("quand on met this on parle des propriétés qui me concerne")
//    }


//    public static calculImc () {
//        double valeurKg =0;
//        double valeurCm = 0;
//        double imc = valeurKg / (valeurCm  * valeurCm );
//
//        switch (){
//
//            case 1:
//                if (imc < 18.5)
//                    System.out.println("Vous êtes en situation de sous poids : "+imc);
//            case 2:
//                if (18.5 >= imc  &&  imc <= 24.9 )
//                    System.out.println("Vous êtes en situation normale : "+imc);
//            case 3:
//                if (25 >= imc  &&  imc <= 29.9 )
//                    System.out.println("Vous êtes en situation surpoids : "+imc);
//            case 4:
//                if (30 >= imc  &&  imc <= 34.9 )
//                    System.out.println("Vous êtes en situation d'obésité : "+imc);
//            default:
//                if (imc > 35 )
//                    System.out.println("Vous êtes en situation d'obésité severe : "+imc);
//        }
//
//
//}


// double btnKg = 0;
//    double btnCm = 0;
//    imc = (kg/cm*cm)
//
//            switch(nu
//            m+2)
//    {
//        case 1:
//            if (imc < 18.5)
//            System.out.println("Vous êtes en situation de sous poids : "+imc);
//        case 2:
//            if (18.5 >= imc  &&  imc <= 24.9 )
//                System.out.println("Vous êtes en situation normale : "+imc);
//        case 3:
//            if (25 >= imc  &&  imc <= 29.9 )
//                System.out.println("Vous êtes en situation surpoids : "+imc);
//        case 4:
//            if (30 >= imc  &&  imc <= 34.9 )
//                System.out.println("Vous êtes en situation d'obésité : "+imc);
//        default:
//            if (imc > 35 )
//                System.out.println("Vous êtes en situation d'obésité severe : "+imc);
//    }
//}
//}


}}
