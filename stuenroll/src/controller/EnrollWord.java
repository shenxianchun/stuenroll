package controller;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

import com.jfinal.core.Controller;
import com.jfinal.plugin.activerecord.Record;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.ooxml.JRDocxExporter;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.export.ExporterOutput;

public class EnrollWord extends Controller{
	public void Myword(Record listword) throws Exception, JRException {
		HashMap parameter = new HashMap();
		parameter.put("name", listword.getStr("name"));
		parameter.put("sex", listword.getStr("sex"));
		parameter.put("nation", listword.getStr("nation"));
		parameter.put("pid", listword.getStr("pid"));
		parameter.put("graduate_school", listword.getStr("graduate_school"));
		parameter.put("graduate_year", listword.getInt("graduate_year")+"");
		parameter.put("graduate_date",listword.get("graduate_date")+"");
		parameter.put("graduate_specialty",listword.getStr("graduate_specialty"));
		parameter.put("education", listword.getStr("education"));
		parameter.put("healthy", listword.getStr("healthy"));
		
		parameter.put("politics", listword.getStr("politics"));
		parameter.put("birthday", listword.get("birthday")+"");
		parameter.put("address", listword.getStr("address"));
		parameter.put("household_address", listword.getStr("household_address"));
		parameter.put("home_address", listword.getStr("home_address"));
		parameter.put("tel", listword.getStr("tel"));
		parameter.put("home_tel",listword.getStr("home_tell"));
		parameter.put("email", listword.getStr("email"));
		parameter.put("orgnization_id", listword.getStr("orgnization_name"));
		parameter.put("specialty_id", listword.getStr("specialty_name"));
		parameter.put("place", listword.getStr("place"));
		
		HashSet set = new HashSet();
		set.add("Hello");
	
		JRBeanCollectionDataSource source = new JRBeanCollectionDataSource(set);
		JasperReport jasperReport=(JasperReport) JRLoader.loadObject(new FileInputStream("E:/stuenroll.jasper"));
		JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameter, source);
		
		ArrayList list=new ArrayList();
		list.add(jasperPrint);
		JRDocxExporter exporter=new JRDocxExporter();
		exporter.setParameter(JRExporterParameter.JASPER_PRINT_LIST, list);
		exporter.setParameter(JRExporterParameter.OUTPUT_FILE, new File("E:/我的报名表.docx"));
		exporter.exportReport();
	}
}
