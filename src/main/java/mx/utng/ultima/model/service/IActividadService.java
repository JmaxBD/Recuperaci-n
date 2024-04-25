package mx.utng.ultima.model.service;


import java.util.List;

import mx.utng.ultima.model.entity.Actividad;



public interface IActividadService {
    List<Actividad> list();
    void save(Actividad actividad);
    Actividad getById(Long id);
    void delete(Long id);
}

