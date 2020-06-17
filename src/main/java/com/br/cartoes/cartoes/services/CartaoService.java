package com.br.cartoes.cartoes.services;
import com.br.cartoes.cartoes.models.Cliente;
import com.br.cartoes.cartoes.models.Dto.CartaoDto;
import com.br.cartoes.cartoes.repositories.ClienteRepository;
import com.br.cartoes.cartoes.enums.TipoDeStatus;

import com.br.cartoes.cartoes.models.Cartao;
import com.br.cartoes.cartoes.repositories.CartaoRepository;
import javassist.tools.rmi.ObjectNotFoundException;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CartaoService {
    @Autowired
    private CartaoRepository cartaoRepository;

    @Autowired
    private ClienteService clienteService;

    //public Iterable<Cliente> buscarTodosClientes(List<Integer> clientesId){
        //Iterable<Cliente> clienteIterable = clienteRepository.findAllById(clientesId);
        //Iterable<Cliente> clienteIterable = clienteService.buscarPorId(clientesId);
        //return clienteIterable;
    //}

    public Cartao salvarCartao(Cartao cartao)throws ObjectNotFoundException{
        //if (clienteOptional.isPresent()){
         //   Cartao cartao = new Cartao();
         //   cartao.setTipoDeStatus(TipoDeStatus.FALSE);
         //   cartao.setNumero(cartaoDto.getNumero());
          //  cartao.setCliente(clienteOptional.get());
         //   Cartao cartaoObjeto = cartaoRepository.save(cartao);
         //   return cartaoObjeto;
        //}
        //throw new org.hibernate.ObjectNotFoundException(Cartao.class, "Cliente Inexistente no Cadastro!");
        // Bloco de validação
        Cliente cliente = clienteService.buscarPorId(cartao.getCliente().getId());
        cartao.setCliente(cliente);

        Optional<Cartao> byNumero = cartaoRepository.findByNumero(cartao.getNumero());

        if(byNumero.isPresent()) {
            throw new org.hibernate.ObjectNotFoundException(Cartao.class, "Número de cartão já existe no Cadastro!");
        }

        // Regras de negócio
        cartao.setTipoDeStatus(TipoDeStatus.FALSE);

        return cartaoRepository.save(cartao);

    }

    public Cartao getById(int id) {
        Optional<Cartao> byId = cartaoRepository.findById(id);

        if(!byId.isPresent()) {
            throw new org.hibernate.ObjectNotFoundException(Cartao.class, "O Cartão não foi encontrado");
        }

        return byId.get();
    }

    public Optional<Cartao> buscarPorId(long id){
        Optional<Cartao> cartaoOptional = cartaoRepository.findById(Integer.valueOf((int) id));
        return cartaoOptional;
    };

    public Cartao getByNumero(String numero) {
        Optional<Cartao> byId = cartaoRepository.findByNumero(numero);

        if(!byId.isPresent()) {
            throw new org.hibernate.ObjectNotFoundException(Cartao.class, "O Cartão não foi encontrado");
        }

        return byId.get();
    }

    public Iterable<Cartao> buscarTodosCartoes(){
        Iterable<Cartao> cartoes = cartaoRepository.findAll();
        return cartoes;
    }

    public Cartao atualizarCartao(Cartao cartao) throws ObjectNotFoundException{
        Optional<Cartao> cartaoOptional = buscarPorId(cartao.getId());
         if (cartaoOptional.isPresent()){
            Cartao cartaoData = cartaoOptional.get();
            if (cartao.getNumero() == null){
                cartao.setNumero(cartaoData.getNumero());
            }

            if (cartao.getTipoDeStatus() != TipoDeStatus.FALSE && cartao.getTipoDeStatus() != TipoDeStatus.TRUE) {
                cartao.setTipoDeStatus(cartaoData.getTipoDeStatus());
            }
            //cartao.setCliente(clienteOptional.get());
            cartao.setCliente(cartaoData.getCliente());
            Cartao cartaoObjeto = cartaoRepository.save(cartao);
            return cartaoObjeto;
         }
        throw new org.hibernate.ObjectNotFoundException(Cartao.class, "O Cartão não foi encontrado");
    }

    public Cartao update(Cartao updatedCartao) {
        Cartao databaseCartao = getByNumero(updatedCartao.getNumero());

        databaseCartao.setTipoDeStatus(updatedCartao.getTipoDeStatus());

        return cartaoRepository.save(databaseCartao);
    }

    public Cartao atualizarStatusCartao(Cartao cartao) throws ObjectNotFoundException{
        Optional<Cartao> cartaoOptional = buscarPorId(cartao.getId());
        if (cartaoOptional.isPresent()){
            Cartao cartaoData = cartaoOptional.get();
            cartaoData.setTipoDeStatus(cartao.getTipoDeStatus());
            //cartao.setTipoDeStatus(cartaoData.getTipoDeStatus());
            //if (cartao.getNumero() == 0.0){
            //    cartao.setNumero(cartaoData.getNumero());
            //}
            Cartao cartaoObjeto = cartaoRepository.save(cartaoData);
            return cartaoObjeto;
        }
        throw new org.hibernate.ObjectNotFoundException(Cartao.class, "O Cartão não foi encontrado");
    }


    public void deletarCartao(Cartao cartao){
        cartaoRepository.delete(cartao);
    }
}
