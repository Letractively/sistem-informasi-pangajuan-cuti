
package dao;

import javax.persistence.EntityManager;

/**
 *
 * @author Pratyaksa Ocsa
 */
public class GeneralDAOImpl implements GeneralDAO {

    protected  EntityManager em;

    public GeneralDAOImpl(EntityManager em){
        this.em = em;
    }

    @Override
    public void insert(Object obj) throws Exception {
        try {
            em.getTransaction().begin();
            em.persist(obj);
            em.getTransaction().commit();
        } catch (Exception ex) {
            throw ex;
        }
    }

    @Override
    public void delete(Object obj) throws Exception {
        try {
            em.getTransaction().begin();
            em.remove(obj);
            em.getTransaction().commit();
        } catch (Exception ex) {
            throw ex;
        }
    }

    @Override
    public void update(Object obj) throws Exception {
        try {
            em.getTransaction().begin();
            em.merge(obj);
            em.getTransaction().commit();
        } catch (Exception ex) {
            throw ex;
        }
    }

}
