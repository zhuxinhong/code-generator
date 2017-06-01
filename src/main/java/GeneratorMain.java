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

//        List<Table> tables = TableFactory.getInstance().getAllTables();
//        List<String> toGenerateTables = new ArrayList<>();
//        for (Table table : tables) {
//            if(table.getSqlName().startsWith("service_diff")){
//                toGenerateTables.add(table.getSqlName());
//            }
//        }
//
//        String[] dest = new String[toGenerateTables.size()];
//        toGenerateTables.toArray(dest);
//        g.generateByTable(dest);

        g.generateByTable("d_express");

    }

}
