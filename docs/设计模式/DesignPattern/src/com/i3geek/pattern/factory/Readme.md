## 简单工厂模式

../_images/SimpleFactory.jpg
一个工厂实现类，一个产品抽象类，N个产品实现类。

### 动机

像工厂一样，可以生产出来多个产品。比如一个按钮工厂，可以生产出来圆形按钮、矩形按钮、三角形按钮等等，但是所有的按钮都继承自原始的按钮抽象基类。

### 定义

简单工厂模式(Simple Factory Pattern)：又称为静态工厂方法(Static Factory Method)模式，它属于类创建型模式。在简单工厂模式中，可以根据参数的不同返回不同类的实例。简单工厂模式专门定义一个类来负责创建其他类的实例，被创建的实例通常都具有共同的父类。

### 功能

传入一个值不同的参数可以生产出不同的按钮。各自的形状属性可能不同，但是都有相同的方法。

优点：不用考虑如何生产的过程。只要传入不同参数就可以得到不同产品。

### 实现

例如：工厂类 buttonFactory ；产品抽象类 Button ；多个产品实现类 AButton,BButton,CButton；

	buttonFactory bfactory = new buttonFactory();
	Button abutton = bfactory.getButton("A");//通过传入参数A 获得AButton
	Button bbutton = bfactory.getButton("B");//通过传入参数B 获得BButton
	Button cbutton = bfactory.getButton("C");//通过传入参数C 获得CButton

---

问题（缺点）：如果要加入新的产品，必须要修改工厂实现类，违背“开闭原则”。

## 工厂方法模式

../_images/FactoryMethod.jpg
一个工厂抽象类，N个工厂实现类，一个产品抽象类，N个产品实现类。

### 动机

在简单工厂模式的基础上，为工厂创建抽象类，生产不同的按钮由不同的工厂实现类完成。

### 定义

工厂方法模式(Factory Method Pattern)又称为工厂模式，也叫虚拟构造器(Virtual Constructor)模式或者多态工厂(Polymorphic Factory)模式，它属于类创建型模式。在工厂方法模式中，工厂父类负责定义创建产品对象的公共接口，而工厂子类则负责生成具体的产品对象，这样做的目的是将产品类的实例化操作延迟到工厂子类中完成，即通过工厂子类来确定究竟应该实例化哪一个具体产品类。

### 功能

不同工厂生产不同产品。（或者传入一个值不同的参数可以实例化出不同的工厂，从而产出不同的产品）

优点：增加新产品时，无需修改抽象工厂或其他具体的工厂，只需要添加一个具体工厂和具体产品就可以了。

### 实现

例如：工厂抽象类 Factory ； 多个工厂实现类 AbuttonFactory,BbuttonFactory,CbuttonFactory ；产品抽象类 Button ；多个产品实现类 AButton,BButton,CButton；

	buttonFactory bfactory = new AbuttonFactory();//获得AbuttonFactory工厂实现类
	Button abutton = bfactory.getButton();//通过传入参数A 获得AButton
	bfactory = new BbuttonFactory();//获得BbuttonFactory工厂实现类
	Button bbutton = bfactory.getButton();//通过传入参数B 获得BButton
	bfactory = new CbuttonFactory();//获得CbuttonFactory工厂实现类
	Button cbutton = bfactory.getButton();//通过传入参数C 获得CButton
	
<更进一步> 工厂抽象类 Factory ； 工厂工具类 BaseFactory ；多个工厂实现类 AbuttonFactory,BbuttonFactory,CbuttonFactory ；产品抽象类 Button ；多个产品实现类 AButton,BButton,CButton；

	BaseFactory factory = new BaseFactory();//实例化工厂工具类
	buttonFactory bfactory = factory.getFactory("A");//获得AbuttonFactory工厂实现类
	Button abutton = bfactory.getButton();//通过传入参数A 获得AButton
	bfactory = factory.getFactory("B");//获得BbuttonFactory工厂实现类
	Button bbutton = bfactory.getButton();//通过传入参数B 获得BButton
	bfactory = factory.getFactory("C");//获得CbuttonFactory工厂实现类
	Button cbutton = bfactory.getButton();//通过传入参数C 获得CButton
	
应用：JDBC中的工厂方法：
	
	Connection conn=DriverManager.getConnection("jdbc:microsoft:sqlserver://localhost:1433; DatabaseName=DB;user=sa;password=");
	Statement statement=conn.createStatement();
	ResultSet rs=statement.executeQuery("select * from UserInfo");
	
---

问题（缺点）：一个工厂只能生产一类产品对象，如果生产多类产品呢？

## 抽象工厂模式

../_images/AbatractFactory.jpg
一个工厂抽象类，N个工厂实现类，N个产品抽象类，N个产品实现类。

## 动机

在工厂方法模式的基础上，每一个工厂不仅可以生产各自特有的按钮，还可以生产各自特有的输入框。比如，生产圆形按钮的工厂可以生产圆形按钮和圆形输入框；生产方形按钮的工厂可以生产方形按钮和方形输入框……

## 定义

抽象工厂模式(Abstract Factory Pattern)：提供一个创建一系列相关或相互依赖对象的接口，而无须指定它们具体的类。抽象工厂模式又称为Kit模式，属于对象创建型模式。

## 功能

同一工厂可以生产多种不同类商品。

优点：只需更换工厂的实例，就可以改变全部生产产品（比如将生产圆形的工厂改成生产方形的工厂，则由原工厂生产的按钮、输入框全都变成了方形）；保证所有不同类的商品都源自一个工厂；增加新的具体工厂和对应的各类商品实例很方便，无须修改原有系统（比如增加个三角形工厂，再增加三角形按钮和三角形输入框的实现类即可）

## 实现

例如：工厂抽象类 Factory ； 多个工厂实现类 AFactory,BFactory ；多个产品抽象类（一个产品抽象类可以想象成一类商品） Button,Text ；多个产品实现类 AButton,BButton,AText,BText；

	Factory factory = new AFactory(); // 实例化AFactory对象
	Button button = factory.getButton(); //获得AButton对象
	Text text = factory.getText(); //获得AText对象
	
	factory = new BFactory(); // 实例化BFactory对象
	Button button = factory.getButton(); //获得BButton对象
	Text text = factory.getText(); // 获得BText对象

应用：软件系统中的界面主题，当主题变更时，所有的按钮、文本框、背景色等一起发生变化。

*原文：http://www.i3geek.com/archives/1272*
*实现源代码：https://github.com/yangengzhe/coding-guide_i3geek/tree/master/docs/%E8%AE%BE%E8%AE%A1%E6%A8%A1%E5%BC%8F*