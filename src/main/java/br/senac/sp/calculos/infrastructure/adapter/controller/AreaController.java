package br.senac.sp.calculos.infrastructure.adapter.controller;

import br.senac.sp.calculos.application.dto.AreaRequest;
import br.senac.sp.calculos.application.service.AreaCalculatorService;
import br.senac.sp.calculos.domain.entity.Formato;
import br.senac.sp.calculos.domain.entity.FabricaFormatos;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/areas")
public class AreaController {

    private final AreaCalculatorService areaCalculatorService;

    public AreaController(AreaCalculatorService areaCalculatorService) {
        this.areaCalculatorService = areaCalculatorService;
    }

    @PostMapping
    public double calculateArea(@RequestBody AreaRequest areaRequest) {
        Formato shape = FabricaFormatos.criarFormato(
                areaRequest.getShapeType(),
                areaRequest.getDimensao1(),
                areaRequest.getDimensao2());
        return areaCalculatorService.calculateArea(shape);
    }

}
