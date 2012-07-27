
package dao;

import entity.HistoryCuti;
import entity.Karyawan;
import java.util.List;

/**
 *
 * @author Pratyaksa Ocsa
 */
public interface HistoryCutiDAO extends GeneralDAO {
    public List<HistoryCuti> gets() throws Exception;
    public List<HistoryCuti> getByIdKaryawan(Karyawan karyawan) throws Exception;
    public List<HistoryCuti> getByDate(String startDate, String endDate) throws Exception;
}
