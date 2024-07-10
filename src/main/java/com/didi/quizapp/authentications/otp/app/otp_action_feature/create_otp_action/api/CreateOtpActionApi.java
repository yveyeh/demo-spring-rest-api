package com.didi.quizapp.authentications.otp.app.otp_action_feature.create_otp_action.api;

import com.didi.quizapp.authentications.otp.app.otp_action_feature.create_otp_action.dto.CreateOtpActionRequestDTO;
import com.didi.quizapp.authentications.otp.app.otp_action_feature.create_otp_action.dto.CreateOtpActionResponseDTO;
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
@Tag(name = "CreateOtpAction", description = "Endpoint feature to create an OTP action")
public interface CreateOtpActionApi {

    /**
     * POST iam/authentications/otp/otp-actions : Create an OTP action
     * As system runner, I can create an OTP action
     *
     * @param createOtpActionRequestDTO OtpAction payload for creation operation (required)
     * @return This response is return when operation succeeded (status code 201)
     *         or Returned when an error occur (status code 200)
     */
    @Operation(
        operationId = "createOtpAction",
        summary = "Create an OTP action",
        description = "As system runner, I can create an OTP action",
        tags = { "CreateOtpAction" },
        responses = {
            @ApiResponse(responseCode = "201", description = "This response is return when operation succeeded", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = CreateOtpActionResponseDTO.class))
            }),
            @ApiResponse(responseCode = "default", description = "Returned when an error occurs", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = ResponseErrorDTO.class))
            })
        }
    )
    @RequestMapping(
        method = RequestMethod.POST,
        value = "iam/authentications/otp/otp-actions",
        produces = { "application/json" },
        consumes = { "application/json" }
    )
    
    ResponseEntity<CreateOtpActionResponseDTO> _createOtpAction(
        @Valid 
        @RequestBody 
        @Parameter(name = "createOtpActionRequestDTO", description = "OtpAction payload for creation operation", required = true) 
        CreateOtpActionRequestDTO createOtpActionRequestDTO
    );

}
