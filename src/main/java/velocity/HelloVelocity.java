/*
 * Project: hello-velocity
 * 
 * File Created at 2016年5月10日
 * 
 * Copyright 2014 zhidier.com All right reserved. This software is the
 * confidential and proprietary information of zhidier.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with zhidier.com .
 */
package velocity;

import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Properties;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.runtime.RuntimeConstants;
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;

/**
 * @type HelloVelocity
 * @Desc 
 * @author leexm
 * @date 2016年5月10日
 * @version v1.0
 */
public class HelloVelocity {

    public static void main(String[] args) {
        // 初始化模板引擎
        Properties props = new Properties();
        props.put(RuntimeConstants.RESOURCE_LOADER, "classpath");
        props.put("classpath.resource.loader.class", ClasspathResourceLoader.class.getName());
        VelocityEngine ve = new VelocityEngine(props);
//        VelocityEngine ve = new VelocityEngine();
//        ve.setProperty(RuntimeConstants.RESOURCE_LOADER, "classpath");
//        ve.setProperty("classpath.resource.loader.class", ClasspathResourceLoader.class.getName());
        
//        ve.init();
        
        Template t = ve.getTemplate("frm.vm");
        VelocityContext ctx = new VelocityContext();
        
//        ctx.put("name", "leexm");
//        ctx.put("date", (new Date()).toString());
//        
//        List<String> temp = new ArrayList<String>();
//        temp.add("1");
//        temp.add("2");
//        ctx.put("list", temp);
        
        ctx.put("action", "./submit");
        ArrayList<HashMap<String, String>> inputs = new ArrayList<HashMap<String,String>>();
        HashMap<String, String> input1 = new HashMap<String, String>();
        input1.put("id", "title");
        input1.put("title", "标题：");
        inputs.add(input1);
        HashMap<String, String> input2 = new HashMap<String, String>();
        input2.put("id", "brief");
        input2.put("title", "摘要：");
        inputs.add(input2);
        ctx.put("inputs", inputs);
        ArrayList<HashMap<String, Object>> selects = new ArrayList<HashMap<String,Object>>();
        HashMap<String, Object> select1 = new HashMap<String, Object>();
        selects.add(select1);
        select1.put("id", "sex");
        select1.put("title", "性别：");
        HashMap<Integer, String> kv1 = new HashMap<Integer, String>();
        kv1.put(0, "男");
        kv1.put(1, "女");
        select1.put("items", kv1);
        HashMap<String, Object> select2 = new HashMap<String, Object>();
        selects.add(select2);
        select2.put("id", "job");
        select2.put("title", "职业：");
        HashMap<Integer, String> kv2 = new HashMap<Integer, String>();
        kv2.put(0, "Java工程师");
        kv2.put(1, "Net工程师");
        select2.put("items", kv2);
        ctx.put("selects", selects);
        
        StringWriter sw = new StringWriter();
        t.merge(ctx, sw);
        System.out.println(sw.toString());
    }

}
