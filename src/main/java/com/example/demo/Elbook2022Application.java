package com.example.demo;

import java.io.File;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.demo.Config.AppConfig;

@SpringBootApplication
public class Elbook2022Application {

	public static void main(String[] args) {
		SpringApplication.run(Elbook2022Application.class, args);
	}
	
	
	@Bean//@Beanアノテーションを付けたメソッドを定義しておくことでSpring Frameworkがオブジェクトを登録して後で使える
	public AppConfig appConfig() {
		
		// 起動時のディレクトリをAppConfigのimageDirフィールドに保持しておく
		File imageDir = new File("images");
		imageDir = imageDir.getAbsoluteFile();
		
		// imagesフォルダがなかったら作成する
		if(!imageDir.exists()) {
			imageDir.mkdir();
		}
		AppConfig appConfig = new AppConfig();
		appConfig.setImageDir(imageDir);
		System.out.println(imageDir);
		return appConfig;
	}

}
