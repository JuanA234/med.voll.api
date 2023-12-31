/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package med.voll.api.domain.paciente;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author JuanAndres
 */
@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Long>{

   Page<Paciente>findAllByActivoTrue(Pageable paginacion);

//   @Query("""
//          select p.activo 
//          from Paciente p
//          where p.id=:idPaciente
//          """)
//   boolean findActivoById(Long idPaciente);
//   
   @Query("""
            select p.activo
            from paciente p
            where p.id=:idPaciente 
            """)
    Boolean findActivoById(Long idPaciente);
    
}


