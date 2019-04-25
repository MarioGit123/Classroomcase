package com.study.Member.dao;

import com.study.Member.pojo.Memberlist;
import com.study.utils.BaseDAO;
import com.study.utils.RowMapper;

import java.lang.reflect.Member;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public class Memberdao extends BaseDAO {
//    public List<Memberlist> find() {
//        String sql = "";
//        Object[] param = {};
//        return null;
//    }

    /**
     * 添加数据
     * @param name
     * @param realName
     * @param pwd
     * @param headerimg
     * @param phone
     * @param sex
     * @param birthday
     * @return int
     */
    public int add(String name, String realName, String pwd , String headerimg, String phone, String sex, Date birthday){
        String sql="INSERT INTO Memberlist VALUES(null,?,?,?,null,0,?,?,?,?) ";
        Object[] param={
                name,        // 登录名
                realName,    //真实姓名
                pwd,         // 密码
                headerimg,   //用户头像（存路径）
                phone,       //电话
                sex,         //性别
                birthday     // 出生日期
        };
        return super.insert(sql,param);
    }
    public List<Memberlist> read(){
        String sql="SELECT * FROM Memberlist ";
        Object[] param={};

        return super.query(sql,param,new menRowmpper());
    }
    class menRowmpper implements RowMapper<Memberlist> {
        @Override
        public Memberlist rowmap(ResultSet rs) throws SQLException {
            return new Memberlist(
                    rs.getInt("mid"),      // Integer mid;
                    rs.getString("login_Name"),    // String login_Name;
                    rs.getString("real_Name"),    // String realName;
                    rs.getString("mpwd"),    //  String mpwd;
                    rs.getTimestamp("reg_Time"),    //Timestamp regTime;
                    rs.getInt("score"),    //Integer score;
                    rs.getString("header_Image"), //String headerImage;
                    rs.getString("phone"),    // String phone;
                    rs.getString("sex"),  //String sex;
                    rs.getDate("birthday")    //Date birthday;
            );
        }
    }
}
