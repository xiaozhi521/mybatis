### 一级缓存
    - Session级别，默认开启
    
    - 必须用一个Session，close后就失效了
    
    - 查询条件需要是相同的
    
    - 没有执行过session.clearCache()清理缓存
    
    - 没有执行过增删改的操作(这些操作都会清理缓存)
    
### 二级缓存  
    - SessionFactory 级别
    
    - 实体类需要实现Serializable接口
    
    - 在settings中所有映射器中配置的缓存的全局开关：<setting name="cacheEnabled" value="true"/>
    
    - 在Mapper.xml 文件中加入<cache/>
    