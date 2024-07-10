package com.didi.quizapp.authentications.otp.core.otp_action_feature.consult_otp_action_list.handler;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.didi.quizapp.authentications.otp.core.otp_action_feature.consult_otp_action_list.dto.ConsultOtpActionListOutputDTO;
import com.didi.quizapp.authentications.otp.core.otp_action_feature.consult_otp_action_list.usecase.ConsultOtpActionListUseCase;
import com.didi.quizapp.authentications.otp.core.otp_action_feature.shared.dto.OtpActionOutputDTO;
import com.didi.quizapp.authentications.otp.core.otp_action_feature.shared.mapper.OtpActionCoreMapper;
import com.didi.quizapp.authentications.otp.core.otp_action_feature.shared.mapper.OtpActionCoreMapperImpl;
import com.didi.quizapp.authentications.otp.core.otp_action_feature.shared.model.OtpActionModel;
import com.didi.quizapp.authentications.otp.core.otp_action_feature.shared.repository.OtpActionRepositoryPort;
import com.didi.quizapp.authentications.shared.dto.MetaDataDTO;
import com.didi.quizapp.authentications.shared.utils.Utils;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ConsultOtpActionListHandler implements ConsultOtpActionListUseCase {

    @Autowired
    private OtpActionRepositoryPort otpActionRepositoryPort;

    @Override
    public ConsultOtpActionListOutputDTO consultOtpActionList(Integer page, Integer size) {
        //
        long startTime = System.currentTimeMillis();

        System.out.println("Page: " + page + ", Size: " + size);

        // OtpActionModel
        Pageable pageable = PageRequest.of(page - 1, size);

        System.out.println("PAGEABLE :: " + pageable);

        // List<OtpActionModel> actions = otpActionRepositoryPort.findAll();

        Page<OtpActionModel> otpActionModelPage = otpActionRepositoryPort.findAll(pageable);

        System.out.println("PAGE :: " + otpActionModelPage);

        // Meta data
        MetaDataDTO metaDataDTO = Utils.setMetaDataFromEntityPage(otpActionModelPage);

        ConsultOtpActionListOutputDTO consultOtpActionListOutputDTO = new ConsultOtpActionListOutputDTO();

        consultOtpActionListOutputDTO.setMetaData(metaDataDTO);

        // Data
        OtpActionCoreMapper MAPPER = new OtpActionCoreMapperImpl();
        List<OtpActionOutputDTO> otpActionOutputDTOs = MAPPER._map(otpActionModelPage.getContent());

        consultOtpActionListOutputDTO.setData(otpActionOutputDTOs);

        //
        long endTime = System.currentTimeMillis();

        consultOtpActionListOutputDTO.setElapsedTime(BigDecimal.valueOf(endTime - startTime));

        // Output DTO
        return consultOtpActionListOutputDTO;
    }

}
