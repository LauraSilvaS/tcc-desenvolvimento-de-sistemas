
package com.senacead.B.CLweb.service;

import com.senacead.B.CLweb.model.Login;
import com.senacead.B.CLweb.repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
    
    @Autowired
    private LoginRepository repository;
    
    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
    
    public Login cadastrar(Login login, String senhaPura){
       String hash = encoder.encode(senhaPura);
        login.setSenhaHash(hash);
        return repository.save(login);
    }
    
    public boolean autenticar(String email, String senhaPura){
        Login login = repository.findByEmail(email);
        
        if (login == null){
            return false;
        }
        return encoder.matches(senhaPura, login.getSenhaHash());
    }
    
    
}
