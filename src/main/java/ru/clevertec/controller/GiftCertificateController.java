package ru.clevertec.controller;

import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.clevertec.dto.GiftCertificateDto;
import ru.clevertec.service.AllService;
import ru.clevertec.service.impl.GiftCertificateAllServiceImpl;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("api/v1/gifts")
public class GiftCertificateController {

    private final AllService<GiftCertificateDto> allService;
    private final GiftCertificateAllServiceImpl service;

    @GetMapping
    public ResponseEntity<List<GiftCertificateDto>> getGiftCertificateAll(@RequestParam("page") String page) {

        return allService.getAll(page);
    }

    @SneakyThrows
    @GetMapping("/get-id")
    public ResponseEntity<GiftCertificateDto> getGiftCertificateId(@RequestParam("id") String id) {
        return ResponseEntity.ok(allService.getId(id));
    }

    @GetMapping("/name")
    public ResponseEntity<List<GiftCertificateDto>> certificateDtoList(@RequestParam("name") String name) {

        return service.getName(name);
    }

    @PostMapping("/add")
    public ResponseEntity<GiftCertificateDto> addGiftCertificate(@RequestBody GiftCertificateDto certificateDto) {
        return allService.add(certificateDto);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<GiftCertificateDto> updateIdGiftCertificate(@PathVariable("id") Integer id,
                                                                      @RequestBody GiftCertificateDto certificateDto) {
        return allService.updateId(id, certificateDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteIdTag(@PathVariable("id") Integer idTag) {
        allService.deleteId(idTag);
        return ResponseEntity.ok("Delete Ok!");
    }
}
