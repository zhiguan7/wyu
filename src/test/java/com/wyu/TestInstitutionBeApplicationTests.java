package com.wyu;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.util.FileCopyUtils;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;

@SpringBootTest
class TestInstitutionBeApplicationTests {

	@Test
	void contextLoads() throws IOException {
		String src = ResourceUtils.getURL("").getPath()+"/src/main/resources/temporary";
		String des = ResourceUtils.getURL("").getPath()+"/src/main/resources/data/ddd/ddd";
		File srcFile = new File(src);
		String[] srcFileNames = srcFile.list();
		System.out.println(srcFileNames[0].substring(0,srcFileNames[0].lastIndexOf(".")));

		FileChannel inputChannel = null;
		FileChannel outputChannel = null;
		File file = new File(des);
		if(!file.exists()) System.out.println(file.mkdirs());
		try {
  		inputChannel = new FileInputStream(src+"/"+srcFileNames[0]).getChannel();
   		outputChannel = new FileOutputStream(des+"/"+srcFileNames[0]).getChannel();
    	outputChannel.transferFrom(inputChannel, 0, inputChannel.size());
 		}finally {
			inputChannel.close();
			outputChannel.close();
		}
	}

}
