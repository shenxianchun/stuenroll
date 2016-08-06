package dao;

import java.util.List;

import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Record;

public class EnrollDao{
	public Record Count(){
		String sql="select count(*) from enroll";
		Record count=Db.findFirst(sql);
		return count;
	}
	public Record Enrollcount(){//统计每个月报名量
		StringBuffer sql=new StringBuffer();
		sql.append("SELECT ");
		sql.append("(SELECT COUNT(*) FROM enroll WHERE MONTH (create_time) = 1 AND YEAR (create_time) = YEAR(now()))AS 'Jan', ");
		sql.append("(SELECT COUNT(*) FROM enroll WHERE MONTH (create_time) = 2 AND YEAR (create_time) = YEAR(now()))AS 'Feb', ");
		sql.append("(SELECT COUNT(*) FROM enroll WHERE MONTH (create_time) = 3 AND YEAR (create_time) = YEAR(now()))AS 'Mar', ");
		sql.append("(SELECT COUNT(*) FROM enroll WHERE MONTH (create_time) = 4 AND YEAR (create_time) = YEAR(now()))AS 'Apr', ");
		sql.append("(SELECT COUNT(*) FROM enroll WHERE MONTH (create_time) = 5 AND YEAR (create_time) = YEAR(now()))AS 'May', ");
		sql.append("(SELECT COUNT(*) FROM enroll WHERE MONTH (create_time) = 6 AND YEAR (create_time) = YEAR(now()))AS 'Jun', ");
		sql.append("(SELECT COUNT(*) FROM enroll WHERE MONTH (create_time) = 7 AND YEAR (create_time) = YEAR(now()))AS 'Jul', ");
		sql.append("(SELECT COUNT(*) FROM enroll WHERE MONTH (create_time) = 8 AND YEAR (create_time) = YEAR(now()))AS 'Aug', ");
		sql.append("(SELECT COUNT(*) FROM enroll WHERE MONTH (create_time) = 9 AND YEAR (create_time) = YEAR(now()))AS 'Sep', ");
		sql.append("(SELECT COUNT(*) FROM enroll WHERE MONTH (create_time) = 10 AND YEAR (create_time) = YEAR(now()))AS 'Oct', ");
		sql.append("(SELECT COUNT(*) FROM enroll WHERE MONTH (create_time) = 11 AND YEAR (create_time) = YEAR(now()))AS 'Nov', ");
		sql.append("(SELECT COUNT(*) FROM enroll WHERE MONTH (create_time) = 12 AND YEAR (create_time) = YEAR(now()))AS 'Dec'  ");
		sql.append("FROM test WHERE id=1 ");
		Record list=Db.findFirst(sql.toString());
		System.out.println(list);
		return list;
	}
	public Record EnrollStudent(){//统计每个月学员量
		StringBuffer sql=new StringBuffer();
		sql.append("SELECT ");
		sql.append("(SELECT COUNT(*) FROM enroll WHERE MONTH (create_time) = 1 "
				+ "AND YEAR (create_time) = YEAR(now()) AND state_id!=1) AS 'Jan', ");
		sql.append("(SELECT COUNT(*) FROM enroll WHERE MONTH (create_time) = 2 "
				+ "AND YEAR (create_time) = YEAR(now()) AND state_id!=1) AS 'Feb', ");
		sql.append("(SELECT COUNT(*) FROM enroll WHERE MONTH (create_time) = 3 "
				+ "AND YEAR (create_time) = YEAR(now()) AND state_id!=1) AS 'Mar', ");
		sql.append("(SELECT COUNT(*) FROM enroll WHERE MONTH (create_time) = 4 "
				+ "AND YEAR (create_time) = YEAR(now()) AND state_id!=1) AS 'Apr', ");
		sql.append("(SELECT COUNT(*) FROM enroll WHERE MONTH (create_time) = 5 "
				+ "AND YEAR (create_time) = YEAR(now()) AND state_id!=1) AS 'May', ");
		sql.append("(SELECT COUNT(*) FROM enroll WHERE MONTH (create_time) = 6 "
				+ "AND YEAR (create_time) = YEAR(now()) AND state_id!=1) AS 'Jun', ");
		sql.append("(SELECT COUNT(*) FROM enroll WHERE MONTH (create_time) = 7 "
				+ "AND YEAR (create_time) = YEAR(now()) AND state_id!=1) AS 'Jul', ");
		sql.append("(SELECT COUNT(*) FROM enroll WHERE MONTH (create_time) = 8 "
				+ "AND YEAR (create_time) = YEAR(now()) AND state_id!=1) AS 'Aug', ");
		sql.append("(SELECT COUNT(*) FROM enroll WHERE MONTH (create_time) = 9 "
				+ "AND YEAR (create_time) = YEAR(now()) AND state_id!=1) AS 'Sep', ");
		sql.append("(SELECT COUNT(*) FROM enroll WHERE MONTH (create_time) = 10 "
				+ "AND YEAR (create_time) = YEAR(now()) AND state_id!=1) AS 'Oct', ");
		sql.append("(SELECT COUNT(*) FROM enroll WHERE MONTH (create_time) = 11 "
				+ "AND YEAR (create_time) = YEAR(now()) AND state_id!=1) AS 'Nov', ");
		sql.append("(SELECT COUNT(*) FROM enroll WHERE MONTH (create_time) = 12 "
				+ "AND YEAR (create_time) = YEAR(now()) AND state_id!=1) AS 'Dec'  ");
		sql.append("FROM test WHERE id=1 ");
		Record list=Db.findFirst(sql.toString());
		System.out.println(list);
		return list;
	}
	public Record EnrollRecently(String time){
		StringBuffer sql=new StringBuffer();
		sql.append("SELECT ");
		sql.append("(SELECT COUNT(*) FROM enroll "
				+ "WHERE DATE(create_time) BETWEEN DATE_SUB(DATE(NOW()),INTERVAL ? DAY)"
				+ " AND DATE(NOW())) AS 'num'");
		sql.append("FROM test WHERE id=1 ");
		Record list=Db.findFirst(sql.toString(),time);
		System.out.println(list);
		return list;
	}
	public Record EnrollRecentlySixMonthDayBefore(){
		StringBuffer sql=new StringBuffer();
		sql.append("SELECT ");
		sql.append("(SELECT COUNT(*) FROM enroll WHERE "
				+ "DATE(create_time)<DATE_SUB(DATE(NOW()),INTERVAL 6*30 DAY)) AS 'num'");
		sql.append("FROM test WHERE id=1 ");
		Record list=Db.findFirst(sql.toString());
		System.out.println(list);
		return list;
	}
	public Record Enrolldrop(String time){
		StringBuffer sql=new StringBuffer();
		sql.append("SELECT ");
		sql.append("(SELECT COUNT(*) FROM enroll WHERE DATE(create_time) BETWEEN DATE_SUB(DATE(NOW()),INTERVAL ? DAY) AND DATE(NOW()) AND state_id='6') AS 'num'");
		sql.append("FROM test WHERE id=1 ");
		Record list=Db.findFirst(sql.toString(),time);
		System.out.println(list);
		return list;
	}
	public Record EnrolldropSixMonthDayBefore(){
		StringBuffer sql=new StringBuffer();
		sql.append("SELECT ");
		sql.append("(SELECT COUNT(*) FROM enroll WHERE DATE(create_time)<DATE_SUB(DATE(NOW()),INTERVAL 6*30 DAY) AND state_id='6') AS 'num'");
		sql.append("FROM test WHERE id=1 ");
		Record list=Db.findFirst(sql.toString());
		System.out.println(list);
		return list;
	}
	public boolean Mypid(String pid){//验证身份证号是否存在
		boolean tt=false;
		StringBuffer sql=new StringBuffer();
		sql.append("SELECT pid FROM enroll WHERE pid=? ");
		Record list=Db.findFirst(sql.toString(),pid);
		if(list!=null){
			tt=true;
		}
		return tt;
	}
	public Record EnrollWord(String pid){//查询我的报名表
		StringBuffer sql=new StringBuffer();
		sql.append("SELECT ");
		sql.append("pid,enroll.id,enroll.`name`,sex,nation,graduate_school,graduate_year,graduate_date,graduate_specialty,education,healthy,politics,birthday,enroll.address,household_address,home_address,enroll.tel,home_tell,email,orgnization.`name` AS orgnization_name,specialty.`name` AS specialty_name,place,`year` ");
		sql.append("FROM enroll,orgnization,specialty ");
		sql.append("WHERE orgnization_id = enroll.orgnization_id AND specialty_id = enroll.specialty_id AND enroll.pid = ? ");
		sql.append("GROUP BY id");
		Record list=Db.findFirst(sql.toString(),pid);
		System.out.println(list);
		return list;
	}
}
