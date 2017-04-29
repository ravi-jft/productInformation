package com.productStore.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
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

@Configuration
@EnableWebMvc
@ComponentScan("com.productStore")
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
}
