package com.didi.quizapp.authentications.otp.app.otp_code_feature.send_otp_code.api;

import com.didi.quizapp.authentications.otp.app.otp_code_feature.send_otp_code.dto.CreateOtpCodeRequestDTO;
import com.didi.quizapp.authentications.otp.app.otp_code_feature.send_otp_code.dto.CreateOtpCodeResponseDTO;
import com.didi.quizapp.authentications.shared.dto.ResponseErrorDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
// import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

// import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

@Validated
@Tag(name = "CreateOtpCode", description = "Endpoint feature to create an OTP code")
public interface SendOtpCodeApi {

        /**
         * POST iam/authentications/otp/send-code/otp-codes : Create an OTP code
         * As system runner, I can create an OTP code
         *
         * @param createOtpCodeRequestDTO OtpCode payload for creation operation
         *                                (required)
         * @return This response is return when operation succeeded (status code 201)
         */
        @Operation(operationId = "createOtpCode", summary = "Create an OTP code", description = "As system runner, I can create an OTP code", tags = {
                        "CreateOtpCode" }, responses = {
                                        @ApiResponse(responseCode = "201", description = "This response is return when operation succeeded", content = {
                                                        @Content(mediaType = "application/json", schema = @Schema(implementation = CreateOtpCodeResponseDTO.class))
                                        }),
                                        @ApiResponse(responseCode = "default", description = "Returned when an error occurs", content = {
                                                        @Content(mediaType = "application/json", schema = @Schema(implementation = ResponseErrorDTO.class))
                                        })
                        })
        @RequestMapping(
                method = RequestMethod.POST, 
                value = "iam/authentications/otp/send-code/otp-codes", 
                produces = { "application/json" }, 
                consumes = { "application/json" }
        )

        ResponseEntity<CreateOtpCodeResponseDTO> _createOtpCode(
                @Valid 
                @RequestBody 
                @Parameter(name = "createOtpCodeRequestDTO", description = "OtpCode payload for creation operation", required = true) 
                CreateOtpCodeRequestDTO createOtpCodeRequestDTO
        );

}
