/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.TblAdmin;
import java.util.List;

/**
 *
 * @author and2erlangga
 */
public interface AdminDAO extends GeneralDAO {
    public List<TblAdmin> gets() throws Exception;
    public boolean loginAdmin(TblAdmin tAdmin) throws Exception;
}
