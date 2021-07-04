package com.mg.springboot_project;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

@SpringBootTest
class SpringbootProjectApplicationTests {
	private final static Logger log= LoggerFactory.getLogger(SpringbootProjectApplicationTests.class);

	@Autowired
	private Configuration configuration;

	@Test
	public void createHtmlTest() throws IOException, TemplateException {
		Template template = configuration.getTemplate("freemark.ftl");
		HashMap<String, Object> map = new HashMap<>();
		map.put("username", "mg");
		FileWriter fileWriter = new FileWriter(
				"C:\\maven(workspace)\\mg_test20210424\\springboot_project\\" +
						"src\\main\\resources\\static\\s.html");
		template.process(map, fileWriter);

		log.debug("debug级别输出");
		log.info("{}生成静态页成功！","mg");
	}

}
