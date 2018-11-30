import cn.org.rapid_framework.generator.GeneratorFacade;

/**
 * Created by zhuxh on 16/11/30.
 */
public class GeneratorMain {

    private static final String TEMPLATE_DIR = "/Users/zhuxh/gitown/codegenerator/template";

    public static void main(String[] args) throws Exception {
        GeneratorFacade g = new GeneratorFacade();
        g.getGenerator().setTemplateRootDir(TEMPLATE_DIR);
        g.deleteOutRootDir();
//        g.generateByAllTable();
        g.generateByTable("product_order");

    }

}
