package ru.clevertec.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.clevertec.dto.TagDto;
import ru.clevertec.entity.TagEntity;
import ru.clevertec.exception.BusinessException;
import ru.clevertec.mappers.TagMapper;
import ru.clevertec.repository.TagRepository;
import ru.clevertec.service.AllService;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class TagAllServiceImpl implements AllService<TagDto> {

    private final TagRepository tagRepository;
    private final TagMapper tagMapper;
    Integer pageSize = 10;

    @Transactional
    @Override
    public ResponseEntity<TagDto> add(TagDto tagDto) {

        TagDto tag = (TagDto) tagRepository
                .findByNameIgnoreCase(tagDto.getName()).map(giftCertificateEntity -> {
                    throw new BusinessException(String.format("%s%s%s", "Already exists "
                            , "name = ", tagDto.getName()));
                }).orElseGet(() -> {
                    TagEntity gce = tagMapper.tagDtoToEntity(tagDto);
                    TagEntity entity = tagRepository.save(gce);
                    return tagMapper.tagEntityToDto(entity);
                });

        return ResponseEntity.ok(tag);
    }

    @Transactional
    @Override
    public ResponseEntity<TagDto> updateId(Integer id, TagDto tagDto) {

        Long idTag = id.longValue();
        TagEntity save;

        if (tagRepository.existsById(idTag)) {
            TagEntity tagEntity = tagMapper.tagDtoToEntity(tagDto);
            tagEntity.setId(idTag);
            save = tagRepository.save(tagEntity);
        } else throw new BusinessException(String.format("%s%s%s", "Requested resouce not found "
                , "id = ", id));

        return ResponseEntity.ok(tagMapper.tagEntityToDto(save));
    }

    @Override
    public ResponseEntity<List<TagDto>> getAll(String page) {

        Pageable firstPage = PageRequest.of(Integer.parseInt(page), pageSize);

        return ResponseEntity.ok(tagRepository.findAll(firstPage).stream()
                .map(tag -> tagMapper.tagEntityToDto(tag)).collect(toList()));
    }

    @Override
    public TagDto getId(String id) {

        TagEntity byId = tagRepository.findById(Long.parseLong(id))
                .orElseThrow(() -> new BusinessException(String.format("%s%s%s", "Requested resouce not found "
                        , "id = ", id)));

        return tagMapper.tagEntityToDto(byId);
    }

    public ResponseEntity<List<TagEntity>> getAllSort() {

        return ResponseEntity.ok(tagRepository.findByNameOrderByNameAsc().stream().collect(toList()));
    }

    @Transactional
    @Override
    public void deleteId(Integer idTag) {

        Long id = idTag.longValue();
        tagRepository.findById(id).map(tag -> {
            tagRepository.deleteById(id);
            return tag;
        }).orElseThrow(() -> new BusinessException(String.format("%s%s%s", "Requested resouce not found "
                , "id = ", id)));
    }
}
