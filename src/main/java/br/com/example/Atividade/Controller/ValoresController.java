package br.com.example.Atividade.Controller;

import br.com.example.Atividade.DTO.Valores;
import br.com.example.Atividade.Service.ValoresService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/valores")
public class ValoresController {

    @Autowired
    private ValoresService valoresService;


    @PostMapping
    public ResponseEntity<?> receber(@RequestBody Valores valores){
        try{
         //   this.valoresService.insercao(valores.getListValores());
            Double media = this.valoresService.media(valores.getListValores());
            Double desvioPadrao = this.valoresService.desvioPadrao(valores.getListValores(), media);
            int quantValores = this.valoresService.quantValores(valores.getListValores());
            Double mediana = this.valoresService.mediana(valores.getListValores());
            return ResponseEntity.ok("Valores: " + quantValores + "\nMedia: " + media + "\nDesvio Padrão: " + desvioPadrao + "\nMediana: " + mediana);
        }
        catch(RuntimeException e){
            return  ResponseEntity.internalServerError().body("Error: " + e.getMessage());
        }
        catch(Exception e){
            return ResponseEntity.badRequest().body("Error: " + e.getMessage());
        }
    }

}
