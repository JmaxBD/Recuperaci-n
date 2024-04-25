package mx.utng.ultima.model.dao;


import java.util.List;

import mx.utng.ultima.model.entity.Actividad;



public interface IActividadDao {
    //Estos metodos son abstractos no tienen cuerpo
    
    //Listar estudiantes
    List<Actividad> list();

    //Guardar un estudiante
    void save(Actividad actividad);

    //Obterner un estudiante en especifico a partir del id
    Actividad getById(Long id);

    //Eliminar un estudiante por el id
    void delete(Long id);
}


