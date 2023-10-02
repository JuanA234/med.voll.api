/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Record.java to edit this template
 */
package med.voll.api.domain.medico;

import med.voll.api.domain.direccion.DatosDireccion;
/**
 *
 * @author JuanAndres
 */
public record DatosRespuestaMedico( 
        
        Long id,
        String nombre, 
        
        String email, 
        String documento, 
        
        String telefono,
        DatosDireccion direccion
        
        
        ) {

}
