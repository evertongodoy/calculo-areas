package br.senac.sp.calculos.application.service;

import br.senac.sp.calculos.domain.entity.Circulo;
import br.senac.sp.calculos.domain.entity.Formato;
import br.senac.sp.calculos.domain.entity.Retangulo;
import br.senac.sp.calculos.domain.usecase.CalculateAreaUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class AreaCalculatorServiceTest {

    @Mock
    private CalculateAreaUseCase calculateAreaUseCase;
    @InjectMocks
    private AreaCalculatorService areaCalculatorService;

    @Test
    void testCalcularAreaRetangulo(){
        Formato formato = new Retangulo(10.0, 10.0);
        Mockito.when(calculateAreaUseCase.execute(formato)).thenReturn(100.0);

        double atual = areaCalculatorService.calculateArea(formato);

        Assertions.assertEquals(100.0, atual);
    }

    @Test
    void testCalcularAreaCirculo(){
        Formato formato = new Circulo(10.0);
        Mockito.when(calculateAreaUseCase.execute(formato)).thenReturn(314.1592653589793);

        double atual = areaCalculatorService.calculateArea(formato);

        Assertions.assertEquals(314.1592653589793, atual);
    }
}
