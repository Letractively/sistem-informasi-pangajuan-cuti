package dao;

import entity.HistoryCuti;
import entity.Karyawan;
import entity.Loginkaryawan;
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
            list = em.createQuery("SELECT hc FROM HistoryCuti hc WHERE hc.tglawalcuti = " + startDate
                    + " AND hc.tglakhircuti = " + endDate).getResultList();
            em.getTransaction().commit();
        } catch (Exception ex) {
            throw ex;
        }
        return list;
    }

    // NEW
    public List<HistoryCuti> getByStatus(String status) throws Exception {
        List<HistoryCuti> list = new ArrayList<HistoryCuti>();
        try {
            em.getTransaction().begin();
            list = em.createQuery("SELECT hc FROM HistoryCuti hc WHERE hc.status ='" + status + "'").getResultList();
            em.getTransaction().commit();
        } catch (Exception ex) {
            throw ex;
        }
        return list;
    }

    public void approveCuti(Long id, String status) throws Exception {
        try {
            em.getTransaction().begin();
            em.createQuery("UPDATE HistoryCuti hc SET hc.status = :status WHERE hc.id = :id").setParameter("status", status).setParameter("id", id).executeUpdate();
            em.getTransaction().commit();
        } catch (Exception ex) {
            throw ex;
        }
    }

    // Lagi
    public List<HistoryCuti> getByIdKaryawanAccept(Karyawan karyawan) throws Exception {
        List<HistoryCuti> list = new ArrayList<HistoryCuti>();
        try {
            em.getTransaction().begin();
            TypedQuery<HistoryCuti> query = em.createQuery("SELECT hc FROM HistoryCuti hc WHERE hc.karyawan = :id AND hc.status = 'Accept'",
                    HistoryCuti.class);
            query.setParameter("id", karyawan);
            list = query.getResultList();
            em.getTransaction().commit();
        } catch (Exception ex) {
            throw ex;
        }
        return list;
    }

    public List<HistoryCuti> getById(Karyawan id) throws Exception{
        List<HistoryCuti> list = new ArrayList<HistoryCuti>();
        try {
            em.getTransaction().begin();
            TypedQuery<HistoryCuti> query = em.createQuery("SELECT hc FROM HistoryCuti hc WHERE hc.karyawan= :id",
                    HistoryCuti.class);
            query.setParameter("id", id);
            list = query.getResultList();
            em.getTransaction().commit();
        } catch (Exception ex) {
            throw ex;
        }
        return list;
    }
    public void removeCuti(Karyawan id, String status) throws Exception {
        try {
            em.getTransaction().begin();
            em.createQuery("UPDATE HistoryCuti hc SET hc.status = :status WHERE hc.karyawan = :id").setParameter("status", status).setParameter("id", id).executeUpdate();
            em.getTransaction().commit();
        } catch (Exception ex) {
            throw ex;
        }
    }
    
}
