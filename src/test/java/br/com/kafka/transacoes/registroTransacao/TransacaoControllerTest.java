package br.com.kafka.transacoes.registroTransacao;

import br.com.kafka.transacoes.registroCartao.Cartao;
import br.com.kafka.transacoes.registroEstabelecimento.Estabelecimento;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.util.Assert;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureMockMvc
class TransacaoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private TransacaoRepository repository;

    @Test
    @WithMockUser
    @DisplayName("Deve retornar vazio")
    void testaConsultaDetransacoes(){

        Transacao transacao = new Transacao(
                "5541da9c-79c5-44fb-b701",
                new BigDecimal(1203),
                new Estabelecimento("Nome","cidade","endereco"),
                new Cartao("5541da9c-79c5-44fb-b701-cc50ed07b45d","email@email.com"),
                "2020-08-10T13:16:56");

        repository.save(transacao);
        List<Transacao> resultadoDaBusca = repository.findFirst10ByCartaoIdOrderByEfetivadaEmDesc("541da9c-79c5-44fb-b701-cc50ed07b45d");

        Assertions.assertTrue(resultadoDaBusca.isEmpty());
    }
}