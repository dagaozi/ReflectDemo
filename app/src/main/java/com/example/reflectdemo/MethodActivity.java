package com.example.reflectdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.lang.reflect.Method;

public class MethodActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_method);
        getMethodTest();

    }
    private void getMethodTest(){
        A a1=new A();
        Class c=a1.getClass();

        try {
            //获取方法
           // c.getMethod("print",new Class[]{int.class,int.class});
          Method m= c.getMethod("print",int.class,int.class);
            //方法的反射操作
            //方法如果没有返回值返回null,有返回值返回具体的返回值
           Object o= m.invoke(a1,new Object[]{10,20});

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    class A{
        public void print(int a,int b){
            System.out.println(a+b+"");
        }
        public void print(String a,String b){
            System.out.println(a.toUpperCase()+","+b.toLowerCase());
        }
    }
}
