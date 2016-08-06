package controller;

import java.io.File;

import com.jfinal.core.Controller;
import com.jfinal.plugin.activerecord.Record;

import config.Factory;
import dao.EnrollDao;

public class WelcomeController extends Controller{
	private EnrollDao enrollDao=(EnrollDao) Factory.getBean("EnrollDao");
	private EnrollWord enrollword=new EnrollWord();
	public void specialtyExcle(){
		renderFile(new File("E:/培训专业名录.xlsx"));
	}
	public void enrollWord(){
		renderFile(new File("E:/报名表.docx"));
	}
	public void word(){
		boolean tt=false;
		String pid=getPara("pid");
		if(enrollDao.Mypid(pid)){
			tt=true;
			setAttr("result", tt);
		}else{
			setAttr("result", tt);
		}
		renderJson();
	}
	public void MyWord(){
		String pid=getPara("pid");
		//String pid="532128199307213915";
			Record list=enrollDao.EnrollWord(pid);
				try {
					enrollword.Myword(list);
				}
				catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			renderFile(new File("E:/我的报名表.docx"));
	}
	
}
