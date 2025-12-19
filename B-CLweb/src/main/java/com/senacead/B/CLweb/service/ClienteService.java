
package com.senacead.B.CLweb.service;

import com.senacead.B.CLweb.model.Cliente;
import com.senacead.B.CLweb.repository.ClienteRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {
    
    @Autowired
    private ClienteRepository clienteRepository;
    
     // GET - listar todos
    public List<Cliente> listarTodos(){
        return clienteRepository.findAll();
    }
    
    // GET - buscar por id
    public Cliente buscarPorId(Long id){
        return clienteRepository.findById(id).orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
    }
    
    // POST - cadastrar cliente
    public Cliente salvar (Cliente cliente){
        return clienteRepository.save(cliente);
    }
    // PUT - atualizar cliente
    public Cliente atualizar(Long id, Cliente novo){
        Cliente cliente = buscarPorId(id);
        
        cliente.setNomeCliente(novo.getNomeCliente());
        cliente.setContato(novo.getContato());
        cliente.setPagamentoPendente(novo.getPagamentoPendente());
        
        return clienteRepository.save(cliente);
    }
    
     // DELETE - excluir cliente
    public void deletar(Long id){
        clienteRepository.deleteById(id);
    }
    
    
}
