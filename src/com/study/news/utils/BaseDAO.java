/*
package com.study.news.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

*/
/**1、四个常量字符串
 * 	① 驱动字符串（驱动包名）
 *  ② 连接字符串
 *  ③ 用户名
 *  ④ 密码
 * 2、三大对象
 * 	① Connection 连接对象
 *  ② PreparedStatement 预编译执行
 *  ③ ResultSet 结果集对象
 * 3、静态块
 * 	加载驱动
 * 4、获取连接
 * 5、执行增删改操作，返回受影响的行数——update
 * 6、执行新增操作，返回自增的主键id ——insert
 * 7、执行查询操作，利用接口，隔离实体类和DAO
 * 8、释放资源，先创建的后关闭
 * @author SMILE
 *//*

public class BaseDAO {
	private static final String driver = "com.mysql.cj.jdbc.Driver";
	private static final String url = "jdbc:mysql://localhost:3306/bignewsexplosion?charcterEncoding=UTF-8&&useSSL=false&&serverTimezone=GMT%2B8";
	private static final String user = "root";
	private static final String pwd = "51880975asd";
	
	private Connection conn;
	private PreparedStatement stmt;
	private ResultSet rs;
	
	static{
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	private Connection getConnection(){
		try {
			if(conn==null || conn.isClosed()){
				conn=DriverManager.getConnection(url, user, pwd);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
	
	public <E>List<E> query(String sql,Object[] param,RowMapper<E> map){
		try {
			stmt = getConnection().prepareStatement(sql);
			if (param != null && param.length > 0) {
				int i = 1;
				for (Object o : param) {
					stmt.setObject(i++, o);
				}
			}
			System.out.println(stmt);//打印生成的sql语句，做测试用
			rs = stmt.executeQuery();
			List<E> list = new ArrayList<>();
			while(rs!=null && rs.next()){
				E e = map.rowmap(rs);
				list.add(e);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			closeAll();
		}
		return null;
	}
	
	
	public int insert(String sql,Object[] param){
		int id=0;
		try {
			stmt=getConnection().prepareStatement(sql);
			if(param!=null && param.length>0){
				for(int i=0;i<param.length;i++){
					stmt.setObject(i+1, param[i]);
				}
			}
			int result = stmt.executeUpdate();
			if(result>0){//新增语句执行成功
				rs=stmt.getGeneratedKeys();
				if(rs!=null && rs.next()){
					id=rs.getInt(1);
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			closeAll();
		}
		return id;
	}
	
	
	public int update(String sql,Object[] param){
		try {
			stmt=getConnection().prepareStatement(sql);
			//给预编译执行对象设置参数（根据占位符来）
			if(param!=null && param.length>0){
				int i=1;
				for(Object o:param){
					stmt.setObject(i++, o);
				}
			}
			System.out.println(stmt);//打印生成的sql语句，做测试用
			return stmt.executeUpdate();
			
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			closeAll();
		}
		return -1;
	}
	
	private void closeAll(){
		try {
			if(rs!=null)
				rs.close();
			if(stmt!=null)
				stmt.close();
			if(conn!=null)
				conn.close();
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
}
*/
