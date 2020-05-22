package com.br.cartoes.cartoes.services;

import com.br.cartoes.cartoes.enums.TipoDeLancamento;
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
        Optional<Cartao> cartaoOptional =  cartaoRepository.findById(lancamento.getIdCartao());

        if (cartaoOptional.isPresent()){
            Cartao cartaoData = cartaoOptional.get();
            double limiteTotal = cartaoData.getLimiteTotal();
            double limiteAtual = cartaoData.getLimiteAtual();
            double excedido = 0;
            System.out.println("LancamentoService - getTipoDeLancamento(" + lancamento.getTipoDeLancamento() + ")");

            if (lancamento.getTipoDeLancamento().equals(TipoDeLancamento.DEBITO)){
                System.out.println("LancamentoService - DEBITO");
                limiteAtual -= lancamento.getValor();
                if (limiteAtual < 0){
                    throw new org.hibernate.ObjectNotFoundException(Cartao.class, "Saldo Insuficiente em Cartão!");
                }else{
                    cartaoData.setLimiteAtual(limiteAtual);
                    Cartao cartaoObjeto = cartaoRepository.save(cartaoData);
                    Lancamento lancamentoObjeto = lancamentoRepository.save(lancamento);
                    return lancamentoObjeto;
                }
             }

            if (lancamento.getTipoDeLancamento().equals(TipoDeLancamento.CREDITO)){
                limiteAtual += lancamento.getValor();
                if (limiteAtual > limiteTotal){
                    excedido = lancamento.getValor() - (limiteAtual - limiteTotal);
                    throw new org.hibernate.ObjectNotFoundException(Cartao.class, "Crédito não efetuado. Voce só poderá Creditar no máximo " + excedido);
                }else{
                    cartaoData.setLimiteAtual(limiteAtual);
                    Cartao cartaoObjeto = cartaoRepository.save(cartaoData);
                    Lancamento lancamentoObjeto = lancamentoRepository.save(lancamento);
                    return lancamentoObjeto;
                }
            }

            if (lancamento.getTipoDeLancamento().equals(TipoDeLancamento.ESTORNO)){
                limiteAtual += lancamento.getValor();
                    cartaoData.setLimiteAtual(limiteAtual);
                    Cartao cartaoObjeto = cartaoRepository.save(cartaoData);
                    Lancamento lancamentoObjeto = lancamentoRepository.save(lancamento);
                    return lancamentoObjeto;
            }

        }
        throw new org.hibernate.ObjectNotFoundException(Cartao.class, "Cartão Inexistente no Cadastro!");



     //************************************* antigo *************************************************
     //   Lancamento lancamentoObjeto = lancamentoRepository.save(lancamento);
     //   return lancamentoObjeto;
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
