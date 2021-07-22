# **springboot-redis cache**
## **springboot整合redis实现cache缓存**
- redis序列化配置
- redis缓存配置
### spring cache缓存注解
#### @EnableCaching
开启基于注解的缓存，表示允许使用注解的方式进行缓存操作，一般加在启动类或配置类上
#### @Cacheable
可用于类或方法上；在目标方法执行前，会根据key先去缓存中查询看是否有数据，有就直接返回缓存中的key对应的value值。不再执行目标方法；无则执行目标方法，并将方法的返回值作为value，并以键值对的形式存入缓存
#### @CacheEvict
清除缓存，可用于类或方法上；在执行完目标方法后，清除缓存中对应key的数据(如果缓存中有对应key的数据缓存的话)
#### @CachePut
可用于类或方法上；在执行完目标方法后，并将方法的返回值作为value，并以键值对的形式存入缓存中
#### @Caching
此注解即可作为@Cacheable、@CacheEvict、@CachePut三种注解中的的任何一种或几种来使用
