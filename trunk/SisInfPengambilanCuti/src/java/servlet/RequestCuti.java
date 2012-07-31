/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import cuti.DateTimeCuti;
import dao.*;
import entity.HistoryCuti;
import entity.Karyawan;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author rika
 */
@WebServlet(name = "RequestCuti", urlPatterns = {"/RequestCuti"})
public class RequestCuti extends HttpServlet {

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("SisInfPengambilanCutiPU");
            EntityManager em = emf.createEntityManager();
            HistoryCuti hc = new HistoryCuti();
            HistoryCutiDAO hdao = new HistoryCutiDAOImpl(em);
            String usrname = request.getParameter("usrname");
            Karyawan k = new Karyawan();
            k.setId(Long.parseLong(usrname));
            List<HistoryCuti> dataHC = hdao.getByIdKaryawan(k);
            boolean cekPending = false;
            for (int i = 0; i < dataHC.size(); i++) {
                if (dataHC.get(i).getStatus().equalsIgnoreCase("Pending")) {
                    cekPending = true;
                    break;
                }
            }
            if (!cekPending) {
                KaryawanDAO kdao = new KaryawanDAOImpl(em);
                try {
                    k = kdao.get(Long.parseLong(usrname));
                } catch (Exception ex) {
                    Logger.getLogger(RequestCuti.class.getName()).log(Level.SEVERE, null, ex);
                }
                String alasan = request.getParameter("alasancuti");
                String status = "pending";
                String tgl1 = request.getParameter("cmbTanggal1");
                String bln1 = request.getParameter("cmbBulan1");
                String thn1 = request.getParameter("cmbTahun1");
                String tgl2 = request.getParameter("cmbTanggal2");
                String bln2 = request.getParameter("cmbBulan2");
                String thn2 = request.getParameter("cmbTahun2");
                
                
                String convertBulan1 = "";
                String convertBulan2 = "";
                String[] hurufBulan = {"januari", "februari", "maret", "april", "mei", "juni", "juli", "agustus", "september", "oktober", "november", "desember"};
                int a = 0;
                for (int i = 0; i < hurufBulan.length; i++) {
                    a = i + 1;
                    if (hurufBulan[i].contains(bln1)) {
                        if (i == 9 || i == 10 || i == 11) {
                            convertBulan1 = "" + a;
                        } else {
                            convertBulan1 = "0" + a;
                        }
                    }
                    if (hurufBulan[i].contains(bln2)) {
                        if (i == 9 || i == 10 || i == 11) {
                            convertBulan2 = "" + a;
                        } else {
                            convertBulan2 = "0" + a;
                        }
                    }
                }
                
                
                String tanggalAwal = tgl1 + "-" + convertBulan1 + "-" + thn1;
                String tanggalAkhir = tgl2 + "-" + convertBulan2 + "-" + thn2;


                hc.setAlasan(alasan);
                hc.setStatus(status);
                hc.setTglakhircuti(tanggalAkhir);
                hc.setTglawalcuti(tanggalAwal);
                hc.setKaryawan(k);
                try {
                    if (Integer.parseInt(k.getSisacuti()) > 0) {
                        hdao.insert(hc);
                        kdao.updateNotifikasi(k.getId().toString(), "true");
                        response.sendRedirect("/SisInfPengambilanCuti/home.jsp");
                    } else {
                        response.sendRedirect("#");
                    }
                } catch (Exception ex) {
                    Logger.getLogger(RequestCuti.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                DateTimeCuti.cekPending = true;
                response.sendRedirect("home.jsp");
            }
        } catch (Exception ex) {
        } finally {
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
