package ru.clevertec.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.clevertec.entity.TagEntity;

import java.util.List;
import java.util.Optional;

public interface TagRepository extends JpaRepository<TagEntity, Long> {

    @Query(nativeQuery = true, value = "SELECT id, name from tag order by name")
    List<TagEntity> findByNameOrderByNameAsc();

    @Override
    @EntityGraph(attributePaths = {"giftCertificateEntities"})
    Optional<TagEntity> findById(Long aLong);

    @Override
    @EntityGraph(attributePaths = {"giftCertificateEntities"})
    Page<TagEntity> findAll(Pageable pageable);

    @EntityGraph(attributePaths = {"tagEntities"})
    Optional<TagEntity> findByNameIgnoreCase(String tagDtoName);

}
