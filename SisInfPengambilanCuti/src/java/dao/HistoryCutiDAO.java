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

    public List<HistoryCuti> getByStatus(String status) throws Exception;

    public void approveCuti(Long id, String status) throws Exception;

    public List<HistoryCuti> getByIdKaryawanAccept(Karyawan karyawan) throws Exception;

    public List<HistoryCuti> getById(Karyawan id) throws Exception;

    public void removeCuti(Karyawan id, String status) throws Exception;
}
