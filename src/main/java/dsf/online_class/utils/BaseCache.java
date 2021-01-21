package dsf.online_class.utils;

import com.google.common.cache.Cache;
import org.springframework.stereotype.Component;
import com.google.common.cache.CacheBuilder;

import java.util.concurrent.TimeUnit;

@Component
public class BaseCache {

    private Cache<String,Object>  cache = CacheBuilder.newBuilder()

            //缓存初始化
            .initialCapacity(10)
            //最大值
            .maximumSize(100)
            //并发数
            .concurrencyLevel(5)
            //过期时间
            .expireAfterWrite(600,TimeUnit.SECONDS)
            //统计缓存命中率
            .recordStats()
            .build();

    public Cache<String, Object> getCache() {
        return cache;
    }

    public void setCache(Cache<String, Object> cache) {
        this.cache = cache;
    }
}
