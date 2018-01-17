package com.atguigu.servlet;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadBase.FileSizeLimitExceededException;
import org.apache.commons.fileupload.FileUploadBase.SizeLimitExceededException;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.IOUtils;

/**
 * Servlet implementation class FileUploadServlet
 */
public class FileUploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取请求参数
	/*	request.setCharacterEncoding("utf-8");
		String nickname = request.getParameter("nickname");
		String file = request.getParameter("file");
		System.out.println(nickname+"--"+file);*/
		
		ServletInputStream in = request.getInputStream();
		
		//创建工厂类
		DiskFileItemFactory factory = new DiskFileItemFactory();
		
		//获取解析器
		ServletFileUpload upload = new ServletFileUpload(factory);
		
		//上传文件总大小不可以超过5KB
		upload.setSizeMax(1024*10);
		
		//上传单个文件大小不可以超过3KB
		upload.setFileSizeMax(1024*3);
		
		try {
			//解析request
			List<FileItem> list = upload.parseRequest(request);
			
			//处理部件 
			for (FileItem item : list) {
				
				//区分普通表单项与文件表单项
				boolean flag = item.isFormField();
				if(flag){
					//普通表单项
					//获取name属性值 
					String fieldName = item.getFieldName();
					//获取value属性值 
					String value = item.getString("utf-8");
					
					System.out.println("普通表单项:"+fieldName+"--"+value);
					
				}else{
					//文件表单项
					
					//获取文件大小
					long size = item.getSize();
					
					if(size==0){
						continue;
					}
					
					//获取文件类型
					String contentType = item.getContentType();
					
					//获取文件的名称
					String name = item.getName();
					
					//c\:/photo/狗狗.jpg
					if(name.contains("/")){
						name= name.substring(name.lastIndexOf("/")+1);
					}
					
					//获取物理路径
					String realPath = getServletContext().getRealPath("/upload");
					File file = new File(realPath);
					if(!file.exists()){
						file.mkdirs();
					}
					
					//文件名确保唯一
					String uuid = UUID.randomUUID().toString().replace("-", "");
					//狗狗.jpg---> 2323423445056_狗狗.jpg --》2323423445056_c\:/photo/狗狗.jpg
					
					name = uuid+"_"+name;
					
					//将文件保存到服务器
					File file2 = new File(realPath+"/"+name);
					try {
						item.write(file2);
					} catch (Exception e) {
						e.printStackTrace();
					}
					
					
					System.out.println("文件表单项："+size+"--"+contentType+"--"+name);
				//	System.out.println("文件表单项："+realPath);
					
				}
			}
		} catch (SizeLimitExceededException e){
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			request.setAttribute("msg", "总文件大小超过限制");
			request.getRequestDispatcher("/index.jsp").forward(request, response);
		} catch (FileSizeLimitExceededException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			request.setAttribute("msg", "单个文件大小超过限制");
			request.getRequestDispatcher("/index.jsp").forward(request, response);
		}catch (FileUploadException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

		
	}

}
