package com.Deff83;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.*;

public class Main {
	public final static String sp = System.getProperty("line.separator");
	

	public Main() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String pathp = null;
		Integer timerp = 5;
		ScreenShot screenshot = new ScreenShot();
		File configfilest = new File("config.xml");
		if(!configfilest.exists()) {
			FileChoose filech = new FileChoose();
		}
		while(true) {
			try {
				File configfile = new File("config.xml");
				if(!configfile.exists()) {
					
					
				}else{
					DocumentBuilder docBuild = DocumentBuilderFactory.newInstance().newDocumentBuilder();
					Document doc = docBuild.parse("config.xml");
					Node root = doc.getDocumentElement();
					NodeList configlist = root.getChildNodes();
					for(int i=0; i<configlist.getLength(); i++) {
						Node path = configlist.item(i);
						if(path.getNodeType() != path.TEXT_NODE) {
							switch(path.getNodeName()) {
							case "Path":
								pathp = path.getTextContent()+"\\";
							break;
							case "Timer":
								int timerpp = Integer.parseInt(path.getTextContent());
								if (timerpp >= 1) {
									timerp = timerpp;
								}
							break;
							}
							
						}
						
					}
					
					if(pathp != null) {
						File folder = new File(pathp);
						if(!folder.exists()) {
							System.out.println("create folder "+pathp);
							folder.mkdirs();
						}
						screenshot.screen(pathp);
					}else {
						System.out.println("pathp null");
					}
					
				};
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				Thread.sleep(timerp*1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
