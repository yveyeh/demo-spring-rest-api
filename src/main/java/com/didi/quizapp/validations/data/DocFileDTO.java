package com.didi.quizapp.validations.data;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.didi.quizapp.validations.DocFile;

@Repository
public interface DocFileDTO extends JpaRepository<DocFile, UUID> {

    //
}
