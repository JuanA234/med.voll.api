/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package med.voll.api.controller;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import java.net.URI;
import med.voll.api.domain.direccion.DatosDireccion;
import med.voll.api.domain.medico.DatosActualizarMedico;
import med.voll.api.domain.medico.DatosListadoMedico;
import med.voll.api.domain.medico.DatosRegistroMedico;
import med.voll.api.domain.medico.DatosRespuestaMedico;
import med.voll.api.domain.medico.Medico;
import med.voll.api.domain.medico.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

/**
 *
 * @author JuanAndres
 */
@RestController
@RequestMapping("/medicos")
@SecurityRequirement(name = "bearer-key")
public class MedicoController {

    @Autowired
    private MedicoRepository medicoRepository;

    @PostMapping
    public ResponseEntity<DatosRespuestaMedico> registrarMedico(@RequestBody @Valid DatosRegistroMedico datosRegistroMedico,
            UriComponentsBuilder uriComponentsBuilder) {
        Medico medico = medicoRepository.save(new Medico(datosRegistroMedico));
        DatosRespuestaMedico datosRespuestaMedico = new DatosRespuestaMedico(medico.getId(),
                medico.getNombre(), medico.getEmail(),
                medico.getDocumento(), medico.getTelefono(), new DatosDireccion(medico.getDireccion().getCalle(),
                medico.getDireccion().getDistrito(), medico.getDireccion().getCiudad(),
                medico.getDireccion().getNumero(), medico.getDireccion().getComplemento(),
                medico.getDireccion().getUrbanizacion(), medico.getDireccion().getCodigoPostal(),
                medico.getDireccion().getProvincia()));
        
        URI url= uriComponentsBuilder.path("/medicos/{id}").buildAndExpand(medico.getId()).toUri();
        return ResponseEntity.created(url).body(datosRespuestaMedico);
    }

    @GetMapping
    public ResponseEntity<Page<DatosListadoMedico>> listadoMedicos(@PageableDefault(size = 10, sort = "nombre") Pageable paginacion) {
        //return medicoRepository.findAll(paginacion).map(DatosListadoMedico::new);
        return ResponseEntity.ok(medicoRepository.findByActivoTrue(paginacion).map(DatosListadoMedico::new));

    }

    @PutMapping
    @Transactional
    public ResponseEntity<DatosRespuestaMedico> actualizarMedico(@RequestBody @Valid DatosActualizarMedico datosActualizarMedico) {
        Medico medico = medicoRepository.getReferenceById(datosActualizarMedico.id());
        medico.actualizarDatos(datosActualizarMedico);
        return ResponseEntity.ok(new DatosRespuestaMedico(medico.getId(),medico.getNombre(), medico.getEmail(),
                medico.getDocumento(), medico.getTelefono(), new DatosDireccion(medico.getDireccion().getCalle(),
                medico.getDireccion().getDistrito(), medico.getDireccion().getCiudad(),
                medico.getDireccion().getNumero(), medico.getDireccion().getComplemento(),
                medico.getDireccion().getUrbanizacion(), medico.getDireccion().getCodigoPostal(),
                medico.getDireccion().getProvincia())));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity eliminarMedico(@PathVariable Long id) {
        Medico medico = medicoRepository.getReferenceById(id);
        medico.desactivarMedico();
        return ResponseEntity.noContent().build();
    }
    
     @GetMapping("/{id}")
    public ResponseEntity<DatosRespuestaMedico> obtenerMedico(@PathVariable Long id) {
        Medico medico = medicoRepository.getReferenceById(id);
        var datosMedico = new DatosRespuestaMedico(medico.getId(),medico.getNombre(), medico.getEmail(),
                medico.getDocumento(), medico.getTelefono(), new DatosDireccion(medico.getDireccion().getCalle(),
                medico.getDireccion().getDistrito(), medico.getDireccion().getCiudad(),
                medico.getDireccion().getNumero(), medico.getDireccion().getComplemento(),
                medico.getDireccion().getUrbanizacion(), medico.getDireccion().getCodigoPostal(),
                medico.getDireccion().getProvincia()));
        return ResponseEntity.ok(datosMedico);
    }
//    public void eliminarMedico(@PathVariable Long id) {
//        Medico medico = medicoRepository.getReferenceById(id);
//        medicoRepository.delete(medico);
//    }
}
