package com.didi.quizapp.validations.data;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.didi.quizapp.validations.OTP;

@Repository
public interface OtpDTO extends JpaRepository<OTP, UUID> {
    OTP findByRecipient(String recipient);

    // @Query("DELETE FROM otp WHERE recipient = ?1")
    // void deleteByRecipient(String recipient);
}
