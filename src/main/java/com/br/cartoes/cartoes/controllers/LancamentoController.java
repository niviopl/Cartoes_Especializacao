package com.br.cartoes.cartoes.controllers;


import com.br.cartoes.cartoes.models.Cartao;
import com.br.cartoes.cartoes.models.Lancamento;
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
@RequestMapping("/Lancamentos")
public class LancamentoController {

    @Autowired
    private LancamentoService lancamentoService;

    @Autowired
    private CartaoService cartaoService;

    @GetMapping
    public Iterable<Lancamento> buscarTodosLancamentos(){
        return lancamentoService.buscarTodosLancamentos();
    }

    @GetMapping("/{id}")
    public Lancamento buscarLancamento(@PathVariable Integer id){
        Optional<Lancamento> lancamentoOptional = lancamentoService.buscarPorId(id);
        if (lancamentoOptional.isPresent()){
            return lancamentoOptional.get();
        }else {
            throw new ResponseStatusException((HttpStatus.NO_CONTENT));
        }
     }

     @PostMapping
    public ResponseEntity<Lancamento> salvarLancamento(@RequestBody @Valid Lancamento lancamento){
         try {
             Lancamento lancamentoObjeto = lancamentoService.salvarLancamento(lancamento);
             return ResponseEntity.status(201).body(lancamentoObjeto);
         }catch (Exception e){
             throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getLocalizedMessage());
         }
     }
}
