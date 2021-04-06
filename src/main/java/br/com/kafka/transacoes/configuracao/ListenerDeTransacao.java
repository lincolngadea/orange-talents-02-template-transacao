package br.com.kafka.transacoes.configuracao;

import br.com.kafka.transacoes.configuracao.log.Logback;
import br.com.kafka.transacoes.registroTransacao.TransacaoRepository;
import br.com.kafka.transacoes.registroTransacao.TransacaoRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import javax.validation.Valid;

@Component
public class ListenerDeTransacao {


    @Autowired
    TransacaoRepository transacaoRepository;

    private final Logger logger = LoggerFactory.getLogger(Logback.class);

    @KafkaListener(topics = "${spring.kafka.topic.transactions}")
    public void ouvir(@Valid TransacaoRequest request) {
        try{
            transacaoRepository.save(request.toModel());
        }catch (Exception e){
            logger.error("Aconteceu uma erro ao gravar os dados:{}",e.getMessage());
        }

        logger.info("Dados Salvos com sucesso: {}",request.getEstabelecimento());
    }
}
