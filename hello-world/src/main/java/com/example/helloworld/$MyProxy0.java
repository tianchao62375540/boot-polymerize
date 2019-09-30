package com.example.helloworld;
import java.lang.reflect.Method;
import com.example.helloworld.cutomerjdk.CustomerInvocationHandler;
public class $MyProxy0 implements com.example.helloworld.cutomerjdk.CustomerService{
CustomerInvocationHandler h;
public $MyProxy0(CustomerInvocationHandler h){
this.h = h;
}
@Override
public void gotohome()throws Throwable{ 
Method method1 = com.example.helloworld.cutomerjdk.CustomerService.class.getMethod("gotohome",new Class[]{});this.h.invoke(this,method1,null);}
@Override
public void gotowork()throws Throwable{ 
Method method1 = com.example.helloworld.cutomerjdk.CustomerService.class.getMethod("gotowork",new Class[]{});this.h.invoke(this,method1,null);}
}