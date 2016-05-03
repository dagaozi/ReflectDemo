package com.example.reflectdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.tvText)
    TextView tvText;
    @Bind(R.id.etClass)
    EditText etClass;
    @Bind(R.id.btnTest)
    Button btnTest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
      /*  ClassTsest();
        LoadClassTest();*/
        String s="hello";
        ClassUtil.printClassMessage(s);
    }

    private void ClassTsest() {
        //new 创建对象，是静态加载类，在编译时刻就需要加载所有可能用到的类
        Foo foo = new Foo();
        //获取类类型（class type）的三种方式
        Class c1 = Foo.class;
        Class c2 = foo.getClass();
        try {
            Class c3 = Class.forName("com.example.reflectdemo.Foo");//不仅仅表示了类的类类型，还代表了动态加载类（运行时加载类）
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        //根据类类型创建类的对象
        try {
            Foo foo1 = (Foo) c1.newInstance();//该类必须有无参构造方法
            foo1.print();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    /**
     * 动态加载类测试
     */
    private void LoadClassTest() {
        Class c=null;
        try {
             c=Class.forName(etClass.getText().toString());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            OfficeAble officeAble=(OfficeAble) c.newInstance();
            officeAble.start();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    class Foo {
        void print() {
        }
    }

}
