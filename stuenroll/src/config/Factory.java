package config;

import java.util.HashMap;
import dao.ClassDao;
import dao.EnrollDao;
import dao.OrgnizationDao;
import dao.SpecialtyDao;

public class Factory {
	private static HashMap map=new HashMap();
	static {
		map.put("SpecialtyDao", new SpecialtyDao());
		map.put("OrgnizationDao", new OrgnizationDao());
		map.put("EnrollDao",new EnrollDao());
		map.put("ClassDao", new ClassDao());
	}
	public static Object getBean(String param){
		if(map.containsKey(param)){
			return map.get(param);
		}else{
			return null;
		}
	}
}
