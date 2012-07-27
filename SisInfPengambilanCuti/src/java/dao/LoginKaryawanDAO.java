/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import entity.Karyawan;
import entity.LoginKaryawan;
import java.util.List;

/**
 *
 * @author Wirawan
 */
public interface LoginKaryawanDAO {
    public List<LoginKaryawan> gets() throws Exception;
    public boolean loginKaryawan(LoginKaryawan lk) throws Exception;
}
