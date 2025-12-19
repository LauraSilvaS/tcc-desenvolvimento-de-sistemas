
package com.senacead.B.CLweb.service;

import com.senacead.B.CLweb.model.Fornecedor;
import com.senacead.B.CLweb.repository.FornecedorRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FornecedorService {
      @Autowired
    private FornecedorRepository fornecedorRepository;
    
     // GET - listar todos
    public List<Fornecedor> listarTodos(){
        return fornecedorRepository.findAll();
    }
    
    // GET - buscar por id
    public Fornecedor buscarPorId(Long id){
        return fornecedorRepository.findById(id).orElseThrow(() -> new RuntimeException("Fornecedor não encontrado"));
    }
    
    // POST - cadastrar fornecedor
    public Fornecedor salvar (Fornecedor fornecedor){
        return fornecedorRepository.save(fornecedor);
    }
    // PUT - atualizar fornecedor
    public Fornecedor atualizar(Long id, Fornecedor novo){
        Fornecedor fornecedor = buscarPorId(id);
        
        fornecedor.setNomeFornecedor(novo.getNomeFornecedor());
        fornecedor.setContato(novo.getContato());
        fornecedor.setObservacoes(novo.getObservacoes());
        
        
        return fornecedorRepository.save(fornecedor);
    }
    
     // DELETE - excluir fornecedor
    public void deletar(Long id){
        fornecedorRepository.deleteById(id);
    }
    
    
}
