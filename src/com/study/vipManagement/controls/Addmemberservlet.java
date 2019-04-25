package com.study.vipManagement.controls;

import com.study.vipManagement.beans.Users;
import com.study.vipManagement.dao.UsersDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

@WebServlet(name = "Addmemberservlet", urlPatterns = "/addvip")
@MultipartConfig
public class Addmemberservlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置编码格式
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        //获取表单提交的参数信息
        String nickname = request.getParameter("nickname");
        String realname = request.getParameter("realname");
        String sex = request.getParameter("sex");
        String birth = request.getParameter("year") + "-" +
                request.getParameter("month") + "-" +
                request.getParameter("day");
        String con = request.getParameter("constellation");
        String provice = request.getParameter("provice");
        String city = request.getParameter("city");
        String district = request.getParameter("district");

        //头像
        String path = upload(request, response);
        System.out.println("服务器路径是：" + path);
        UsersDao dao = new UsersDao();
        String id = request.getParameter("mid");
        Users mem = new Users(null, path, nickname, realname, sex, Date.valueOf(birth), con, provice, city, district);

        if ( dao.selectOfId(Integer.valueOf(id))){
            //修改
            int u=dao.modify(mem);
            if (u !=-1){

                System.out.println("修改成功！");
            }

        }
        int meid = dao.doInsert(mem);
        //重定向---Servlet
        response.sendRedirect("addvip?mid=" + meid);
    }

    String upload(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        PrintWriter out = response.getWriter();

        //② 将文件域中的内容转换成Part对象
        //参数就是文件域的name值 <input type="file" name="upfile">
        Part part = request.getPart("uphead");

        //设置上传文件的最大大小
        int maxSize = 10 * 1024 * 1024;//10M
        System.out.println(part.getSize() + "大小是：---" + maxSize);
        if (part.getSize() > maxSize) {
            out.print("你上传的文件太大，请控制在10M以内");
            return "";
        }

        //③ 获取上传的原始文件名
        String origName = part.getSubmittedFileName();
        System.out.println("原始的文件名：" + origName);
        //④ 获取原始的文件后缀名
        String fix = origName.substring(origName.lastIndexOf("."));
        //⑤ 生成新的文件名
        String newName = System.currentTimeMillis() + fix;
        System.out.println("新的文件名：" + newName);

        //⑥ 确定上传到服务器的地址
        String path = "";
        //获取工程所在根路径
        path = request.getServletContext().getRealPath("/") + "imgs/head";

        File file = new File(path);
        //判断路径所在的目录是否存在，不存在，则新建
        if (!file.exists()) {
            file.mkdirs();
        }
//
//		//⑦ 确定上传物理路径
        String absulotPath = path + "/" + newName;
//		//⑧ 调用write，将文件写入到物理路径
        part.write(absulotPath);

        //imgs/head/newName

        return "imgs/head/" + newName;

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //转发到JSP页面，查看页面
        String id = request.getParameter("mid");
        if (id != null) {
            Users mem = new Users();
            UsersDao uDao = new UsersDao();
            mem = uDao.selectById(Integer.parseInt(id));
            request.setAttribute("mem", mem);
            System.out.println("新用户：*************************************************************************" + mem);

        }
        request.getRequestDispatcher("WEB-INF/member/addmember.jsp").forward(request, response);
    }
}
