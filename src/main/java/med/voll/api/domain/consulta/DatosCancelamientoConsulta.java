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
public record DatosCancelamientoConsulta(Long idConsulta, MotivoCancelamiento motivo, LocalDateTime fecha) {

}
