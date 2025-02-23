//package net.mdsgene.admin;
//
//import static java.util.concurrent.TimeUnit.HOURS;
//
//import javax.cache.CacheManager;
//import javax.cache.configuration.MutableConfiguration;
//import javax.cache.expiry.CreatedExpiryPolicy;
//import javax.cache.expiry.Duration;
//import javax.cache.expiry.TouchedExpiryPolicy;
//
//import org.springframework.boot.autoconfigure.cache.JCacheManagerCustomizer;
//import org.springframework.stereotype.Component;
//
//@Component
//public class CachingSetup implements JCacheManagerCustomizer
//{
//
//	@Override
//	public void customize(CacheManager cacheManager) {
//	    cacheManager.createCache("overview", new MutableConfiguration<>()
//	    	      .setExpiryPolicyFactory(CreatedExpiryPolicy.factoryOf(new Duration(HOURS, 1)))
//	    	      .setStoreByValue(false)
//	    	      .setStatisticsEnabled(false));
//	}
//}