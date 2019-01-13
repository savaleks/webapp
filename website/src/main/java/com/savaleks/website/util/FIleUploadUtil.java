package com.savaleks.website.util;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

public class FIleUploadUtil {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(FIleUploadUtil.class);

	private static final String ABSOLUTE_PATH = "C:\\Users\\Alexander\\repos\\webapp\\website\\src\\main\\webapp\\assets\\images\\";
	private static String REAL_PATH = null;
	
	public static void uploadFile(HttpServletRequest request, MultipartFile file, String code) {
		
		REAL_PATH = request.getSession().getServletContext().getRealPath("/assets/images/");
		
		LOGGER.info(REAL_PATH);
		
		// check if directory exist
		if(!new File(ABSOLUTE_PATH).exists()) {
			new File(ABSOLUTE_PATH).mkdirs();
		}
		
		if(!new File(REAL_PATH).exists()) {
			new File(REAL_PATH).mkdirs();
		}
		
		try {
			// server upload
			file.transferTo(new File(REAL_PATH + code + ".jpg"));
			//project directory upload
			file.transferTo(new File(ABSOLUTE_PATH + code + ".jpg"));
		} catch (IOException e) {
		}
		
	}
}
