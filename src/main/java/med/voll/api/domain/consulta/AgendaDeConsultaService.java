/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package med.voll.api.domain.consulta;

import java.util.List;
import med.voll.api.domain.consulta.desafio.ValidadorDeCancelamientos;
import med.voll.api.domain.consulta.validaciones.ValidadorDeConsultas;
import med.voll.api.domain.medico.Medico;
import med.voll.api.domain.medico.MedicoRepository;
import med.voll.api.domain.paciente.Paciente;
import med.voll.api.domain.paciente.PacienteRepository;
import med.voll.api.infra.errores.ValidacionDeIntegridad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author JuanAndres
 */

@Service
public class AgendaDeConsultaService {
    
    
    
    @Autowired
    private PacienteRepository pacienteRepository;
    
    @Autowired
    private MedicoRepository medicoRepository;
    
    @Autowired
    private ConsultaRepository consultaRepository;
    
    @Autowired
    List<ValidadorDeConsultas> validadores;
    
    @Autowired
    List<ValidadorDeCancelamientos> validadoresCancelamiento;
    
        public DatosDetalleConsulta agendar(DatosAgendarConsulta datosAgendarConsulta){
        
        if(!pacienteRepository.findById(datosAgendarConsulta.idPaciente()).isPresent()){
            throw new ValidacionDeIntegridad("Este id para el paciente no fue encontrado");
        }
        
        if(datosAgendarConsulta.idMedico()!=null && !medicoRepository.existsById(datosAgendarConsulta.idMedico())){
                 throw new ValidacionDeIntegridad("Este id para el medico no fue encontrado");
        }
        
        validadores.forEach(v->v.validar(datosAgendarConsulta));
        
        var paciente =  pacienteRepository.findById(datosAgendarConsulta.idPaciente()).get();
        
        var medico =  seleccionarMedico(datosAgendarConsulta);
        
         if(medico==null){
            throw new ValidacionDeIntegridad("no existen medicos disponibles para este horario y especialidad");
        }
        
        var consulta = new Consulta(medico, paciente, datosAgendarConsulta.fecha());
       
        consultaRepository.save(consulta);
        
        return new DatosDetalleConsulta(consulta);
    }
        
       
    public void cancelar(DatosCancelamientoConsulta datos){
        if(!consultaRepository.existsById(datos.idConsulta())){
            throw new ValidacionDeIntegridad("Id de la consulta de informada no existe");
        }
        
        validadoresCancelamiento.forEach(v->v.validar(datos));
        
        var consulta = consultaRepository.getReferenceById(datos.idConsulta());
        consulta.cancelar(datos.motivo());
        
    }

    private Medico seleccionarMedico(DatosAgendarConsulta datosAgendarConsulta) {
        
        if(datosAgendarConsulta.idMedico()!=null){
            return medicoRepository.getReferenceById(datosAgendarConsulta.idMedico());
        }
        if(datosAgendarConsulta.especialidad()==null){
            throw new ValidacionDeIntegridad("debe seleccionarse una especialidad para el medico");
        }
        
        return medicoRepository.seleccionarMedicoConEspecialidadEnFecha(
                datosAgendarConsulta.especialidad(), datosAgendarConsulta.fecha());
    }
}
