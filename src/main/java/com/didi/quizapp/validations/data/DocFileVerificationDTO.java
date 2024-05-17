package com.didi.quizapp.validations.data;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.didi.quizapp.validations.DocFileVerification;

@Repository
public interface DocFileVerificationDTO extends JpaRepository<DocFileVerification, UUID> {

    List<DocFileVerification> findByDocFileId(UUID docFileId);
}
