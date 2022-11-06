package ru.clevertec.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.clevertec.dto.GiftCertificateDto;
import ru.clevertec.entity.GiftCertificateEntity;
import ru.clevertec.exception.BusinessException;
import ru.clevertec.mappers.GiftCertificateMapper;
import ru.clevertec.repository.GiftCertificateRepositoy;
import ru.clevertec.service.AllService;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Transactional(readOnly = true)
@Service
@RequiredArgsConstructor
public class GiftCertificateAllServiceImpl implements AllService<GiftCertificateDto> {

    private final GiftCertificateMapper certificateMapper;
    private final GiftCertificateRepositoy certificateRepositoy;
    Integer pageSize = 10;

    @Transactional
    @Override
    public ResponseEntity<GiftCertificateDto> add(GiftCertificateDto certificateDto) {

        GiftCertificateDto certificate = (GiftCertificateDto) certificateRepositoy
                .findByNameIgnoreCase(certificateDto.getName()).map(giftCertificateEntity -> {
                    throw new BusinessException(String.format("%s%s%s", "Already exists "
                            , "name = ", certificateDto.getName()));
                }).orElseGet(() -> {
                    GiftCertificateEntity gce = certificateMapper.certificateDtoToEntity(certificateDto);
                    GiftCertificateEntity entity = certificateRepositoy.save(gce);
                    return certificateMapper.certificateEntityToDto(entity);
                });

        return ResponseEntity.ok(certificate);
    }

    @Transactional
    @Override
    public ResponseEntity<GiftCertificateDto> updateId(Integer id, GiftCertificateDto certificateDto) {

        Long idGift = id.longValue();
        GiftCertificateEntity save;

        if (certificateRepositoy.existsById(idGift)) {

            GiftCertificateEntity certificateEntity = certificateMapper.certificateDtoToEntity(certificateDto);
            certificateEntity.setId(idGift);
            save = certificateRepositoy.save(certificateEntity);

        } else throw new BusinessException(String.format("%s%s%s", "Requested resouce not found "
                , "id = ", id));

        return ResponseEntity.ok(certificateMapper.certificateEntityToDto(save));
    }

    @Override
    public ResponseEntity<List<GiftCertificateDto>> getAll(String page) {

        Pageable firstPage = PageRequest.of(Integer.parseInt(page), pageSize);

        return ResponseEntity.ok(certificateRepositoy.findAll(firstPage).stream()
                .map(tag -> certificateMapper.certificateEntityToDto(tag)).collect(toList()));
    }

    @Override
    public GiftCertificateDto getId(String id) {

        GiftCertificateEntity byId = certificateRepositoy.findById(Long.parseLong(id))
                .orElseThrow(() -> new BusinessException(String.format("%s%s%s", "Requested resouce not found "
                        , "id = ", id)));

        return certificateMapper.certificateEntityToDto(byId);
    }

    public ResponseEntity<List<GiftCertificateDto>> getName(String name) {

        List<GiftCertificateEntity> y = certificateRepositoy.findByNameLike(name);

        return ResponseEntity.ok(y.stream().map(tag -> certificateMapper.certificateEntityToDto(tag)).collect(toList()));
    }

    @Transactional
    @Override
    public void deleteId(Integer idGift) {

        Long id = idGift.longValue();
        certificateRepositoy.findById(id).map(certificateEntity -> {
            certificateRepositoy.deleteById(id);
            return certificateEntity;
        }).orElseThrow(() -> new BusinessException(String.format("%s%s%s", "Requested resouce not found "
                , "id = ", id)));
    }
}
