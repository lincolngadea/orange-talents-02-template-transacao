package br.com.kafka.transacoes.registroTransacao;

import br.com.kafka.transacoes.registroCartao.Cartao;
import br.com.kafka.transacoes.registroEstabelecimento.Estabelecimento;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.math.BigDecimal;

@Entity
public class Transacao {

    @Id
    private String id;

    private BigDecimal valor;
    @OneToOne(cascade = CascadeType.MERGE)
    private Estabelecimento estabelecimento;
    @OneToOne(cascade = CascadeType.MERGE)
    private Cartao cartao;

    private String efetivadaEm;

    @Deprecated
    public Transacao() {
    }

    public Transacao(
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
}
