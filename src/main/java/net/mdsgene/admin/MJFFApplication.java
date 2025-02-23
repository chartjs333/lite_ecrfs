package net.mdsgene.admin;

import javax.sql.DataSource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cache.annotation.EnableCaching;
//import org.springframework.cache.ehcache.EhCacheCacheManager;
//import org.springframework.cache.ehcache.EhCacheManagerFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@EnableCaching
public class MJFFApplication {

    public static void main(String[] args) {
        SpringApplication.run(MJFFApplication.class, args);
    }

//	@Bean
//	CommandLineRunner lookup(SOAPConnector soapConnector) {
//		return (args) -> {
//
//			DeleteToken request1 = new net.mdsgene.admin.wsdl.ObjectFactory().createDeleteToken();
//			request1.setLoginToken("1AC6C56C53BA83C09AFB6240227C8C");
//			DeleteTokenResponse response1 =(DeleteTokenResponse) soapConnector.callWebService("https://test-mds.execinc.com/edibo/Login/IntegratedLoginWebService?wsdl", request1);
//            System.out.println("Got Response As below ========= : ");
//			
//			
//			GetObjectAccessorValue request = new net.mdsgene.admin.wsdl.ObjectFactory().createGetObjectAccessorValue();
//            request.setAccessorName("ContactId");
//            request.setObjectName("AuthenticatedContact");
//            request.setLoginToken("1AC6C56C53BA83C09AFB6240227C8C");
//            GetObjectAccessorValueResponse response =(GetObjectAccessorValueResponse) soapConnector.callWebService("https://test-mds.execinc.com/edibo/Login/IntegratedLoginWebService?wsdl", request);
//            System.out.println("Got Response As below ========= : ");
//		};
//	}

//	//TODO
//	@Bean(name = "datasource1")
//	@ConfigurationProperties("spring.datasource")
//	public DataSource dataSource() {
//		return DataSourceBuilder.create().build();
//	}

	
//	@Primary
//    @Bean(name = "default")
//    public CacheManager cacheManager() {
//        return new EhCacheCacheManager(ehCacheCacheManager().getObject());
//    }
//
//
//    @Bean
//    public EhCacheManagerFactoryBean ehCacheCacheManager() {
//        EhCacheManagerFactoryBean cmfb = new EhCacheManagerFactoryBean();
//        cmfb.setConfigLocation(new ClassPathResource("ehcache.xml"));
//        cmfb.setShared(true);
//        return cmfb;
//    }
}