package br.com.kafka.transacoes.transacao;

import br.com.kafka.transacoes.configuracoes.log.Logback;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequestMapping("/api")
public class TransacaoController {

    @Autowired
    TransacaoRepository transacaoRepository;

    private final Logger logger = LoggerFactory.getLogger(Logback.class);

    @GetMapping("/transacoes/{id}")
    @Transactional
    public ResponseEntity<?> buscaTransacoes(@PathVariable String id){
        List<Transacao> listaDeTransacoes = transacaoRepository.findFirst10ByCartaoIdOrderByEfetivadaEmDesc(id);
        logger.info("Lista de Transações: {}",listaDeTransacoes);
        if(listaDeTransacoes.isEmpty()){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok().body(listaDeTransacoes);

    }

}
