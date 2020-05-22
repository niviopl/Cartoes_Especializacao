package com.br.cartoes.cartoes.services;

import com.br.cartoes.cartoes.models.Cliente;
import com.br.cartoes.cartoes.repositories.ClienteRepository;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;


    public Cliente salvarCliente(Cliente cliente){
        Cliente clienteObjeto = clienteRepository.save(cliente);
        return clienteObjeto;
    }

    public Optional<Cliente> buscarPorId(int id){
        Optional<Cliente> clienteOptional = clienteRepository.findById(id);
        return clienteOptional;
    }

    public Iterable<Cliente> buscarTodosClientes(){
        Iterable<Cliente> clientes = clienteRepository.findAll();
        return clientes;
    }

    public Cliente atualizarCliente(Cliente cliente) throws ObjectNotFoundException{
        Optional<Cliente> clienteOptional = buscarPorId(cliente.getId());
        if (clienteOptional.isPresent()){
            Cliente clienteData = clienteOptional.get();
            if (cliente.getNome()== null){
                cliente.setNome(clienteData.getNome());
            }
            if (cliente.getCpf()== null){
                cliente.setCpf(clienteData.getCpf());
            }
            if (cliente.getDataNascimento()== null){
                cliente.setDataNascimento(clienteData.getDataNascimento());
            }
            if (cliente.getEmail()== null){
                cliente.setEmail(clienteData.getEmail());
            }
            Cliente clienteObjeto = clienteRepository.save(cliente);
            return clienteObjeto;
       }
        throw new ObjectNotFoundException(Cliente.class, "O Cliente não foi encontrado");
    }

    public void deletarCliente(Cliente cliente){
        clienteRepository.delete(cliente);
    }
}
