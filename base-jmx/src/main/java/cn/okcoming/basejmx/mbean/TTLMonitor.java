package cn.okcoming.basejmx.mbean;

import javax.management.ObjectName;
import java.util.concurrent.atomic.AtomicLong;

/**
 * 统计每个url的请求响应耗时
 *
 * @author bluces
 */
public class TTLMonitor implements TTLMonitorMBean {
    private ObjectName objectName;

    private AtomicLong _0_count = new AtomicLong(0);
    private AtomicLong _1_lt100ms = new AtomicLong(0);
    private AtomicLong _2_lt500ms = new AtomicLong(0);
    private AtomicLong _3_lt1s = new AtomicLong(0);
    private AtomicLong _4_lt5s = new AtomicLong(0);
    private AtomicLong _5_gt5s = new AtomicLong(0);

    public void compute(long consume){
        _0_count.incrementAndGet();

        if(consume < 100){
            _1_lt100ms.incrementAndGet();
        }else if(consume < 500){
            _2_lt500ms.incrementAndGet();
        }else if(consume < 1000){
            _3_lt1s.incrementAndGet();
        }else if(consume < 5000) {
            _4_lt5s.incrementAndGet();
        }else{
            _5_gt5s.incrementAndGet();
        }
    }

    public long get_0_count() {
        return _0_count.longValue();
    }

    public long get_1_lt100ms() {
        return _1_lt100ms.longValue();
    }

    public long get_2_lt500ms() {
        return _2_lt500ms.longValue();
    }

    public long get_3_lt1s() {
        return _3_lt1s.longValue();
    }

    public long get_4_lt5s() {
        return _4_lt5s.longValue();
    }

    public long get_5_gt5s() {
        return _5_gt5s.longValue();
    }

    @Override
    public ObjectName getObjectName() {
        return objectName;
    }

    public void setObjectName(ObjectName objectName) {
        this.objectName = objectName;
    }
}
