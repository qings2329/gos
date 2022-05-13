package testBean;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringRunner.class)
@WebAppConfiguration
@SpringBootTest(classes = {FactoryBeanTest.class})
public class SpringbootApplicationTest {

    @Autowired
    private ApplicationContext applicationContext;

    @Test
    public void test() {
        // BeanFactory 的接口
        FactoryBeanTest bean1 = applicationContext.getBean(FactoryBeanTest.class);

        Job jobObj1 = (Job) applicationContext.getBean("factoryBeanTest");
        System.out.println(jobObj1.stamp);

        Object obj1 = applicationContext.getBean("&factoryBeanTest");
        try {
            System.out.println(bean1 == obj1);

            Thread.sleep(1000);
            Job jobObj2 = bean1.getObject();
            System.out.println(jobObj2.stamp);

            System.out.println(jobObj1 == jobObj2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}