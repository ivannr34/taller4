package pa.actividad.service;


import pa.actividad.modelo.Actividad;

import pa.actividad.repository.ActividadRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Lógica de negocio
 */
@Service
public class ActividadService {

    private final ActividadRepository repository;

    public ActividadService(ActividadRepository repository) {
        this.repository = repository;
    }

    public Actividad crearActividad(Actividad actividad) {
        return repository.save(actividad);
    }

    public List<Actividad> obtenerTodas() {
        return repository.findAll();
    }

    public Optional<Actividad> obtenerPorId(Long id) {
        return repository.findById(id);
    }

    public Actividad actualizar(Long id, Actividad nueva) {
        return repository.findById(id).map(act -> {
            act.setTitulo(nueva.getTitulo());
            act.setDescripcion(nueva.getDescripcion());
            act.setFechaInicio(nueva.getFechaInicio());
            act.setFechaFin(nueva.getFechaFin());
            act.setIdQuehacer(nueva.getIdQuehacer());
            act.setIdTutor(nueva.getIdTutor());
            act.setIdHijo(nueva.getIdHijo());
            return repository.save(act);
        }).orElseThrow(() -> new RuntimeException("Actividad no encontrada"));
    }

    public void eliminar(Long id) {
        repository.deleteById(id);
    }
}