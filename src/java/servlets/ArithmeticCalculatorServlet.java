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
public class ArithmeticCalculatorServlet extends HttpServlet {


   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        //assigns value to message on load
        request.setAttribute("message", "---");

        getServletContext().getRequestDispatcher("/WEB-INF/arithmeticcalculator.jsp")
            .forward(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String firstNumber = request.getParameter("firstnumber");
        String secondNumber = request.getParameter("secondnumber");
        
        request.setAttribute("firstnumber", firstNumber);
        request.setAttribute("secondnumber", secondNumber);
        
        try{
            //.trim() added to ignore an accidental space
            int num1 = Integer.parseInt(firstNumber.trim());
            int num2 = Integer.parseInt(secondNumber.trim());
            int ans = 0;
            
            String operator = request.getParameter("submit");
            
            switch (operator) {
                case "+" :
                    ans = num1 + num2;
                    break;
                case "-" :
                    ans = num1 - num2;
                    break;
                case "*" :
                    ans = num1 * num2;
                    break;
                case "%" :
                    ans = num1 / num2;
                    break;
            }
            request.setAttribute("message", ans);
        }
        catch (NumberFormatException e) {
            request.setAttribute("message", "invalid");
        }
        catch (ArithmeticException e) {
            request.setAttribute("message", "Cannot divide by 0");
        }
        finally{
            getServletContext()
                .getRequestDispatcher("/WEB-INF/arithmeticcalculator.jsp")
                .forward(request, response);
        } 

    }
}
