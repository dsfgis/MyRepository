package dsf.online_class.config;

import dsf.online_class.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 拦截器配置
 */
@Configuration
public class InterceptorConfig implements WebMvcConfigurer {
    @Bean
    LoginInterceptor loginInterceptor(){
        return new LoginInterceptor();
    }
    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        //用户注册及登录不拦截
        registry.addInterceptor(loginInterceptor()).addPathPatterns("/api/v1/pri/*/*/**")
        //.excludePathPatterns("/api/v1/pri/user/login","/api/v1/pri/user/register")
        ;
        WebMvcConfigurer.super.addInterceptors(registry);

    }
}
