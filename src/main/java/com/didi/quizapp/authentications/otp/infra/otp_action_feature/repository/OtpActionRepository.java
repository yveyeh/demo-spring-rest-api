package com.didi.quizapp.authentications.otp.infra.otp_action_feature.repository;

import java.util.UUID;

// import org.springframework.data.domain.Page;
// import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.didi.quizapp.authentications.otp.infra.otp_action_feature.entity.OtpActionEntity;

public interface OtpActionRepository extends JpaRepository<OtpActionEntity, UUID> {

}
