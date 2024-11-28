package com.example.utils;

import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.concurrent.*;

@Service
public class ipStoreUtils {

    // 存储 IP 地址及其过期时间
    private final Map<String, Long> ipStorage = new ConcurrentHashMap<>();
    private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
    private final long EXPIRATION_TIME = TimeUnit.MINUTES.toMillis(5); // IP 过期时间 5 分钟

    public ipStoreUtils() {
        // 定时清理任务，每分钟运行一次
        scheduler.scheduleAtFixedRate(this::removeExpiredIps, 1, 1, TimeUnit.MINUTES);
    }

    // 添加 IP 地址
    public boolean addIp(String ip) {
        if (ipStorage.containsKey(ip)) {
            return false; // IP 已存在
        }
        ipStorage.put(ip, System.currentTimeMillis() + EXPIRATION_TIME);
        return true;
    }

    // 检查 IP 是否已存在
    public boolean containsIp(String ip) {
        return ipStorage.containsKey(ip);
    }

    // 移除过期 IP
    private void removeExpiredIps() {
        long now = System.currentTimeMillis();
        ipStorage.entrySet().removeIf(entry -> entry.getValue() < now);
    }
}
