package dao;

import java.util.List;

import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.Record;

public class SpecialtyDao{
	public List<Record> searchAll(){
		String sql="SELECT id,name FROM specialty ORDER BY id";
		List<Record> list=Db.find(sql);
		return list;
	}
	public List<Record> Specialtyenrollcount(){
		String sql="SELECT sp.id,sp.NAME,(SELECT COUNT(*) FROM enroll e JOIN orgnization o ON o.id = e.orgnization_id WHERE specialty_id = sp.id)AS 'specialty_num' FROM enroll e RIGHT JOIN specialty sp ON e.specialty_id = sp.id GROUP BY sp.id";
		List<Record> list=Db.find(sql);
		System.out.println(list);
		return list;
	}
	
	
	
	public Record Recently(String time){
		StringBuffer sql=new StringBuffer();
		sql.append("SELECT ");
		sql.append("(SELECT COUNT(*) FROM enroll WHERE DATE(create_time) BETWEEN DATE_SUB(DATE(NOW()),INTERVAL ? DAY) AND DATE(NOW()) AND specialty_id!=1) AS 'num'");
		sql.append("FROM test WHERE id=1 ");
		Record list=Db.findFirst(sql.toString(),time);
		return list;
	}
	
//	public Record RecentlyTenDay(){
//		StringBuffer sql=new StringBuffer();
//		sql.append("SELECT ");
//		sql.append("");
//		sql.append("FROM test WHERE id=1 ");
//		Record list=Db.findFirst(sql.toString());
//		System.out.println(list);
//		return list;
//	}
//	public Record RecentlyOneMonthDay(){
//		StringBuffer sql=new StringBuffer();
//		sql.append("SELECT ");
//		sql.append("(SELECT COUNT(*) FROM enroll WHERE DATE(create_time) BETWEEN DATE_SUB(DATE(NOW()),INTERVAL 30 DAY) AND DATE(NOW()) AND specialty_id!=1) AS 'm_1'");
//		sql.append("FROM test WHERE id=1 ");
//		Record list=Db.findFirst(sql.toString());
//		System.out.println(list);
//		return list;
//	}
//	public Record RecentlyThressMonthDay(){
//		StringBuffer sql=new StringBuffer();
//		sql.append("SELECT ");
//		sql.append("(SELECT COUNT(*) FROM enroll WHERE DATE(create_time) BETWEEN DATE_SUB(DATE(NOW()),INTERVAL 3*30 DAY) AND DATE(NOW()) AND specialty_id!=1) AS 't_3'");
//		sql.append("FROM test WHERE id=1 ");
//		Record list=Db.findFirst(sql.toString());
//		System.out.println(list);
//		return list;
//	}
//	public Record RecentlySixMonthDay(){
//		StringBuffer sql=new StringBuffer();
//		sql.append("SELECT ");
//		sql.append("(SELECT COUNT(*) FROM enroll WHERE DATE(create_time) BETWEEN DATE_SUB(DATE(NOW()),INTERVAL 6*30 DAY) AND DATE(NOW()) AND specialty_id!=1) AS 's_6'");
//		sql.append("FROM test WHERE id=1 ");
//		Record list=Db.findFirst(sql.toString());
//		System.out.println(list);
//		return list;
//	}
	public Record RecentlySixMonthDayBefore(){
		StringBuffer sql=new StringBuffer();
		sql.append("SELECT ");
		sql.append("(SELECT COUNT(*) FROM enroll WHERE DATE(create_time)<DATE_SUB(DATE(NOW()),INTERVAL 6*30 DAY) AND specialty_id!=1) AS 'num'");
		sql.append("FROM test WHERE id=1 ");
		Record list=Db.findFirst(sql.toString());
		System.out.println(list);
		return list;
	}
}
