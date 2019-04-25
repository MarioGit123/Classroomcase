package com.study.vipManagement.dao;

import com.study.utils.BaseDAO;
import com.study.utils.RowMapper;
import com.study.vipManagement.beans.Users;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class UsersDao extends BaseDAO {
    /**新增会员
     * @param mem
     * @return
     */
    public int doInsert(Users mem) {
        String sql="insert into member values"
                + "(null,?,?,?,?,?,?,?,?,?)";
        Object[] param = {
                mem.getHead(),
                mem.getNickname(),
                mem.getRealname(),
                mem.getSex(),
                mem.getBirth(),
                mem.getConstellation(),
                mem.getProvice(),
                mem.getCity(),
                mem.getDistrict()
        };
        return super.insert(sql, param);
    }

    /**根据主键id，获取会员信息
     * @param meid
     * @return
     */
    public Users selectById(Integer meid) {
        String sql="select * from member where  meid=?";
        List<Users> list = super.query( sql, new Object[] {meid}, new UserRowMapper());
        if(list!=null && list.size()>0) {
            return list.get(0);
        }
        return null;
    }

    /**
     * 判断主键是否存在
     * @param mid
     * @return
     */
    public Boolean selectOfId(Integer mid){
        String sql="select * from member where  meid=?";
        List<Users> list = super.query( sql, new Object[] {mid}, new UserRowMapper());
        return list != null && list.size() > 0;
    }

    /**
     *查询所有数据
     * @return 所有数据
     */
    public List<Users> selectAll(){
        String sql="select * from member";
        List<Users> list = super.query( sql, new Object[] { }, new UserRowMapper());
        if(list!=null && list.size()>0) {
            return list;
        }
        return null;
    }

    /**
     *
     * @param mem
     * @return
     */
    public int modify(Users mem){
        String sql="UPDATE Member SET head=?,nickname=?,realname=?, sex=?,birth =?,constellation =? , provice =? ,city =? ,district=?,where meid=?;";
        Object[] param = {
                mem.getHead(),
                mem.getNickname(),
                mem.getRealname(),
                mem.getSex(),
                mem.getBirth(),
                mem.getConstellation(),
                mem.getProvice(),
                mem.getCity(),
                mem.getDistrict(),
                mem.getMeid()
        };
        return super.update(sql, param);
    }

    class UserRowMapper implements RowMapper<Users> {
        @Override
        public Users rowmap(ResultSet rs) throws SQLException {
            return new Users(rs.getInt("meid"),
                    rs.getString("head"),
                    rs.getString("nickname"),
                    rs.getString("realname"),
                    rs.getString("sex"),
                    rs.getDate("birth"),
                    rs.getString("constellation"),
                    rs.getString("provice"),
                    rs.getString("city"),
                    rs.getString("district"));
        }
    }
}
