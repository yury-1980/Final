package ru.clevertec.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.clevertec.dto.TagDto;
import ru.clevertec.entity.TagEntity;
import ru.clevertec.service.AllService;
import ru.clevertec.service.impl.TagAllServiceImpl;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("api/v1/tags")
public class TagController {

    private final AllService<TagDto> allService;
    private final TagAllServiceImpl tagAllService;

    @GetMapping("find-all")
    public ResponseEntity<List<TagDto>> getTagAll(@RequestParam("page") String page) {

        return allService.getAll(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TagDto> getTag(@PathVariable("id") String id) {
        return ResponseEntity.ok(allService.getId(id));
    }

    @GetMapping("/sort")
    public ResponseEntity<List<TagEntity>> getAllNameSort() {
        return tagAllService.getAllSort();
    }

    @PostMapping("/add")
    public ResponseEntity<TagDto> addTag(@RequestBody TagDto tagDto) {
        return allService.add(tagDto);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<TagDto> updateIdTag(@PathVariable("id") Integer id, @RequestBody TagDto tagDto) {
        return allService.updateId(id, tagDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteIdTag(@PathVariable("id") Integer idTag) {
        allService.deleteId(idTag);
        return ResponseEntity.ok("Delete Ok!");
    }
}
