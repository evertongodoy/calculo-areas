package br.senac.sp.calculos.domain.entity;

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

}