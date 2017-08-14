package com.personal.reflect.test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import com.personal.reflect.beans.StudentBean;

public class TestReflect {
	
	public static void main(String[] args) {
		//反射的定义：在运行期载入、探知和使用编译时完全未知的类；
		//反射的步骤
		//1.获取class对象-类模板对象--存放某个类型（引用数据类型、基本数据类型、void）的信息
		//1-1、根据实例对象获取Class对象---没有编译时未知的动态效果
		//只能获得引用数据类型的Class对象（因为其它类型没有实例对象）
		//没有动态效果
		StudentBean stu = new StudentBean("zhang3",25);
		Class stuclass2 = stu.getClass();
		//1-2:通过类型名获取反射对象
		//能获取任意类型的Class对象，但还是没有动态效果
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
		

		//2.探究Class对象里面的信息
		//2-0:探究类的申明信息
		String classname = stuclass.getName();
		classname = stuclass.getSimpleName();
		Class superClassName = stuclass.getSuperclass();
		Class[] stuInters = stuclass.getInterfaces();
//		for(Class in :stuInters) {
//			System.out.println(in);
//		}
		//访问修饰符
		String classMod = Modifier.toString(stuclass.getModifiers());
		
		int mod = stuclass.getModifiers();
		
		Package pack= stuclass.getPackage();
		//获取包名
		String packageStr = stuclass.getPackage().getName();
		//获取属性
		Field[] allPublicField = stuclass.getFields();
		Field[] allFields = stuclass.getDeclaredFields();
//		for(Field in :allFields) {
//			System.out.println(in);
//		}
		
		//2-2、探究类的构造
				Constructor[] allPublicCons = stuclass.getConstructors();//得到所有公共构造
				Constructor[] allCons = stuclass.getDeclaredConstructors();//得到所有构造
				try {
					Constructor thePublicCon = stuclass.getConstructor(String.class,int.class);//得到指定的公共构造
					Constructor theCon = stuclass.getDeclaredConstructor();//得到指定的构造
				} catch (NoSuchMethodException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SecurityException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				System.out.println("==========构造==========");
				for(Constructor con : allCons){
					String conName = con.getName();//构造方法名字
					String conMod = Modifier.toString(con.getModifiers());//构造方法的修饰符
					Class[] params = con.getParameterTypes();//得到构造方法的参数Class数组
					String paramStr = "";
					if(params != null && params.length > 0){
						for(int i = 0; i < params.length; i++){
							paramStr += params[i].getName();
							if(i != params.length - 1){
								paramStr += ",";
							}
						}
					}
					
					Class[] exClasses = con.getExceptionTypes();//得到构造方法抛出的异常的Class数组
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
				
				
				
				//2-3、探究类的方法
				
				System.out.println("========方法==========");
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
				
				StudentBean.eat("西瓜");
				
				//3、使用探究到的信息
				Class myClass;
				try {
					myClass = Class.forName("com.lovo.reflect.bean.StudentBean");
					StudentBean student = (StudentBean)myClass.newInstance();
					student.eat("西瓜");
					Method theMethod = myClass.getDeclaredMethod("eat", String.class);
					theMethod.invoke(student, "西瓜");
					
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
