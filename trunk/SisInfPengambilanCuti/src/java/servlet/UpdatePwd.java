/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import dao.GeneralDAO;
import dao.GeneralDAOImpl;
import dao.LoginKaryawanDAO;
import dao.LoginKaryawanDAOImpl;
import entity.Karyawan;
import entity.Loginkaryawan;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author rika
 */
@WebServlet(name = "UpdatePwd", urlPatterns = {"/UpdatePwd"})
public class UpdatePwd extends HttpServlet {

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
            Loginkaryawan lk= new Loginkaryawan();
            LoginKaryawanDAO ldao= new LoginKaryawanDAOImpl(em);
            GeneralDAO gdao= new GeneralDAOImpl(em);
            Karyawan k= new Karyawan();
            k.getId();
            String user= request.getParameter("usrname");
            String newPass=request.getParameter("newpwd");
            String confPass=request.getParameter("confpwd");
            if(newPass.equals(newPass)){
                
                lk.setId(1L);
                lk.setUsername(user);
                lk.setIdKaryawan(k);
                lk.setPassword(confPass);
                try {
                  ldao.updateLoginKaryawan(confPass, user);
                  response.sendRedirect("/SisInfPengambilanCuti/home.jsp");
                } catch (Exception ex) {
                    Logger.getLogger(UpdatePwd.class.getName()).log(Level.SEVERE, null, ex);
                }
                System.out.println(""+user);
            }
        
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
