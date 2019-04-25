package com.study.Member.controls;

import com.study.Member.dao.Memberdao;
import com.study.Member.pojo.Memberlist;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "Readservlet", urlPatterns = "/readvip")
public class Readservlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//        request.getRequestDispatcher("WEB-INF/member/addvip.jsp").forward(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Memberdao memberdao = new Memberdao();
        List<Memberlist> list = memberdao.read();
        System.out.println("" + list);
        request.setAttribute("vip", list);
        request.getRequestDispatcher("WEB-INF/member/addmember.jsp").forward(request, response);

    }
}
