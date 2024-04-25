package mx.utng.ultima.model.dao;


import java.util.List;

import mx.utng.ultima.model.entity.Venta;



public interface IVentaDao {
    //Estos metodos son abstractos no tienen cuerpo
    
    //Listar estudiantes
    List<Venta> list();

    //Guardar un estudiante
    void save(Venta venta);

    //Obterner un estudiante en especifico a partir del id
    Venta getById(Long id);

    //Eliminar un estudiante por el id
    void delete(Long id);
}


