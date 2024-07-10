package com.didi.quizapp.authentications.otp.app.otp_action_feature.consult_otp_action_details.api;

import java.util.UUID;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.didi.quizapp.authentications.otp.app.otp_action_feature.consult_otp_action_details.dto.ConsultOtpActionDetailsResponseDTO;
import com.didi.quizapp.authentications.shared.dto.ResponseErrorDTO;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

public interface ConsultOtpActionDetailsApi {

        /**
         * GET /iam/authentications/otp/otp-actions/{id} : Consult OtpAction
         * Details
         * Consult the details of a OtpAction identified by it ID.
         *
         * @param id Unique identifier (UUID) of the otp action to fetch (required)
         * @return Returned when the otp action ID provided is found (status code 200)
         */
        @Operation(operationId = "consultOtpActionDetails", summary = "Consult OtpAction Details", description = "Consult the details of a OtpAction identified by it ID.", tags = {
                        "ConsultOtpActionDetails" }, responses = {
                                        @ApiResponse(responseCode = "200", description = "Returned when the otp action ID provided is found", content = {
                                                        @Content(mediaType = "application/json", schema = @Schema(implementation = ConsultOtpActionDetailsResponseDTO.class))
                                        }),
                                        @ApiResponse(responseCode = "default", description = "Returned when an error occur", content = {
                                                        @Content(mediaType = "application/json", schema = @Schema(implementation = ResponseErrorDTO.class))
                                        })
                        })
        @RequestMapping(
                method = RequestMethod.GET, 
                value = "/iam/authentications/otp/otp-actions/{id}", 
                produces = { "application/json" }
        )

        ResponseEntity<ConsultOtpActionDetailsResponseDTO> _consultOtpActionDetails(
                @Parameter(name = "id", description = "Unique identifier (UUID) of the otp action to fetch", required = true, in = ParameterIn.PATH) 
                @PathVariable("id") UUID id);

}
