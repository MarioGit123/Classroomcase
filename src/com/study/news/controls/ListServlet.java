package com.study.news.controls;

import com.study.news.dao.NewsDAO;
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

@WebServlet(name = "ListServlet",urlPatterns = "/news")
public class ListServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//设置编码格式
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        //获取传递过来的当前页的参数
        String p=request.getParameter("pageno");
        Integer pageSize=2;
        Integer pageNo=1;//默认页面是1
        //判断p变量是否能够转成数字
        if(CommonUtils.verifyPageNo(p)) {
            pageNo=Integer.parseInt(p);
        }
        NewsDAO dao = new NewsDAO();
        List<News> list = dao.selectPager(pageNo, pageSize);
        System.out.println("sefwsdf "+list);
        //把数据封装到Pager
        Pager<News> pager = new Pager<>();
        pager.setData(list);//分页数据
        pager.setPageno(pageNo);//当前页
        pager.setPagesize(pageSize);//每页条数
        pager.setTotal(dao.getTotal());//数据库的总记录数

        //将获取的数据存入作用域
        request.setAttribute("pager", pager);
        //跳转(转发)
        request.getRequestDispatcher("WEB-INF/Newsbigtruth/news.jsp").forward(request, response);
    }
}
