package com.bankingapp.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bankingapp.service.CustomerService;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Servlet implementation class FrontController
 */
@WebServlet("/FrontController")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FrontController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		if(request.getMethod().equals("GET")){
//			ObjectMapper mapper = new ObjectMapper();
//			response.setContentType("application/json");
//			response.getOutputStream()
//				.write(mapper.writeValueAsBytes(RequestHelper.processGet(request, response)));
//		}else if(request.getMethod().equals("POST")){
//			ObjectMapper mapper = new ObjectMapper();
//			response.setContentType("application/json");
//			response.getOutputStream()
//				.write(mapper.writeValueAsBytes(RequestHelper.processPost(request, response)));
//		}
		boolean bool = new CustomerService().validateEmail("bogum@mail.com");
		System.out.println("email available " + bool);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
