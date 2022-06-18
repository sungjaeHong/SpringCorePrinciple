package study.springcoreprinciple.order.support;

import study.springcoreprinciple.order.domain.TraceStatus;

/**
 * Created by peter on 2022/06/18
 */
public interface LogTrace {
    TraceStatus begin(String message);
    void end(TraceStatus status);
    void exception(TraceStatus status, Exception e);
}
