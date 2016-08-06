package dao;

import java.util.List;

import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Record;

public class OrgnizationDao {
	public List<Record> searchAll(){
		String sql="SELECT id,name,address FROM orgnization ORDER BY id";
		List<Record> list=Db.find(sql);
		return list;
	}
	
}
