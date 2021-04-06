package br.com.kafka.transacoes.registroTransacao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransacaoRepository extends JpaRepository<Transacao, String> {
    List<Transacao> findFirst10ByCartaoIdOrderByEfetivadaEmDesc(String id);
}
