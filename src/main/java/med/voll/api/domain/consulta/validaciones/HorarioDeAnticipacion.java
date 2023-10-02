/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package med.voll.api.domain.consulta.validaciones;

import jakarta.validation.ValidationException;
import java.time.Duration;
import java.time.LocalDateTime;
import med.voll.api.domain.consulta.DatosAgendarConsulta;

/**
 *
 * @author JuanAndres
 */


public class HorarioDeAnticipacion implements ValidadorDeConsultas{
    
    public void validar(DatosAgendarConsulta datosAgendarConsulta){
        var ahora = LocalDateTime.now();
        var horaDeConsulta = datosAgendarConsulta.fecha();
        
        var diferencia30min=Duration.between(ahora, horaDeConsulta).toMinutes()<30;
        
        if(diferencia30min){
            throw new ValidationException("Las consultas deben programarse con al menos 30 minutos "
                    + "de anticipación");
        }
    }
    
}
