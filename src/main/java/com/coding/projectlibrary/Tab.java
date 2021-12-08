package com.coding.projectlibrary;

public class Tab {
    private String titre;
    private String auteur;
    private int parution;
    private int colonne;
    private int range;
    private String resume;

    public Tab(String titre, String auteur,int parution,int colonne,int range, String resume) {
        this.titre = titre;
        this.auteur = auteur;
        this.parution = parution;
        this.colonne = colonne;
        this.range = range;
        this.resume = resume;
    }

    public String getTitre() {
        return titre;
    }

    public String getAuteur() {
        return auteur;
    }

    public int getParution() {
        return parution;
    }

    public int getColonne() {
        return colonne;
    }

    public int getRange() {
        return range;
    }

    public String getResume() {
        return resume;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    public void setParution(int parution) {
        this.parution = parution;
    }

    public void setColonne(int colonne) {
        this.colonne = colonne;
    }

    public void setRange(int range) {
        this.range = range;
    }

    public void setResume(String resume) {
        this.resume = resume;
    }

    @Override
    public String toString() {
        return "Tab : " +
                "titre='" + titre + '\'' +
                ", auteur='" + auteur + '\'' +
                ", parution=" + parution +
                ", colonne=" + colonne +
                ", range=" + range +
                ", resume='" + resume + '\'';
    }
}
