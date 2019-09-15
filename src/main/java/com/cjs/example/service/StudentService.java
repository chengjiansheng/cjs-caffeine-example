package com.cjs.example.service;

import com.cjs.example.model.Student;
import com.github.benmanes.caffeine.cache.LoadingCache;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author ChengJianSheng
 * @date 2019-09-15
 */
@Service
public class StudentService {

    @Resource(name = "studentCache")
    private LoadingCache<Integer, Student> studentCache;

    public Student getById(Integer id) {
        return studentCache.get(id);
    }

    public List<Student> getAll(List<Integer> idList) {
        Map<Integer, Student> studentMap = studentCache.getAll(idList);
        return studentMap.values().parallelStream().sorted(Comparator.comparing(Student::getId)).collect(Collectors.toList());
    }

    public Double hitRate() {
        return studentCache.stats().hitRate();
    }

    /**
     * 不直接写到本地缓存，而是先写到Redis，然后从Redis中读到本地
     */
}
