/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package med.voll.api.domain.medico;

import java.time.LocalDateTime;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author JuanAndres
 */
public interface MedicoRepository extends JpaRepository<Medico, Long> {

    Page<Medico> findByActivoTrue(Pageable paginacion);
    
    @Query("""
           select m from medico m
           where m.activo= true 
           and
           m.especialidad=:especialidad 
           and
           m.id not in(
           select c.medico.id from consulta c
           where
           c.fecha=:fecha
           )
           order by rand()
           limit 1
           """)
            
    Medico seleccionarMedicoConEspecialidadEnFecha(Especialidad especialidad, LocalDateTime fecha);

    @Query("""
           select m.activo
           from medico m
           where m.id=:idMedico
           """)
    Boolean findActivoById(Long idMedico);
    
}
