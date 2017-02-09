# WebSocket介绍，与Socket的区别

## WebSocket介绍与原理

> WebSocket protocol 是HTML5一种新的协议。它实现了浏览器与服务器全双工通信(full-duplex)。一开始的握手需要借助HTTP请求完成。
> ——百度百科

### 目的：即时通讯，替代轮询

网站上的即时通讯是很常见的，比如网页的QQ，聊天系统等。按照以往的技术能力通常是采用**轮询**技术解决。

HTTP协议是非持久化的，单向的网络协议，在建立连接后只允许浏览器向服务器发出请求后，服务器才能返回相应的数据。当需要即时通讯时，通过轮询在特定的时间间隔（如1秒），由浏览器向服务器发送Request请求，然后将最新的数据返回给浏览器。这样的方法最明显的缺点就是需要不断的发送请求，而且通常HTTP request的Header是非常长的，为了传输一个很小的数据 需要付出巨大的代价，是很不合算的，占用了很多的宽带。

然而WebSocket的出现可以弥补这一缺点。在WebSocket中，只需要服务器和浏览器通过HTTP协议进行一个握手的动作，然后单独建立一条TCP的通信通道进行数据的传送。

### 原理

WebSocket同HTTP一样也是应用层的协议，但是它是一种**双向通信协议**，是建立在TCP之上的。

![image](http://pic.7tool.cn/uploads/2016/07/080903326.png)

#### 连接过程 —— 握手过程

1. 浏览器、服务器建立TCP连接，三次握手。这是通信的基础，传输控制层，若失败后续都不执行。
2. TCP连接成功后，浏览器通过HTTP协议向服务器传送WebSocket支持的版本号等信息。（**开始前的HTTP握手**）
3. 服务器收到客户端的握手请求后，**同样采用HTTP协议**回馈数据。
4. 当收到了连接成功的消息后，通过TCP通道进行传输通信。

## WebSocket与HTTP的关系

### 相同点

1. 都是一样基于TCP的，都是可靠性传输协议。
2. 都是应用层协议。

### 不同点

1. WebSocket是双向通信协议，模拟Socket协议，可以双向发送或接受信息。HTTP是单向的。
2. WebSocket是需要握手进行建立连接的。

### 联系

WebSocket在建立握手时，数据是通过HTTP传输的。但是建立之后，在真正传输时候是不需要HTTP协议的。

## WebSocket与Socket的关系

Socket其实并不是一个协议，而是为了方便使用TCP或UDP而抽象出来的一层，是位于应用层和传输控制层之间的一组接口。

> Socket是应用层与TCP/IP协议族通信的中间软件抽象层，它是一组接口。在设计模式中，Socket其实就是一个门面模式，它把复杂的TCP/IP协议族隐藏在Socket接口后面，对用户来说，一组简单的接口就是全部，让Socket去组织数据，以符合指定的协议。

当两台主机通信时，必须通过Socket连接，Socket则利用TCP/IP协议建立TCP连接。TCP连接则更依靠于底层的IP协议，IP协议的连接则依赖于链路层等更低层次。

WebSocket则是一个典型的应用层协议。

![image](http://pic.7tool.cn/uploads/2016/07/socket.gif)

### 区别

**Socket是传输控制层协议，WebSocket是应用层协议。**

## HTML5与WebSocket的关系

WebSocket API 是 HTML5 标准的一部分， 但这并不代表 WebSocket 一定要用在 HTML 中，或者只能在基于浏览器的应用程序中使用。

实际上，许多语言、框架和服务器都提供了 WebSocket 支持，例如：

* 基于 C 的 libwebsocket.org
* 基于 Node.js 的 Socket.io
* 基于 Python 的 ws4py
* 基于 C++ 的 WebSocket++
* Apache 对 WebSocket 的支持： Apache Module mod_proxy_wstunnel
* Nginx 对 WebSockets 的支持： NGINX as a WebSockets Proxy 、 NGINX Announces Support for WebSocket Protocol 、WebSocket proxying
* lighttpd 对 WebSocket 的支持：mod_websocket