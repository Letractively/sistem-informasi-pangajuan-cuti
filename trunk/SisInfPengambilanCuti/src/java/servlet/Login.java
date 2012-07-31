/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import dao.*;
import entity.Karyawan;
import entity.Loginkaryawan;
import entity.Tbladmin;
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
import javax.servlet.http.HttpSession;

/**
 *
 * @author Pratyaksa Ocsa
 */
@WebServlet(name = "Login", urlPatterns = {"/Login"})
public class Login extends HttpServlet {

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
            String username = request.getParameter("usr");

            String password = request.getParameter("pwd");
            Tbladmin loginAdmin = new Tbladmin();
            loginAdmin.setUsername(username);
            loginAdmin.setPassword(password);
            AdminDAO adminDao = new AdminDAOImpl(em);

            Loginkaryawan loginKaryawan = new Loginkaryawan();
            loginKaryawan.setUsername(username);
            loginKaryawan.setPassword(password);
            LoginKaryawanDAO loginKaryawanDAO = new LoginKaryawanDAOImpl(em);

            Karyawan k = new Karyawan();
            KaryawanDAO kado = new KaryawanDAOImpl(em);
            k = kado.get(Long.parseLong(username));
            if (adminDao.loginAdmin(loginAdmin) && k.getStatuskerja().equalsIgnoreCase("true")) {
                //LOGIN AS ADMIN
                HttpSession session = request.getSession(true);
                session.setAttribute("user", "administrator");
                response.sendRedirect("home.jsp");
            } else if (loginKaryawanDAO.loginKaryawan(loginKaryawan)) {
                HttpSession session = request.getSession(true);
                session.setAttribute("user", loginKaryawan.getUsername());

                response.sendRedirect("home.jsp");
            } else {
                RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
                request.setAttribute("failed", "Login Gagal");
                cuti.DateTimeCuti.validator=true;                
                response.sendRedirect("home.jsp");
                rd.include(request, response);
            }

            //LOGIN gagal

        } catch (Exception ex) {
            System.out.println(ex.getCause());
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
