package br.com.kafka.transacoes.transacao;

import javax.validation.constraints.NotBlank;

public class TransacaoRequest {

    @NotBlank
    private String email;

    @Deprecated
    public TransacaoRequest() {
    }

    public TransacaoRequest(@NotBlank String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "TransacaoRequest{" +
                "email='" + email + '\'' +
                '}';
    }
}
