package ru.clevertec.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.clevertec.entity.GiftCertificateEntity;

import java.util.List;
import java.util.Optional;

public interface GiftCertificateRepositoy extends JpaRepository<GiftCertificateEntity, Long> {

    //        @EntityGraph(attributePaths = {"tagEntities"}) Нельзя для своего запроса
    @Query(nativeQuery = true, value = "SELECT id, name, description, price, duration, create_data, last_update_date" +
            " FROM gift_certificate WHERE name iLIKE lower(concat('%', :name,'%' ))")
    List<GiftCertificateEntity> findByNameLike(@Param("name") String name);

    @Override
    @EntityGraph(attributePaths = {"tagEntities"})
    Optional<GiftCertificateEntity> findById(Long aLong);

    @Override
    @EntityGraph(attributePaths = {"tagEntities"})
    Page<GiftCertificateEntity> findAll(Pageable pageable);

    @EntityGraph(attributePaths = {"tagEntities"})
    Optional<GiftCertificateEntity> findByNameIgnoreCase(String certificateDtoName);

}
