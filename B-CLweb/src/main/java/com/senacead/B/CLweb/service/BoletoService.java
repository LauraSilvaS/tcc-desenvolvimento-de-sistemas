
package com.senacead.B.CLweb.service;

import com.senacead.B.CLweb.model.Boleto;

import com.senacead.B.CLweb.model.Fornecedor;
import com.senacead.B.CLweb.repository.BoletoRepository;
import com.senacead.B.CLweb.repository.FornecedorRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class BoletoService {

    @Autowired
    private BoletoRepository boletoRepository;

    @Autowired
    private FornecedorRepository fornecedorRepository;

    public List<Boleto> listarTodos() {
        return boletoRepository.findAll();
    }

    public Boleto buscarPorId(Long id) {
        return boletoRepository.findById(id).orElseThrow(() -> new RuntimeException("Boleto não encontrado"));
    }

    public Boleto salvar(Long fornecedorId, Boleto boleto) {

        Fornecedor fornecedor = fornecedorRepository.findById(fornecedorId).orElseThrow(() -> new RuntimeException("Fornecedor não encontrado"));
        boleto.setFornecedor(fornecedor);
        boleto.setNomeFornecedor(fornecedor.getNomeFornecedor());
        return boletoRepository.save(boleto);
    }

    public Boleto atualizar(Long id, Boleto novo) {

        Boleto boleto = buscarPorId(id);

        boleto.setDataVencimento(novo.getDataVencimento());
        boleto.setValor(novo.getValor());
        boleto.setNomeFornecedor(novo.getNomeFornecedor());
        
        return boletoRepository.save(boleto);
    }

    public void deletar(Long id) {
        boletoRepository.deleteById(id);
    }
}
