package ru.itmo.wp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.itmo.wp.domain.Notice;

import java.util.List;

public interface NoticeRepository extends JpaRepository<Notice, Long> {
    @Query(
            value = "SELECT * FROM `notice` ORDER BY `notice`.`creation_time` DESC",
            nativeQuery = true
    )
    List<Notice> findAllByOrderByCreationTime();

}