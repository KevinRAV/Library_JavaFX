package com.coding.projectlibrary.model;

public class general extends armee{
    int soldat;
    public general(int general, int soldat) {
        super(general);
        this.soldat = soldat;
    }

    public int getSoldat() {
        return soldat;
    }

    public void setSoldat(int soldat) {
        this.soldat = soldat;
    }
}
