package mx.utng.ultima.model.service;


import java.util.List;

import mx.utng.ultima.model.entity.Venta;



public interface IVentaService {
    List<Venta> list();
    void save(Venta venta);
    Venta getById(Long id);
    void delete(Long id);
}

