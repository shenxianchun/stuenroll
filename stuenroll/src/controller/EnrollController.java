package controller;

import java.util.HashMap;
import java.util.List;

import com.jfinal.core.Controller;
import com.jfinal.plugin.activerecord.Record;
import com.jfinal.plugin.redis.Cache;
import com.jfinal.plugin.redis.Redis;

import config.Factory;
import dao.ClassDao;
import dao.EnrollDao;
import dao.SpecialtyDao;

public class EnrollController extends Controller{
	private EnrollDao enrollDao=(EnrollDao) Factory.getBean("EnrollDao");
	private ClassDao classDao=(ClassDao) Factory.getBean("ClassDao");
	private SpecialtyDao specialtyDao=(SpecialtyDao) Factory.getBean("SpecialtyDao");
	public void register(){
		String name=getPara("name");
		String sex=getPara("sex");
		String pid=getPara("pid");
		//把数据写入到Redis高速缓存存入Hash表
		Cache cache=Redis.use("enroll");
		HashMap map= new HashMap();
		map.put("name", name);
		map.put("sex", sex);
		map.put("pid", pid);
		cache.hmset(pid, map);
		
		setAttr("result",true);
		renderJson();
	}
	public void Enrollcount(){
		
		Record list_1=enrollDao.Enrollcount();
		setAttr("list_1", list_1);
		
		Record list_2=enrollDao.EnrollStudent();
		setAttr("list_2", list_2);
		
		Record list_3=classDao.Classcount();
		setAttr("list_3", list_3);
		
		
		renderJson();
	}
	public void Count(){
		Record count1=enrollDao.Count();
		setAttr("count", count1);
		System.out.println(count1);
		renderJson();
	}
	public void CountSum(){
		Record e_list_TenDay=enrollDao.EnrollRecently(10+"");
		setAttr("list_11", e_list_TenDay);
		
		Record e_list_OneMonth=enrollDao.EnrollRecently(30+"");
		setAttr("list_12", e_list_OneMonth);
		
		Record e_list_ThressMonth=enrollDao.EnrollRecently(3*30+"");
		setAttr("list_13", e_list_ThressMonth);
		
		Record e_list_sixMonth=enrollDao.EnrollRecently(6*30+"");
		setAttr("list_14", e_list_sixMonth);
		
		Record e_list_sixMonthbefore=enrollDao.EnrollRecentlySixMonthDayBefore();
		setAttr("list_15", e_list_sixMonthbefore);
		
		
		
		
		Record s_list_TenDay=specialtyDao.Recently(10+"");
		setAttr("list_21", s_list_TenDay);
		
		Record s_list_OneMonth=specialtyDao.Recently(30+"");
		setAttr("list_22", s_list_OneMonth);
		
		Record s_list_ThressMonth=specialtyDao.Recently(3*30+"");
		setAttr("list_23", s_list_ThressMonth);
		
		Record s_list_sixMonth=specialtyDao.Recently(6*30+"");
		setAttr("list_24", s_list_sixMonth);
		
		Record s_list_sixMonthbefore=specialtyDao.RecentlySixMonthDayBefore();
		setAttr("list_25", s_list_sixMonthbefore);
		
		
		Record d_list_TenDay=enrollDao.Enrolldrop(10+"");
		setAttr("list_31", d_list_TenDay);
		
		Record d_list_OneMonth=enrollDao.Enrolldrop(30+"");
		setAttr("list_32", d_list_OneMonth);
		
		Record d_list_ThressMonth=enrollDao.Enrolldrop(3*30+"");
		setAttr("list_33", d_list_ThressMonth);
		
		Record d_list_sixMonth=enrollDao.Enrolldrop(6*30+"");
		setAttr("list_34", d_list_sixMonth);
		
		Record d_list_sixMonthbefore=enrollDao.EnrolldropSixMonthDayBefore();
		setAttr("list_35", d_list_sixMonthbefore);
		
		renderJson();
	}
}
