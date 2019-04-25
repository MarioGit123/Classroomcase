package com.study.Member.controls;

import com.study.Member.dao.Memberdao;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.sql.Date;

@WebServlet(name = "Addservlet", urlPatterns = "/addmem")
@MultipartConfig
public class Addservlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        String name = request.getParameter("loginName");// 登录名
        String realName = request.getParameter("realNname");  //真实姓名
        String pwd = request.getParameter("pwd");// 密码
        Part headerimg = request.getPart("header");//用户头像（存路径）
        String phone = request.getParameter("phone");//电话
        String sex = request.getParameter("sex");//性别
        String birthday = request.getParameter("birthday");// 出生日期
        System.out.println("name" + name);

        //将本地文件转为物理路径文件
        System.out.println("touxiang" + headerimg);

        //原来的文件名
        String oldName = headerimg.getSubmittedFileName();
        System.out.println("原始的文件名：" + oldName);
        //获取后缀名
        String suffixName = oldName.substring(oldName.lastIndexOf("."));

        //生成新的文件名
        String newName = System.currentTimeMillis() + suffixName;

        System.out.println("新的文件名：" + newName);

        //确定上传到服务器的地址
        //获取工程所在根路径
        String path = request.getServletContext().getRealPath("/") + "imgs";

        File file = new File(path);
        //判断路径所在的目录是否存在，不存在，则新建
        if (!file.exists()) {
            file.mkdirs();
        }

        //确定上传物理路径
        String absulotPath = path + "/" + newName;
        //调用write，将文件写入到物理路径
        headerimg.write(absulotPath);
        System.out.println("hedew"+headerimg);

        Memberdao memberdao=new Memberdao();
      int i=  memberdao.add(
                name,
                realName,
                pwd,
                newName,
                phone,
                sex,
                Date.valueOf(birthday)
                );
        request.getRequestDispatcher("http://localhost:8080/web/readvip").forward(request, response);
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("WEB-INF/member/addvip.jsp").forward(request, response);

    }
}
