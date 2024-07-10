package com.didi.quizapp.authentications.otp.app.otp_code_feature.consult_otp_code_details.api;

import java.util.UUID;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.didi.quizapp.authentications.otp.app.otp_code_feature.consult_otp_code_details.dto.ConsultOtpCodeDetailsResponseDTO;
import com.didi.quizapp.authentications.shared.dto.ResponseErrorDTO;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

public interface ConsultOtpCodeDetailsApi {

        /**
         * GET /iam/authentications/otp/otp-codes/{id} : Consult OtpCode Details
         * Consult the details of an OtpCode identified by it ID.
         *
         * @param id Unique identifier (UUID) of the otp code to fetch (required)
         * @return Returned when the otp code ID provided is found (status code 200)
         */
        @Operation(operationId = "consultOtpCodeDetails", summary = "Consult OtpCode Details", description = "Consult the details of an OtpCode identified by it ID.", tags = {
                        "ConsultOtpCodeDetails" }, responses = {
                                        @ApiResponse(responseCode = "200", description = "Returned when the otp code ID provided is found", content = {
                                                        @Content(mediaType = "application/json", schema = @Schema(implementation = ConsultOtpCodeDetailsResponseDTO.class))
                                        }),
                                        @ApiResponse(responseCode = "default", description = "Returned when an error occur", content = {
                                                        @Content(mediaType = "application/json", schema = @Schema(implementation = ResponseErrorDTO.class))
                                        })
                        })
        @RequestMapping(method = RequestMethod.GET, value = "/iam/authentications/otp/otp-codes/{id}", produces = {
                        "application/json" })

        ResponseEntity<ConsultOtpCodeDetailsResponseDTO> _consultOtpCodeDetails(
                        @Parameter(name = "id", description = "Unique identifier (UUID) of the otp code to fetch", required = true, in = ParameterIn.PATH) @PathVariable("id") UUID id);

}
