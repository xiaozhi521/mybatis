**mybatis提供对SQL语句动态的组装能力，使用XML的几个简单的元素，便能完成动态sql的功能。**

**大量的判断都可以在 MyBatis 的映射XML里面配置，以达到许多需要大量代码才能实现的功能。**
#### if 元素
    <select id="seachKeyWord" parameterType="ConditionItems" resultType="Items">
         select * from Items
            <if test="keyword != null and keyword != ''">
               where itemName like concat('%',#{keyword},'%')
            </if>
    </select>
    
#### choose、when、otherwise 元素
    <select id="findRole2" parameterType="role" resultMap="roleResultMap">
        select role_no, role_name, note from t_role
        where 1=1
        <choose>
            <when test="roleNo != null and roleNo !=''">
                AND role_no = #{roleNo}
            </when>
            <when test="roleName != null and roleName !=''">
                AND role_name like concat('%', #{roleName}, '%')
            </when>
            <otherwise>
                AND note is not null
            </otherwise>
        </choose>
    </select>
#### trim、where、set 元素
- **where 元素**


    <select id="findRole3" parameterType="role" resultMap="roleResultMap">
        select role_no, role_name, note from t_role
        <where>
            <if test="roleName != null and roleName !=''">
                and role_name like concat('%', #{roleName}, '%')
            </if>
            <if test="note != null and note !=''">
                and note like concat('%', #{note}, '%')
            </if>
        </where>
    </select>
    
>   当 where 条件成立时，才会加入 where 这个 SQL 关键字到组装SQL里面，否则不加入。
    
- **trim 元素**
    
    
    <select id="findRole4" parameterType="string" resultMap="roleResultMap">
        select role_no, role_name, note from t_role
        <trim prefix="where" prefixOverrides="and">
            <if test="roleName != null and roleName !=''">
                and role_name like concat('%', #{roleName}, '%')
            </if>
        </trim>
    </select>
    
>trim 元素意味着要去掉一些特殊字符， prefix 代表着语句的前缀，prefixOverrides代表的是需要去掉那种字符串。这种写法与where的等效的。
    
- **set 元素**


    <update id="updateRole" parameterType="role">
        update t_role
        <set>
            <if test="roleName != null and roleName !=''">
                role_name = #{roleName},
            </if>
            <if test="note != null and note != ''">
                note = #{note}
            </if>
        </set>
        where role_no = #{roleNo}
    </update>
    
>  使用 trim 元素对update 进行改造:

    <update id="updateRole" parameterType="role">
        update t_role
        <trim prefix="set" prefixOverrides=",">
            <if test="roleName != null and roleName !=''">
                role_name = #{roleName},
            </if>
            <if test="note != null and note != ''">
                note = #{note}
            </if>
        </trim>
        where role_no = #{roleNo}
    </update>
#### foreach 元素
foreach 元素是一个循环语句，他的作用是遍历集合，他能够很好的支持数组和List，Set接口的集合，对此提供遍历的功能。往往用于SQL中的in关键字。
    
    <select id="findRoleByNums" resultMap="roleResultMap">
        select role_no, role_name, note from t_role where role_no in
        <foreach item="roleNo" index="index" collection="roleNoList"
            open="(" separator="," close=")">
            #{roleNo}
        </foreach>
    </select>
- **collection：roleNoList是传递进来的参数名称，可以是一个数组，List，Set等集合**
- **item: 配置当前循环的元素**
- **index：当前元素在集合位置下标**
- **open和close是以什么符号将这些集合元素包装起来**
- **separator：各个元素的间隔符**

> SQL中的**in**语句要特别注意，他会消耗大量的性能。
#### 用 test 的属性判断字符串
> test 用于条件判断语句，他在Mybatis中使用非常广泛。

> test的作用相当于判断真假，在大部分场景中，都是用以判断空和非空的。

> 有时候需要判断字符串，数字，和枚举等。

    <select id="getRoleTest" parameterType="string" resultMap="roleResultMap">
		select role_no, role_name, note from t_role
		<if test="type == 'Y'.toString()">
			where 1=1
		</if>
	</select>

如果把 type='Y'传递给SQL，MyBatis加入了条件where=1。**对于字符串的判断，可以通过toSting()的方法进行比较。
它可以判断数值型的参数。对于枚举而言，取决于使用何种typeHandler。**
#### bind 元素
- **bind元素的作用是通过OGNL表达式去定义一个上下文变量，这样更方便使用**

在进行模糊查询时，如果是 MySql数据库，常常用到的是一个concat，他用 **%** 和参数相连，然而在Oracle 数据库则没有，
Oracle数据库使用连接符号 **||** ，这样需要提供两种形式去实现。

但有了**bind**元素，就不必使用数据库语言，使用MyBatis的动态SQL即可完成。
    
    <select id="findRole5" parameterType="string" resultMap="roleResultMap">
        <bind name="pattern" value="'%' + _parameter + '%'" />
        SELECT role_no, role_name, note FROM t_role
        where role_name like #{pattern}
    </select>
    
- **_parameter：传递进来的参数，他和通配符 % 连接赋值给了pattern**    
> MyBatis 支持多个参数使用bind元素的用法传递多个参数也没有问题，首先定义接口方法。
    
    public List<Role> findRole6(@Param("roleName") String roleName, @Param("note") String note);

    <select id="findRole6" resultMap="roleResultMap">
        <bind name="pattern_roleName" value="'%' + roleName + '%'" />
        <bind name="pattern_note" value="'%' + note + '%'" />
        SELECT role_no, role_name, note FROM t_role
        where role_name like
        #{pattern_roleName}
        and note like #{pattern_note}
    </select>



