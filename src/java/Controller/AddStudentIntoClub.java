/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import Model.Student;
import dal.ClubStudentDAO;
import dal.StudentDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ACER NITRO 5
 */
@WebServlet(name = "AddStudentIntoClub", urlPatterns = {"/add-into-club"})
public class AddStudentIntoClub extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet AddStudentIntoClub</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AddStudentIntoClub at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String clubId = request.getParameter("club-id");
        String studentId = request.getParameter("student-id");
        ClubStudentDAO clubStudentDAO= new ClubStudentDAO();
        StudentDAO sdao= new StudentDAO();
        Student s= sdao.getStudentById(studentId);
        if(s==null){
            String message="There is not existed student with ID="+studentId;
            request.setAttribute("error", message);
            request.getRequestDispatcher("add_student.jsp?clubId="+clubId).forward(request, response);
        }else
            if(clubStudentDAO.isJoining(studentId, clubId)==false){
            clubStudentDAO.add(clubId, studentId);
            response.sendRedirect("joined-student?id="+clubId);
        }else{
            String message="Student with Id= "+studentId+" have already join club with Id= "+clubId+"";
            request.setAttribute("error", message);
            request.getRequestDispatcher("add_student.jsp?clubId="+clubId).forward(request, response);
        }
    } // ktr sv có id có ồn tại k , k tì báo lỗi, có thì ktr join club chưa, rồi thì báo lỗi , chưa thì thêm

    /**
     * Handles the HTTP <code>POST</code> method.
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
