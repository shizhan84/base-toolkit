package cn.okcoming.jmx.mbean;

public interface TTLMonitorMBean {
    long get_0_count();

    long get_1_lt100ms();

    long get_2_lt500ms();

    long get_3_lt1s();

    long get_4_lt5s() ;

    long get_5_gt5s();
}
