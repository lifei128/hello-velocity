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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
        VelocityEngine ve = new VelocityEngine();
        ve.setProperty(RuntimeConstants.RESOURCE_LOADER, "classpath");
        ve.setProperty("classpath.resource.loader.class", ClasspathResourceLoader.class.getName());
        ve.init();
        
        Template template = ve.getTemplate("hellovelocity.vm");
        VelocityContext ctx = new VelocityContext();
        
        ctx.put("name", "leexm");
        
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        ctx.put("date", formatter.format(new Date()));
        
        List<String> temp = new ArrayList<String>();
        temp.add("1");
        temp.add("2");
        ctx.put("list", temp);
        
        StringWriter sw = new StringWriter();
        template.merge(ctx, sw);
        System.out.println(sw.toString());
    }

}
