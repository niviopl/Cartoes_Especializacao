package com.br.cartoes.cartoes.models.mapper;

import com.br.cartoes.cartoes.models.Cartao;
import com.br.cartoes.cartoes.models.Dto.CreateLancamentoRequest;
import com.br.cartoes.cartoes.models.Dto.LancamentoResponse;
import com.br.cartoes.cartoes.models.Lancamento;

import java.util.ArrayList;
import java.util.List;

public class LancamentoMapper {

    public static LancamentoResponse toLancamentoResponse(Lancamento lancamento) {
        LancamentoResponse lancamentoResponse = new LancamentoResponse();

        lancamentoResponse.setId(lancamento.getId());
        lancamentoResponse.setCartaoId(lancamento.getCartao().getId());
        lancamentoResponse.setDescricao(lancamento.getDescricao());
        lancamentoResponse.setValor(lancamento.getValor());

        return lancamentoResponse;
    }

    public static List<LancamentoResponse> toLancamentoResponse(List<Lancamento> lancamentos) {
        List<LancamentoResponse> pagamentoResponses = new ArrayList<>();

        for (Lancamento lancamento : lancamentos) {
            pagamentoResponses.add(toLancamentoResponse(lancamento));
        }

        return pagamentoResponses;
    }

    public static Lancamento toLancamento(CreateLancamentoRequest createPagamentoRequest) {
        Cartao cartao = new Cartao();
        cartao.setId(createPagamentoRequest.getCartaoId());

        Lancamento lancamento = new Lancamento();

        lancamento.setDescricao(createPagamentoRequest.getDescricao());
        lancamento.setValor(createPagamentoRequest.getValor());
        lancamento.setCartao(cartao);

        return lancamento;
    }
}
