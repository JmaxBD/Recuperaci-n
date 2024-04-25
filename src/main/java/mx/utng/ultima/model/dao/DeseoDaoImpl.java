package mx.utng.ultima.model.dao;


import java.util.List;

import org.springframework.stereotype.Repository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import mx.utng.ultima.model.entity.Deseo;

@Repository
public class DeseoDaoImpl implements IDeseoDao{

    //Coloco un atributo que me permitira gestionar la entidad
    @PersistenceContext
    private EntityManager em;

    @SuppressWarnings("unchecked")
    @Override
    public List<Deseo> list() {
        return em.createQuery("from Deseo").getResultList();
    }

    @Override
    public void save(Deseo deseo) {
        //Si el id es distinto a nulo o mayor que cero, quiere decir que el registro ya existe lo va a modificar
        if(deseo.getId() != null && deseo.getId()>0){
            em.merge(deseo);
        }else{
            //Registro nuevo al usar persist
            em.persist(deseo);
        }
    }

    @Override
    public Deseo getById(Long id) {
        return em.find(Deseo.class, id);
    }

    @Override
    public void delete(Long id) {
      Deseo deseo = getById(id);
      em.remove(deseo);
    }
    

}
