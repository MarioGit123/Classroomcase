package com.study.news.dao;

import com.study.news.pojo.Comment;

import com.study.utils.BaseDAO;
import com.study.utils.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class Commentdao extends BaseDAO {

    public List<Comment> selectPager(int newsid, int pageNo, int pageSize) {
        String sql = "select newsid,content from comment  where newsid = ? limit ?,?";


        List<Comment> list = super.query(sql, new Integer[]{newsid, (pageNo - 1) * pageSize, pageSize}, new CommentRowMapper());


//                new RowMapper<Comment>() {
//                    @Override
//                    public Comment rowmap(ResultSet rs) throws SQLException {
//                        return new Comment(
//                                null,
//                                rs.getInt("newid"),
//                                rs.getString("ccontent"));
//                    }
//                });
        if (list != null && !list.isEmpty()) {
            return list;
        }
        return null;
    }

    public Integer getTotal(int newsid) {
        String sql = "select count(*) from comment where newsid=?";
        List<Integer> list = super.query(sql, new Integer[]{newsid},
                new RowMapper<>() {
                    @Override
                    public Integer rowmap(ResultSet rs) throws SQLException {
                        return rs.getInt(1);
                    }
                });
        if (list != null && list.size() > 0){
            return list.get(0);

        }
        return 0;
    }

    class CommentRowMapper implements RowMapper<Comment> {
        @Override
        public Comment rowmap(ResultSet rs) throws SQLException {
            Comment comnew = new Comment(
                    rs.getInt("cid"),
                    rs.getString("ccontext"),
                    rs.getInt("newid")
            );
            return comnew;
        }
    }

}
