package com.br.cartoes.cartoes.controllers;


import com.br.cartoes.cartoes.models.Cliente;
import com.br.cartoes.cartoes.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/Cliente")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public Iterable<Cliente> buscarTodosClientes(){
        return clienteService.buscarTodosClientes();
    }

    @GetMapping("/{id}")
    public Cliente buscarCliente(@PathVariable Integer id) {
        return clienteService.buscarPorId(id);
        //Optional<Cliente> clienteOptional = clienteService.buscarPorId(id);
        //if (clienteOptional.isPresent()) {
         //  return clienteOptional.get();
        //} else {
         //   throw new ResponseStatusException(HttpStatus.NO_CONTENT);
        //}
    }

    @PostMapping
    public ResponseEntity<Cliente> salvarCliente(@RequestBody @Valid Cliente cliente){
        Cliente clienteObjeto = clienteService.salvarCliente(cliente);
        return ResponseEntity.status(201).body(clienteObjeto);
    }

    //@PutMapping("/{id}")
    //public Cliente atualizarCliente(@PathVariable Integer id, @RequestBody Cliente cliente){
    //    cliente.setId(id);
     //   try {
     //       Cliente clienteObjeto = clienteService.atualizarCliente(cliente);
     //       return clienteObjeto;
     //   }catch (Exception e){
      //      throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getLocalizedMessage());
     //   }
    //}

    //@DeleteMapping("/{id}")
    //public Cliente deletarCliente(@PathVariable Integer id){
     //   Optional<Cliente> clienteOptional = clienteService.buscarPorId(id);
     //   if (clienteOptional.isPresent()){
     //       clienteService.deletarCliente(clienteOptional.get());
      //      return clienteOptional.get();
     //   }
     //   throw new ResponseStatusException(HttpStatus.NO_CONTENT);
    //}

}
