
package com.senacead.B.CLweb.service;

import com.senacead.B.CLweb.model.ItemVenda;
import com.senacead.B.CLweb.model.Produto;
import com.senacead.B.CLweb.model.Venda;
import com.senacead.B.CLweb.repository.ItemVendaRepository;
import com.senacead.B.CLweb.repository.ProdutoRepository;
import com.senacead.B.CLweb.repository.VendaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ItemVendaService {
    @Autowired
        private ItemVendaRepository itemVendaRepository;
    @Autowired
    private ProdutoRepository produtoRepository;
    @Autowired
    private VendaRepository vendaRepository;
    
    // GET - listar todos
    public List<ItemVenda> listarTodos(){
       return itemVendaRepository.findAll();
    }
    
    // GET - buscar por id
    public ItemVenda buscarPorId(Long id){
        return itemVendaRepository.findById(id).orElseThrow(() -> new RuntimeException("Item da Venda não encontrado"));
    } 
    
    // POST - cadastrar ItemVenda
    public ItemVenda salvar(ItemVenda itemVenda){
        return itemVendaRepository.save(itemVenda);
    }
    
    // PUT - atualizar ItemVenda
    public ItemVenda atualizar(Long id,ItemVenda novo){
        ItemVenda itemVenda = buscarPorId(id);
        itemVenda.setNomeProduto(novo.getNomeProduto());
        itemVenda.setQuantidade(novo.getQuantidade());
        itemVenda.setValorUnitario(novo.getValorUnitario());
       
        
        return itemVendaRepository.save(itemVenda);
    }
    
    // DELETE - excluir itemVenda
    public void deletar(Long id){
        itemVendaRepository.deleteById(id);
    }
    
    //Adicionar produto
    public Produto adicionarProduto (Long idItemVenda, Produto produto){
        ItemVenda itemVenda = buscarPorId(idItemVenda);
        Produto produtoSalvo = produtoRepository.save(produto);
        itemVenda.setProduto(produtoSalvo);
        itemVenda.setNomeProduto(produtoSalvo.getNomeProduto());
        
        itemVendaRepository.save(itemVenda);
        return produtoSalvo;
    }
    
    public Venda adicionarVenda (Long idItemVenda, Venda venda){
        ItemVenda itemVenda = buscarPorId(idItemVenda);
        Venda vendaSalva = vendaRepository.save(venda);
        itemVenda.setVenda(vendaSalva);
        
        itemVendaRepository.save(itemVenda);
        return vendaSalva;
    }
}
