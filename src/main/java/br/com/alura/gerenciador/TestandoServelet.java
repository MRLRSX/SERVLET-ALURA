package br.com.alura.gerenciador;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns="/index")
public class TestandoServelet extends HttpServlet{

	private static final long serialVersionUID = 1L;
    private String url ="C:\\Projetos\\gerenciador\\src\\main\\webapp\\index.html";
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		try(BufferedReader st = new BufferedReader(new FileReader(url))){
			while(st.ready()) {
				PrintWriter out = resp.getWriter();
				out.println(st.readLine());
			}
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}
