package com.didi.quizapp.authentications.otp.core.otp_code_feature.consult_otp_code_list.handler;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.didi.quizapp.authentications.otp.core.otp_code_feature.consult_otp_code_list.dto.ConsultOtpCodeListOutputDTO;
import com.didi.quizapp.authentications.otp.core.otp_code_feature.consult_otp_code_list.usecase.ConsultOtpCodeListUseCase;
import com.didi.quizapp.authentications.otp.core.otp_code_feature.shared.dto.OtpCodeOutputDTO;
import com.didi.quizapp.authentications.otp.core.otp_code_feature.shared.mapper.OtpCodeCoreMapper;
import com.didi.quizapp.authentications.otp.core.otp_code_feature.shared.mapper.OtpCodeCoreMapperImpl;
import com.didi.quizapp.authentications.otp.core.otp_code_feature.shared.model.OtpCodeModel;
import com.didi.quizapp.authentications.otp.core.otp_code_feature.shared.repository.OtpCodeRepositoryPort;
import com.didi.quizapp.authentications.shared.dto.MetaDataDTO;
import com.didi.quizapp.authentications.shared.utils.Utils;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ConsultOtpCodeListHandler implements ConsultOtpCodeListUseCase {

    @Autowired
    private OtpCodeRepositoryPort otpCodeRepositoryPort;

    @Override
    public ConsultOtpCodeListOutputDTO consultOtpCodeList(Integer page, Integer size) {
        //
        long startTime = System.currentTimeMillis();

        System.out.println("Page: " + page + ", Size: " + size);

        // OtpCodeModel
        Pageable pageable = PageRequest.of(page - 1, size);

        System.out.println("PAGEABLE :: " + pageable);

        // List<OtpCodeModel> codes = otpCodeRepositoryPort.findAll();

        Page<OtpCodeModel> otpCodeModelPage = otpCodeRepositoryPort.findAll(pageable);

        System.out.println("PAGE :: " + otpCodeModelPage);

        // Meta data
        MetaDataDTO metaDataDTO = Utils.setMetaDataFromEntityPage(otpCodeModelPage);

        ConsultOtpCodeListOutputDTO consultOtpCodeListOutputDTO = new ConsultOtpCodeListOutputDTO();

        consultOtpCodeListOutputDTO.setMetaData(metaDataDTO);

        // Data
        OtpCodeCoreMapper MAPPER = new OtpCodeCoreMapperImpl();
        List<OtpCodeOutputDTO> otpCodeOutputDTOs = MAPPER.map(otpCodeModelPage.getContent());

        consultOtpCodeListOutputDTO.setData(otpCodeOutputDTOs);

        //
        long endTime = System.currentTimeMillis();

        consultOtpCodeListOutputDTO.setElapsedTime(BigDecimal.valueOf(endTime - startTime));

        // Output DTO
        return consultOtpCodeListOutputDTO;
    }

}
