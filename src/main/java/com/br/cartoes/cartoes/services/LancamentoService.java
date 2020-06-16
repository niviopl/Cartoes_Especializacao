package com.br.cartoes.cartoes.services;

import com.br.cartoes.cartoes.enums.TipoDeLancamento;
import com.br.cartoes.cartoes.enums.TipoDeStatus;
import com.br.cartoes.cartoes.models.Cartao;
import com.br.cartoes.cartoes.models.Cliente;
import com.br.cartoes.cartoes.models.Lancamento;
import com.br.cartoes.cartoes.repositories.CartaoRepository;
import com.br.cartoes.cartoes.repositories.LancamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LancamentoService {

    @Autowired
    private LancamentoRepository lancamentoRepository;

    @Autowired
    private CartaoRepository cartaoRepository;

    public Lancamento salvarLancamento(Lancamento lancamento){
        if (lancamento.getValor() == 0){
            throw new org.hibernate.ObjectNotFoundException(Cartao.class, "Lançamento não pode ser Zerado!");
        }

        if (lancamento.getIdCartao() == 0){
            throw new org.hibernate.ObjectNotFoundException(Cartao.class, "ID Cartão não pode ser Zerado!");
        }

        if (lancamento.getDescricao() == null){
            throw new org.hibernate.ObjectNotFoundException(Cartao.class, "Descrição não pode estar em Branco!");
        }

        Optional<Cartao> cartaoOptional =  cartaoRepository.findById(lancamento.getIdCartao());

        if (cartaoOptional.isPresent()){
            Cartao cartaoData = cartaoOptional.get();
            if (cartaoData.getTipoDeStatus() == TipoDeStatus.FALSE){
                    throw new org.hibernate.ObjectNotFoundException(Cartao.class, "Cartão Não está Ativo!");
            }else{
                    Cartao cartaoObjeto = cartaoRepository.save(cartaoData);
                    Lancamento lancamentoObjeto = lancamentoRepository.save(lancamento);
                    return lancamentoObjeto;
            }
         }
        throw new org.hibernate.ObjectNotFoundException(Cartao.class, "Cartão Inexistente no Cadastro!");
    }

    public Optional<Lancamento> buscarPorId(int id) {
        Optional <Lancamento> lancamentoOptional =lancamentoRepository.findById(id);
        return lancamentoOptional;
    }

    public Iterable<Lancamento> buscarTodosLancamentos(){
        Iterable<Lancamento> lancamentos = lancamentoRepository.findAll();
        return lancamentos;
    }
}
