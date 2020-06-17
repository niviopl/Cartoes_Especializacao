package com.br.cartoes.cartoes.repositories;

import com.br.cartoes.cartoes.models.Cartao;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CartaoRepository extends CrudRepository<Cartao, Integer> {

    Optional<Cartao> findByNumero(String numero);
}
