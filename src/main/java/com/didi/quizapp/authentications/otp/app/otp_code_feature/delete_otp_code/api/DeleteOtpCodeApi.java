package com.didi.quizapp.authentications.otp.app.otp_code_feature.delete_otp_code.api;

import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.didi.quizapp.authentications.shared.dto.ResponseErrorDTO;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@Validated
@Tag(name = "DeleteOtpCode", description = "Endpoint to delete an OTP code")
public interface DeleteOtpCodeApi {

        /**
         * DELETE /iam/authentications/otp/otp-codes/{id} : Delete OtpCode Details
         * Delete the details of an OtpCode identified by its ID.
         *
         * @param id Unique identifier (UUID) of the otp code to delete (required)
         * @return This response is returned when operation succeeded (status code 204)
         */
        @Operation(operationId = "DeleteOtpCode", summary = "Delete OtpCode Details", description = "Delete the details of an OtpCode identified by it ID.", tags = {
                        "OtpCode" }, responses = {
                                        @ApiResponse(responseCode = "204", description = "This response is returned when operation succeeded"),
                                        // @ApiResponse(responseCode = "400", description = "Bad Request - Invalid
                                        // request, likely due to invalid id format"),
                                        // @ApiResponse(responseCode = "401", description = "Unauthorized - User is not
                                        // authorized to delete OTP codes"),
                                        // @ApiResponse(responseCode = "403", description = "Forbidden - User authorized
                                        // but lacks permission to delete this specific OTP code"),
                                        // @ApiResponse(responseCode = "404", description = "Not Found - OTP code with
                                        // the provided ID does not exist"),
                                        // @ApiResponse(responseCode = "409", description = "Conflict - There is a
                                        // conflict preventing deletion (e.g., OTP code still in use)"),
                                        // @ApiResponse(responseCode = "500", description = "Internal Server Error -
                                        // Unexpected server error during deletion"),
                                        @ApiResponse(responseCode = "default", description = "Returned when an error occurs", content = {
                                                        @Content(mediaType = "application/json", schema = @Schema(implementation = ResponseErrorDTO.class))
                                        })
                        })
        @RequestMapping(method = RequestMethod.DELETE, value = "/iam/authentications/otp/otp-codes/{id}", produces = {
                        "application/json" })

        ResponseEntity<String> _deleteOtpCodeDetails(
                        @Parameter(name = "id", description = "Unique identifier (UUID) of the otp code to delete", required = true, in = ParameterIn.PATH) @PathVariable("id") UUID id);

}
