/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import dao.HistoryCutiDAO;
import dao.HistoryCutiDAOImpl;
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
 * @author rika
 */
@WebServlet(name = "RequestCutiAdmin", urlPatterns = {"/RequestCutiAdmin"})
public class RequestCutiAdmin extends HttpServlet {

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
            String id = request.getParameter("txtId");
            String cek = request.getParameter("txtCek");
            String idkaryawan = request.getParameter("txtIdKaryawan");
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("SisInfPengambilanCutiPU");
            EntityManager em = emf.createEntityManager();
            HistoryCutiDAO daoPending = new HistoryCutiDAOImpl(em);
            if (cek.equalsIgnoreCase("true")) {

                KaryawanDAO kdao = new KaryawanDAOImpl(em);
                Karyawan k = new Karyawan();
                k = kdao.get(Long.parseLong(idkaryawan));

                if (Integer.parseInt(k.getSisacuti()) > 0) {
                    daoPending.approveCuti(Long.parseLong(id), "Accept");
                    kdao.updateSisaCuti(Long.parseLong(idkaryawan), Integer.parseInt(k.getSisacuti()) - 1 + "");
                } else {
                    out.print("Sisa Cuti Tidak Memenuhi");
                }
            } else if (cek.equalsIgnoreCase("false")) {
                daoPending.approveCuti(Long.parseLong(id), "Denied");
            }
            KaryawanDAO kDao = new KaryawanDAOImpl(em);
            kDao.updateNotifikasi(Long.parseLong(idkaryawan), "true");
            RequestDispatcher req = request.getRequestDispatcher("administrator/home.jsp");
            response.sendRedirect("administrator/home.jsp");
            req.include(request, response);
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
