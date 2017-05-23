package com.productStore.config;

import com.productStore.aspectConfig.MyAspect;
import com.productStore.service.CheckAspectServiceImpl;
import org.springframework.aop.framework.ProxyFactoryBean;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.core.env.Environment;
import org.springframework.mail.MailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.util.UrlPathHelper;

import javax.servlet.descriptor.TaglibDescriptor;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.Tag;
import java.util.Properties;

@Configuration
@EnableWebMvc
@ComponentScan("com.productStore")
//@ComponentScan(basePackages = {"com.productStore.aspectConfig","com.productStore"})
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class WebApplicationContextConfig extends WebMvcConfigurerAdapter{

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer){
        configurer.enable();
    }

    @Bean
    public InternalResourceViewResolver getInternalResourceViewResolver(){
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setViewClass(JstlView.class);
        resolver.setPrefix("/WEB-INF/views/");
        resolver.setSuffix(".jsp");
        return resolver;
    }

    @Override
    public void configurePathMatch(PathMatchConfigurer configurer) {
        UrlPathHelper urlPathHelper = new UrlPathHelper();
        urlPathHelper.setRemoveSemicolonContent(false);
        configurer.setUrlPathHelper(urlPathHelper);
    }

    public MessageSource messageSource(){
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setBasename("locale/messages");
        messageSource.setDefaultEncoding("UTF-8");
        return messageSource;
    }

/*    public Taglib taglib() {
        TaglibDescriptor tablibDesc = new TaglibDescriptor() {
            @Override
            public String getTaglibURI() {
                return "http://productInformation.com/jsp/tlds/mytags";
            }

            @Override
            public String getTaglibLocation() {
                return "/WEB-INF/numberformatter.tld";
            }

        }
    }*/

    public TaglibDescriptor taglibDescriptor(){
        TaglibDescriptor taglibDescriptor = new TaglibDescriptor() {

            @Override
            public String getTaglibURI() {
                return "http://productInformation.com/jsp/tlds/mytags";
            }

            @Override
            public String getTaglibLocation() {
                return "/WEB-INF/numberformatter.tld";
            }
        };
        return taglibDescriptor;
    }

    //email sending
  /*  @Bean
    public MailSender mailSender(Environment env){
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost(env.getProperty("mailserver.host"));
        //mailSender.getHost("mail.smtp")
        return mailSender;
    }*/
    private Properties getMailProperties() {
        Properties properties = new Properties();
        properties.setProperty("mail.smtp.auth", "true");
        properties.setProperty("mail.smtp.socketFactory.port", "465");
        properties.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        properties.setProperty("mail.smtp.socketFactory.fallback", "false");
        return properties;
    }

    @Bean
    public MailSender mailSender(){
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost("smtp.gmail.com");
        mailSender.setPort(465);
        mailSender.setUsername("ravikumaraggarwalabc@gmail.com");
        mailSender.setPassword("shivmandir");
        mailSender.setJavaMailProperties(getMailProperties());
        return mailSender;
    }

    @Bean
    public ProxyFactoryBean proxyFactoryBean(){
        ProxyFactoryBean pfb = new ProxyFactoryBean();
        pfb.setTarget(new CheckAspectServiceImpl());
        pfb.setInterceptorNames(new String[]{String.valueOf(new MyAspect())});
        return pfb;
    }
}
