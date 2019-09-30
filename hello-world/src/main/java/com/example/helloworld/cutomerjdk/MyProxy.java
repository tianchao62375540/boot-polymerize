package com.example.helloworld.cutomerjdk;


import com.example.helloworld.proxyjdk.MyInvocationHandler;
import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.springframework.util.FileCopyUtils;

import javax.tools.JavaCompiler;
import javax.tools.JavaFileObject;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * Description:
 * <p>
 * ModelName:【】模块
 *
 * @author: TianChao
 * Create at:  2019/9/26 09:22
 * Company: 沈阳艾尔时代科技发展有限公司
 * Copyright: (c)2018 AIR Times Inc. All rights reserved.
 * @version: 1.0
 */
public class MyProxy {

    private static final String rt = "\r\n";
    /**
     *
     * @param loader 类加载器
     * @param interfaces 被代理对象实现的所有接口
     * @param h 处理器
     * @return
     */
    public static Object newProxyInstance(MyClassLoader loader,
                                          Class<?>[] interfaces,
                                          InvocationHandlerInterface h){
        final Class<?>[] intfs = interfaces.clone();
        //构造代理类
        //先处理一个接口
        Class<?> anInterface = interfaces[0];
        Method[] methods = anInterface.getMethods();
        StringBuilder proxyClassString = new StringBuilder("");
        proxyClassString.append("package ")
                .append(loader.getProxyClassPackage()).append(";").append(rt)
                .append("import java.lang.reflect.Method;").append(rt)
                .append("import com.example.helloworld.cutomerjdk.CustomerInvocationHandler;").append(rt)
                .append("public class $MyProxy0 implements ").append(anInterface.getName()).append("{").append(rt)
                .append("CustomerInvocationHandler h;").append(rt)
                .append("public $MyProxy0(CustomerInvocationHandler h){").append(rt).append("this.h = h;").append(rt).append("}").append(rt)
                .append(getMethodString(methods,anInterface)).append("}");
        System.out.println(proxyClassString);
        String fileName  = loader.getDir() + File.separator + "$MyProxy0.java";
        File myProxyFile = new File(fileName);
        Object o = null;
        try {
            compile(proxyClassString,myProxyFile);
            Class $myProxy0 = loader.findClass("$MyProxy0");
            Constructor constructor = $myProxy0.getConstructor(CustomerInvocationHandler.class);
            o = constructor.newInstance(h);
        }catch (Exception e){
            e.printStackTrace();
        }
        return o;

    }

    private static void compile(StringBuilder proxyClassString, File myProxyFile) throws IOException {
       /* final JavaCompiler systemJavaCompiler = ToolProvider.getSystemJavaCompiler();
        InputStream in = null;
        OutputStream os = null;
        try {
            in = new ByteArrayInputStream(proxyClassString.toString().getBytes());
            os= new FileOutputStream(myProxyFile);
            int run = systemJavaCompiler.run(in, os, os);
            System.out.println("成功了吗？："+run);
        } catch (Exception e) {
            e.printStackTrace();
        }*/
        FileCopyUtils.copy(proxyClassString.toString().getBytes(),myProxyFile);
        JavaCompiler systemJavaCompiler = ToolProvider.getSystemJavaCompiler();
        StandardJavaFileManager standardFileManager = systemJavaCompiler.getStandardFileManager(null, null, null);
        final Iterable<? extends JavaFileObject> javaFileObjects = standardFileManager.getJavaFileObjects(myProxyFile);
        JavaCompiler.CompilationTask task = systemJavaCompiler.getTask(null, standardFileManager, null, null, null, javaFileObjects);
        task.call();
        standardFileManager.close();
    }

    private static String getMethodString(Method[] methods, Class<?> anInterface) {
        StringBuffer methodsBuffer  = new StringBuffer("");
        for(Method m: methods){
            methodsBuffer.append("@Override").append(rt)
                    .append("public void ").append(m.getName()).append("()").append("throws Throwable{ ").append(rt)
                    .append("Method method1 = ").append(anInterface.getName()).append(".class.getMethod(\"")
                    .append(m.getName()+"\",").append("new Class[]{});")
                    .append("this.h.invoke(this,method1,null);}").append(rt);
        }
        return methodsBuffer.toString();
    }

}
