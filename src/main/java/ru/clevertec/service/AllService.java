package ru.clevertec.service;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface AllService<T> {

    ResponseEntity<T> add(@RequestBody T t);

    ResponseEntity<T> updateId(Integer id, @RequestBody T t);

    ResponseEntity<List<T>> getAll(String page);

    T getId(@RequestParam("id") String id);

    void deleteId(Integer idTag);

}
