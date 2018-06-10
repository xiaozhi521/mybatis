package com.cn;

import com.org.bean.ConditionItems;
import com.org.bean.Items;
import com.org.dao.UserMapper;
import com.org.util.SessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

public class ItemTest {
    /**
     *  动态sql if
     * @throws IOException
     */
    @Test
    public void seachKeyWord() throws IOException {
        //创建能执行映射文件中sql的sqlSession
        SqlSession session =  SessionFactoryUtil.getSession().openSession();

        String statement = "com.org.mapper.ItemsMapper.seachKeyWord";

        ConditionItems conditionItems = new ConditionItems();
//        conditionItems.setKeyword("%an%");
        List<Items> list = session.selectList(statement,conditionItems);

        System.out.println(list);
    }
}
