package ru.clevertec.mappers;

import org.mapstruct.Mapper;
import ru.clevertec.dto.TagDto;
import ru.clevertec.entity.TagEntity;

@Mapper
public interface TagMapper {

    TagDto tagEntityToDto(TagEntity tagEntity);

    TagEntity tagDtoToEntity(TagDto tagDto);

}
