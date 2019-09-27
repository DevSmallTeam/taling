package com.uxunchina.taling.utils;


import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chenfeng
 * @Package com.uxunchina.taling.utils
 * 代码生成工具
 * @date 2019/9/20 09:37
 */
public class CodeGeneration {

    public static void main(String[] args){

        AutoGenerator mpg = new AutoGenerator();

        //全局配置
        GlobalConfig gc = new GlobalConfig();

        gc.setOutputDir("/Users/chenfeng/forum/taling/src/main/java");

        gc.setFileOverride(true);
        //不需要ActiveRecord特性的请改为false
        gc.setActiveRecord(true);
        //XML二级缓存
        gc.setEnableCache(false);
        //XML ResultMap
        gc.setBaseResultMap(true);
        //XML columList
        gc.setBaseColumnList(false);
        //作者
        gc.setAuthor("chenfeng");
        //设置 swagger2注解
        gc.setSwagger2(true);


        //自定义文件命名，注意%s 会自动填充表实体属性
        gc.setControllerName("%sController");
        gc.setServiceName("%sService");
        gc.setServiceImplName("%sServiceImpl");
        gc.setMapperName("%sMapper");
        gc.setXmlName("%sMapper");
        mpg.setGlobalConfig(gc);

        //数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setDbType(DbType.MYSQL);
        dsc.setDriverName("com.mysql.cj.jdbc.Driver");
        dsc.setUsername("root");
        dsc.setPassword("root123456");
        dsc.setUrl("jdbc:mysql://127.0.0.1:3306/taling");
        mpg.setDataSource(dsc);

        //策略配置
        StrategyConfig strategy = new StrategyConfig();
        //此处可以修改您的表前缀
        strategy.setTablePrefix(new String[]{});
        //表名生成策略
        strategy.setNaming(NamingStrategy.underline_to_camel);
        //需要生成的表
        strategy.setInclude(new String[]{"sys_menu"});
        //是否使用lombook
        strategy.setEntityLombokModel(true);

        strategy.setSuperServiceClass(null);
        strategy.setSuperServiceImplClass(null);
        strategy.setSuperMapperClass(null);

        mpg.setStrategy(strategy);

        //包配置
        PackageConfig pc = new PackageConfig();
        pc.setParent("com.uxunchina.taling");
        pc.setController("controller");
        pc.setService("service");
        pc.setServiceImpl("service.impl");
        pc.setMapper("mapper");
        pc.setEntity("entity");

        // 注入自定义配置，
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
                // to do nothing
            }
        };

        String templatePath = "/templates/mapper.xml.vm";
        // 自定义输出配置
        List<FileOutConfig> focList = new ArrayList<>();
        // 自定义配置会被优先输出
        focList.add(new FileOutConfig(templatePath) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输出文件名 ， 如果你 Entity 设置了前后缀、此处注意 xml 的名称会跟着发生变化！！
                return  "/Users/chenfeng/forum/taling/src/main/resources/mapping/"
                        + "/" + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
            }
        });
        cfg.setFileOutConfigList(focList);
        mpg.setCfg(cfg);


        //配置不自动生成entity
        TemplateConfig templateConfig = new TemplateConfig();
        templateConfig.setEntity(null);
        templateConfig.setXml(null);
        mpg.setTemplate(templateConfig);
        //end
        mpg.setPackageInfo(pc);


        //执行生成
        mpg.execute();
    }

}
