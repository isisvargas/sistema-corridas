package com.bcopstein.CtrlCorredorV1.business_logic;

public class PerformanceDTO {
    private String provaAnterior;
    private String provaSeguinte;
    private double ganhoPerformance;

    public PerformanceDTO(String provaAnterior, String provaSeguinte, double ganhoPerformance) {
        this.provaAnterior = provaAnterior;
        this.provaSeguinte = provaSeguinte;
        this.ganhoPerformance = ganhoPerformance;
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

    public double getGanhoPerformance() {
        return ganhoPerformance;
    }

    public void setGanhoPerformance(double ganhoPerformance) {
        this.ganhoPerformance = ganhoPerformance;
    }
}
