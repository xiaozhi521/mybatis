### 自定义typeHandler
#### 方式一：采用 typeHandler 方式
  - 1.1 自定义 StringTypeHandle 
  
  
    com.org.typeHandler.MyTypeIntegerHandler
    com.org.typeHandler.MyTypeStringHandler
  - 1.2、在 mybatis-config.xml 中配置typeHandler
  
  
    <typeHandlers>
        <typeHandler handler="com.org.typeHandler.MyTypeStringHandler" javaType="string" jdbcType="VARCHAR"/>
        <typeHandler handler="com.org.typeHandler.MyTypeIntegerHandler" javaType="int" jdbcType="INTEGER"/>
    </typeHandlers>

  - 1.3 在 com.org.dao.ContactInformationMapper.xml 中 id = informationResultMap  测试
  
  
    <resultMap id="informationResultMap" type="ContactInformation">
        <id property="id" column="c_id" typeHandler="com.org.typeHandler.MyTypeIntegerHandler"/>
        <result property="tel" column="c_tel" jdbcType="VARCHAR" javaType="string"/>
        <result property="email" column="c_email" typeHandler="com.org.typeHandler.MyTypeStringHandler"/>
        <!--<result property="user" column="user_id"/>-->
    </resultMap>
#### 方式二：采用 package 方式
  - 2.1 自定义 StringTypeHandle
  
  
    com.org.typeHandler.MyTypeIntegerHandlerScan
    com.org.typeHandler.MyTypeStringHandlerScan
  - 2.2 在 mybatis-config.xml 中配置typeHandler
  
  
    <typeHandlers>
        <package name="com.org.typeHandler"/>
    </typeHandlers>
  - 2.3 在 com.org.dao.ContactInformationMapper.xml 中 id = informationResultMap0  测试
  
  
    <select id="getContactInformationrById_2" parameterType="int" resultMap="informationResultMap0">
        select * from contactinformation where c_id = #{id}
    </select>
    <resultMap id="informationResultMap0" type="ContactInformation">
        <id property="id" column="c_id" typeHandler="com.org.typeHandler.MyTypeIntegerHandlerScan"/>
        <result property="tel" column="c_tel" jdbcType="VARCHAR" javaType="string"/>
        <result property="email" column="c_email" typeHandler="com.org.typeHandler.MyTypeStringHandlerScan"/>
        <!--<result property="user" column="user_id"/>-->
    </resultMap>

