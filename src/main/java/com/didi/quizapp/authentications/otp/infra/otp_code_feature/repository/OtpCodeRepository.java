package com.didi.quizapp.authentications.otp.infra.otp_code_feature.repository;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import com.didi.quizapp.authentications.otp.infra.otp_code_feature.entity.OtpCodeEntity;

public interface OtpCodeRepository extends JpaRepository<OtpCodeEntity, UUID> {

}
