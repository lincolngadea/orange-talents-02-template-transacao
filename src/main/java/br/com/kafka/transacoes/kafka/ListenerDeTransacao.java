package br.com.kafka.transacoes.kafka;

import br.com.kafka.transacoes.transacao.TransacaoRequest;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class ListenerDeTransacao {

    @KafkaListener(topics = "${spring.kafka.topic.transactions}")
    public void ouvir(TransacaoRequest eventoDeTransacao) {
        System.out.println(eventoDeTransacao);
    }
}
