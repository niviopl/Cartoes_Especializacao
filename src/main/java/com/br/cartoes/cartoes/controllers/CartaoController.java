package com.br.cartoes.cartoes.controllers;

import com.br.cartoes.cartoes.models.Cartao;
import com.br.cartoes.cartoes.models.Cliente;
import com.br.cartoes.cartoes.models.Dto.*;
import com.br.cartoes.cartoes.models.mapper.CartaoMapper;
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

    @GetMapping("/{numero}")
    public GetCartaoResponse buscarCartao(@PathVariable String numero){
        Cartao byNumero = cartaoService.getByNumero(numero);
        return CartaoMapper.toGetResponse(byNumero);
    }

    @PostMapping
    public CreateCartaoResponse salvarCartao(@RequestBody CreateCartaoRequest createCartaoRequest){
       try {
       //     Cartao cartaoObjeto = cartaoService.salvarCartao(cartaoDto);
           Cartao cartao = CartaoMapper.fromCreateRequest(createCartaoRequest);

           cartao = cartaoService.salvarCartao(cartao);

           return CartaoMapper.toCreateResponse(cartao);
             //return ResponseEntity.status(201).body(cartaoObjeto);

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

    @PatchMapping("/{numero}")
    public UpdateCartaoResponse atualizarStatusCartao(@PathVariable String numero,  @RequestBody UpdateCartaoRequest updateCartaoRequest){
        Cartao cartao = CartaoMapper.fromUpdateRequest(updateCartaoRequest);
        cartao.setNumero(numero);

        cartao = cartaoService.update(cartao);
        return CartaoMapper.toUpdateResponse(cartao);
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
