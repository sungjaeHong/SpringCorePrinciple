package study.springcoreprinciple.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import study.springcoreprinciple.order.support.FieldLogTrace;
import study.springcoreprinciple.order.support.LogTrace;

/**
 * Created by peter on 2022/06/18
 */
@Configuration
public class LogTraceConfig {
    @Bean
    public LogTrace logTrace() {
        return new FieldLogTrace();
    }
}
