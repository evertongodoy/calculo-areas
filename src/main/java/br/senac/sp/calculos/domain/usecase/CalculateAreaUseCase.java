package br.senac.sp.calculos.domain.usecase;

import br.senac.sp.calculos.domain.entity.Formato;
import br.senac.sp.calculos.domain.exception.InvalidShapeException;
import org.springframework.stereotype.Service;

@Service
public class CalculateAreaUseCase {

    public double execute(Formato shape) {
        if (shape == null) {
            throw new InvalidShapeException("Formato nao pode ser null");
        }
        return shape.calculateArea();
    }

}
