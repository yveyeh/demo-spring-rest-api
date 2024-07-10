package com.didi.quizapp.authentications.shared.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface BaseRepository<T> {
    T saveAndFlush(T model);

    T getById(UUID uuid);

    T save(T model);

    Optional<T> findById(UUID uuid);

    boolean existsById(UUID uuid);

    List<T> findAll();

    long count();

    void delete(T model);

    void deleteById(UUID uuid);

    Page<T> findAll(Pageable pageable);

    // Page<T> findByUserId(Pageable pageable, UUID userId);
}
