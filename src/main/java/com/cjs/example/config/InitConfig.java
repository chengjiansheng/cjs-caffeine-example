package com.cjs.example.config;

import com.alibaba.fastjson.JSON;
import com.cjs.example.model.Student;
import com.cjs.example.model.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.util.Arrays;
import java.util.List;

/**
 * @author ChengJianSheng
 * @date 2019-09-15
 */
@Configuration
public class InitConfig implements CommandLineRunner {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public void run(String... args) throws Exception {
        List<Student> studentList = Arrays.asList(
                new Student(101, "漩涡鸣人", 1, "影分身"),
                new Student(102, "宇智波佐助", 1, "写轮眼"),
                new Student(103, "日向宁次", 1, "白眼"),
                new Student(104, "日向雏田", 2, "八卦掌"),
                new Student(105, "春野樱", 2, "医疗忍者"));

        HashOperations<String, String, String> hashOperations = stringRedisTemplate.opsForHash();
        for (Student student : studentList) {
            hashOperations.put("STU_HS", String.valueOf(student.getId()), JSON.toJSONString(student));
        }

        List<Teacher> teacherList = Arrays.asList(
                new Teacher(1, "旗木卡卡西"),
                new Teacher(2, "新垣结衣"),
                new Teacher(3, "长泽雅美"));

        for (Teacher teacher : teacherList) {
            hashOperations.put("TEA_HS", String.valueOf(teacher.getId()), JSON.toJSONString(teacher));
        }
    }
}
