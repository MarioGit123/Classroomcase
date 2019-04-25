package com.study.news.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.study.news.pojo.News;
import com.study.utils.BaseDAO;
import com.study.utils.RowMapper;


/**来完成对应表的增删改查原子性操作
 * @author SMILE
 */
public class NewsDAO extends BaseDAO {
	/**根据当前页面和分页数，获取对应页的新闻信息
	 * @param pageNo  当前页
	 * @param pageSize	每页的新闻条数
	 * @return
	 */
	public List<News> selectPager(int pageNo,int pageSize){

		System.out.println("sdawsd"+pageNo+pageSize);
		String sql="select newsid,title,newdate from news limit ?,?";
		List<News> list = super.query(sql, 
							new Integer[] {(pageNo-1)*pageSize,pageSize}, 
		new RowMapper<>() {
			@Override
			public News rowmap(ResultSet rs) throws SQLException {
				return new News(rs.getInt("newsid"), 
						        rs.getString("title"), 
						        null,
						        rs.getTimestamp("newdate"), 
						        null, 
						        null);
			}
		});
		System.out.println("sssssssssssssssssssssssssssssssss     "+list);
		if(list!=null && !list.isEmpty()) {
			return list;
		}
		return null;
	}
	
	
	/**获取新闻表的总记录
	 * @return
	 */
	public Integer getTotal() {
		String sql = "select count(*) from news";
		List<Integer> list = super.query(sql, null, 
		new RowMapper<Integer>() {
			@Override
			public Integer rowmap(ResultSet rs) throws SQLException {
				return rs.getInt(1);
			}
		});
		if(list!=null && list.size()>0)
			return list.get(0);
		return 0;
	}
	
	
	/**根据新闻编号，查询该条新闻的所有信息
	 * @param newId
	 * @return
	 */
	public News selectById(Integer newId) {
		String sql = "select * from news where newsid=?";
		List<News> list = super.query(sql, 
				new Integer[] {newId}, 
		new RowMapper<News>() {
		@Override
		public News rowmap(ResultSet rs) throws SQLException {
			return new News(rs.getInt("newsid"), 
					        rs.getString("title"), 
					        rs.getString("content"),
					        rs.getTimestamp("newdate"),
					        rs.getString("author"), 
					        rs.getString("resource"));
			}
		});
		if(list!=null && list.size()>0)
			return list.get(0);
		return null;
	}
}
