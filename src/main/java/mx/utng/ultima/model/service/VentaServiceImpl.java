package mx.utng.ultima.model.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.utng.ultima.model.dao.IVentaDao;
import mx.utng.ultima.model.entity.Venta;
/*
 * Una clase service, esta basada en el patron de diseño facade.
 * Un unico punto de acceso hacia distintos DAOS (Datas and objects).
 * Dentro de la clase service podemos operar distintas clases DAO.
 */
@Service
public class VentaServiceImpl implements IVentaService{

    //Inyecta una interfaz para utilizar sus metodos
    @Autowired
    private IVentaDao ventaDao;

    @Transactional(readOnly = true)
    @Override
    public List<Venta> list() {
        return ventaDao.list();
    }

    @Transactional
    @Override
    public void save(Venta venta) {
        ventaDao.save(venta);
    }

    @Transactional(readOnly = true)
    @Override
    public Venta getById(Long id) {
        return ventaDao.getById(id);
    }

    @Transactional
    @Override
    public void delete(Long id) {
        ventaDao.delete(id);
    }
    
}

