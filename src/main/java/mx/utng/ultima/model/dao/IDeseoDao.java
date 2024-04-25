package mx.utng.ultima.model.dao;


import java.util.List;

import mx.utng.ultima.model.entity.Deseo;



public interface IDeseoDao {
    //Estos metodos son abstractos no tienen cuerpo
    
    //Listar estudiantes
    List<Deseo> list();

    //Guardar un estudiante
    void save(Deseo deseo);

    //Obterner un estudiante en especifico a partir del id
    Deseo getById(Long id);

    //Eliminar un estudiante por el id
    void delete(Long id);
}


