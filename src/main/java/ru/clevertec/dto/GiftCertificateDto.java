package ru.clevertec.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.clevertec.entity.TagEntity;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GiftCertificateDto {

    Long id;

    @NotBlank
    String name;
    String description;

    @Min(value = 0)
    Double price;
    Integer duration;
    LocalDateTime createData;
    LocalDateTime lastUpdateDate;
    List<TagEntity> tagEntities = new ArrayList<>();
}
