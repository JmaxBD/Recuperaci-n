package mx.utng.ultima.model.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import mx.utng.ultima.model.dao.IActividadDao;
import mx.utng.ultima.model.entity.Actividad;
/*
 * Una clase service, esta basada en el patron de diseño facade.
 * Un unico punto de acceso hacia distintos DAOS (Datas and objects).
 * Dentro de la clase service podemos operar distintas clases DAO.
 */
@Service
public class ActividadServiceImpl implements IActividadService{

    //Inyecta una interfaz para utilizar sus metodos
    @Autowired
    private IActividadDao actividadDao;

    @Transactional(readOnly = true)
    @Override
    public List<Actividad> list() {
        return actividadDao.list();
    }

    @Transactional
    @Override
    public void save(Actividad actividad) {
        actividadDao.save(actividad);
    }

    @Transactional(readOnly = true)
    @Override
    public Actividad getById(Long id) {
        return actividadDao.getById(id);
    }

    @Transactional
    @Override
    public void delete(Long id) {
        actividadDao.delete(id);
    }
    
}

