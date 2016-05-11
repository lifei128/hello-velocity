package velocity;

import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.apache.velocity.runtime.RuntimeConstants;

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
        // 初始化方法一
//        VelocityEngine ve = new VelocityEngine();
//        ve.setProperty(RuntimeConstants.RESOURCE_LOADER, "classpath");
//        ve.setProperty("classpath.resource.loader.class", ClasspathResourceLoader.class.getName());
//        ve.init();
//        Template template = ve.getTemplate("hellovelocity.vm");
        
        // 初始化方法二
        Properties p = new Properties();
        //加载classpath目录下的vm文件
//        p.put(RuntimeConstants.RESOURCE_LOADER, "classpath");
//        p.put("classpath.resource.loader.class", ClasspathResourceLoader.class.getName());
        
        //根据绝对路径加载，vm文件置于硬盘某分区中
        p.put(RuntimeConstants.FILE_RESOURCE_LOADER_PATH, "/Users/leexm/documents/workspace/hello-velocity/src/main/resources");
        
        Velocity.init(p);
        Template template = Velocity.getTemplate("hellovelocity.vm");
        
        VelocityContext ctx = new VelocityContext();
        ctx.put("name", "比克大魔王");
        
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
