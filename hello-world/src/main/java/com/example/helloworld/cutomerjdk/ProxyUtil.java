package com.example.helloworld.cutomerjdk;

import javax.tools.JavaCompiler;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;

/**
 * 〈一句话功能简述〉
 * 〈功能详细描述〉
 *
 * @author qi_b
 * @version 2019年09月21日
 * @see ProxyUtil
 * @since V1.0
 */
public class ProxyUtil {

    public static Object  getInstance(Object target,CustomerInvocationHandler h){

        Class targetInf = target.getClass().getInterfaces()[0];

        Object o = null;

        StringBuilder sb = new StringBuilder();
        String tab = "\t";
        String enter = "\n";


        sb.append("package com.luban.proxy;").append(enter);
        sb.append("import java.lang.reflect.Method;").append(enter);
        sb.append("import com.luban.proxy.DemoInvocationHandler;").append(enter);
        sb.append("public class $Proxy implements Dao {").append(enter);
        sb.append(tab).append("private DemoInvocationHandler h;").append(enter);
        sb.append(tab).append("public $Proxy(DemoInvocationHandler h){").append(enter);
        sb.append(tab+tab).append("this.h = h;").append(enter);
        sb.append(tab).append("}").append(enter);
        //动态实现所有方法接口
        for(Method m : targetInf.getDeclaredMethods()){
            //返回值类型
            String returnType = m.getReturnType().getSimpleName();
            //方法名
            String methodName = m.getName();
            //返回值类型
            Class[] parametersArr = m.getParameterTypes();

            String parameters = "";

            String invokeParameters = "";

            String invokeParametersClass = "";

            //动态获取方法名和方法参数
            sb.append(tab).append("public "+returnType+" "+methodName+"(");
            //添加参数类型
            for (int i = 0; i < parametersArr.length ; i++) {
                if (i==parametersArr.length-1){
                    sb.append(parametersArr[i].getSimpleName()+" var"+i);
                    parameters += "var"+i;
                    invokeParametersClass+= parametersArr[i].getSimpleName()+".class";
                }else {
                    sb.append(parametersArr[i].getSimpleName()+" var"+i+",");
                    parameters += "var"+i+",";
                    invokeParametersClass+= parametersArr[i].getSimpleName()+".class,";
                }
            }

            sb.append(") {").append(enter);


            //TODO:此处代码写死，需要增强
            sb.append(tab+tab).append("try{").append(enter);
            //使用ClassforName就没有问题，但是使用this.getClass就存在问题
            sb.append(tab+tab+tab).append("Method m = Class.forName(\""+targetInf.getName()+"\").getDeclaredMethod(\""+methodName+"\",new Class[]{"+invokeParametersClass+"});").append(enter);
//            sb.append(tab+tab+tab).append("Method m = this.getClass().getDeclaredMethod(\""+methodName+"\",new Class[]{"+invokeParametersClass+"});").append(enter);


            sb.append(tab+tab+tab).append("Object[] args = {"+parameters+"};").append(enter);

            //
            if ("void".equals(returnType)){
                sb.append(tab+tab+tab).append("h.invoke(m,args);").append(enter);
            }else {
                sb.append(tab+tab+tab).append("return ("+returnType+")h.invoke(m,args);").append(enter);
            }
            sb.append(tab+tab).append("}catch(Exception e){").append(enter);
            sb.append(tab+tab+tab).append("e.printStackTrace();").append(enter);
            sb.append(tab+tab+"}").append(enter);
            if (!"void".equals(returnType)){
                sb.append(tab+tab).append("return null;").append(enter);
            }
            sb.append(tab).append("}").append(enter);
        }

        sb.append("}").append(enter);

        try {

            //生成.java文件
            String filePath = ProxyUtil.class.getResource("").getPath();
            System.out.println("文件磁盘路径："+filePath);

            File f = new File(filePath + "$Proxy.java");
            FileWriter fw = new FileWriter(f);
            fw.write(sb.toString());
            fw.flush();
            fw.close();

            //将java文件编译成.class文件
            JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();

            StandardJavaFileManager manage = compiler.getStandardFileManager(null, null, null);
            Iterable iterable = manage.getJavaFileObjects(f);

            JavaCompiler.CompilationTask task = compiler.getTask(null, manage, null, null, null, iterable);
            task.call();
            manage.close();

            //使用ClassLoader将类加载到内存当中
            URL url = new URL("file:d:/workspaces/workspace_practise/aop/target/classes");
            URL[] urls = new URL[]{url};
            URLClassLoader classLoader = new URLClassLoader(urls);
            Class c = classLoader.loadClass("com.luban.proxy.$Proxy");

            o = c.getConstructor(CustomerInvocationHandler.class).newInstance(h);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return o;

    }
}