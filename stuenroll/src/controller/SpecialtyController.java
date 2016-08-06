package controller;

import java.util.List;

import com.jfinal.core.Controller;
import com.jfinal.plugin.activerecord.Record;

import config.Factory;
import dao.SpecialtyDao;

public class SpecialtyController extends Controller{
	private SpecialtyDao specialtyDao=(SpecialtyDao) Factory.getBean("SpecialtyDao");
	public void searchAll(){
		List<Record> list = specialtyDao.searchAll();
		setAttr("list",list);
		renderJson();//把数据以JSON格式返回给浏览器
	}
	public void Specialtyenrollcount(){
		List<Record> data_1 = specialtyDao.Specialtyenrollcount();
		setAttr("data_1",data_1);
		renderJson();//把数据以JSON格式返回给浏览器
	}
}
