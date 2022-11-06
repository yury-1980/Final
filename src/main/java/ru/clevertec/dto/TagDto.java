package ru.clevertec.dto;

import lombok.Builder;
import lombok.Value;
import ru.clevertec.entity.GiftCertificateEntity;

import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

@Value
@Builder
public class TagDto {

    Long id;

    @NotBlank
    String name;
    List<GiftCertificateEntity> giftCertificateEntities = new ArrayList<>();
}
