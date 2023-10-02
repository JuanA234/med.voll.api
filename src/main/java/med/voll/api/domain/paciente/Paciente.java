/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package med.voll.api.domain.paciente;

import jakarta.annotation.Generated;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.voll.api.domain.direccion.DatosDireccion;
import med.voll.api.domain.direccion.Direccion;

/**
 *
 * @author JuanAndres
 */

@Entity(name="paciente")
@Table(name="pacientes")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Paciente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nombre;
    private String email;
    private String telefono;
    private String documento;
    private boolean activo;
    @Embedded
    private Direccion datosDireccion;

    public Paciente(DatosRegistroPaciente datosRegistroPaciente){
        this.activo = true;
        this.nombre = datosRegistroPaciente.nombre();
        this.telefono = datosRegistroPaciente.telefono();
        this.email = datosRegistroPaciente.email();
        this.documento = datosRegistroPaciente.documento();
        this.datosDireccion = new Direccion(datosRegistroPaciente.direccion());
    }

    public void actualizarDatos(DatosActualizarPaciente datosActualizarPaciente) {
        if(datosActualizarPaciente.nombre()!= null){
            this.nombre = datosActualizarPaciente.nombre();
        }
        if(datosActualizarPaciente.direccion()!= null){
            this.datosDireccion = datosDireccion.actualizarDireccion(datosActualizarPaciente.direccion());
        }
        if(datosActualizarPaciente.telefono()!= null){
            this.telefono = datosActualizarPaciente.telefono();
        }
    }
    
    public void desactivar(){
        this.activo = false;
    }
    
}
