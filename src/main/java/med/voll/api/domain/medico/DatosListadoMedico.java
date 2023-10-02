/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Record.java to edit this template
 */
package med.voll.api.domain.medico;

/**
 *
 * @author JuanAndres
 */
public record DatosListadoMedico(Long id,String nombre ,String especialidad,String documento,String email){

    public DatosListadoMedico(Medico medico) {
        this(medico.getId(),medico.getNombre(), medico.getEspecialidad().toString(), medico.getDocumento(), medico.getEmail());
    }

}
