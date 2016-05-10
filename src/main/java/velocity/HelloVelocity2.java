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

public class HelloVelocity2 {

    public static void main(String[] args) {
        // 初始化模板引擎
        Properties props = new Properties();
        props.put(RuntimeConstants.RESOURCE_LOADER, "classpath");
        props.put("classpath.resource.loader.class", ClasspathResourceLoader.class.getName());
        VelocityEngine ve = new VelocityEngine(props);
        ve.init();
        // 配置引擎上下文对象
        VelocityContext ctx = new VelocityContext();
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
        
        // 加载模板文件
        Template template = ve.getTemplate("frm.vm");
        StringWriter sw = new StringWriter();
        // 渲染模板
        template.merge(ctx, sw);
        System.out.print(sw.toString());
    }

}
