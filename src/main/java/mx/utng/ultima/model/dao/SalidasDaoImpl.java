package mx.utng.ultima.model.dao;


import java.util.List;

import org.springframework.stereotype.Repository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import mx.utng.ultima.model.entity.Salidas;

@Repository
public class SalidasDaoImpl implements ISalidasDao{

    //Coloco un atributo que me permitira gestionar la entidad
    @PersistenceContext
    private EntityManager em;

    @SuppressWarnings("unchecked")
    @Override
    public List<Salidas> list() {
        return em.createQuery("from Salidas").getResultList();
    }

    @Override
    public void save(Salidas salidas) {
        //Si el id es distinto a nulo o mayor que cero, quiere decir que el registro ya existe lo va a modificar
        if(salidas.getId() != null && salidas.getId()>0){
            em.merge(salidas);
        }else{
            //Registro nuevo al usar persist
            em.persist(salidas);
        }
    }

    @Override
    public Salidas getById(Long id) {
        return em.find(Salidas.class, id);
    }

    @Override
    public void delete(Long id) {
      Salidas salidas = getById(id);
      em.remove(salidas);
    }
    

}
