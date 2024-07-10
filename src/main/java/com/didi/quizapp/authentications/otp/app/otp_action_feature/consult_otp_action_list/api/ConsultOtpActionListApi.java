package com.didi.quizapp.authentications.otp.app.otp_action_feature.consult_otp_action_list.api;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.didi.quizapp.authentications.otp.app.otp_action_feature.consult_otp_action_list.dto.ConsultOtpActionListResponseDTO;
import com.didi.quizapp.authentications.shared.dto.ResponseErrorDTO;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

@Validated
@Tag(name = "ConsultOtpActionList", description = "Endpoint feature to consult otp actions list")
public interface ConsultOtpActionListApi {

    /**
     * GET /iam/authentications/otp/otp-actions : Consult OtpAction List
     * Consult the list of otp actions paginated.
     *
     * @param page The page number (optional, default to 1)
     * @param size The page size (optional, default to 10)
     * @return Returned when everything works well (status code 200)
     */
    @Operation(
        operationId = "consultOtpActionList",
        summary = "Consult OtpAction List",
        description = "Consult the list of otp actions paginated.",
        tags = { "ConsultOtpActionList" },
        responses = {
            @ApiResponse(responseCode = "200", description = "Returned when everything works well", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = ConsultOtpActionListResponseDTO.class))
            }),
            @ApiResponse(responseCode = "default", description = "Returned when an error occur", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = ResponseErrorDTO.class))
            })
        }
    )
    @RequestMapping(
        method = RequestMethod.GET,
        value = "/iam/authentications/otp/otp-actions",
        produces = { "application/json" }
    )
    
    ResponseEntity<ConsultOtpActionListResponseDTO> _consultOtpActionList(
        @Min(1) @Parameter(name = "page", description = "The page number", in = ParameterIn.QUERY) @Valid @RequestParam(value = "page", required = false, defaultValue = "1") Integer page,
        @Min(1) @Max(100) @Parameter(name = "size", description = "The page size", in = ParameterIn.QUERY) @Valid @RequestParam(value = "size", required = false, defaultValue = "10") Integer size
    );

}
