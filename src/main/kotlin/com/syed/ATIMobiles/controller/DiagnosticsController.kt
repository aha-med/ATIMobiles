package com.syed.ATIMobiles.controller

import com.syed.ATIMobiles.model.FaultCodeModel
import com.syed.ATIMobiles.service.DiagnosticsService
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/Diagnostics")
class DiagnosticsController(
    val diagnosticsService: DiagnosticsService
) {

    @GetMapping("/faultCodes")
    fun getFaultCodes() = diagnosticsService.getFaultCodes()

    @GetMapping("/faul  tCode/{vinNumber}")
    fun getFaultCode(@PathVariable(required = false) vinNumber: String?) = diagnosticsService.getFaultCode(vinNumber)

    @PostMapping
    fun addFaultCode(
        @Valid @RequestBody faultCodeModel: FaultCodeModel
    ): ResponseEntity<FaultCodeModel> {
        diagnosticsService.addFaultCode(faultCodeModel)
        return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(faultCodeModel)
    }

    @PutMapping
    fun updateFaultCode(
        @RequestBody faultCodeModel: FaultCodeModel
    ): FaultCodeModel {
        return diagnosticsService.updateFaultCode(faultCodeModel)
    }

    @DeleteMapping("/{faultCodeId}")
    fun deleteFaultCode(
        @PathVariable faultCodeId: String
    ) {
        diagnosticsService.deleteFaultCode(faultCodeId)
    }
}