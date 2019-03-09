package com.Deff83;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.imageio.ImageIO;

import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;


public class ScreenShot {
	private SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd_HH_mm_ss");
	private SimpleDateFormat formatterdate = new SimpleDateFormat("yyyyMMddHH");
	public ScreenShot() {
		// TODO Auto-generated constructor stub
	}
	public void screen(String pathp) throws Exception {
		Calendar now = Calendar.getInstance();
		Robot robot = new Robot();
		BufferedImage screenShot = robot.createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
		File folder = new File(pathp+"screen");
		if(!folder.exists()) {
			System.out.println("create folder screen");
			folder.mkdirs();
		}
		File folderh = new File(pathp+"screen\\"+formatterdate.format(now.getTime()));
		if(!folderh.exists()) {
			folderh.mkdirs();
			System.out.println("create folder "+formatterdate.format(now.getTime()));
		}
		File file = new File(pathp+"screen\\"+formatterdate.format(now.getTime()),formatter.format(now.getTime())+".png");
		
		ImageIO.write(screenShot, "PNG", file);
		System.out.println(formatter.format(now.getTime()));
	}
}
