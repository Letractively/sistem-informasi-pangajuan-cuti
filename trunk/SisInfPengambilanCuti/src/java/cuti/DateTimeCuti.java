/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cuti;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author suriojiwandono
 */
public class DateTimeCuti {

    public static boolean validator = false;
    public static boolean cekPending = false;

    public String Bulan(String tgl) {
        String ttl[] = tgl.split("-");
        if (ttl[1].equalsIgnoreCase("01")) {
            ttl[1] = "Januari";
        } else if (ttl[1].equalsIgnoreCase("02")) {
            ttl[1] = "Februari";
        } else if (ttl[1].equalsIgnoreCase("03")) {
            ttl[1] = "Maret";
        } else if (ttl[1].equalsIgnoreCase("04")) {
            ttl[1] = "April";
        } else if (ttl[1].equalsIgnoreCase("05")) {
            ttl[1] = "Mei";
        } else if (ttl[1].equalsIgnoreCase("06")) {
            ttl[1] = "Juni";
        } else if (ttl[1].equalsIgnoreCase("07")) {
            ttl[1] = "Juli";
        } else if (ttl[1].equalsIgnoreCase("08")) {
            ttl[1] = "Agustus";
        } else if (ttl[1].equalsIgnoreCase("09")) {
            ttl[1] = "September";
        } else if (ttl[1].equalsIgnoreCase("10")) {
            ttl[1] = "Oktober";
        } else if (ttl[1].equalsIgnoreCase("11")) {
            ttl[1] = "November";
        } else if (ttl[1].equalsIgnoreCase("12")) {
            ttl[1] = "Desember";
        }
        return ttl[0] + " " + ttl[1] + " " + ttl[2];

    }

    public boolean checkTime(String tglAwal, String tglAkhir, int type) throws ParseException {
        boolean flag = false;
        Calendar currentDate = Calendar.getInstance();
        DateFormat dff = new SimpleDateFormat("dd-MM-yyyy");
        String tglNow1 = dff.format(currentDate.getTime());

        Date tglAwalCuti = dff.parse(tglAwal);
        Date tglAkhirCuti = dff.parse(tglAkhir);
        Date tglNow = dff.parse(tglNow1);

        long HariAwalCuti = tglAwalCuti.getTime();
        long HariAkhirCuti = tglAkhirCuti.getTime();
        long HariSekarang = tglNow.getTime();

        long rAwal = HariAwalCuti / (24 * 60 * 60 * 1000);
        long rAkhir = HariAkhirCuti / (24 * 60 * 60 * 1000);
        long rSekarang = HariSekarang / (24 * 60 * 60 * 1000);

        switch (type) {
            case 0:
                if (rSekarang >= rAwal && rSekarang <= rAkhir) {
                    flag = true;
                }
                break;
            case 1:
                if (rSekarang >= rAwal) {
                    flag = true;
                }
                break;
            case 2:
                if (rSekarang < rAwal) {
                    flag = true;
                }
                break;
            case 3:
                if (rSekarang <= rAkhir) {
                    flag = true;
                }
                break;
            default:
                break;
        }

        return flag;
    }
}
