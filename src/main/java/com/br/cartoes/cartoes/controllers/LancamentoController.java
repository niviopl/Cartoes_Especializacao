package com.br.cartoes.cartoes.controllers;


import com.br.cartoes.cartoes.models.Cartao;
import com.br.cartoes.cartoes.models.Dto.CreateLancamentoRequest;
import com.br.cartoes.cartoes.models.Dto.LancamentoResponse;
import com.br.cartoes.cartoes.models.Lancamento;
import com.br.cartoes.cartoes.models.mapper.LancamentoMapper;
import com.br.cartoes.cartoes.services.CartaoService;
import com.br.cartoes.cartoes.services.LancamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
public class LancamentoController {

    @Autowired
    private LancamentoService lancamentoService;

    @Autowired
    private CartaoService cartaoService;

    @GetMapping("/lancamentos")
    public Iterable<Lancamento> buscarTodosLancamentos(){
        return lancamentoService.buscarTodosLancamentos();
    }

    @PostMapping("/lancamento")
    public LancamentoResponse create(@RequestBody CreateLancamentoRequest createLancamentoRequest) {
        Lancamento lancamento = LancamentoMapper.toLancamento(createLancamentoRequest);

        lancamento = lancamentoService.create(lancamento);

        return LancamentoMapper.toLancamentoResponse(lancamento);
    }

    @GetMapping("/lancamentos/{cartaoId}")
    public List<LancamentoResponse> listByCartao(@PathVariable int cartaoId) {
        List<Lancamento> lancamentos = lancamentoService.listByCartao(cartaoId);
        return LancamentoMapper.toLancamentoResponse(lancamentos);
    }

}
