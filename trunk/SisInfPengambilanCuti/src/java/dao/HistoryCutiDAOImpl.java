package dao;

import entity.HistoryCuti;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;

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

    public List<HistoryCuti> getByIdKaryawan(long idKaryawan) throws Exception {
        List<HistoryCuti> list = new ArrayList<HistoryCuti>();
        try {
            em.getTransaction().begin();
            list = em.createQuery("SELECT hc FROM HistoryCuti hc WHERE hc.id_karyawan = " + idKaryawan).getResultList();
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
            list = em.createQuery("SELECT hc FROM HistoryCuti hc WHERE hc.tglawalcuti = " + startDate +
                                  " AND hc.tglakhircuti = "+endDate).getResultList();
            em.getTransaction().commit();
        } catch (Exception ex) {
            throw ex;
        }
        return list;
    }
}
