package com.senacead.B.CLweb.service;

import com.senacead.B.CLweb.model.Cliente;
import com.senacead.B.CLweb.model.Venda;
import com.senacead.B.CLweb.repository.ClienteRepository;
import com.senacead.B.CLweb.repository.VendaRepository;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class VendaService {

    @Autowired
    private VendaRepository vendaRepository;
    @Autowired
    private ClienteRepository clienteRepository;

    // GET - listar todos
    public List<Venda> listarTodos() {
        return vendaRepository.findAll();
    }

    // GET - buscar por id
    public Venda buscarPorId(Long id) {
        return vendaRepository.findById(id).orElseThrow(() -> new RuntimeException("Venda não encontrada"));
    }

    // POST - cadastrar venda
    public Venda salvar(Long clienteId, Venda venda) {
        Cliente cliente = clienteRepository.findById(clienteId).orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
        venda.setCliente(cliente);
        venda.setNomeCliente(cliente.getNomeCliente());
        return vendaRepository.save(venda);
    }

    // PUT - atualizar venda
    public Venda atualizar(Long id, Long clienteId, Venda novo) {
        Venda venda = buscarPorId(id);

        venda.setStatus(novo.getStatus());
        venda.setDataVenda(novo.getDataVenda());
        venda.setValorTotal(novo.getValorTotal());
        venda.setModoPagamento(novo.getModoPagamento());
        venda.setPendente(novo.getPendente());
        venda.setNomeCliente(novo.getNomeCliente());

        return vendaRepository.save(venda);
    }

    // DELETE - excluir venda
    public void deletar(Long id) {
        vendaRepository.deleteById(id);
    }

}
