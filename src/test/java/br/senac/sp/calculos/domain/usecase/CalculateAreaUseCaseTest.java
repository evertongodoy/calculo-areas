package br.senac.sp.calculos.domain.usecase;


import br.senac.sp.calculos.domain.entity.Formato;
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

    @Mock
    private Formato formato;
    @InjectMocks
    private CalculateAreaUseCase calculateAreaUseCase;

    @Test
    void testExecute_QuandoOk(){
        Mockito.when(formato.calculateArea()).thenReturn(100.0);
        double atual = calculateAreaUseCase.execute(formato);
        Assertions.assertEquals(100.0, atual);
    }

    @Test
    void testExecute_QuandoInvalidShapeException(){
        InvalidShapeException exception = Assertions.assertThrows(
                InvalidShapeException.class, () -> calculateAreaUseCase.execute(null));
        Assertions.assertEquals("Formato nao pode ser null", exception.getMessage());
    }
}
