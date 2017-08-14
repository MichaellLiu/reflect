package com.personal.reflect.beans;

import java.io.Serializable;

public final class StudentBean implements Serializable,Cloneable{
	
	public String name;
	
	private int age;
	
	public StudentBean() throws Exception{
		
	}
	
	public StudentBean(String name, int age){
		this.name = name;
		this.age = age;
	}
	
	public void study(){
		System.out.println("好好学习，天天向上。");
	}
	
	public void playGame(String gameName){
		System.out.println("我最喜欢的游戏是：" + gameName);
	}
	
	public  static void eat(String food){
		System.out.println("我喜欢吃的是"+food);
	}
}
