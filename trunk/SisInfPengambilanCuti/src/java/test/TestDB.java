/**
 * Hanya untuk ngetest Kalau mau dipakai silahkan diganti2 sendiri Kalau g y
 * diemin aja Hahahaha
 */
package test;

import dao.AdminDAO;
import dao.AdminDAOImpl;
import dao.HistoryCutiDAO;
import dao.HistoryCutiDAOImpl;
import dao.KaryawanDAO;
import dao.KaryawanDAOImpl;
import dao.LoginKaryawanDAO;
import dao.LoginKaryawanDAOImpl;
import entity.HistoryCuti;
import entity.Karyawan;
import entity.Loginkaryawan;
import entity.Tbladmin;
import java.util.ArrayList;
import java.util.List;
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
        try {
            HistoryCutiDAO hcdao = new HistoryCutiDAOImpl(em);
            HistoryCuti hc = hcdao.getById(1);
            System.out.println(hc.getStatus());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
