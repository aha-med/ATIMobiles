package com.syed.ATIMobiles.repository

import com.syed.ATIMobiles.model.FaultCodeModel
import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Repository
import org.springframework.web.server.ResponseStatusException

@Repository
class DiagnosticsRepository {
    val logger = LoggerFactory.getLogger(DiagnosticsRepository::class.java)

    val allFaultCodes : MutableList<FaultCodeModel> = mutableListOf(
        FaultCodeModel(
            id = "1",
            code = "P021",
            name = "Front Type Pressure",
        ),
        FaultCodeModel(
            id = "2",
            code = "P022",
            name = "Rear Type Pressure",
        ),
        FaultCodeModel(
            id = "3",
            code = "P023",
            name = "Head Unit",
        ),
        FaultCodeModel(
            id = "4",
            code = "P024",
            name = "BCM",
        ),
        FaultCodeModel(
            id = "5",
            code = "P025",
            name = "MCU",
        ),
        FaultCodeModel(
            id = "6",
            code = "P026",
            name = "VCU",
        ),
    )

    fun getFaultCodes(): List<FaultCodeModel>{
        return allFaultCodes
    }

    fun getFaultCodeByVin(vin: String?): FaultCodeModel?{
        val faultCode = allFaultCodes.find { it.id == vin }
        logger.info("current FaultCode : ${faultCode}")
        if (faultCode != null){
          return faultCode
        } else {
            throw ResponseStatusException(HttpStatus.NOT_FOUND)
        }
    }

    fun addFaultCode(faultCode : FaultCodeModel): String?{
        allFaultCodes.add(faultCode)
        return "Fault Code Added.. : ${faultCode}"
    }

    fun updateFaultCode(faultCodeModel: FaultCodeModel): FaultCodeModel {
        val indexOfFaultCode = allFaultCodes.indexOfFirst { faultCode -> faultCodeModel.id == faultCode.id }
        allFaultCodes[indexOfFaultCode] = faultCodeModel
        return faultCodeModel
    }

    fun deleteFaultCode(faultCodeId: String) {
        val faultCodeToDelete = allFaultCodes.find { it.id == faultCodeId }

        if (faultCodeToDelete != null){
            allFaultCodes.remove(faultCodeToDelete)
        } else {
            throw ResponseStatusException(HttpStatus.NOT_FOUND)
        }
    }
}