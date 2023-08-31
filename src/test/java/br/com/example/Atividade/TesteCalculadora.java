package br.com.example.Atividade;

import br.com.example.Atividade.Service.ValoresService;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.Arrays;
import java.util.List;

@SpringBootTest
public class TesteCalculadora {

    @Test
    public void testMedia(){
        ValoresService valoresService = new ValoresService();

        Double[] num = {7.5, 10.0, 5.0};
        List<Double> listNum = Arrays.asList(num);
        Double number = 7.5;
        Assert.assertEquals(number, valoresService.media(listNum));
    }

    @Test
    public void testQuantValores(){
        ValoresService valoresService = new ValoresService();

        Double[] num = {1.0, 2.0, 3.0, 4.0, 5.0};
        List<Double> listNum = Arrays.asList(num);
        Integer number = 5;
        Assert.assertEquals(number, valoresService.quantValores(listNum));
    }

    @Test
    public void testDesvioPadrao(){
        ValoresService valoresService = new ValoresService();

        Double[] num = {1.0, 2.0, 3.0, 4.0, 5.0};
        List<Double> listNum = Arrays.asList(num);
        Double number = 1.4142135623730951;
        Assert.assertEquals(number, valoresService.desvioPadrao(listNum, valoresService.media(listNum)));
    }

    @Test
    public void testMediana(){
        ValoresService valoresService = new ValoresService();

        Double[] num = {1.0, 2.0, 3.0, 4.0, 5.0};
        List<Double> listNum = Arrays.asList(num);
        Double number = 3.0;
        Assert.assertEquals(number, valoresService.mediana(listNum));
    }


}
