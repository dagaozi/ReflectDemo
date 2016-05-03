package com.example.reflectdemo;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Created by 海滨 .（dagaozi@163.com）
 * 创建时间：2016/5/2 14:05
 * 类描述：
 */
public class ClassUtil {
    public static void printClassMessage(Object obj){
        Class c=obj.getClass();//传递的是哪个子类的对象，c就是该子类的类类型
        //获取类的名称
        System.out.println("");
        System.out.println("类的名称"+c.getName());
        Method[] ms=c.getMethods();//获取所有public方法，包括分类集成而来的。
        Method[] ms1=c.getDeclaredMethods();//获取的是该类自己生命的方法，不问访问类型
        for(int i=0;i<ms.length;i++) {
            Class returnType = ms[i].getReturnType();//得到方法的返回值类型的类类型
            System.out.println(returnType.getName() + "");
            System.out.print(ms[i].getName() + "(");//得到方法的名称
            Class[] paramTypes = ms[i].getParameterTypes();//得到参数列表的类型的类类型
            for (Class class1 : paramTypes) {
                System.out.print(class1.getName() + ",");
            }
            System.out.println(")");

        }

    }
    //类的成员变量
    public static void printClassFieldMessage(Object obj){
        Class c=obj.getClass();//传递的是哪个子类的对象，c就是该子类的类类型
        //获取类的名称
        System.out.println("");
        System.out.println("类的名称"+c.getName());
        //获取类的成员变量
        Field[] fs=c.getFields();//获取所有的public的成员变量信息
        Field[] fs1=c.getDeclaredFields();//获取该类自己声明的成员变量的信息
        for(Field field:fs){
            //得到成员变量的类型的类类型
            Class fieldType=field.getType();
            String typeName=fieldType.getName();
            //得到成员变量的名称
            String fieldName=field.getName();
            System.out.println(typeName+" "+fieldName);
        }
    }
    //类的构造函数
    public static void printConMessage(Object obj){
        Class c=obj.getClass();
        Constructor[] constructors=c.getConstructors();//获取所有的public的构造函数
        Constructor[] constructors1=c.getDeclaredConstructors();//获取自己声明的构造函数
        for(Constructor con:constructors){
            System.out.print(con.getName()+"(");
            //获取构造函数的参数列表
            Class[] paramTypes=con.getParameterTypes();
            for(Class class1:paramTypes){
                System.out.print(class1.getName()+",");
            }
            System.out.println(")");
        }
    }
}
