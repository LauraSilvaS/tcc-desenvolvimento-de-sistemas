
package com.senacead.B.CLweb.repository;


import com.senacead.B.CLweb.model.Login;
import org.springframework.data.jpa.repository.JpaRepository;


public interface LoginRepository extends JpaRepository<Login, Long>{
    
    Login findByEmail(String email);
}
