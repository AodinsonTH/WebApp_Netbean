/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Food;
import controller.DBConnection;

@WebServlet(name = "AddNewFoodServlet", urlPatterns = {"/AddNewFoodServlet"})
public class AddNewFoodServlet extends HttpServlet {

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
        
        // รับค่าจากผู้ใช้งาน
        String food_name = request.getParameter("food_name");
        String food_id = request.getParameter("food_id");
        String food_type = request.getParameter("food_type");
        int food_price = Integer.parseInt(request.getParameter("food_price"));
        
        // สร้าง instance of Food
        Food food = new Food();
        food.setId(food_id);
        food.setName(food_name);
        food.setPrice(food_price);
        food.setType(food_type);
        
        
        // insert into MySQL: table food
        DBConnection dbConnection = new DBConnection();
        if(!dbConnection.insertNewFood(food)){
            System.out.println(">>> AddNewFoodMySQL ERROR");
        }
        
        // เก็บ food ไว้ที่ session
        HttpSession session = request.getSession();
        session.setAttribute("food", food);
        
        // forward ไป addNewFoodSuccess.jsp
        request.getRequestDispatcher("/addNewFoodSuccess.jsp").forward(request, response);
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
