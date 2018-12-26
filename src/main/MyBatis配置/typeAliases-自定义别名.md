### 定义别名
#### 使用配置文件定义别名
    <typeAliases>
        <typeAlias type="com.org.bean.User" alias="_User"/>
    </typeAliases>
#### 使用包名定义别名 ：
   - 为org.bean包下的所有实体类配置别名，MyBatis默认的设置别名的方式就是去除类所在的包后的简单的类名
        
        
    <typeAliases>
        <package name="com.org.bean"/>
    </typeAliases>
   - 使用 @Alias 注解定义别名
        
        
    @Alias("user")
    public class User implements Serializable{}