package br.com.kafka.transacoes.transacao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class TransacaoController {

    @Autowired
    TransacaoRepository transacaoRepository;

    @GetMapping("/transacoes/{id}")
    @Transactional
    public ResponseEntity<?> buscaTransacoes(@PathVariable String id){
        List<Transacao> listaDeTransacoes = transacaoRepository.findFirst10ByCartaoIdOrderByEfetivadaEmDesc(id);

        if(listaDeTransacoes.isEmpty()){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok().body(listaDeTransacoes);

    }

}
