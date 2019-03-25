package com.xiaoy.dubbo.provider.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

/**
 * @Author: Xiaoy
 * @Description: 应用的配置
 * @Date: Created in 20:24 2019/3/19
 * @Modified By:
 */
@Component
@ConfigurationProperties(prefix = "application")
@RefreshScope
public class ApplicationProperties {

    private final Task task = new Task();

    public static class Task{
        private int schedulePoolSize;

        private String threadName;

        private int maxErrorCount;

        public int getSchedulePoolSize() {
            return schedulePoolSize;
        }

        public void setSchedulePoolSize(int schedulePoolSize) {
            this.schedulePoolSize = schedulePoolSize;
        }

        public String getThreadName() {
            return threadName;
        }

        public void setThreadName(String threadName) {
            this.threadName = threadName;
        }

        public int getMaxErrorCount() {
            return maxErrorCount;
        }

        public void setMaxErrorCount(int maxErrorCount) {
            this.maxErrorCount = maxErrorCount;
        }
    }

    public Task getTask() {
        return task;
    }
}
