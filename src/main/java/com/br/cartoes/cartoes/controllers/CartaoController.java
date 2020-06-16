package com.br.cartoes.cartoes.controllers;

import com.br.cartoes.cartoes.models.Cartao;
import com.br.cartoes.cartoes.models.Cliente;
import com.br.cartoes.cartoes.models.Dto.CartaoDto;
import com.br.cartoes.cartoes.services.CartaoService;
import com.br.cartoes.cartoes.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Cartao")
public class CartaoController {

    @Autowired
    private CartaoService cartaoService;

    @GetMapping
    public Iterable<Cartao> buscarTodosCartoes(){
        return cartaoService.buscarTodosCartoes();
    }

    @GetMapping("/{id}")
    public Cartao buscarCartao(@PathVariable Integer id){
        Optional<Cartao> cartaoOptional = cartaoService.buscarPorId(id);
        if (cartaoOptional.isPresent()){
            return cartaoOptional.get();
        } else{
            throw new ResponseStatusException(HttpStatus.NO_CONTENT);
        }
    }

    @PostMapping
    public ResponseEntity<Cartao> salvarCartao(@RequestBody @Valid CartaoDto cartaoDto){
       try {
            Cartao cartaoObjeto = cartaoService.salvarCartao(cartaoDto);
            return ResponseEntity.status(201).body(cartaoObjeto);
        }catch (Exception e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getLocalizedMessage());
        }
    }

    @PutMapping("/{id}")
    public Cartao atualizarCartao(@PathVariable Integer id, @RequestBody Cartao cartao){
        cartao.setId(id);
        try {
            Cartao cartaoObjeto = cartaoService.atualizarCartao(cartao);
            return cartaoObjeto;
        }catch (Exception e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getLocalizedMessage());
        }
    }

    @PatchMapping("/{num}")
    public Cartao atualizarStatusCartao(@PathVariable double num,  @RequestBody Cartao cartao){
        cartao.setNumero(num);
        //System.out.println("NumDocartao: " + num);
        try {
            Cartao cartaoObjeto = cartaoService.atualizarStatusCartao(cartao);
            return cartaoObjeto;
        }catch (Exception e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getLocalizedMessage());
        }
    }

    @DeleteMapping("/{id}")
    public Cartao deletarCartao(@PathVariable Integer id){
        Optional<Cartao> cartaoOptional = cartaoService.buscarPorId(id);
        if (cartaoOptional.isPresent()){
            cartaoService.deletarCartao(cartaoOptional.get());
            return cartaoOptional.get();
        }
        throw new ResponseStatusException(HttpStatus.NO_CONTENT);
    }

}
