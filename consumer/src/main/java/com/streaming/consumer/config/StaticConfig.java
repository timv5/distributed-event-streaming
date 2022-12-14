package com.streaming.consumer.config;

public class StaticConfig {

    public static final String TOPIC = "test_topic";
    public static final String GROUP = "com.streaming";
    public static final String SERVER_CONFIG = "localhost:29092";
    public static final Integer CONCURRENT_CONSUMERS = 2;
    public static final Integer RETRY_BACKOFF_MS_CONFIG = 2;

}
