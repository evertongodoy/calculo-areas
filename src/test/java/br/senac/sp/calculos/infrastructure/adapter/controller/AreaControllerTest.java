package br.senac.sp.calculos.infrastructure.adapter.controller;

import br.senac.sp.calculos.application.dto.AreaRequest;
import br.senac.sp.calculos.application.service.AreaCalculatorService;
import br.senac.sp.calculos.domain.entity.Circulo;
import br.senac.sp.calculos.domain.entity.Formato;
import br.senac.sp.calculos.domain.entity.Retangulo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

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
        req.setDimensao1(10.0);

        Formato f = new Circulo(10.0);
        var raio = Double.valueOf(10.0);
        var esperado = ResponseEntity.ok().body(314.1592653589793);

        Mockito
                .when(areaCalculatorService.calculateArea(f))
                .thenReturn(Math.PI * raio * raio);

        ResponseEntity<Double> atual = areaController.calculateArea(req);
        Assertions.assertEquals(esperado.getStatusCode(), atual.getStatusCode());
        Assertions.assertEquals(esperado.getBody(), atual.getBody());

    }

    @Test
    void testCalculateAreaQuandoRetangulo(){
        AreaRequest req = new AreaRequest();
        req.setShapeType("retangulo");
        req.setDimensao1(10.0);
        req.setDimensao2(10.0);

        Formato formato = new Retangulo(10.0, 10.0);
        var esperado = ResponseEntity.ok().body(100.0);

        Mockito
                .when(areaCalculatorService.calculateArea(formato))
                .thenReturn(100.0);

        ResponseEntity<Double> atual = areaController.calculateArea(req);
        Assertions.assertEquals(esperado.getStatusCode(), atual.getStatusCode());
        Assertions.assertEquals(esperado.getBody(), atual.getBody());
    }

    @Test
    void testCalculateAreaQuandoNaoExisteFormaGeometrica(){
        AreaRequest req = new AreaRequest();
        req.setShapeType("Pentagono-Romano");

        Mockito
                .when(areaCalculatorService.calculateArea(null))
                .thenReturn(0.0);

        ResponseEntity<Double> atual = areaController.calculateArea(req);
        Assertions.assertEquals(HttpStatus.OK, atual.getStatusCode());
        Assertions.assertEquals(0.0, atual.getBody());
    }

}