package com.syed.ATIMobiles.service

import com.syed.ATIMobiles.model.FaultCodeModel
import com.syed.ATIMobiles.repository.DiagnosticsRepository
import org.springframework.stereotype.Service

@Service
class DiagnosticsService(
    val diagnosticsRepository: DiagnosticsRepository
) {


    fun getFaultCodes(
    ) = diagnosticsRepository.getFaultCodes()

    fun getFaultCode(
        vinNumber: String?
    ) = diagnosticsRepository.getFaultCodeByVin(vinNumber)

    fun addFaultCode(faultCodeModel: FaultCodeModel): String?{
       return diagnosticsRepository.addFaultCode(faultCodeModel)
    }

    fun updateFaultCode(faultCodeModel: FaultCodeModel): FaultCodeModel {
        return diagnosticsRepository.updateFaultCode(faultCodeModel)
    }

    fun deleteFaultCode(faultCodeId: String) {
        diagnosticsRepository.deleteFaultCode(faultCodeId)
    }
}