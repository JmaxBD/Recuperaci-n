package mx.utng.ultima.model.service;


import java.util.List;

import mx.utng.ultima.model.entity.Deseo;



public interface IDeseoService {
    List<Deseo> list();
    void save(Deseo deseo);
    Deseo getById(Long id);
    void delete(Long id);
}

