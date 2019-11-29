package guru.springframework.config;

import guru.springframework.examplebeans.FakeDataSource;
import guru.springframework.examplebeans.FakeJmsBroker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;

@Configuration
@PropertySources({
        @PropertySource({"classpath:datasource.properties"}),
        @PropertySource({"classpath:jms.properties"})
})
//@PropertySource({"classpath:datasource.properties", "classpath:jms.properties"})
public class PropertyConfig {
    private final Environment env;
    @Value("${guru.username}")
    String user;
    @Value("${guru.password}")
    String password;
    @Value("${guru.dburl}")
    String url;
    @Value("${guru.jms.username}")
    String jmsUserName;
    @Value("${guru.jms.password}")
    String jmsPassoword;
    @Value("${guru.jms.url}")
    String jmsUrl;

    public PropertyConfig(Environment env) {
        this.env = env;
    }
        @Bean
        public FakeJmsBroker fakeJmsBroker() {
            FakeJmsBroker jmsBroker = new FakeJmsBroker();
            jmsBroker.setUser(jmsUserName);
            jmsBroker.setPassword(jmsPassoword);
            jmsBroker.setDburl(jmsUrl);
            return jmsBroker;
        }

        @Bean
        public FakeDataSource fakeDataSource() {
            FakeDataSource fakeDataSource = new FakeDataSource();
            fakeDataSource.setUser(env.getProperty("USERNAME"));
            fakeDataSource.setPassword(password);
            fakeDataSource.setDburl(url);
            return fakeDataSource;
        }

        @Bean
        private static PropertySourcesPlaceholderConfigurer properties() {
            return new PropertySourcesPlaceholderConfigurer();
        }
    }
