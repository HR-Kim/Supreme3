package kr.co.supreme.orderstatus.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import kr.co.supreme.orderstatus.service.OrderStatusService;

@Controller
public class OrderStatusController {

	Logger LOG = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	OrderStatusService orderStatusService;
	
			
}
