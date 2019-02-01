package cn.smbms.dao.provider;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;



import org.springframework.stereotype.Repository;

import cn.smbms.dao.BaseDao;
import cn.smbms.pojo.Provider;

@Repository
public class ProviderDaoImpl extends BaseDao implements ProviderDao {

	@Override
	public List<Provider> getProviderList(String proName){
		StringBuffer sql = new StringBuffer("SELECT * FROM `smbms_provider` WHERE 1=1 ");
		if(proName!=null&&proName!=""){
			sql.append("AND `proName` LIKE CONCAT('%','"+proName+"','%')");
		}
		Connection conn = BaseDao.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Provider> list = new ArrayList<Provider>();
		Provider pro = null;
		try {
			rs = BaseDao.execute(conn, ps, rs, sql.toString(), null);
			while(rs.next()){
				pro = new Provider();
				pro.setId(rs.getInt("id"));
				pro.setProName(rs.getString("proName"));
				pro.setProContact(rs.getString("proContact"));
				pro.setProPhone(rs.getString("proPhone"));
				pro.setProFax(rs.getString("proFax"));
				pro.setCreationDate(rs.getDate("creationDate"));
				list.add(pro);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			BaseDao.closeAll(conn, ps, rs);
		}
		return list;
	}

	@Override
	public boolean addProviderSave(Provider pro) {
		String sql = "INSERT INTO `smbms_provider`(`proName`,`proContact`,`proPhone`,`proAddress`,`proDesc`,`proFax`,`createdBy`,`creationDate`)"
				+ "VALUE(?,?,?,?,?,?,?,?)";
		Connection conn = BaseDao.getConnection();
		PreparedStatement ps = null;
		int updateRows = 0;
		try {
			Object[] params = {pro.getProName(),pro.getProContact(),pro.getProPhone(),pro.getProAddress(),pro.getProDesc(),pro.getProFax(),pro.getCreatedBy(),pro.getCreationDate()};
			updateRows = BaseDao.execute(conn, ps, sql,params);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return updateRows>0?true:false;
	}

}
