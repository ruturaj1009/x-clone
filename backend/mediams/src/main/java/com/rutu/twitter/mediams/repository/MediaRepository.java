package com.rutu.twitter.mediams.repository;

import com.rutu.twitter.mediams.entity.Media;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface MediaRepository extends JpaRepository<Media, Long> {
}
