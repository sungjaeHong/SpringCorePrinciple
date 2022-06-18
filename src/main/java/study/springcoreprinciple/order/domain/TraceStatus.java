package study.springcoreprinciple.order.domain;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by peter on 2022/06/18
 */

@Getter
@Setter
public class TraceStatus {
    private TraceId traceId;
    private Long startTimeMs;
    private String message;

    public TraceStatus(TraceId traceId, Long startTimeMs, String message) {
        this.traceId = traceId;
        this.startTimeMs = startTimeMs;
        this.message = message;
    }
}
