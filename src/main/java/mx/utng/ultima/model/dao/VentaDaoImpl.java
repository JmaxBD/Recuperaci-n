package mx.utng.ultima.model.dao;


import java.util.List;

import org.springframework.stereotype.Repository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import mx.utng.ultima.model.entity.Venta;

@Repository
public class VentaDaoImpl implements IVentaDao{

    //Coloco un atributo que me permitira gestionar la entidad
    @PersistenceContext
    private EntityManager em;

    @SuppressWarnings("unchecked")
    @Override
    public List<Venta> list() {
        return em.createQuery("from Venta").getResultList();
    }

    @Override
    public void save(Venta venta) {
        //Si el id es distinto a nulo o mayor que cero, quiere decir que el registro ya existe lo va a modificar
        if(venta.getId() != null && venta.getId()>0){
            em.merge(venta);
        }else{
            //Registro nuevo al usar persist
            em.persist(venta);
        }
    }

    @Override
    public Venta getById(Long id) {
        return em.find(Venta.class, id);
    }

    @Override
    public void delete(Long id) {
      Venta venta = getById(id);
      em.remove(venta);
    }
    

}
