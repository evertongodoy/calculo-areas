package br.senac.sp.calculos.domain.usecase;


import br.senac.sp.calculos.domain.entity.Circulo;
import br.senac.sp.calculos.domain.entity.Formato;
import br.senac.sp.calculos.domain.entity.Retangulo;
import br.senac.sp.calculos.domain.exception.InvalidShapeException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class CalculateAreaUseCaseTest {

    @InjectMocks
    private CalculateAreaUseCase calculateAreaUseCase;

    @Test
    void testExecute_QuandoRetangulo(){
        Formato formato = new Retangulo(10.0, 10.0);
        double atual = calculateAreaUseCase.execute(formato);
        Assertions.assertEquals(100.0, atual);
    }

    @Test
    void testExecute_QuandoCirculo(){
        Formato formato = new Circulo(10.0);
        double atual = calculateAreaUseCase.execute(formato);
        Assertions.assertEquals(314.1592653589793, atual);
    }

    @Test
    void testExecute_QuandoInvalidShapeException(){
        InvalidShapeException exception = Assertions.assertThrows(
                InvalidShapeException.class, () -> calculateAreaUseCase.execute(null));
        Assertions.assertEquals("Formato nao pode ser null", exception.getMessage());
    }

}