package dao;

import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Record;

public class ClassDao {
	public Record Classcount(){
		StringBuffer sql=new StringBuffer();
		sql.append("SELECT ");
		sql.append("(SELECT COUNT(*) FROM class WHERE MONTH (create_time) = 1 AND YEAR (create_time) = YEAR(now()))AS 'c_1', ");
		sql.append("(SELECT COUNT(*) FROM class WHERE MONTH (create_time) = 2 AND YEAR (create_time) = YEAR(now()))AS 'c_2', ");
		sql.append("(SELECT COUNT(*) FROM class WHERE MONTH (create_time) = 3 AND YEAR (create_time) = YEAR(now()))AS 'c_3', ");
		sql.append("(SELECT COUNT(*) FROM class WHERE MONTH (create_time) = 4 AND YEAR (create_time) = YEAR(now()))AS 'c_4', ");
		sql.append("(SELECT COUNT(*) FROM class WHERE MONTH (create_time) = 5 AND YEAR (create_time) = YEAR(now()))AS 'c_5', ");
		sql.append("(SELECT COUNT(*) FROM class WHERE MONTH (create_time) = 6 AND YEAR (create_time) = YEAR(now()))AS 'c_6', ");
		sql.append("(SELECT COUNT(*) FROM class WHERE MONTH (create_time) = 7 AND YEAR (create_time) = YEAR(now()))AS 'c_7', ");
		sql.append("(SELECT COUNT(*) FROM class WHERE MONTH (create_time) = 8 AND YEAR (create_time) = YEAR(now()))AS 'c_8', ");
		sql.append("(SELECT COUNT(*) FROM class WHERE MONTH (create_time) = 9 AND YEAR (create_time) = YEAR(now()))AS 'c_9', ");
		sql.append("(SELECT COUNT(*) FROM class WHERE MONTH (create_time) = 10 AND YEAR (create_time) = YEAR(now()))AS 'c_10', ");
		sql.append("(SELECT COUNT(*) FROM class WHERE MONTH (create_time) = 11 AND YEAR (create_time) = YEAR(now()))AS 'c_11', ");
		sql.append("(SELECT COUNT(*) FROM class WHERE MONTH (create_time) = 12 AND YEAR (create_time) = YEAR(now()))AS 'c_12'  ");
		sql.append("FROM test WHERE id=1 ");
		Record list=Db.findFirst(sql.toString());
		return list;
	}
}
