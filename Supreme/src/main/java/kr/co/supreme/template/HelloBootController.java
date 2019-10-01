package kr.co.supreme.template;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloBootController {

	private final Logger LOG = LoggerFactory.getLogger(this.getClass());
	
	@RequestMapping(value="template/index.do")
	public String helloBootView() {
		LOG.debug("==========================");
		LOG.debug("=@Controller=helloBootView");
		LOG.debug("==========================");
		return "template/index.do";
	}
	
}
