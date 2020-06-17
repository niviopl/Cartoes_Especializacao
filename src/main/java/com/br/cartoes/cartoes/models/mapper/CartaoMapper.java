package com.br.cartoes.cartoes.models.mapper;

import com.br.cartoes.cartoes.models.Cartao;
import com.br.cartoes.cartoes.models.Cliente;
import com.br.cartoes.cartoes.models.Dto.*;

public class CartaoMapper {

    public static Cartao fromCreateRequest(CreateCartaoRequest cartaoCreateRequest) {
        Cliente cliente = new Cliente();
        cliente.setId(cartaoCreateRequest.getClienteId());

        Cartao cartao = new Cartao();
        cartao.setNumero(cartaoCreateRequest.getNumero());

        cartao.setCliente(cliente);
        return cartao;
    }

    public static CreateCartaoResponse toCreateResponse(Cartao cartao) {
        CreateCartaoResponse createCartaoResponse = new CreateCartaoResponse();

        createCartaoResponse.setId(cartao.getId());
        createCartaoResponse.setNumero(cartao.getNumero());
        createCartaoResponse.setClienteId(cartao.getCliente().getId());
        createCartaoResponse.setTipoDeStatus(cartao.getTipoDeStatus());

        return createCartaoResponse;
    }

    public static Cartao fromUpdateRequest(UpdateCartaoRequest updateCartaoRequest) {
        Cartao cartao = new Cartao();
        cartao.setTipoDeStatus(updateCartaoRequest.getTipoDeStatus());
        return cartao;
    }

    public static UpdateCartaoResponse toUpdateResponse(Cartao cartao) {
        UpdateCartaoResponse updateCartaoResponse = new UpdateCartaoResponse();
        updateCartaoResponse.setId(cartao.getId());
        updateCartaoResponse.setNumero(cartao.getNumero());
        updateCartaoResponse.setClienteId(cartao.getCliente().getId());
        updateCartaoResponse.setTipoDeStatus(cartao.getTipoDeStatus());

        return updateCartaoResponse;
    }

    public static GetCartaoResponse toGetResponse(Cartao cartao) {
        GetCartaoResponse getCartaoResponse = new GetCartaoResponse();

        getCartaoResponse.setId(cartao.getId());
        getCartaoResponse.setNumero(cartao.getNumero());
        getCartaoResponse.setClienteId(cartao.getCliente().getId());

        return getCartaoResponse;
    }

}

