/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package med.voll.api.domain.consulta.validaciones;

import jakarta.validation.ValidationException;
import med.voll.api.domain.consulta.DatosAgendarConsulta;
import med.voll.api.domain.medico.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author JuanAndres
 */

@Component
public class MedicoActivo implements ValidadorDeConsultas{
    @Autowired
      private MedicoRepository medicoRepository;
      
      
    public void validar(DatosAgendarConsulta datosAgendarConsulta){
        
        if(datosAgendarConsulta.idMedico()==null){
            return;
        }
        
       var medicoActivo = medicoRepository.findActivoById(datosAgendarConsulta.idMedico());
       
       if(!medicoActivo){
           throw new ValidationException("No se puede agendar citas con médicos inactivos en el sistema");
       }
    }
}
