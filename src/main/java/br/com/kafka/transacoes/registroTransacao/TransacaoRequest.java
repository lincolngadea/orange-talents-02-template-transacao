package br.com.kafka.transacoes.registroTransacao;

import br.com.kafka.transacoes.registroCartao.Cartao;
import br.com.kafka.transacoes.registroEstabelecimento.Estabelecimento;

import java.math.BigDecimal;

public class TransacaoRequest {

    private String id;
    private BigDecimal valor;
    private Estabelecimento estabelecimento;
    private Cartao cartao;
    private String efetivadaEm;

    @Deprecated
    public TransacaoRequest() {
    }

    public TransacaoRequest(
            String id,
            BigDecimal valor,
            Estabelecimento estabelecimento,
            Cartao cartao,
            String efetivadaEm) {
        this.id = id;
        this.valor = valor;
        this.estabelecimento = estabelecimento;
        this.cartao = cartao;
        this.efetivadaEm = efetivadaEm;
    }

    public String getId() {
        return id;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public Estabelecimento getEstabelecimento() {
        return estabelecimento;
    }

    public Cartao getCartao() {
        return cartao;
    }

    public String getEfetivadaEm() {
        return efetivadaEm;
    }

    public Transacao toModel() {
        return new Transacao(id,valor,estabelecimento,cartao,efetivadaEm);
    }
}
