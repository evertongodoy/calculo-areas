package br.senac.sp.calculos.application.service;

import br.senac.sp.calculos.domain.entity.Formato;
import br.senac.sp.calculos.domain.usecase.CalculateAreaUseCase;
import org.springframework.stereotype.Service;

@Service
public class AreaCalculatorService {

    private final CalculateAreaUseCase calculateAreaUseCase;

    public AreaCalculatorService(CalculateAreaUseCase calculateAreaUseCase) {
        this.calculateAreaUseCase = calculateAreaUseCase;
    }

    public double calculateArea(Formato shape) {
        return calculateAreaUseCase.execute(shape);
    }

}
