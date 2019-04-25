package com.study.news.controls;

import com.study.news.dao.Commentdao;
import com.study.news.dao.NewsDAO;
import com.study.news.pojo.Comment;
import com.study.news.pojo.News;
import com.study.news.utils.CommonUtils;
import com.study.news.utils.Pager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "DetailServlet" ,urlPatterns = "/new")
public class DetailServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        //设置编码格式
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
//
        String p = request.getParameter("pageno");
        String id = request.getParameter("newsid");
        Integer pageSize = 2;
        Integer pageNo = 1;//默认页面是1
        //判断p变量是否能够转成数字
        if (CommonUtils.verifyPageNo(p)) {
            pageNo = Integer.parseInt(p);
        }
        Commentdao commentdao = new Commentdao();
        List<Comment> list = commentdao.selectPager(Integer.parseInt(id), pageNo, pageSize);
        Pager<Comment> pager = new Pager<>(pageNo, commentdao.getTotal(Integer.parseInt(id)), pageSize, list);
        request.setAttribute("commentPager", pager);
        request.getRequestDispatcher("WEB-INF/Newsbigtruth/new.jsp").forward(request, response);
    }
}
