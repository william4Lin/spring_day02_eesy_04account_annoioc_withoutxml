1.Spring中的新注解：
  Configuration：
       作用：指定当前类为一个配置类
       细节：当配置类作为AnnotationConfigApplicationContext对象创建的参数时，该注解可以不写。
       
 
  ComponentScan：
       作用：通过注解指定Spring在创建容器时需要扫描的包
       属性：
               value：它和basePackages的作用是一样的，都用于指定创建容器时需要扫描的包
        次注解等同于bean.xml中配置的<context:component-scan base-package="com.william"></context:component-scan>这一行
 
  Bean：
       作用：把当前方法的返回值作为bean对象，存入spring的ioc容器中。
       属性：
           name：用于指定bean的id。默认值是当前方法的名称。
       细节：
           当我们使用注解方法配置时，如果方法中有参数，spring框架会去容器中查找有没有可用的bean对象。
           查找的方式与Autowired注解一样
 
  Import：
       作用：用于导入其他的配置类
       属性：
           value：用于指定其他配置类的字节码
                   当我们使用Import的注解之后，有Import注解的类就是父配置类，而导入的类为子配置类
 
  PropertySource：
       作用：用于指定properties文件的位置
       属性：
           value：指定文件的名称和文件的路径
                   classpath：类路径下



2.Spring整个junit的注解配置
    1.导入spring整合junit的jar包（pom.xml中配置）
    2.使用Junit提供的注解@Runwith把原有的main方法替换了，替换成spring提供的
    3.告知spring运行期，spring的ioc创建时基于xml的还是基于注解的，并且说明位置
                @ContextConfiguration
                     location:指定xml的文件位置，加上classpath关键字，标识在类路径下
                     classes:指定注解类所在位置
     
     
    当我们使用spring 5.x版本的时候，spring要求junit的jar包必须是4.12以上
