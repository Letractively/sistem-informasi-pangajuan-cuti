
package dao;

import entity.Historycuti;
import entity.Karyawan;
import java.util.List;

/**
 *
 * @author Pratyaksa Ocsa
 */
public interface HistoryCutiDAO extends GeneralDAO {
    public List<Historycuti> gets() throws Exception;
    public List<Historycuti> getByIdKaryawan(Karyawan idKaryawan) throws Exception;
    public List<Historycuti> getByDate(String startDate, String endDate) throws Exception;
}
