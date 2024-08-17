package br.senac.sp.calculos.domain.entity;

public class FabricaFormatos {

    public static Formato criarFormato(String shapeType, double... dimensoes) {
        switch (shapeType.toLowerCase().trim()) {
                case "circulo":
                    if (dimensoes.length >= 1) {
                        return new Circulo(dimensoes[0]);
                    } else {
                        throw new IllegalArgumentException("Circulo necessita de 1 dimension (raio).");
                    }
            case "retangulo":
                if (dimensoes.length == 2) {
                    return new Retangulo(dimensoes[0], dimensoes[1]);
                } else {
                    throw new IllegalArgumentException("Retangulo necessita de 2 dimensoes (largura e altura).");
                }
            default:
                return null;
        }
    }

}