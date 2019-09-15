package com.cjs.example.service;

import com.alibaba.fastjson.JSON;
import com.cjs.example.model.Teacher;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * @author ChengJianSheng
 * @date 2019-09-15
 */
@Slf4j
@Service
public class TeacherService {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Cacheable(cacheNames = "teacher", key = "#teacherId")
    public Teacher getById(Integer teacherId) {
        log.info("从缓存中读取...Key={}", teacherId);
        HashOperations<String, String, String> hashOperations = stringRedisTemplate.opsForHash();
        String value = hashOperations.get("TEA_HS", String.valueOf(teacherId));
        if (StringUtils.isEmpty(value)) {
            return null;
        }
        return JSON.parseObject(value, Teacher.class);
    }

}
