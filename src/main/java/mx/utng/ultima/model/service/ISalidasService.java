package mx.utng.ultima.model.service;


import java.util.List;

import mx.utng.ultima.model.entity.Salidas;

public interface ISalidasService {
    List<Salidas> list();
    void save(Salidas salidas);
    Salidas getById(Long id);
    void delete(Long id);
}

