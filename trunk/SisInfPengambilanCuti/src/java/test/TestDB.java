/**
 * Hanya untuk ngetest
 * Kalau mau dipakai silahkan diganti2 sendiri
 * Kalau g y diemin aja
 * Hahahaha
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

//        Karyawan k = new Karyawan();
//        k.setNamakaryawan("Toni");
//        k.setAlamat("Salatiga");
//        k.setJenkel("Laki-Laki");
//        k.setSisacuti("7");
//
//
//        HistoryCuti hc = new HistoryCuti();
//        hc.setKaryawan(k);
//        hc.setStatus("Pending");
//        hc.setTglawalcuti("13-07-2012");
//        hc.setTglakhircuti("20-07-2012");
           String username = "toni";
           String password = "toni";
        try {
            KaryawanDAO kdao = new KaryawanDAOImpl(em);
            
            Loginkaryawan login = new Loginkaryawan();
            login.setUsername(username);
            login.setPassword(password);
            //login.setIdKaryawan(kdao.get(1));
            LoginKaryawanDAO ldao = new LoginKaryawanDAOImpl(em);
            System.out.println(ldao.getLoginKaryawanName(username).getNamakaryawan());
            //ldao.insert(login);
            //System.out.print(adminDao.loginAdmin(loginAdmin));
//            HistoryCutiDAO hcDao = new HistoryCutiDAOImpl(em);
            //hcDao.insert(hc);
           //System.out.println(hcDao.getByIdKaryawan(new Karyawan(1)).get(0).getKaryawan().getNamakaryawan());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
}}
