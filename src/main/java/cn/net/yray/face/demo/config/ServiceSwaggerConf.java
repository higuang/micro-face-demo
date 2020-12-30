package cn.net.yray.face.demo.config;

import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.time.LocalDate;

@Configuration
@EnableSwagger2
public class ServiceSwaggerConf implements EnvironmentAware{
	
	private String swagger;
	
	
	@Bean
	public Docket petApi() {
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(apiInfo())
				.select()
				.apis(RequestHandlerSelectors.basePackage(swagger))
				.paths(PathSelectors.any())
				.build()
				.pathMapping("/")
				.directModelSubstitute(LocalDate.class, String.class)
				.genericModelSubstitutes(ResponseEntity.class)
				.useDefaultResponseMessages(false)
				.enableUrlTemplating(false);
	}
	private ApiInfo apiInfo() {
		return new ApiInfoBuilder()
				.title("基于Restful APIs构建的相关用户接口")
				.description("门户、手机用户相关接口")
				.contact("lyg").version("0.1").build();
	}
	
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
	
	public void setEnvironment(Environment environment) {
        this.swagger = "cn.net.cfss.fgbp.face.console.controller";//propertyResolver.getProperty("user.service.swagger");
    }
}
