# Filter过滤器

## 工作原理

过滤器是一个服务器端的组件，它可以截取用户端的请求与相应信息，并对这些信息进行过滤。
可以转发链接，但是不可以响应数据。

配置项：
1. filter配置：filter名称和filter类
2. filter-map配置：filter名称和（url-pattern路径 或者 servlet名称）
注：servlet名称意思是，将调用该servlet的servlet-map 同servlet相同的路径。

## 生命周期

实例化 -> web.xml 只容器加载实例化一次

初始化 -> init 只容器加载实例化后初始化一次 调用init方法

过滤 -> dofilter 每次过滤调用一次dofilter方法，调用n次

销毁 -> destory 容器销毁 执行一次，destory方法

## 责任链模式

	请求		过滤器1				过滤器2			    资源（servlet）
	
	req --> code1  
			  |					
			chain.dofilter	-->  code1
									|
								 chain.dofilter	--> doGet/doPost
								 				        |
	res	<--	code2		<--		 code2			<--    <-

## 过滤器类型

### request

每个请求，直接访问时，进入过滤器

	HttpServletRequest req = (HttpServletRequest) request;
	HttpServletResponse res = (HttpServletResponse) response;
	//重定向 -> 走的request -> 告诉浏览器新地址，全新访问，地址变化
	res.sendRedirect(req.getContextPath()+"/main.jsp");
	//转发 -> 没有走request，走的forward -> 走的内部方法，浏览器不知道，地址不变化
	req.getRequestDispatcher("main.jsp").forward(request,response);

### forward

通过RequestDispatcher的forward访问时，进入过滤器，例如jsp的forward转发也会进入过滤器

	<jsp:forward page="middle.jsp"> </jsp:forward>

也会进入过滤器，但是直接请求 request不会进入过滤器。

### include

同forward，只是RequestDispatcher的include访问时会进入过滤器

### Error

目标资源通过声明式异常处理机制调用时，过滤器被调用

一般下配合error-page使用。用于当页面跳转到错误页面 比如404时，执行过滤器

	<error-page>
		<error-code>404</error-code>
		<location>/error.jsp</location>
	</error-page>
	<filter>
		<filter-name>ErrorFilter</filter-name>
		<filter-class>com.ErrorFilter</filter-class>
	</filter>
	<filter-mapping>
		<filter-name>ErrorFilter</filter-name>
		<url-pattern>/error.jsp<url-pattern>
		<dispatcher>ERROR</dispatcher>
	</filter-mapping>

只有标注为error类型，当跳转到404时才会执行filter，否则不会执行

### Async（Servlet3.0 异步处理）

## 应用

登陆判断、编码转换、数据过滤替换、图像格式转换、内容压缩、加密处理
	