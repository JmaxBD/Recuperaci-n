package mx.utng.ultima.model.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.utng.ultima.model.dao.ISalidasDao;
import mx.utng.ultima.model.entity.Salidas;

/*
 * Una clase service, esta basada en el patron de diseño facade.
 * Un unico punto de acceso hacia distintos DAOS (Datas and objects).
 * Dentro de la clase service podemos operar distintas clases DAO.
 */
@Service
public class SalidasServiceImpl implements ISalidasService{

    //Inyecta una interfaz para utilizar sus metodos
    @Autowired
    private ISalidasDao salidasDao;

    @Transactional(readOnly = true)
    @Override
    public List<Salidas> list() {
        return salidasDao.list();
    }

    @Transactional
    @Override
    public void save(Salidas salidas) {
        salidasDao.save(salidas);
    }

    @Transactional(readOnly = true)
    @Override
    public Salidas getById(Long id) {
        return salidasDao.getById(id);
    }

    @Transactional
    @Override
    public void delete(Long id) {
        salidasDao.delete(id);
    }
    
}

