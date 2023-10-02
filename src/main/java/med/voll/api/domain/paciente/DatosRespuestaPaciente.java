/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Record.java to edit this template
 */
package med.voll.api.domain.paciente;

import med.voll.api.domain.direccion.DatosDireccion;

/**
 *
 * @author JuanAndres
 */
public record DatosRespuestaPaciente(
        
        Long id,
        String nombre,
        String email,
        String telefono,
        String documento,
        DatosDireccion direccion
        
        ) {

    public DatosRespuestaPaciente(Paciente paciente) {
        this(paciente.getId(), paciente.getNombre(), paciente.getEmail(), paciente.getTelefono(),paciente.getDocumento(),
        new DatosDireccion(paciente.getDatosDireccion().getCalle(), paciente.getDatosDireccion().getDistrito(), 
                paciente.getDatosDireccion().getCiudad(), paciente.getDatosDireccion().getNumero(), 
                paciente.getDatosDireccion().getComplemento(), paciente.getDatosDireccion().getUrbanizacion(), 
                paciente.getDatosDireccion().getComplemento(), paciente.getDatosDireccion().getProvincia()));
    }
    

}
