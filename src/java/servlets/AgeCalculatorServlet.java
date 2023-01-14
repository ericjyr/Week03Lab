/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ericr
 */
public class AgeCalculatorServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/WEB-INF/agecalculator.jsp")
                .forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String stringAge = request.getParameter("userage");
        request.setAttribute("userage", stringAge);
        int intAge = 0;
        
        if (stringAge == null || stringAge.equals("")) {
            request.setAttribute("message", "You must give your current age");
            
            getServletContext().getRequestDispatcher("/WEB-INF/agecalculator.jsp")
               .forward(request, response);
            
            return;
        }
        
        try{
            //if negative throws error
            if (stringAge.contains("-")) throw new NumberFormatException();
            intAge = Integer.parseInt(stringAge);
        } 
        catch (NumberFormatException e) {
            request.setAttribute("message", "You must enter a positive number");

            getServletContext().getRequestDispatcher("/WEB-INF/agecalculator.jsp")
               .forward(request, response);
        }
        
      
    }

  
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
