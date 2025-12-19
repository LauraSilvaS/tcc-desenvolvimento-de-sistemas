
package com.senacead.B.CLweb.repository;

import com.senacead.B.CLweb.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProdutoRepository extends JpaRepository<Produto, Long>{
    
}
