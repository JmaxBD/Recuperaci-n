package mx.utng.ultima.model.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.utng.ultima.model.dao.IDeseoDao;
import mx.utng.ultima.model.entity.Deseo;

/*
 * Una clase service, esta basada en el patron de diseño facade.
 * Un unico punto de acceso hacia distintos DAOS (Datas and objects).
 * Dentro de la clase service podemos operar distintas clases DAO.
 */
@Service
public class DeseoServiceImpl implements IDeseoService{

    //Inyecta una interfaz para utilizar sus metodos
    @Autowired
    private IDeseoDao deseoDao;

    @Transactional(readOnly = true)
    @Override
    public List<Deseo> list() {
        return deseoDao.list();
    }

    @Transactional
    @Override
    public void save(Deseo deseo) {
        deseoDao.save(deseo);
    }

    @Transactional(readOnly = true)
    @Override
    public Deseo getById(Long id) {
        return deseoDao.getById(id);
    }

    @Transactional
    @Override
    public void delete(Long id) {
        deseoDao.delete(id);
    }
    
}

