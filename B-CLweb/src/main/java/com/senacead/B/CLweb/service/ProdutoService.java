
package com.senacead.B.CLweb.service;

import com.senacead.B.CLweb.model.Fornecedor;
import com.senacead.B.CLweb.model.Produto;
import com.senacead.B.CLweb.repository.FornecedorRepository;
import com.senacead.B.CLweb.repository.ProdutoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProdutoService {
    @Autowired
    private ProdutoRepository produtoRepository;
    @Autowired
    private FornecedorRepository fornecedorRepository;
    
    // GET - listar todos
    public List<Produto> listarTodos(){
       return produtoRepository.findAll();
    }
    
    // GET - buscar por id
    public Produto buscarPorId(Long id){
        return produtoRepository.findById(id).orElseThrow(() -> new RuntimeException("Produto não encontrado"));
    } 
    
    // POST - cadastrar produto
    public Produto salvar(Long fornecedorId, Produto produto){
        Fornecedor fornecedor = fornecedorRepository.findById(fornecedorId).orElseThrow(() -> new RuntimeException("Fornecedor não encontrado"));
        produto.setFornecedor(fornecedor);
        produto.setNomeFornecedor(fornecedor.getNomeFornecedor());
        return produtoRepository.save(produto);
    }
    
    // PUT - atualizar produto
    public Produto atualizar(Long id, Produto novo){
        
        Produto produto = buscarPorId(id);
        
        produto.setNomeProduto(novo.getNomeProduto());
        produto.setEstoque(novo.getEstoque());
        produto.setCategoria(novo.getCategoria());
        produto.setPrecoCompra(novo.getPrecoCompra());
        produto.setPrecoVenda(novo.getPrecoVenda());
        produto.setDataValidade(novo.getDataValidade());
        produto.setCodigoBarras(novo.getCodigoBarras());
        produto.setNomeFornecedor(novo.getNomeFornecedor());
       
        
        return produtoRepository.save(produto);
    }
    
    // DELETE - excluir produto
    public void deletar(Long id){
        produtoRepository.deleteById(id);
    }
    
}
