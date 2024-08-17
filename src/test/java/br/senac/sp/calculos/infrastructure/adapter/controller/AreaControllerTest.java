package br.senac.sp.calculos.infrastructure.adapter.controller;

import br.senac.sp.calculos.application.dto.AreaRequest;
import br.senac.sp.calculos.application.service.AreaCalculatorService;
import br.senac.sp.calculos.domain.entity.Circulo;
import br.senac.sp.calculos.domain.entity.Formato;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class AreaControllerTest {

    @Mock
    private AreaCalculatorService areaCalculatorService;

    @InjectMocks
    private AreaController areaController;

    @Test
    void testCalculateAreaQuandoCirculo(){
        AreaRequest req = new AreaRequest();
        req.setShapeType("circulo");
        req.setDimensao1(Double.valueOf(10.0));

        Formato f = new Circulo(Double.valueOf(10.0));
        var raio = Double.valueOf(10.0);
        var esperado = Double.valueOf(314.1592653589793);

        Mockito
                .when(areaCalculatorService.calculateArea(f))
                .thenReturn(Math.PI * raio * raio);

        double atual = areaController.calculateArea(req);
        Assertions.assertEquals(esperado, atual);

    }

}
