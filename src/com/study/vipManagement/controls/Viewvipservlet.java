package com.study.vipManagement.controls;

import com.study.vipManagement.beans.Users;
import com.study.vipManagement.dao.UsersDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "Viewvipservlet",urlPatterns = "/viewvip")
public class Viewvipservlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //转发到JSP页面，查看页面


            List<Users> list=new ArrayList<>();
            UsersDao uDao = new UsersDao();
            list = uDao.selectAll();
            request.setAttribute("list", list);

            System.out.println("查看所有账户：" + list);


        request.getRequestDispatcher("WEB-INF/member/Viewvip.jsp").forward(request, response);
    }
}
