Tutorial available here: [Spring-MVC with gradle](http://www.cnblogs.com/SLKnate/p/spring-mvc-in-oneminitue-with-gradle.html)

Powershell execute:
mkdir src\main\java ; mkdir src\main\resources ; mkdir src\main\webapp ; mkdir src\main\webapp\WEB-INF; mkdir src\test\java ; mkdir src\test\resources

Extend class
public class SampleWebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

}

public class SpringMVCConfig extends WebMvcConfigurerAdapter {
	
}
