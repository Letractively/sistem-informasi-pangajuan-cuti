/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import entity.Karyawan;
import java.util.List;

/**
 *
 * @author Smart
 */
public interface KaryawanDAO {
     public List<Karyawan> gets() throws Exception;
    public Karyawan get(long id) throws Exception;
}
