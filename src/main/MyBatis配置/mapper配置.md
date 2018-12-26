#### 1、用文件路径引入映射器
    <mappers>
        <mapper resource="com/org/mapper/userMapper.xml"/>
    </mappers>
#### 2、用包名引入映射器
    <mappers>
        <package name="com.org.dao"></package>
    </mappers>
#### 3、使用类注册引入
    <mappers>
        <mapper class="com.org.dao.UserMapper"/>
    </mappers>
#### 4、用 userMapper.xml 引入
    <mappers>
        <mapper url="file:///var/mappers/com/org/mapper/userMapper.xml"/>
    </mappers>
