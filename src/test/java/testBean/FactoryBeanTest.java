package testBean;

import org.springframework.beans.factory.FactoryBean;

public class FactoryBeanTest implements FactoryBean<Job> {
    @Override
    public Job getObject() throws Exception {
        return new Job();
    }

    @Override
    public Class<Job> getObjectType() {
        return Job.class;
    }
}