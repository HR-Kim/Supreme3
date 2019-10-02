package kr.co.supreme.code.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.supreme.cmn.DTO;
import kr.co.supreme.code.service.CodeService;



@Service
public class CodeServiceImpl implements CodeService {
	@Autowired
	private CodeDaoImpl codeDaoImpl;
	
	@Override
	public List<?> get_retrieve(DTO dto) {
		
		return codeDaoImpl.get_retrieve(dto);
	}

}
