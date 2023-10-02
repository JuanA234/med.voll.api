/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Record.java to edit this template
 */
package med.voll.api.domain.consulta;

import java.time.LocalDateTime;

/**
 *
 * @author JuanAndres
 */
public record DatosDetalleConsulta(Long id, 
        Long idPaciente, 
        Long idMedico, 
        
        LocalDateTime fecha) {

    public DatosDetalleConsulta(Consulta consulta) {
       this(consulta.getId(), consulta.getPaciente().getId(), consulta.getMedico().getId(),consulta.getFecha()); 
    }

}
    