
1、Dagger2的使用及理解
    http://www.voidcn.com/blog/qduningning/article/p-6175305.html 
    1、简单使用方式
        @Inject 构造函数(源) 
        @Component 注入器(连接源和目的)
        @Inject 完成注入
      工作流程:
        a、@Component 注入器内先查找到需要注入的Activity或者Fragment 查找到@Inject 标注的成员变量的属性
        b、查看@Component 是否有module,如果有,就从module中查找@Provides 如果没有,就直接按照属性去查找对应的Inject标注的构造函数
        
            查找目标类中用Inject注解标注的属性，查找到相应的属性后会接着查找该属性对应的用Inject标注的构造函数
        (如果下面要提到的Module没有提供的话)
    
    2、复杂使用方式
        @Module @Provide 提供注入源
        @Component 注入器(@Component(modules = ApiModule.class))
        @Inject 完成注入
      工作流程:
        使用@Provide提供源,完成注入
        
    3、多层依赖使用方式
       @Module @Provide 提供注入源
       @Component 注入器(@Component(dependencies = AppComponent.class,modules = ApiModule.class) )
       @Inject完成注入
       
    解析2和3多层依赖的不同
       dependencies = AppComponent.class 依赖AppComponent.class 的传递,所以AppComponent.class中需要有传递函数。
       比如AppComponent.class的module=AModule.class AModule中提供了@Provider test providertest,需要在AppComponent
       添加传递函数 test gettest()   来完成传递,从而使依赖的component中能够使用test
       
       @Component  :
       1、注入器,是注入源和目的端的连接器
       2、传递,在被依赖的component中,完成对module中的provider的传递
       
       头部:
        @component(含有modules=****Module.class),源仅来自于****module
        @component(含有dependencies=****component.class) 源仅来自于****component中的传递,终归来自于****component的**module
        @component() 源来自于@Inject
       内容:
         void inject(Activity  activity)  void inject(Fragment  fragment)   仅仅作为连接器
         A getA()  B getB()                                                 仅仅作为传递
         void inject(Activity activity)  A getA()                           即作为连接有作为传递

2、Rxjava的使用
    a 给 Android 开发者的 RxJava 详解
        http://gank.io/post/560e15be2dca930e00da1083#toc_1
    b 最简单的介绍及使用
        http://www.jianshu.com/p/19cac3c5b106
   
   核心:
   流形式处理(流操作)
   转换(数据)
   线程(创建线程和消费线程)

1、转换   map()  flatmap()   lift()   compose()
2、subscribeOn()   创建的线程io   observeOn() 消费的线程ui
https://mcxiaoke.gitbooks.io/rxdocs/content/operators/Create.html  RX字典

         
        

        
