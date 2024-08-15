package br.senac.sp.calculos.application.dto;

public class AreaRequest {

    private String shapeType;
    private double dimensao1;  // para formas que precisam de uma dimensao
    private double dimensao2; // Para formas que precisam de duas dimensões

    public String getShapeType() {
        return shapeType;
    }

    public AreaRequest setShapeType(String shapeType) {
        this.shapeType = shapeType;
        return this;
    }

    public double getDimensao1() {
        return dimensao1;
    }

    public AreaRequest setDimensao1(double dimensao1) {
        this.dimensao1 = dimensao1;
        return this;
    }

    public double getDimensao2() {
        return dimensao2;
    }

    public AreaRequest setDimensao2(double dimensao2) {
        this.dimensao2 = dimensao2;
        return this;
    }

}