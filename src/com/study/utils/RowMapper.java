package com.study.utils;

import java.sql.ResultSet;
import java.sql.SQLException;

/**行映射接口
 * 用途：
 * 	将ResultSet结果集中的一行数据，映射到一个实体类的对象
 * @author SMILE
 *
 */
public interface RowMapper<E> {
	/**接收rs对象，将rs中的数据，映射到实体对象E中
	 * @param rs
	 * @return
	 * @throws SQLException
	 */
	public E rowmap(ResultSet rs) throws SQLException;
}
