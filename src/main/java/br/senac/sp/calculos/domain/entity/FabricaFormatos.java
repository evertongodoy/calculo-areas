package br.senac.sp.calculos.domain.entity;

public class FabricaFormatos {

    public static Formato criarFormato(String shapeType, double... dimensoes) {
        switch (shapeType.toLowerCase().trim()) {
            case "circulo":
                    return new Circulo(dimensoes[0]);
            case "retangulo":
                return new Retangulo(dimensoes[0], dimensoes[1]);
            default:
                return null;
        }
    }

}