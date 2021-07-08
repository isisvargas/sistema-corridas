package com.bcopstein.CtrlCorredorV1.business_logic;

public class EstastisticasDTO {
    private int totalCorridas;
    private double media;
    private double mediana;
    private double desvioPadrao;

    public EstastisticasDTO(int totalCorridas, double media, double mediana, double desvioPadrao) {
        this.totalCorridas = totalCorridas;
        this.media = media;
        this.mediana = mediana;
        this.desvioPadrao = desvioPadrao;
    }

    public int getTotalCorridas() {
        return totalCorridas;
    }

    public void setTotalCorridas(int totalCorridas) {
        this.totalCorridas = totalCorridas;
    }

    public double getMedia() {
        return media;
    }

    public void setMedia(double media) {
        this.media = media;
    }

    public double getMediana() {
        return mediana;
    }

    public void setMediana(double mediana) {
        this.mediana = mediana;
    }

    public double getDesvioPadrao() {
        return desvioPadrao;
    }

    public void setDesvioPadrao(double desvioPadrao) {
        this.desvioPadrao = desvioPadrao;
    }
}
