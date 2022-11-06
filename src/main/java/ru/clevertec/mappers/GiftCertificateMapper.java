package ru.clevertec.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.clevertec.dto.GiftCertificateDto;
import ru.clevertec.entity.GiftCertificateEntity;

import java.time.LocalDateTime;

@Mapper(imports = LocalDateTime.class)
public interface GiftCertificateMapper {

    GiftCertificateDto certificateEntityToDto(GiftCertificateEntity giftCertificateEntity);

    @Mapping(target = "createData", defaultExpression = "java(LocalDateTime.now())")
    @Mapping(target = "lastUpdateDate", defaultExpression = "java(LocalDateTime.now())")
    GiftCertificateEntity certificateDtoToEntity(GiftCertificateDto giftCertificateDto);
}
