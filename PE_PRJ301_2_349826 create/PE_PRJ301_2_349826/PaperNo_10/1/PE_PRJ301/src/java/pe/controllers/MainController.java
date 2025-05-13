/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.controllers;

import house.HouseDAO;
import house.HouseDTO;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author hd
 */
public class MainController extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
       throws ServletException, IOException {
        String action = request.getParameter("action");
        String keyword = request.getParameter("keyword");
        if (keyword == null) keyword = "";

       HouseDAO houseDAO = new HouseDAO();

        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("usersession") == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        try {
            if (action == null || action.equals("list")) {
               
                List<HouseDTO> list = houseDAO.list(keyword);
                request.setAttribute("createHouse", list);
                request.getRequestDispatcher("/createHouse.jsp").forward(request, response);

            }else if (action.equals("create")) {
    HouseDTO house = new HouseDTO();
    request.setAttribute("house", house);             // truyền object house sang JSP
    request.setAttribute("nextaction", "insert");     // thông báo action tiếp theo là insert
    request.getRequestDispatcher("houseedit.jsp").forward(request, response);
} else if (action.equals("insert")) {
    String id = request.getParameter("id");
    String name = request.getParameter("name");
    String description = request.getParameter("description");
    float size = Float.parseFloat(request.getParameter("size"));

    // Luôn set status = true (1)
    boolean status = true;
    
    // Nhận giá trị price từ form
    float price = Float.parseFloat(request.getParameter("price"));

    HouseDTO house = new HouseDTO();
    house.setId(id);
    house.setName(name);
    house.setDescription(description);
    house.setSize(size);
    house.setStatus(status);  // luôn là true
    house.setPrice(price);    // set giá trị price

    houseDAO.insert(house);  // gọi DAO để lưu vào database

    request.setAttribute("house", house);
    List<HouseDTO> list = houseDAO.list(""); // gọi list() để lấy lại danh sách
request.setAttribute("createHouse", list);
    request.getRequestDispatcher("createHouse.jsp").forward(request, response);
}

        } catch (Exception ex) {
            ex.printStackTrace();
   
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
        processRequest(request, response);
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
