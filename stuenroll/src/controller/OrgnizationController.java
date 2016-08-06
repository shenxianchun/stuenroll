package controller;

import java.util.List;

import com.jfinal.core.Controller;
import com.jfinal.plugin.activerecord.Record;

import config.Factory;
import dao.OrgnizationDao;

public class OrgnizationController extends Controller{
	private OrgnizationDao orgnizationDao=(OrgnizationDao) Factory.getBean("OrgnizationDao");
	public void searchAll(){
		List<Record> list=orgnizationDao.searchAll();
		setAttr("list",list);
		renderJson();
	}
	
}
