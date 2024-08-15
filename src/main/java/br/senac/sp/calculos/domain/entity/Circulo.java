package br.senac.sp.calculos.domain.entity;

public class Circulo implements Formato {

    private final double radius;

    public Circulo(double radius) {
        this.radius = radius;
    }

    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }

}