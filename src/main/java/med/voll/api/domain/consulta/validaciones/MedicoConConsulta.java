/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package med.voll.api.domain.consulta.validaciones;

import jakarta.validation.ValidationException;
import med.voll.api.domain.consulta.ConsultaRepository;
import med.voll.api.domain.consulta.DatosAgendarConsulta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author JuanAndres
 */
@Component
public class MedicoConConsulta implements ValidadorDeConsultas{
 
    @Autowired
    private ConsultaRepository consultaRepository;
    
    public void validar(DatosAgendarConsulta datosAgendarConsulta){
        
        if(datosAgendarConsulta.idMedico()==null){
            return;
        }
        
        var medicoConConsulta = consultaRepository.existsByMedicoIdAndFecha(datosAgendarConsulta.idMedico(),datosAgendarConsulta.fecha()); 
    
        if(medicoConConsulta){
            throw new ValidationException("Este médico ya tiene una consulta agendada");
        }
    }
}
