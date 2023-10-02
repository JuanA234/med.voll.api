/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package med.voll.api.domain.consulta.validaciones;

import jakarta.validation.ValidationException;
import med.voll.api.domain.consulta.DatosAgendarConsulta;
import med.voll.api.domain.paciente.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author JuanAndres
 */

@Component
public class PacienteActivo implements ValidadorDeConsultas{
    
    @Autowired
    private PacienteRepository pacienteRepository;
    public void validar(DatosAgendarConsulta datosAgendarConsulta){
        
        if(datosAgendarConsulta.idPaciente()==null){
            return;
        }
        
       var  pacienteActivo = pacienteRepository.findActivoById(datosAgendarConsulta.idPaciente());
       
       if(!pacienteActivo){
           throw new ValidationException("No se puede  agendar citas con pacientes inactivos en el sistema");
       }
    }
}
