/**
 * Hanya untuk ngetest
 * Kalau mau dipakai silahkan diganti2 sendiri
 * Kalau g y diemin aja
 * Hahahaha
 */
package test;

import dao.HistoryCutiDAO;
import dao.HistoryCutiDAOImpl;
import entity.Historycuti;
import entity.Karyawan;
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

        Karyawan k = new Karyawan();
        k.setNamakaryawan("Tonix");
        k.setAlamat("Salatiga");
        k.setJenkel("Laki-Laki");
        k.setSisacuti("7");


        Historycuti hc = new Historycuti();
        hc.setIdKaryawan(k);
        hc.setStatus("Pending");
        hc.setTglawalcuti("13-07-2012");
        hc.setTglakhircuti("20-07-2012");

        try {
            HistoryCutiDAO hcDao = new HistoryCutiDAOImpl(em);
          //  hcDao.insert(hc);
           System.out.println(hcDao.getByIdKaryawan(new Karyawan(1)).get(0).getIdKaryawan().getNamakaryawan());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
}}
