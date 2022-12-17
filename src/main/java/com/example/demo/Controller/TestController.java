package com.example.demo.Controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.Config.AppConfig;

import lombok.Data;

@Controller
@Data
@RequestMapping("/test")
public class TestController {
	@Autowired
	private AppConfig appConfig;
	
	@Autowired
	ServletContext servletContext;
	
	//ユーザーを作成画面へ移動
	@GetMapping("/showimage")
	public String showImage(Model model) {
		Path p1 = Paths.get("");
		Path p2 = p1.toAbsolutePath();

		System.out.println(p2.toString());
		
		String dir = getServletContext().getRealPath("/");
		System.out.println(dir.toString());
		
		return "imagetest";
	}
	
	@PostMapping("/uploadimage")
	public String upload(@RequestParam MultipartFile file, Model model) {
		if(file.isEmpty()) {
			model.addAttribute("error", "ファイルを指定してください");
			return "imagetest";
		}
		File dest = new File(appConfig.getImageDir(),"picture.jpg");
		try {
			file.transferTo(dest); //表示される修正候補の「try/catchで囲む」を選択
		} catch (IllegalStateException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		} catch (IOException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		return "imagetest";
		
	}
 
}
