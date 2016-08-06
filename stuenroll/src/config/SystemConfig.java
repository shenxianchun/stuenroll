package config;

import java.util.Date;
import java.util.Timer;

import com.jfinal.config.Constants;
import com.jfinal.config.Handlers;
import com.jfinal.config.Interceptors;
import com.jfinal.config.JFinalConfig;
import com.jfinal.config.Plugins;
import com.jfinal.config.Routes;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.druid.DruidPlugin;
import com.jfinal.plugin.redis.RedisPlugin;
import com.jfinal.render.ViewType;

import controller.OrgnizationController;
import controller.SpecialtyController;
import controller.WelcomeController;
import controller.EnrollController;

public class SystemConfig extends JFinalConfig{

	@Override
	public void configConstant(Constants constants) {
		// TODO Auto-generated method stub
		constants.setDevMode(true);//开启开发者模式
		constants.setViewType(ViewType.JSP);//设置jsp和html作为网页界面
		
	}

	@Override
	public void configHandler(Handlers arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void configInterceptor(Interceptors arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void configPlugin(Plugins plugins) {
		// TODO Auto-generated method stub
		///配置数据库strat==============================================================
		DruidPlugin druidPlugin=new DruidPlugin("jdbc:mysql://localhost:8066/MyDB", "admin", "Sxc323556");
		druidPlugin.setDriverClass("com.mysql.jdbc.Driver");//数据库驱动类
		druidPlugin.setInitialSize(5);//最小链接数
		druidPlugin.setMaxActive(20);//最大连接数
		druidPlugin.setTestOnBorrow(true);//每次使用数据库链接前先检测链接是否可用
		druidPlugin.setValidationQuery("select 1");//测试链接的sql语句
		plugins.add(druidPlugin);//把连接池添加到JFinal框架
		
		ActiveRecordPlugin recordPlugin=new ActiveRecordPlugin(druidPlugin);//创建持久层对象并且使用Druid连接池
		plugins.add(recordPlugin);//把持久层对象添加到JFinal框架
		///配置数据库end==============================================================
		
		
		//配置Redis start--------------------------------------------------------------
		RedisPlugin redisPlugin=new RedisPlugin("enroll", "localhost","Sxc323556");//创建redis插件
		plugins.add(redisPlugin);//把Redis插件添加到JFinal框架
		//配置Redis end-----------------------------------------------------------------
		
	}

	@Override
	public void configRoute(Routes routes) {
		// TODO Auto-generated method stub
		routes.add("/specialty",SpecialtyController.class);
		routes.add("/orgnization",OrgnizationController.class);
		routes.add("/enroll",EnrollController.class);
		routes.add("/welcome",WelcomeController.class);
	}
	@Override
	public void afterJFinalStart() {//JFinal框架运行起来后开始执行此方法   同时启动定时器
		// TODO Auto-generated method stub
		//super.afterJFinalStart();
		Timer timer=new Timer();
		//启动定时器
		//timer.schedule(new RedisTask(), new Date("2016/1/11 10:59:00"));//在固定的时间执行
		timer.scheduleAtFixedRate(new RedisTask(), new Date("2016/1/11 11:30:00"), 3000);//每隔一段时间循环执行一次
	}

}
