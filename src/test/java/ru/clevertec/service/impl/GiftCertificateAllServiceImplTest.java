package ru.clevertec.service.impl;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.clevertec.dto.GiftCertificateDto;
import ru.clevertec.entity.GiftCertificateEntity;
import ru.clevertec.entity.TagEntity;
import ru.clevertec.mappers.GiftCertificateMapper;
import ru.clevertec.repository.GiftCertificateRepositoy;
import ru.clevertec.repository.TagRepository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class GiftCertificateAllServiceImplTest {

    @Mock
    private GiftCertificateRepositoy certificateRepositoy;

    @Mock
    private TagRepository tagRepository;

    @Mock
    private GiftCertificateMapper certificateMapper;

    @InjectMocks
    private GiftCertificateAllServiceImpl certificateAllService;

    TagEntity tagEntity;

    GiftCertificateEntity certificateEntity = GiftCertificateEntity.builder()
            .lastUpdateDate(LocalDateTime.now())
            .createData(LocalDateTime.now())
            .duration(1)
            .description("a")
            .name("house")
            .id(1L)
            .price(BigDecimal.valueOf(1.5))
            .tagEntities(Arrays.asList())
            .build();

    GiftCertificateDto certificateDto = GiftCertificateDto.builder()
            .lastUpdateDate(LocalDateTime.now())
            .createData(LocalDateTime.now())
            .duration(1)
            .description("a")
            .name("house")
            .id(1L)
            .price(1.5)
            .tagEntities(Arrays.asList())
            .build();

    @Test
    void add() {


    }

    @Test
    void updateId() {
    }

    @Test
    void getAll() {
    }

    @Test
    void getId() {

        Mockito.when(certificateRepositoy.findById(1L)).thenReturn(Optional.ofNullable(certificateEntity));
        Mockito.when(certificateMapper.certificateEntityToDto(certificateEntity)).thenReturn(certificateDto);
//        Mockito.when(certificateAllService.getId("1")).thenReturn(certificateDto);

        assertEquals(certificateDto, certificateAllService.getId("1"));
    }

    @Test
    void getName() {
    }

    @Test
    void deleteId() {
    }
}