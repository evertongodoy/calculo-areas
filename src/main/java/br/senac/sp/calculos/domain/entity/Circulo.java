package br.senac.sp.calculos.domain.entity;

import java.util.Objects;

public class Circulo implements Formato {

    private final double radius;

    public Circulo(double radius) {
        this.radius = radius;
    }

    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Circulo circulo = (Circulo) o;
        return Double.compare(radius, circulo.radius) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(radius);
    }

}