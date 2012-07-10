/**
 * Hanya untuk ngetest
 * Kalau mau dipakai silahkan diganti2 sendiri
 * Kalau g y diemin aja
 * Hahahaha
 */
package test;

import dao.HistoryCutiDAO;
import dao.HistoryCutiDAOImpl;
import entity.HistoryCuti;
import entity.Karyawan;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Pratyaksa Ocsa
 */
public class TestDB {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("SisInfPengambilanCutiPU");
        EntityManager em = emf.createEntityManager();

        Karyawan k = new Karyawan();
        k.setNamakaryawan("Toni");
        k.setAlamat("Salatiga");
        k.setJenkel("Laki-Laki");
        k.setSisacuti("7");

        HistoryCuti hc = new HistoryCuti();
        hc.setKaryawan(k);
        hc.setStatus("Pending");
        hc.setTglawalcuti("13-07-2012");
        hc.setTglakhircuti("20-07-2012");

        try {
            HistoryCutiDAO hcDao = new HistoryCutiDAOImpl(em);
            hcDao.insert(hc);
        } catch (Exception ex) {
            System.out.println(ex.getCause());
        }
    }
}
