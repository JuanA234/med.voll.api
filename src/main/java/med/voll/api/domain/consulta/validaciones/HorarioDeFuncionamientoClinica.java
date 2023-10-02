/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package med.voll.api.domain.consulta.validaciones;

import jakarta.validation.ValidationException;
import java.time.DayOfWeek;
import med.voll.api.domain.consulta.DatosAgendarConsulta;
import org.springframework.stereotype.Component;

/**
 *
 * @author JuanAndres
 */
@Component
public class HorarioDeFuncionamientoClinica implements ValidadorDeConsultas{
    
    public void validar(DatosAgendarConsulta datos){
        var domingo = DayOfWeek.SUNDAY.equals(datos.fecha().getDayOfWeek());
        
        var antesDeApertura=datos.fecha().getHour()<7;
        var despuesDeCierre=datos.fecha().getHour()>19;
        
        if(domingo||antesDeApertura||despuesDeCierre){
           throw new ValidationException("El horario de atención de la clínica es de lunes a sabado, de"
                   + " 07:00 a 19:00 horas");     
        }
    }
}
