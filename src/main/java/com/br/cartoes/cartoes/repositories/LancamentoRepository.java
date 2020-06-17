package com.br.cartoes.cartoes.repositories;

import com.br.cartoes.cartoes.models.Lancamento;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface LancamentoRepository extends CrudRepository<Lancamento, Integer> {

    List<Lancamento> findAllByCartao_id(int cartao_id);
}
