package eu.epsos.protocolterminators.ws.server.xcpd;

import tr.com.srdc.epsos.data.model.PatientDemographics;

public interface PatientSearchInterfaceWithDemographics extends PatientSearchInterface {

    /**
     * Sets patient demographics for NI
     */
    void setPatientDemographics(PatientDemographics pd);
}
