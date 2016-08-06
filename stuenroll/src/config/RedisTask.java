package config;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TimerTask;

import com.jfinal.plugin.redis.Cache;
import com.jfinal.plugin.redis.Redis;



//定时器-----------------------------------
public class RedisTask extends TimerTask{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		//System.out.println("HelloWrold");
		Cache cache=Redis.use("enroll");
		Set<String> set=cache.keys("*");	//缓存的所有的Key	set集合无顺序
		//根据每一个Key获得对应的报名数据
		Iterator<String> iterator=set.iterator();
		while(iterator.hasNext()){
			String key=iterator.next();
			List<String> list=cache.hmget(key, "name","sex","pid");
			System.out.println(list);
			//调用DAO把数据保存到数据库里面
			//cache.del(key);//数据保存到数据库之后删除Redis里面的这条数据
		}
	}

}
