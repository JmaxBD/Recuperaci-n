package mx.utng.ultima.model.dao;


import java.util.List;

import org.springframework.stereotype.Repository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import mx.utng.ultima.model.entity.Actividad;

@Repository
public class ActividadDaoImpl implements IActividadDao{

    //Coloco un atributo que me permitira gestionar la entidad
    @PersistenceContext
    private EntityManager em;

    @SuppressWarnings("unchecked")
    @Override
    public List<Actividad> list() {
        return em.createQuery("from Actividad").getResultList();
    }

    @Override
    public void save(Actividad actividad) {
        //Si el id es distinto a nulo o mayor que cero, quiere decir que el registro ya existe lo va a modificar
        if(actividad.getId() != null && actividad.getId()>0){
            em.merge(actividad);
        }else{
            //Registro nuevo al usar persist
            em.persist(actividad);
        }
    }

    @Override
    public Actividad getById(Long id) {
        return em.find(Actividad.class, id);
    }

    @Override
    public void delete(Long id) {
      Actividad actividad = getById(id);
      em.remove(actividad);
    }
    

}
