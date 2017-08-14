package com.personal.reflect.test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import com.personal.reflect.beans.StudentBean;

public class TestReflect {
	
	public static void main(String[] args) {
		//����Ķ��壺�����������롢֪̽��ʹ�ñ���ʱ��ȫδ֪���ࣻ
		//����Ĳ���
		//1.��ȡclass����-��ģ�����--���ĳ�����ͣ������������͡������������͡�void������Ϣ
		//1-1������ʵ�������ȡClass����---û�б���ʱδ֪�Ķ�̬Ч��
		//ֻ�ܻ�������������͵�Class������Ϊ��������û��ʵ������
		//û�ж�̬Ч��
		StudentBean stu = new StudentBean("zhang3",25);
		Class stuclass2 = stu.getClass();
		//1-2:ͨ����������ȡ�������
		//�ܻ�ȡ�������͵�Class���󣬵�����û�ж�̬Ч��
		Class stuclass232 = StudentBean.class;
		Class intClass = int.class;
		Class integerclass= Integer.class; 
		Class intClass1 = Integer.TYPE;
		Class stuclass = null;
		
		try {
			stuclass = Class.forName("com.personal.reflect.beans.StudentBean");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		//2.̽��Class�����������Ϣ
		//2-0:̽�����������Ϣ
		String classname = stuclass.getName();
		classname = stuclass.getSimpleName();
		Class superClassName = stuclass.getSuperclass();
		Class[] stuInters = stuclass.getInterfaces();
//		for(Class in :stuInters) {
//			System.out.println(in);
//		}
		//�������η�
		String classMod = Modifier.toString(stuclass.getModifiers());
		
		int mod = stuclass.getModifiers();
		
		Package pack= stuclass.getPackage();
		//��ȡ����
		String packageStr = stuclass.getPackage().getName();
		//��ȡ����
		Field[] allPublicField = stuclass.getFields();
		Field[] allFields = stuclass.getDeclaredFields();
//		for(Field in :allFields) {
//			System.out.println(in);
//		}
		
		//2-2��̽����Ĺ���
				Constructor[] allPublicCons = stuclass.getConstructors();//�õ����й�������
				Constructor[] allCons = stuclass.getDeclaredConstructors();//�õ����й���
				try {
					Constructor thePublicCon = stuclass.getConstructor(String.class,int.class);//�õ�ָ���Ĺ�������
					Constructor theCon = stuclass.getDeclaredConstructor();//�õ�ָ���Ĺ���
				} catch (NoSuchMethodException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SecurityException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				System.out.println("==========����==========");
				for(Constructor con : allCons){
					String conName = con.getName();//���췽������
					String conMod = Modifier.toString(con.getModifiers());//���췽�������η�
					Class[] params = con.getParameterTypes();//�õ����췽���Ĳ���Class����
					String paramStr = "";
					if(params != null && params.length > 0){
						for(int i = 0; i < params.length; i++){
							paramStr += params[i].getName();
							if(i != params.length - 1){
								paramStr += ",";
							}
						}
					}
					
					Class[] exClasses = con.getExceptionTypes();//�õ����췽���׳����쳣��Class����
					String throwsStr = "";
					if(exClasses != null && exClasses.length > 0){
						throwsStr = "throws ";
						for(int i = 0; i < exClasses.length; i++){
							throwsStr += exClasses[i].getName();
							if(i != exClasses.length - 1){
								throwsStr += ",";
							}
						}
					}
					
					System.out.println("\t "+conMod+" "+conName+" ("+paramStr+") "+throwsStr+";");
					System.out.println();
				}
				
				
				
				//2-3��̽����ķ���
				
				System.out.println("========����==========");
				try {
					Method ad = stuclass.getDeclaredMethod("study", null);
				} catch (NoSuchMethodException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SecurityException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
				Method[] allMethods = stuclass.getDeclaredMethods();
				for(Method me : allMethods){
//					System.out.println(me+";");
					String meRe = me.getReturnType().getName();
					String meName = me.getName();
					String meMode =  Modifier.toString(me.getModifiers());
					Class[] params = me.getParameterTypes();
					String paramStr = "";
					if(params != null && params.length > 0){
						for(int i = 0; i < params.length; i++){
							paramStr += params[i].getName();
							if(i != params.length - 1){
								paramStr += ",";
							}
						}
					}
					System.out.println(meMode +" "+meRe+" "+meName+"( "+paramStr +");" );
				}
				
				
				System.out.println("}");
				
				StudentBean.eat("����");
				
				//3��ʹ��̽��������Ϣ
				Class myClass;
				try {
					myClass = Class.forName("com.lovo.reflect.bean.StudentBean");
					StudentBean student = (StudentBean)myClass.newInstance();
					student.eat("����");
					Method theMethod = myClass.getDeclaredMethod("eat", String.class);
					theMethod.invoke(student, "����");
					
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InstantiationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (NoSuchMethodException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SecurityException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalArgumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
			
				} catch (InvocationTargetException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
		
		
	}
}
