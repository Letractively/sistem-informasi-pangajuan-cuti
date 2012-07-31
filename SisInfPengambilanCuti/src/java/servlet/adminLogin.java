/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import dao.AdminDAO;
import dao.AdminDAOImpl;
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
 * @author suriojiwandono
 */
@WebServlet(name = "adminLogin", urlPatterns = {"/adminLogin"})
public class adminLogin extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            String username = request.getParameter("txtUsername");
            String password = request.getParameter("txtPassword");
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("SisInfPengambilanCutiPU");
            EntityManager em = emf.createEntityManager();
            Tbladmin loginAdmin = new Tbladmin();
            loginAdmin.setUsername(username);
            loginAdmin.setPassword(password);
            AdminDAO adminDao = new AdminDAOImpl(em);
            if (adminDao.loginAdmin(loginAdmin)) {
                //LOGIN AS ADMIN
                HttpSession session = request.getSession(true);
                session.setAttribute("loginAdmin", "Administrator");
                response.sendRedirect("administrator/home.jsp");
            } else {
                RequestDispatcher req = request.getRequestDispatcher("administrator/index.jsp");
                response.sendRedirect("administrator/index.jsp");
                cuti.DateTimeCuti.validator=true;
                req.include(request, response);
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
