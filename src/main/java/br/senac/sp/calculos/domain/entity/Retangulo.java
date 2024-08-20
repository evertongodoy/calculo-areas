package br.senac.sp.calculos.domain.entity;

import java.util.Objects;

public class Retangulo implements Formato {

    private final double valorLargura;
    private final double valorAltura;

    public Retangulo(double largura, double altura) {
        this.valorLargura = largura;
        this.valorAltura = altura;
    }

    @Override
    public double calculateArea() {
        return valorLargura * valorAltura;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Retangulo retangulo = (Retangulo) o;
        return Double.compare(valorLargura, retangulo.valorLargura) == 0 && Double.compare(valorAltura, retangulo.valorAltura) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(valorLargura, valorAltura);
    }

}