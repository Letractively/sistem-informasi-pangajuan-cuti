package dao;

import entity.Historycuti;
import entity.Karyawan;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 *
 * @author Pratyaksa Ocsa
 */
public class HistoryCutiDAOImpl extends GeneralDAOImpl implements HistoryCutiDAO {

    public HistoryCutiDAOImpl(EntityManager em) {
        super(em);
    }

    public List<Historycuti> gets() throws Exception {
        List<Historycuti> list = new ArrayList<Historycuti>();
        try {
            em.getTransaction().begin();
            list = em.createQuery("SELECT hc FROM Historycuti hc").getResultList();
            em.getTransaction().commit();
        } catch (Exception ex) {
            throw ex;
        }
        return list;
    }

   public List<Historycuti> getByIdKaryawan(Karyawan idKaryawan) throws Exception {
        List<Historycuti> list = new ArrayList<Historycuti>();
        try {
            em.getTransaction().begin();
            TypedQuery<Historycuti> query = em.createQuery("SELECT hc FROM Historycuti hc WHERE hc.idKaryawan = :id",
                    Historycuti.class);
            query.setParameter("id", idKaryawan);
            list = query.getResultList();
            em.getTransaction().commit();
        } catch (Exception ex) {
            throw ex;
        }
        return list;
    }

    public List<Historycuti> getByDate(String startDate, String endDate) throws Exception {
        List<Historycuti> list = new ArrayList<Historycuti>();
        try {
            em.getTransaction().begin();
            list = em.createQuery("SELECT hc FROM Historycuti hc WHERE hc.tglawalcuti = " + startDate +
                                  " AND hc.tglakhircuti = "+endDate).getResultList();
            em.getTransaction().commit();
        } catch (Exception ex) {
            throw ex;
        }
        return list;
    }
}
