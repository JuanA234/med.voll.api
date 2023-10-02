/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Record.java to edit this template
 */
package med.voll.api.domain.direccion;

import jakarta.validation.constraints.NotBlank;

/**
 *
 * @author JuanAndres
 */
public record DatosDireccion(
        @NotBlank
        String calle,
        @NotBlank
        String distrito,
        @NotBlank
        String ciudad,
        @NotBlank
        String numero,
        @NotBlank
        String complemento,
        @NotBlank
        String urbanizacion,
        @NotBlank
        String codigoPostal,
        @NotBlank
        String provincia) {

}
