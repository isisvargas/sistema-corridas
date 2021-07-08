package com.bcopstein.CtrlCorredorV1.business_logic;

public class AumentoPerformance {
    private String provaAnterior;
    private String provaSeguinte;
    private double aumentoPerformance;

    public AumentoPerformance(String provaAnterior, String provaSeguinte, double aumentoPerformance) {
        this.provaAnterior = provaAnterior;
        this.provaSeguinte = provaSeguinte;
        this.aumentoPerformance = aumentoPerformance;
    }

    public String getProvaAnterior() {
        return provaAnterior;
    }

    public void setProvaAnterior(String provaAnterior) {
        this.provaAnterior = provaAnterior;
    }

    public String getProvaSeguinte() {
        return provaSeguinte;
    }

    public void setProvaSeguinte(String provaSeguinte) {
        this.provaSeguinte = provaSeguinte;
    }

    public double getAumentoPerformance() {
        return aumentoPerformance;
    }

    public void setAumentoPerformance(double aumentoPerformance) {
        this.aumentoPerformance = aumentoPerformance;
    }
}
