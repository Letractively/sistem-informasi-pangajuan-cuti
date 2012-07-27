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
public interface LoginKaryawanDAO {
    public List<Loginkaryawan> gets() throws Exception;
    public boolean loginKaryawan(Loginkaryawan lk) throws Exception;
}
