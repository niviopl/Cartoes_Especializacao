package com.br.cartoes.cartoes.services;

import com.br.cartoes.cartoes.enums.TipoDeLancamento;
import com.br.cartoes.cartoes.enums.TipoDeStatus;
import com.br.cartoes.cartoes.models.Cartao;
import com.br.cartoes.cartoes.models.Cliente;
import com.br.cartoes.cartoes.models.Lancamento;
import com.br.cartoes.cartoes.repositories.CartaoRepository;
import com.br.cartoes.cartoes.repositories.LancamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.support.Querydsl;
import org.springframework.stereotype.Service;

import javax.management.Query;
import java.util.List;
import java.util.Optional;
import java.util.logging.Filter;

@Service
public class LancamentoService {

    @Autowired
    private LancamentoRepository lancamentoRepository;

    @Autowired
    private CartaoService cartaoService;

    public List<Lancamento> listByCartao(int cartaoId) {
        return lancamentoRepository.findAllByCartao_id (cartaoId);
    }

    public Lancamento create(Lancamento lancamento) {
        Cartao cartao = cartaoService.getById(lancamento.getCartao().getId());
        lancamento.setCartao(cartao);
        return lancamentoRepository.save(lancamento);
    }


    public Optional<Lancamento> buscarPorId(int id) {
        Optional <Lancamento> lancamentoOptional =lancamentoRepository.findById(id);
        return lancamentoOptional;
    }

    public Iterable<Lancamento> buscarIdCartao(int id){
        Iterable<Lancamento> lancamentos = lancamentoRepository.findAll();
        //Iterable<Lancamento> LancamentoFiltrado = ;
        return lancamentos;
    }

    public Iterable<Lancamento> buscarTodosLancamentos(){
        Iterable<Lancamento> lancamentos = lancamentoRepository.findAll();
        return lancamentos;
    }
}
