package com.didi.quizapp.authentications.otp.app.otp_code_feature.update_otp_code.api;

import com.didi.quizapp.authentications.otp.app.otp_code_feature.update_otp_code.dto.UpdateOtpCodeRequestDTO;
import com.didi.quizapp.authentications.otp.app.otp_code_feature.update_otp_code.dto.UpdateOtpCodeResponseDTO;
import com.didi.quizapp.authentications.shared.dto.ResponseErrorDTO;

import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.enums.ParameterIn;

import jakarta.validation.Valid;

@Validated
@Tag(name = "UpdateOtpCode", description = "Endpoint feature to update an otp code")
public interface UpdateOtpCodeApi {

        /**
         * PUT /iam/authentications/otp/otp-codes{id} : Update OTP Action Details
         * Update the details of an OTP Action identified by its ID.
         *
         * @param id                      Unique identifier (UUID) of the otp code to
         *                                update (required)
         * @param updateOtpCodeRequestDTO OtpCode payload for update information
         *                                (required)
         * @return This response is return when operation succeeded (status code 200)
         */
        @Operation(operationId = "updateOtpCodeDetails", summary = "Update OTP Action Details", description = "Update the details of an OTP Action identified by its ID.", tags = {
                        "UpdateOtpCode" }, responses = {
                                        @ApiResponse(responseCode = "200", description = "This response is returned when operation succeeded", content = {
                                                        @Content(mediaType = "application/json", schema = @Schema(implementation = UpdateOtpCodeResponseDTO.class))
                                        }),
                                        @ApiResponse(responseCode = "default", description = "Returned when an error occurs", content = {
                                                        @Content(mediaType = "application/json", schema = @Schema(implementation = ResponseErrorDTO.class))
                                        })
                        })
        @RequestMapping(method = RequestMethod.PUT, value = "/iam/authentications/otp/otp-codes{id}", produces = {
                        "application/json" }, consumes = { "application/json" })

        ResponseEntity<UpdateOtpCodeResponseDTO> _updateOtpCodeDetails(
                        @Parameter(name = "id", description = "Unique identifier (UUID) of the otp code to update", required = true, in = ParameterIn.PATH) @PathVariable("id") UUID id,
                        @Parameter(name = "updateOtpCodeRequestDTO", description = "OtpCode payload for update information", required = true) @Valid @RequestBody UpdateOtpCodeRequestDTO updateOtpCodeRequestDTO);

}
