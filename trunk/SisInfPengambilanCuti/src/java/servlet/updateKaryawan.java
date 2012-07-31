/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import dao.KaryawanDAO;
import dao.KaryawanDAOImpl;
import entity.Karyawan;
import java.io.IOException;
import java.io.PrintWriter;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Wirawan
 */
@WebServlet(name = "updateKaryawan", urlPatterns = {"/updateKaryawan"})
public class updateKaryawan extends HttpServlet {

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
            Long id = Long.parseLong(request.getParameter("txtID").trim());
            String nama = request.getParameter("txtNama").trim();
            String alamat = request.getParameter("txtAlamat").trim();
            String jenkel = request.getParameter("cmbJenkel").trim();
            String tanggal = request.getParameter("cmbTanggal").trim();
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
            if (nama.equals("") || alamat.equals("")) {
                cuti.DateTimeCuti.validator = true;
                response.sendRedirect("administrator/ubahKaryawan.jsp");
            } else {
                Karyawan karyawan = new Karyawan();
                karyawan.setId(id);
                karyawan.setNamakaryawan(nama);
                karyawan.setAlamat(alamat);
                karyawan.setJenkel(jenkel);
                karyawan.setTtl(tanggalLahir);
                karyawan.setSisacuti("7");
                karyawan.setStatuskerja("true");
                karyawan.setNotifikasi("false");

                EntityManagerFactory emf = Persistence.createEntityManagerFactory("SisInfPengambilanCutiPU");
                EntityManager em = emf.createEntityManager();
                KaryawanDAO dao = new KaryawanDAOImpl(em);
                dao.update(karyawan);

                RequestDispatcher req = request.getRequestDispatcher("administrator/home.jsp");
                response.sendRedirect("administrator/home.jsp");
                req.include(request, response);
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            out.close();
        }
        //out.print("OK");
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
