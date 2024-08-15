package br.senac.sp.calculos.infrastructure.config;

import br.senac.sp.calculos.domain.usecase.CalculateAreaUseCase;
import org.springframework.context.annotation.Bean;

public class BeanConfig {

    @Bean
    public CalculateAreaUseCase calculateAreaUseCase() {
        return new CalculateAreaUseCase();
    }

}
