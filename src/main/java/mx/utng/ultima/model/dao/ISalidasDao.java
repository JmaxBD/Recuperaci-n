package mx.utng.ultima.model.dao;


import java.util.List;

import mx.utng.ultima.model.entity.Salidas;


public interface ISalidasDao {
    //Estos metodos son abstractos no tienen cuerpo
    
    //Listar estudiantes
    List<Salidas> list();

    //Guardar un estudiante
    void save(Salidas salidas);

    //Obterner un estudiante en especifico a partir del id
    Salidas getById(Long id);

    //Eliminar un estudiante por el id
    void delete(Long id);
}


