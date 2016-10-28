package br.com.fabiose.perfil.repositories;

import br.com.fabiose.perfil.models.AddressModel;
import br.com.fabiose.perfil.models.PersonModel;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;
import java.math.BigInteger;
import java.util.List;

/**
 * Created by fabioestrela on 08/10/16.
 */

@Repository
public class PersonRepository {

    @PersistenceUnit
    private EntityManagerFactory entityManagerFactory;

    public List<PersonModel> getAll(){

        EntityManager em = entityManagerFactory.createEntityManager();

        return em.createQuery("from PersonModel",PersonModel.class).getResultList();
    }

    public PersonModel findById(int id){

        EntityManager em = entityManagerFactory.createEntityManager();


        PersonModel result = null;
        try {
            result = (PersonModel) em
                    .createQuery("from PersonModel p where p.id = :id")
                    .setParameter("id", id).getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public PersonModel addPerson(PersonModel personModel){

        EntityManager em = entityManagerFactory.createEntityManager();

        try {
            em.getTransaction().begin();


            Query query = em.createNativeQuery( "SELECT nextval( 'public.person_id_seq' )" );
            BigInteger _id= (BigInteger) query.getSingleResult();

            personModel.setId(_id.intValue());

            for(AddressModel addressModel : personModel.getAddress())
                addressModel.setPersonModel(personModel);


            em.persist(personModel);

            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
            return  null;
        }
        return personModel;
    }

    public PersonModel removePerson(PersonModel personModel){

        EntityManager em = entityManagerFactory.createEntityManager();

        try {
            em.getTransaction().begin();
            personModel = em.merge(personModel);
            em.remove(personModel);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
            return  null;
        }
        return personModel;
    }

    public PersonModel updatePerson(PersonModel personModel){

        EntityManager em = entityManagerFactory.createEntityManager();

        try {
            em.getTransaction().begin();

            for(AddressModel addressModel : personModel.getAddress()) {
                addressModel.setPersonModel(personModel);
            }

            em.merge(personModel);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
            return  null;
        }
        return personModel;
    }
}
