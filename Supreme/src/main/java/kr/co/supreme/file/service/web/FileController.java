package kr.co.supreme.file.service.web;

import static kr.co.supreme.cmn.StringUtil.UPLOAD_ROOT;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;

import kr.co.supreme.cmn.Message;
import kr.co.supreme.cmn.StringUtil;
import kr.co.supreme.file.service.FileService;


@Controller
public class FileController {
	private final Logger LOG = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private FileService fileService;
	
	private final String VIEW_LIST_NM = "file/file_list";
	private final String VIEW_MNG_NM = "file/file_mng";	
	
	
	
	@RequestMapping(value="file/do_retrieve.do",method = RequestMethod.POST
			,produces = "application/json;charset=UTF-8")
	@ResponseBody	
	public String get_fileList(kr.co.supreme.file.service.File inVO) {
		LOG.debug("=============================");
		LOG.debug("=inVO=="+inVO);
		LOG.debug("=============================");
		
		List<kr.co.supreme.file.service.File> fileList = (List<kr.co.supreme.file.service.File>) fileService.get_retrieve(inVO);
		LOG.debug("=============================");
		LOG.debug("=fileList=="+fileList);
		LOG.debug("=============================");
		
		Gson gson=new Gson();
		String json = gson.toJson(fileList);
		LOG.debug("=============================");
		LOG.debug("=json=="+json);
		LOG.debug("=============================");		
		
		
		return json;
	}
	
	
	//ModelAndView : Model + View
	@RequestMapping(value="file/do_save.do",method = RequestMethod.POST
			,produces = "application/json;charset=UTF-8")
	@ResponseBody	
	public String do_save(MultipartHttpServletRequest mReg) throws IllegalStateException, IOException {
		LOG.debug("===============================");
		LOG.debug("=@Controller do_save=");
		LOG.debug("===============================");
		//Upload파일 정보: 원본,저장,사이즈,확장자 List
		List<kr.co.supreme.file.service.File> fileList = new ArrayList<kr.co.supreme.file.service.File>();
		
		String workDiv = StringUtil.nvl(mReg.getParameter("work_div"));
		String fileId = StringUtil.nvl(mReg.getParameter("attrFileId"));

		LOG.debug("=@Controller workDiv="+workDiv);
		LOG.debug("=@Controller fileId="+fileId);
		
		//01.동적으로 UPLOAD_ROOT 디렉토리 생성
		File  fileRootDir = new File(UPLOAD_ROOT);
		if(fileRootDir.isDirectory() ==false) {  
			boolean flag = fileRootDir.mkdirs();
			LOG.debug("=@Controller flag="+flag);
		}
		
		//02.년월 디렉토리 생성:D:\\HR_FILE\2019\10
		String yyyy = StringUtil.cureDate("yyyy");
		LOG.debug("=@Controller yyyy="+yyyy);
		String mm = StringUtil.cureDate("MM");
		LOG.debug("=@Controller mm="+mm);
		String datePath = UPLOAD_ROOT+File.separator+yyyy+File.separator+mm;
		LOG.debug("=@Controller datePath="+datePath);
		
		File  fileYearMM = new File(datePath);  
		
		if(fileYearMM.isDirectory()==false) {
			boolean flag = fileYearMM.mkdirs();  
			LOG.debug("=@Controller fileYearMM flag="+flag);
		}
		
		int flag  =0;
		Message message=new Message();
		
		//01.파일 Read      
		Iterator<String> files = mReg.getFileNames();
		while(files.hasNext()) {
			kr.co.supreme.file.service.File fileVO=new kr.co.supreme.file.service.File();
			String orgFileNm  = "";//원본파일명
			String saveFileNm = "";//저장파일명
			long   fileSize   = 0L;//파일사이즈
			String ext        = "";//확장자
			
			String uploadFileNm = files.next();//file01
			MultipartFile mFile = mReg.getFile(uploadFileNm);
			orgFileNm = mFile.getOriginalFilename();
			//file선택이 않되면 continue
			if(null==orgFileNm || orgFileNm.equals(""))continue;
			
			
			LOG.debug("=@Controller uploadFileNm="+uploadFileNm);
			LOG.debug("=@Controller orgFileNm="+orgFileNm);
			fileSize = mFile.getSize();//file size byte
			
			if(orgFileNm.indexOf(".")>-1) {
				ext = orgFileNm.substring(orgFileNm.indexOf(".")+1);
			}
			LOG.debug("=@Controller fileSize="+fileSize);
			LOG.debug("=@Controller ext="+ext);
			File orgFileCheck = new File(datePath,orgFileNm);
			
			String newFile = orgFileCheck.getAbsolutePath();
			//04.파일 rename: README -> README1~9999
			if(orgFileCheck.exists()==true) {
				newFile = StringUtil.fileRename(orgFileCheck);
			}
			
			//-----------------------------------------------
			//-FileId 존재 유무로 Key생성 유무 판단.
			//-----------------------------------------------
			//FileId 업는 경우
			if(fileId.equals("") || fileId.length()==0) {
				String yyyymmdd = StringUtil.cureDate("yyyyMMdd");
				String fileIdKey= yyyymmdd+StringUtil.getUUID();
				LOG.debug("yyyymmdd:"+yyyymmdd);
				LOG.debug("fileIdKey:"+fileIdKey);
				fileVO.setFileId(fileIdKey);
				fileVO.setNum(1);
				fileId = fileIdKey;
			}else {
				
				fileVO.setFileId(fileId);
				//max num
				int maxNum = this.fileService.num_max_plus_one(fileVO);
				LOG.debug("maxNum:"+maxNum);
				fileVO.setNum(maxNum);
			}
			
			fileVO.setOrgFileNm(orgFileNm);
			fileVO.setSaveFileNm(newFile);
			fileVO.setfSize(fileSize);
			fileVO.setExt(ext);
			fileList.add(fileVO);
			mFile.transferTo(new File(newFile));
			
			flag = fileService.do_save(fileVO);
			LOG.debug("flag:"+flag);
		}

		//등록성공
		if(flag>0) {
			message.setMsgId(String.valueOf(flag));
			message.setMsgMsg(fileId);
		//등록실패	
		}else {
			message.setMsgId(String.valueOf(flag));
			message.setMsgMsg("등록실패.");	
		}
		Gson gson=new Gson();
		
		String gsonStr = gson.toJson(message);
		LOG.debug("gsonStr:"+gsonStr);
		return gsonStr;
	}
		
}
