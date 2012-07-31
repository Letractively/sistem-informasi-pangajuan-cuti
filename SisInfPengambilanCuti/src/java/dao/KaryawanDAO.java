/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.HistoryCuti;
import entity.Karyawan;
import java.util.List;

/**
 *
 * @author Smart
 */
public interface KaryawanDAO extends GeneralDAO {

    public List<Karyawan> gets() throws Exception;

    public Karyawan get(long id) throws Exception;

    public List<Karyawan> getStatusKerja(String kerja) throws Exception;

    public void updateSisaCuti(Long id, String cuti) throws Exception;

    public void updateNotifikasi(Long id, String notif) throws Exception;

    public boolean updateNotifikasi(String usr, String notif) throws Exception;

}
