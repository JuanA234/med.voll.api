/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Record.java to edit this template
 */
package med.voll.api.domain.medico;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import med.voll.api.domain.direccion.DatosDireccion;

/**
 *
 * @author JuanAndres
 */
public record DatosRegistroMedico(
        @NotBlank 
        String nombre, 
        
        @NotBlank
        @Email
        String email, 
        
        @NotBlank
        String telefono,
        
        @NotBlank
        @Pattern(regexp = "\\d{4,6}")
        String documento, 
        
        @NotNull
        Especialidad especialidad, 
        
        @NotNull
        @Valid
        DatosDireccion direccion) {

}
