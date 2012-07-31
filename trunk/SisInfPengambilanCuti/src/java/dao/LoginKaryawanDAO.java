/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import entity.Karyawan;
import entity.Loginkaryawan;
import java.util.List;

/**
 *
 * @author Wirawan
 */
public interface LoginKaryawanDAO extends GeneralDAO {
    public List<Loginkaryawan> gets() throws Exception;
    public boolean loginKaryawan(Loginkaryawan lk) throws Exception;
    public Karyawan getLoginKaryawanName(String username) throws Exception;
    public boolean updateLoginKaryawan(String pwd, String usr) throws Exception;
}
