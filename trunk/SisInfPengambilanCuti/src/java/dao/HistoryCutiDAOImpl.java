package dao;

import entity.HistoryCuti;
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

    public List<HistoryCuti> gets() throws Exception {
        List<HistoryCuti> list = new ArrayList<HistoryCuti>();
        try {
            em.getTransaction().begin();
            list = em.createQuery("SELECT hc FROM HistoryCuti hc").getResultList();
            em.getTransaction().commit();
        } catch (Exception ex) {
            throw ex;
        }
        return list;
    }

    public List<HistoryCuti> getByIdKaryawan(Karyawan karyawan) throws Exception {
        List<HistoryCuti> list = new ArrayList<HistoryCuti>();
        try {
            em.getTransaction().begin();
            TypedQuery<HistoryCuti> query = em.createQuery("SELECT hc FROM HistoryCuti hc WHERE hc.karyawan = :id",
                    HistoryCuti.class);
            query.setParameter("id", karyawan);
            list = query.getResultList();
            em.getTransaction().commit();
        } catch (Exception ex) {
            throw ex;
        }
        return list;
    }

    public List<HistoryCuti> getByDate(String startDate, String endDate) throws Exception {
        List<HistoryCuti> list = new ArrayList<HistoryCuti>();
        try {
            em.getTransaction().begin();
            list = em.createQuery("SELECT hc FROM Historycuti hc WHERE hc.tglawalcuti = " + startDate
                    + " AND hc.tglakhircuti = " + endDate).getResultList();
            em.getTransaction().commit();
        } catch (Exception ex) {
            throw ex;
        }
        return list;
    }

    public void approveCuti(HistoryCuti hcuti) throws Exception {
        try {
            em.getTransaction().begin();
            em.merge(hcuti);
            em.getTransaction().commit();
        } catch (Exception ex) {
            throw ex;
        }
    }

    public HistoryCuti getById(long id) throws Exception {
        HistoryCuti hc = new HistoryCuti();
        try {
            em.getTransaction().begin();
            hc = (HistoryCuti) em.createQuery("SELECT hc FROM HistoryCuti hc WHERE hc.id="+id).getResultList().get(0);
            em.getTransaction().commit();
        } catch (Exception ex) {
            throw ex;
        }
        return hc;
    }
}