package com.didi.quizapp.authentications.otp.infra.otp_action_feature.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import com.didi.quizapp.authentications.otp.core.otp_action_feature.shared.model.OtpActionModel;
import com.didi.quizapp.authentications.otp.core.otp_action_feature.shared.repository.OtpActionRepositoryPort;
import com.didi.quizapp.authentications.otp.infra.otp_action_feature.entity.OtpActionEntity;
// import com.didi.quizapp.authentications.otp.infra.otp_action_feature.entity.parser.OtpActionJsonParser;
import com.didi.quizapp.authentications.otp.infra.otp_action_feature.mapper.OtpActionInfraMapper;
import com.didi.quizapp.authentications.otp.infra.shared.enums.Method;
import com.didi.quizapp.authentications.otp.infra.shared.enums.OTPFormat;
import com.didi.quizapp.authentications.otp.infra.shared.enums.OTPType;
import com.didi.quizapp.authentications.shared.utils.converters.GenericMapConverter;

import jakarta.validation.constraints.NotNull;

@Repository
public class OtpActionRepositoryAdapter implements OtpActionRepositoryPort {

    @Autowired
    private OtpActionRepository otpActionRepository;

    @Override
    public OtpActionModel saveAndFlush(OtpActionModel entity) {
        return OtpActionInfraMapper.INSTANCE.map(
                otpActionRepository.saveAndFlush(
                        OtpActionInfraMapper.INSTANCE.map(entity)));
    }

    @Override
    public OtpActionModel getById(UUID uuid) {
        return OtpActionInfraMapper.INSTANCE.map(otpActionRepository.getReferenceById(uuid));
    }

    @Override
    public OtpActionModel save(OtpActionModel entity) {
        // String updatedJson = OtpActionJsonParser.serializeOtpActionToJson(entity);

        System.out.println(entity);

        OtpActionEntity innerMapper = OtpActionInfraMapper.INSTANCE.map(entity);

        OtpActionEntity action = otpActionRepository.save(innerMapper);
        OtpActionModel outerMapper = OtpActionInfraMapper.INSTANCE.map(action);
        return outerMapper;
    }

    @Override
    public Optional<OtpActionModel> findById(@NotNull UUID uuid) { 
        // return Optional.of(OtpActionInfraMapper.INSTANCE.map(
        //     otpActionRepository.findById(uuid).get()
        // ));

        OtpActionEntity actionEntity = otpActionRepository.findById(uuid).get();
        OtpActionModel actionModel = OtpActionInfraMapper.INSTANCE.map(actionEntity);
        return Optional.of(actionModel);
    }

    @Override
    public boolean existsById(UUID uuid) {
        return otpActionRepository.existsById(uuid);
    }

    @Override
    public List<OtpActionModel> findAll() {
        return OtpActionInfraMapper.INSTANCE._map(otpActionRepository.findAll());
    }

    @Override
    public long count() {
        return otpActionRepository.count();
    }

    @Override
    public void delete(OtpActionModel model) {
        otpActionRepository.delete(OtpActionInfraMapper.INSTANCE.map(model));
    }

    @Override
    public void deleteById(UUID uuid) {
        otpActionRepository.deleteById(uuid);
    }

    // @Override
    // public Page<OtpActionModel> findAl(Pageable pageable) {
    //     Page<OtpActionEntity> otpActionEntityPage = otpActionRepository.findAll(pageable);

    //     List<OtpActionModel> otpActionModels = OtpActionInfraMapper.INSTANCE._map(otpActionEntityPage.getContent());

    //     return new PageImpl<>(otpActionModels, pageable, count());
    // }

    @Override
    public Page<OtpActionModel> findAll(Pageable pageable) {
        Page<OtpActionEntity> otpActionEntityPage = otpActionRepository.findAll(pageable);

        // List to store converted models
        List<OtpActionModel> otpActionModels = new ArrayList<>();

        // Loop through each entity in the page
        for (OtpActionEntity entity : otpActionEntityPage.getContent()) {
            OtpActionModel model = new OtpActionModel();

            Map<Method, Object> s = entity.getTemplates();
            System.out.println(s);

            GenericMapConverter<Method, Object> mc = new GenericMapConverter<Method, Object>();
            // mc.convertToEntityAttribute(entity.getTemplates());

            // model.setId(entity.getId());
            // Convert string enums to actual enums (assuming relevant fields exist in models)
            model.setOtpType(convertStringOtpTypeEnum(entity.getOtpType().name()));
            model.setOtpFormat(convertStringOtpFormatEnum(entity.getOtpFormat().name()));
            model.setAuthorizedMethods(entity.getAuthorizedMethods());
            model.setDuration(entity.getDuration());
            model.setTemplates(entity.getTemplates());
            // model.setMaxAttempts(entity.getMaxAttempts());

            otpActionModels.add(model);
        }

        // List<OtpActionModel> otpActionModels = OtpActionInfraMapper.INSTANCE._map(otpActionEntityPage.getContent());

        System.out.println(otpActionModels);

        return new PageImpl<>(otpActionModels, pageable, count());
    }

    // Helper method for conversion (replace 'StringEnum' with your actual enum type)
    private OTPType convertStringOtpTypeEnum(String s) {
        return OTPType.valueOf(s);
    }

    private OTPFormat convertStringOtpFormatEnum(String s) {
        return OTPFormat.valueOf(s);
    }

    // @Override
    // public Page<OtpActionModel> findByUserId(Pageable pageable, UUID userId) {
    //     Page<OtpActionEntity> otpActionEntityPage = otpActionRepository.findByUserId(pageable, userId);

    //     List<OtpActionModel> otpActionModels = OtpActionInfraMapper.INSTANCE._map(otpActionEntityPage.getContent());

    //     return new PageImpl<>(otpActionModels, pageable, count());
    // }
}
