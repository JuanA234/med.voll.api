/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package med.voll.api.domain.usuarios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

/**
 *
 * @author JuanAndres
 */
public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

  UserDetails findByLogin(String username);
    
}
