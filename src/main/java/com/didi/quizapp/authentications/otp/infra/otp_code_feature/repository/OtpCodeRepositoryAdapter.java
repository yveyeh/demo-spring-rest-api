package com.didi.quizapp.authentications.otp.infra.otp_code_feature.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import com.didi.quizapp.authentications.otp.core.otp_code_feature.shared.model.OtpCodeModel;
import com.didi.quizapp.authentications.otp.core.otp_code_feature.shared.repository.OtpCodeRepositoryPort;
import com.didi.quizapp.authentications.otp.infra.otp_code_feature.entity.OtpCodeEntity;
import com.didi.quizapp.authentications.otp.infra.otp_code_feature.mapper.OtpCodeInfraMapper;
import jakarta.validation.constraints.NotNull;

@Repository
public class OtpCodeRepositoryAdapter implements OtpCodeRepositoryPort {

    @Autowired
    private OtpCodeRepository otpCodeRepository;

    @Override
    public OtpCodeModel saveAndFlush(OtpCodeModel entity) {
        return OtpCodeInfraMapper.INSTANCE.map(
                otpCodeRepository.saveAndFlush(
                        OtpCodeInfraMapper.INSTANCE.map(entity)));
    }

    @Override
    public OtpCodeModel getById(UUID uuid) {
        return OtpCodeInfraMapper.INSTANCE.map(otpCodeRepository.getReferenceById(uuid));
    }

    @Override
    public OtpCodeModel save(OtpCodeModel entity) {
        // String updatedJson = OtpCodeJsonParser.serializeOtpCodeToJson(entity);

        System.out.println(entity);

        OtpCodeEntity innerMapper = OtpCodeInfraMapper.INSTANCE.map(entity);

        OtpCodeEntity code = otpCodeRepository.save(innerMapper);
        OtpCodeModel outerMapper = OtpCodeInfraMapper.INSTANCE.map(code);
        return outerMapper;
    }

    @Override
    public Optional<OtpCodeModel> findById(@NotNull UUID uuid) {
        // return Optional.of(OtpCodeInfraMapper.INSTANCE.map(
        // otpCodeRepository.findById(uuid).get()
        // ));

        OtpCodeEntity codeEntity = otpCodeRepository.findById(uuid).get();
        OtpCodeModel codeModel = OtpCodeInfraMapper.INSTANCE.map(codeEntity);
        return Optional.of(codeModel);
    }

    @Override
    public boolean existsById(UUID uuid) {
        return otpCodeRepository.existsById(uuid);
    }

    @Override
    public List<OtpCodeModel> findAll() {
        return OtpCodeInfraMapper.INSTANCE.map(otpCodeRepository.findAll());
    }

    @Override
    public long count() {
        return otpCodeRepository.count();
    }

    @Override
    public void delete(OtpCodeModel model) {
        otpCodeRepository.delete(OtpCodeInfraMapper.INSTANCE.map(model));
    }

    @Override
    public void deleteById(UUID uuid) {
        otpCodeRepository.deleteById(uuid);
    }

    @Override
    public Page<OtpCodeModel> findAll(Pageable pageable) {
        
        Page<OtpCodeEntity> otpCodeEntityPage = otpCodeRepository.findAll(pageable);

        List<OtpCodeModel> otpCodeModels = OtpCodeInfraMapper.INSTANCE.map(otpCodeEntityPage.getContent());

        return new PageImpl<>(otpCodeModels, pageable, count());
    }

    // @Override
    // public Page<OtpCodeModel> findByUserId(Pageable pageable, UUID userId) {
    // Page<OtpCodeEntity> otpCodeEntityPage =
    // otpCodeRepository.findByUserId(pageable, userId);

    // List<OtpCodeModel> otpCodeModels =
    // OtpCodeInfraMapper.INSTANCE.map(otpCodeEntityPage.getContent());

    // return new PageImpl<>(otpCodeModels, pageable, count());
    // }
}
