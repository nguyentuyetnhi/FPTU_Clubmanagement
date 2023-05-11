/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import Model.Club;
import dal.ClubDAO;
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
@WebServlet(name = "AddClubServlet", urlPatterns = {"/add"})
public class AddClubServlet extends HttpServlet {

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
            out.println("<title>Servlet AddClubServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AddClubServlet at " + request.getContextPath() + "</h1>");
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
        request.setCharacterEncoding("UTF-8");
        String id = request.getParameter("id");
        String logo= request.getParameter("logo");
        String name= request.getParameter("name");//Lấy các giá trị của tham số "id", "logo" và "name" từ yêu cầu và lưu trữ chúng trong các biến tương ứng.
        // Tạo một đối tượng ClubDAO để truy xuất đến cơ sở dữ liệu.
        ClubDAO c= new ClubDAO();
        if(c.getClubById(id)==null){//Sử dụng phương thức "getClubById" để kiểm tra xem câu lạc bộ có tồn tại trong cơ sở dữ liệu hay không
            Club newClub= new Club(id, name, logo);
            c.add(newClub);
            response.sendRedirect("club");
            //Sau đó, sử dụng phương thức "sendRedirect" để chuyển hướng đến trang "club".
        }else{
            String message="existed Id";
            request.setAttribute("error", message);
            request.getRequestDispatcher("new.jsp").forward(request, response);
            
        }
        //
    }

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
