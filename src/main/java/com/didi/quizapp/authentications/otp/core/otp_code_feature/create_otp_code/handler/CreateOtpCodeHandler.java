package com.didi.quizapp.authentications.otp.core.otp_code_feature.create_otp_code.handler;

import com.didi.quizapp.authentications.otp.core.OTPGenerator;
import com.didi.quizapp.authentications.otp.core.otp_action_feature.shared.model.OtpActionModel;
import com.didi.quizapp.authentications.otp.core.otp_action_feature.shared.repository.OtpActionRepositoryPort;
import com.didi.quizapp.authentications.otp.core.otp_code_feature.create_otp_code.dto.BuildCreateOtpCodeInputDTO;
import com.didi.quizapp.authentications.otp.core.otp_code_feature.create_otp_code.dto.CreateOtpCodeInputDTO;
import com.didi.quizapp.authentications.otp.core.otp_code_feature.create_otp_code.dto.CreateOtpCodeOutputDTO;
import com.didi.quizapp.authentications.otp.core.otp_code_feature.create_otp_code.usecase.CreateOtpCodeUseCase;
import com.didi.quizapp.authentications.otp.core.otp_code_feature.shared.dto.OtpCodeOutputDTO;
import com.didi.quizapp.authentications.otp.core.otp_code_feature.shared.mapper.OtpCodeCoreMapper;
import com.didi.quizapp.authentications.otp.core.otp_code_feature.shared.mapper.OtpCodeCoreMapperImpl;
import com.didi.quizapp.authentications.otp.core.otp_code_feature.shared.model.OtpCodeModel;
import com.didi.quizapp.authentications.otp.core.otp_code_feature.shared.repository.OtpCodeRepositoryPort;
import com.didi.quizapp.authentications.otp.infra.shared.enums.Method;
import com.didi.quizapp.authentications.otp.infra.shared.enums.OTPFormat;
import org.springframework.beans.factory.annotation.Autowired;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Set;

@RequiredArgsConstructor
@Service
public class CreateOtpCodeHandler implements CreateOtpCodeUseCase {

    @Autowired
    private OtpCodeRepositoryPort otpCodeRepositoryPort;

    @Autowired
    OtpActionRepositoryPort otpActionRepositoryPort;

    @Override
    public CreateOtpCodeOutputDTO createOtpCode(CreateOtpCodeInputDTO otpCodeInputDTO) {

        long startTime = System.currentTimeMillis();

        OtpCodeCoreMapper MAPPER = new OtpCodeCoreMapperImpl();

        System.out.println(otpCodeInputDTO);

        //
        

        OtpActionModel otpActionModel = otpActionRepositoryPort.findById(otpCodeInputDTO.getOtpActionId())
            .orElseThrow(() -> new IllegalArgumentException("OTP action not found"));

        System.out.println(otpActionModel);

        // Get the otp format
        String otpFormat = otpActionModel.getOtpFormat().name();
        // Get the duration
        Integer duration = otpActionModel.getDuration();
        // Get methods
        Set<Method> methods = otpActionModel.getAuthorizedMethods();

        //
        OTPFormat numeric = OTPFormat.SHORT_NUMERIC_CODE;
        OTPFormat alpha = OTPFormat.SHORT_ALPHA_CODE;
        OTPFormat alphanumeric = OTPFormat.SHORT_ALPHANUMERIC_CODE;
        OTPFormat token = OTPFormat.FULL_TOKEN;

        // Generate the otp code wrt the otp format
        OTPGenerator otpGenerator = new OTPGenerator();

        //
        BuildCreateOtpCodeInputDTO buildCreateOtpCodeInputDTO = new BuildCreateOtpCodeInputDTO();

        if (otpFormat == numeric.name()) {
            buildCreateOtpCodeInputDTO.setValue(otpGenerator.generateNumericCode(6));
            buildCreateOtpCodeInputDTO.setExpiresAt(getExpiryTime(duration));
            buildCreateOtpCodeInputDTO.setMethods(methods);
            // buildCreateOtpCodeInputDTO.setAttempts();
            // buildCreateOtpCodeInputDTO.setMessages();
            // buildCreateOtpCodeInputDTO.setRecipient();
            // buildCreateOtpCodeInputDTO.setInvalid();
            // buildCreateOtpCodeInputDTO.setOtpActionId();
            // buildCreateOtpCodeInputDTO.setUserId();
        }

        
        // Set the otp code fields

        OtpCodeModel otpCodeModel = otpCodeRepositoryPort.save(MAPPER.map(otpCodeInputDTO));
        OtpCodeOutputDTO outputDTO = MAPPER.map(otpCodeModel);

        CreateOtpCodeOutputDTO createOtpCodeOutputDTO = new CreateOtpCodeOutputDTO();
        createOtpCodeOutputDTO.setData(outputDTO);

        long endTime = System.currentTimeMillis();

        createOtpCodeOutputDTO.setElapsedTime(BigDecimal.valueOf(endTime - startTime));

        return createOtpCodeOutputDTO;
    }

    public OffsetDateTime getExpiryTime(Integer duration) throws IllegalArgumentException {
        if (duration <= 0) {
            throw new IllegalArgumentException("Duration must be positive");
        }
    
        // Get the current time
        LocalDateTime now = LocalDateTime.now();
        // Add seconds
        LocalDateTime later = now.plusSeconds((long) duration);
        // Format to ISO 8601 with UTC timezone (Z)
        DateTimeFormatter formatter = DateTimeFormatter.ISO_OFFSET_DATE_TIME;

        return OffsetDateTime.parse(formatter.format(later), formatter);
    }
}
