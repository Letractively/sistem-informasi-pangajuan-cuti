/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import dao.*;
import entity.Karyawan;
import entity.Loginkaryawan;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import test.TestDB;

/**
 *
 * @author suriojiwandono
 */
@WebServlet(name = "insertKaryawan", urlPatterns = {"/insertKaryawan"})
public class insertKaryawan extends HttpServlet {

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
            String nama = request.getParameter("txtNama").trim();
            String alamat = request.getParameter("txtAlamat").trim();
            String jenkel = request.getParameter("cmbJenkel").trim();
            String tanggal = request.getParameter("cmbTanggal").trim();
            if (nama.equalsIgnoreCase("") || alamat.equalsIgnoreCase("")) {
                ServletContext sc = getServletContext();
                sc.setAttribute("validation", "kosong");
                cuti.DateTimeCuti.validator = true;
                response.sendRedirect("administrator/insertKaryawan.jsp");
            } else {
                EntityManagerFactory emf = Persistence.createEntityManagerFactory("SisInfPengambilanCutiPU");
                EntityManager em = emf.createEntityManager();
                KaryawanDAO dao = new KaryawanDAOImpl(em);
                String convertBulan = "";
                String[] hurufBulan = {"januari", "februari", "maret", "april", "mei", "juni", "juli", "agustus", "september", "oktober", "november", "desember"};
                String bulan = request.getParameter("cmbBulan").trim();
                int a = 0;
                for (int i = 0; i < hurufBulan.length; i++) {
                    a = i + 1;
                    if (hurufBulan[i].contains(bulan)) {
                        if (i == 9 || i == 10 || i == 11) {
                            convertBulan = "" + a;
                        } else {
                            convertBulan = "0" + a;
                        }
                    }
                }
                String tahun = request.getParameter("cmbTahun").trim();
                String tanggalLahir = tanggal + "-" + convertBulan + "-" + tahun;

                Karyawan karyawan = new Karyawan();
                karyawan.setNamakaryawan(nama);
                karyawan.setAlamat(alamat);
                karyawan.setJenkel(jenkel);
                karyawan.setTtl(tanggalLahir);
                karyawan.setSisacuti("7");
                karyawan.setStatuskerja("true");
                karyawan.setNotifikasi("false");
                dao.insert(karyawan);

                List<Karyawan> listkar = dao.gets();
                listkar.get(listkar.size() - 1).getId();

                karyawan.setId(listkar.get(listkar.size() - 1).getId());
                Loginkaryawan lk = new Loginkaryawan();
                lk.setUsername(listkar.get(listkar.size() - 1).getId().toString());
                lk.setPassword(tanggal + convertBulan + tahun);
                lk.setIdKaryawan(karyawan);
//                
//                
//                
                LoginKaryawanDAO lkdao = new LoginKaryawanDAOImpl(em);
                lkdao.insert(lk);

                RequestDispatcher req = request.getRequestDispatcher("administrator/home.jsp");
                response.sendRedirect("administrator/home.jsp");
                req.include(request, response);
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
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
