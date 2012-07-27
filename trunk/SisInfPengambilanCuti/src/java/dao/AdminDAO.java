/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Tbladmin;
import java.util.List;

/**
 *
 * @author and2erlangga
 */
public interface AdminDAO extends GeneralDAO {
    public List<Tbladmin> gets() throws Exception;
    public boolean loginAdmin(Tbladmin tAdmin) throws Exception;
}
