package study.springcoreprinciple.order.logtrace;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import study.springcoreprinciple.order.domain.TraceStatus;
import study.springcoreprinciple.order.support.ThreadLocalLogTrace;

/**
 * Created by peter on 2022/06/18
 */
@Slf4j
public class ThreadLocalLogTraceTest {

    ThreadLocalLogTrace trace = new ThreadLocalLogTrace();

    @Test
    void begin_and_level2() {
        TraceStatus status1 = trace.begin("hello1");
        TraceStatus status2 = trace.begin("hello2");
        trace.end(status2);
        trace.end(status1);
    }

    @Test
    void begin_exception_level2() {
        TraceStatus status1 = trace.begin("hello1");
        TraceStatus status2 = trace.begin("hello2");
        trace.exception(status2, new IllegalArgumentException());
        trace.exception(status1, new IllegalArgumentException());
    }
}
