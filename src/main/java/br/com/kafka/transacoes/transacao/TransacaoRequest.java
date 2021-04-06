package br.com.kafka.transacoes.transacao;

import br.com.kafka.transacoes.cartao.Cartao;
import br.com.kafka.transacoes.estabelecimento.Estabelecimento;

import java.math.BigDecimal;
import java.time.LocalDateTime;

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
