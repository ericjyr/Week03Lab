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
        
        try{
            if (stringAge == null || stringAge.equals("")) {
                request.setAttribute("message", "You must give your current age");
                return;
            }
            
            int intAge = Integer.parseInt(stringAge.trim());
            
            //if negative integer throws error
            if (stringAge.contains("-") || stringAge.contains("."))
                throw new IllegalArgumentException();
            
            request.setAttribute("message",
                    "Your age next birthday will be " + ++intAge);
        } 
        catch (NumberFormatException e) {
            request.setAttribute("message", "You must enter a number");
        }
        catch (IllegalArgumentException i) {
             request.setAttribute("message", 
                     "Your age must be a positive whole number");
        }
        finally {
            getServletContext()
                .getRequestDispatcher("/WEB-INF/agecalculator.jsp")
                .forward(request, response);
        } 
    }
}
