package com.secondexam.model;

public class RetiroAtm extends Retiro {
    private double comision;

    @Override
    public double getMonto() {
        return super.getMonto() + comision;
    }

    public double getComision() {
        return comision;
    }

    public void setComision(double comision) {
        this.comision = comision;
    }
}