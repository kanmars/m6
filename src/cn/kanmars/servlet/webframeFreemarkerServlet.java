package cn.kanmars.servlet;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import freemarker.ext.beans.BeansWrapper;
import freemarker.ext.servlet.FreemarkerServlet;
import freemarker.template.Template;
import freemarker.template.TemplateModel;
import freemarker.template.TemplateModelException;

public class webframeFreemarkerServlet extends FreemarkerServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4129788037798950604L;

	@Override
	protected boolean preTemplateProcess(HttpServletRequest request,
			HttpServletResponse response, Template template, TemplateModel data)
			throws ServletException, IOException {
		return super.preTemplateProcess(request, response, template, data);
	}

	@Override
	public void init() throws ServletException {
		super.init();
	}
	
	private void initConfiguration() throws Exception {
		Enumeration keys = FreeMarkerConfiguration.getConfigKeys();
		String key = null;
		Object value = null;
		while (keys.hasMoreElements()) {
			key = (String) keys.nextElement();
			value = FreeMarkerConfiguration.getConfigVal(key);
			try {
				getConfiguration().setSharedVariable(key, value);
			} catch (TemplateModelException tEx) {
				throw new RuntimeException("TemplateModelException",tEx);
			}
		}
		// config static functions
		getConfiguration().setSharedVariable("statics",
				BeansWrapper.getDefaultInstance().getStaticModels());
	}

}
