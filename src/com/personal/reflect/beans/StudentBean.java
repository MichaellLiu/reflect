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
		System.out.println("�ú�ѧϰ���������ϡ�");
	}
	
	public void playGame(String gameName){
		System.out.println("����ϲ������Ϸ�ǣ�" + gameName);
	}
	
	public  static void eat(String food){
		System.out.println("��ϲ���Ե���"+food);
	}
}
