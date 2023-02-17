# SpringBoot3 Integration  Middleware



## 1、SpringMVC Running Process

SpringMVC中的核心组件 `DispatcherServlet`

核心方法 `doDispatch()`

源码如下：

```java
protected void doDispatch(HttpServletRequest request, HttpServletResponse response) throws Exception {
    HttpServletRequest processedRequest = request;
    HandlerExecutionChain mappedHandler = null;
    boolean multipartRequestParsed = false;
    WebAsyncManager asyncManager = WebAsyncUtils.getAsyncManager(request);

    try {
        try {
            ModelAndView mv = null;
            Exception dispatchException = null;

            try {
                // 校验是否是文件
                processedRequest = this.checkMultipart(request);
                multipartRequestParsed = processedRequest != request;
                // 通过请求查找对应的handlerChain处理链
                mappedHandler = this.getHandler(processedRequest);
                if (mappedHandler == null) {
                    this.noHandlerFound(processedRequest, response);
                    return;
                }
				// 通过处理链找到对应的handlerAdapt	
                HandlerAdapter ha = this.getHandlerAdapter(mappedHandler.getHandler());
                String method = request.getMethod();
                boolean isGet = HttpMethod.GET.matches(method);
                if (isGet || HttpMethod.HEAD.matches(method)) {
                    long lastModified = ha.getLastModified(request, mappedHandler.getHandler());
                    if ((new ServletWebRequest(request, response)).checkNotModified(lastModified) && isGet) {
                        return;
                    }
                }

                if (!mappedHandler.applyPreHandle(processedRequest, response)) {
                    return;
                }
				// 通过HandlerAdapt找到对应的Handler处理，返回ModelAndView对象
                mv = ha.handle(processedRequest, response, mappedHandler.getHandler());
                if (asyncManager.isConcurrentHandlingStarted()) {
                    return;
                }
				// 应用默认视图
                this.applyDefaultViewName(processedRequest, mv);
                // 应用后置处理
                mappedHandler.applyPostHandle(processedRequest, response, mv);
            } catch (Exception var20) {
                dispatchException = var20;
            } catch (Throwable var21) {
                dispatchException = new ServletException("Handler dispatch failed: " + var21, var21);
            }
			// 返回
            this.processDispatchResult(processedRequest, response, mappedHandler, mv, (Exception)dispatchException);
        } catch (Exception var22) {
            this.triggerAfterCompletion(processedRequest, response, mappedHandler, var22);
        } catch (Throwable var23) {
            this.triggerAfterCompletion(processedRequest, response, mappedHandler, new ServletException("Handler processing failed: " + var23, var23));
        }

    } finally {
        if (asyncManager.isConcurrentHandlingStarted()) {
            if (mappedHandler != null) {
                mappedHandler.applyAfterConcurrentHandlingStarted(processedRequest, response);
            }
        } else if (multipartRequestParsed) {
            this.cleanupMultipart(processedRequest);
        }

    }
}
```



详细执行流程

1. 前端发送请求，该请求会被提交到DispatcherServlet
2. DispatcherServlet请求一个或者是多个HandlerMapping 返回一个执行链Handler Execution Chain
3. DispatcherServlet将执行链发送到HandlerAdapt
4. HandlerAdapt 通过Handler信息找到对应的Handler
5. Handler 处理完成之后会返回ModelAndView(模型视图对象)给HandlerAdapt
6. HandlerAdapt将ModelAndView返回给DispatcherServlet
7. DispatcherServlet 接收到 ModelAndView 对象后，会请求 ViewResolver（视图解析器）对视图进行解析；
8. ViewResolver 根据 View 信息匹配到相应的视图结果，并返回给 DispatcherServlet；
9. DispatcherServlet 接收到具体的 View 视图后，进行视图渲染，将 Model 中的模型数据填充到 View 视图中的 request 域，生成最终的 View（视图）；
10. 视图负责将结果显示到浏览器（客户端）



参考文章https://blog.csdn.net/m0_52982868/article/details/126414287





## 2、SpringBoot3 Integration  Redis7



### 1、dependcy



### 2、config



### 3、demo





















