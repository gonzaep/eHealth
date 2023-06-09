package eu.epsos.pt.cc;

import epsos.openncp.protocolterminator.clientconnector.*;
import eu.europa.ec.sante.ehdsi.constant.assertion.AssertionEnum;
import org.opensaml.saml.saml2.core.Assertion;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tr.com.srdc.epsos.data.model.PatientDemographics.Gender;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

public class ClientConnectorServiceSkeletonMock implements ClientConnectorServiceSkeletonInterface {

    private static final String LOG_FORMAT_RESPONSE = "Response (Mock):\n{}";
    private static final String LOG_FORMAT_REQUEST = "\tRequest:\n{}";
    private static final String COUNTRY = "ME";
    private static final String HOME_COMMUNITY_ID = "2.16.17.710.811.1000.990.1";
    private static final String MOCKED_CDA_XML_AS_STRING = "<ClinicalDocument classCode=\"DOCCLIN\" moodCode=\"EVN\" xmlns=\"urn:hl7-org:v3\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n  <typeId root=\"2.16.840.1.113883.1.3\" extension=\"POCD_HD000040\"/>\n  <templateId root=\"1.3.6.1.4.1.12559.11.10.1.3.1.1.1\"/>\n  <id root=\"1.2.752.129.2.1.2.1\" extension=\"3.199592267\"/>\n  <code codeSystemName=\"LOINC\" codeSystem=\"2.16.840.1.113883.6.1\" code=\"57833-6\" displayName=\"ePrescription\"/>\n  <title>L\u00e4kemedel uth\u00e4mtat utomlandsRenitec\u00ae</title>\n  <effectiveTime value=\"20120319\"/>\n  <confidentialityCode displayName=\"normal\" code=\"N\" codeSystem=\"2.16.840.1.113883.5.25\" codeSystemName=\"Confidentiality\"/>\n  <languageCode code=\"sv-SE\"/>\n  <recordTarget typeCode=\"RCT\" contextControlCode=\"OP\">\n    <patientRole classCode=\"PAT\">\n      <id root=\"1.2.752.129.2.1.3.1\" extension=\"199701312390\"/>\n      <addr>\n        <streetAddressLine nullFlavor=\"UNK\"/>\n        <city nullFlavor=\"UNK\"/>\n        <postalCode nullFlavor=\"UNK\"/>\n        <country>SE</country>\n      </addr>\n      <telecom nullFlavor=\"NI\"/>\n      <patient classCode=\"PSN\" determinerCode=\"INSTANCE\">\n        <name>\n          <family>Ohlsson</family>\n          <given>Pasi</given>\n        </name>\n        <administrativeGenderCode code=\"M\" codeSystem=\"2.16.840.1.113883.5.1\" displayName=\"Male\" codeSystemName=\"AdministrativeGender\"/>\n        <birthTime value=\"19970131\"/>\n      </patient>\n    </patientRole>\n  </recordTarget>\n  <author typeCode=\"AUT\" contextControlCode=\"OP\">\n    <functionCode codeSystem=\"2.16.840.1.113883.2.9.6.2.7\" code=\"221\" displayName=\"Medical doctors\" codeSystemName=\"ISCO\">\n      <translation code=\"LAK\" displayName=\"LAK\" codeSystem=\"1.2.752.180.1.1\" codeSystemName=\"RR\"/>\n    </functionCode>\n    <time value=\"20120319\"/>\n    <assignedAuthor classCode=\"ASSIGNED\">\n      <id root=\"1.2.752.129.2.1.2.1\" extension=\"2.9000027\"/>\n      <telecom value=\"tel:+46111-1111111\" use=\"WP\"/>\n      <assignedPerson classCode=\"PSN\" determinerCode=\"INSTANCE\">\n        <name>\n          <family>L\u00e4kare</family>\n          <given>Lars</given>\n        </name>\n      </assignedPerson>\n      <representedOrganization classCode=\"ORG\" determinerCode=\"INSTANCE\">\n        <id root=\"1.2.752.129.2.1.2.1\" extension=\"2.4000000000001\"/>\n        <name nullFlavor=\"UNK\"/>\n        <addr>\n          <streetAddressLine>V\u00e5rdcentralen TC</streetAddressLine>\n          <city>Storstaden</city>\n          <postalCode>12345</postalCode>\n          <country>SE</country>\n        </addr>\n      </representedOrganization>\n    </assignedAuthor>\n  </author>\n  <custodian typeCode=\"CST\">\n    <assignedCustodian classCode=\"ASSIGNED\">\n      <representedCustodianOrganization classCode=\"ORG\" determinerCode=\"INSTANCE\">\n        <id extension=\"12345678\" root=\"1.2.752.129.2.1.4.1\"/>\n        <name>Apotekens Service AB</name>\n        <telecom value=\"tel:+4610-4586200\" use=\"WP\"/>\n        <addr>\n          <streetAddressLine>Ringv\u00e4gen 100</streetAddressLine>\n          <city>Stockholm</city>\n          <postalCode>118 60</postalCode>\n          <country>SE</country>\n        </addr>\n      </representedCustodianOrganization>\n    </assignedCustodian>\n  </custodian>\n  <legalAuthenticator typeCode=\"LA\">\n    <time value=\"20120319\"/>\n    <signatureCode code=\"S\"/>\n    <assignedEntity classCode=\"ASSIGNED\">\n      <id extension=\"12345678\" root=\"1.2.752.129.2.1.4.1\"/>\n      <assignedPerson classCode=\"PSN\" determinerCode=\"INSTANCE\">\n        <name nullFlavor=\"NI\"/>\n      </assignedPerson>\n      <representedOrganization classCode=\"ORG\" determinerCode=\"INSTANCE\">\n        <id extension=\"12345678\" root=\"1.2.752.129.2.1.4.1\"/>\n        <name>Apotekens Service AB</name>\n        <telecom value=\"tel:+4610-4586200\" use=\"WP\"/>\n        <addr>\n          <streetAddressLine>Ringv\u00e4gen 100</streetAddressLine>\n          <city>Stockholm</city>\n          <postalCode>11860</postalCode>\n          <country>SE</country>\n        </addr>\n      </representedOrganization>\n    </assignedEntity>\n  </legalAuthenticator>\n  <!--The relationship to the National document/data should to be recorded in the epSOS friendly-->\n  <relatedDocument typeCode=\"XFRM\">\n    <parentDocument>\n      <id root=\"1.2.752.129.2.1.2.1\" extension=\"3.199592267\"/>\n    </parentDocument>\n  </relatedDocument>\n  <component>\n    <structuredBody>\n      <component>\n        <section>\n          <templateId root=\"1.3.6.1.4.1.12559.11.10.1.3.1.2.1\"/>\n          <id root=\"1.2.752.129.2.1.2.1\" extension=\"3.199592267\"/>\n          <code code=\"57828-6\" codeSystem=\"2.16.840.1.113883.6.1\" codeSystemName=\"LOINC\" displayName=\"Prescriptions\"/>\n          <title>Renitec\u00ae</title>\n          <text>\n            <content ID=\"medication1\">\n              L\u00c4KEMEDELSNAMN: Renitec\u00ae\n              <br/>\n              KVALITATIV OCH KVANTITATIV SAMMANS\u00c4TTNING: Renitec tabl 10mg MSD\n              <br/>\n              <content ID=\"p0\">459099</content>\n              L\u00c4KEMEDELSFORM: Tablett\n              <br/>\n              DOSERING OCH ADMINISTRATION:\n              <br/>\n              <content ID=\"pc0\">En tablett morgon och kv\u00e4ll</content>\n              <content ID=\"d0\"/>\n              <br/>\n              \u00d6VRIGA UPPLYSNINGAR:\n              <br/>\n              <content ID=\"fc0\">EPSOS GARETH 2012-03-19</content>\n            </content>\n          </text>\n          <entry>\n            <templateId root=\"1.3.6.1.4.1.12559.11.10.1.3.1.3.4\"/>\n            <substanceAdministration classCode=\"SBADM\" moodCode=\"INT\">\n              <templateId root=\"2.16.840.1.113883.10.20.1.24\"/>\n              <templateId root=\"1.3.6.1.4.1.12559.11.10.1.3.1.3.2\"/>\n              <id root=\"1.2.752.129.2.1.2.1\" extension=\"3.199592267\"/>\n              <text>\n                <reference value=\"#medication1\"/>\n              </text>\n              <statusCode code=\"active\"/>\n              <effectiveTime xsi:type=\"IVL_TS\">\n                <low value=\"20120319\"/>\n                <high value=\"20130319\"/>\n              </effectiveTime>\n              <effectiveTime xsi:type=\"PIVL_TS\" nullFlavor=\"UNK\"/>\n              <doseQuantity nullFlavor=\"UNK\"/>\n              <consumable>\n                <manufacturedProduct classCode=\"MANU\" xmlns:epsos=\"urn:epsos-org:ep:medication\">\n                  <templateId root=\"1.3.6.1.4.1.19376.1.5.3.1.4.7.2\"/>\n                  <templateId root=\"2.16.840.1.113883.10.20.1.53\"/>\n                  <manufacturedMaterial classCode=\"MMAT\" determinerCode=\"KIND\">\n                    <templateId root=\"1.3.6.1.4.1.12559.11.10.1.3.1.3.1\"/>\n                    <code code=\"459099\" displayName=\"Renitec\u00ae\" codeSystem=\"1.2.752.129.2.1.5.1\" codeSystemName=\"Nordisk Produktkod\">\n                      <originalText>\n                        <reference value=\"#p0\"/>\n                      </originalText>\n                    </code>\n                    <name>Renitec\u00ae</name>\n                    <epsos:formCode code=\"10219000\" displayName=\"Tablet\" codeSystem=\"1.3.6.1.4.1.12559.11.10.1.3.1.44.1\" codeSystemName=\"EDQM\">\n                      <epsos:translation code=\"TABLET\" displayName=\"Tablett\" codeSystem=\"1.2.752.180.1.1\" codeSystemName=\"RR\"/>\n                    </epsos:formCode>\n                    <epsos:asContent classCode=\"CONT\">\n                      <epsos:containerPackagedMedicine classCode=\"CONT\" determinerCode=\"INSTANCE\">\n                        <epsos:name>Renitec tabl 10mg MSD</epsos:name>\n                        <epsos:formCode nullFlavor=\"NI\"/>\n                        <!--epsos:formCode code=\"\" displayName=\"\" codeSystem=\"1.3.6.1.4.1.12559.11.10.1.3.1.44.1\" codeSystemName=\"EDQM\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t<epsos:translation code=\"\" displayName=\"\" codeSystem=\"1.2.752.180.1.1\" codeSystemName=\"RR\"/>\n\t\t\t\t\t\t\t\t\t\t\t\t</epsos:formCode-->\n                        <epsos:capacityQuantity value=\"98\" unit=\"1\"/>\n                      </epsos:containerPackagedMedicine>\n                    </epsos:asContent>\n                    <epsos:ingredient classCode=\"ACTI\">\n                      <epsos:quantity>\n                        <epsos:numerator value=\"10.0\" unit=\"mg\" xsi:type=\"epsos:PQ\"/>\n                        <epsos:denominator value=\"1\" unit=\"1\" xsi:type=\"epsos:PQ\"/>\n                      </epsos:quantity>\n                      <epsos:ingredient classCode=\"MMAT\" determinerCode=\"KIND\">\n                        <epsos:code code=\"C09AA02\" displayName=\"enalapril\" codeSystem=\"2.16.840.1.113883.6.73\" codeSystemName=\"Anatomical Therapeutic Chemical\">\n                          <epsos:translation code=\"C09AA02\" displayName=\"Enalapril\" codeSystem=\"2.16.840.1.113883.6.73\" codeSystemName=\"ATC\"/>\n                        </epsos:code>\n                        <epsos:name>Enalapril</epsos:name>\n                      </epsos:ingredient>\n                    </epsos:ingredient>\n                  </manufacturedMaterial>\n                </manufacturedProduct>\n              </consumable>\n              <entryRelationship typeCode=\"COMP\">\n                <supply classCode=\"SPLY\" moodCode=\"RQO\">\n                  <independentInd value=\"false\"/>\n                  <quantity value=\"3\" unit=\"1\"/>\n                </supply>\n              </entryRelationship>\n              <entryRelationship typeCode=\"SUBJ\" inversionInd=\"true\">\n                <act classCode=\"ACT\" moodCode=\"INT\">\n                  <templateId root=\"2.16.840.1.113883.10.20.1.49\"/>\n                  <templateId root=\"1.3.6.1.4.1.19376.1.5.3.1.4.3\"/>\n                  <code code=\"PINSTRUCT\" codeSystem=\"1.3.5.1.4.1.19376.1.5.3.2\" codeSystemName=\"IHEActCode\"/>\n                  <text>\n                    <reference value=\"#pc0\"/>\n                  </text>\n                  <statusCode code=\"completed\"/>\n                </act>\n              </entryRelationship>\n              <entryRelationship typeCode=\"SUBJ\" inversionInd=\"true\">\n                <act classCode=\"ACT\" moodCode=\"INT\">\n                  <templateId root=\"2.16.840.1.113883.10.20.1.43\"/>\n                  <templateId root=\"1.3.6.1.4.1.19376.1.5.3.1.4.3.1\"/>\n                  <code code=\"FINSTRUCT\" codeSystem=\"1.3.5.1.4.1.19376.1.5.3.2\" codeSystemName=\"IHEActCode\"/>\n                  <text>\n                    <reference value=\"#fc0\"/>\n                  </text>\n                  <statusCode code=\"completed\"/>\n                </act>\n              </entryRelationship>\n              <entryRelationship typeCode=\"SUBJ\" inversionInd=\"true\">\n                <observation classCode=\"OBS\" moodCode=\"EVN\">\n                  <code code=\"SUBST\" codeSystem=\"2.16.840.1.113883.5.6\" codeSystemName=\"ActClass\"/>\n                  <value displayName=\"therapeutic\" code=\"TE\" xsi:type=\"CE\" codeSystem=\"2.16.840.1.113883.5.1070\" codeSystemName=\"substanceAdminSubstitution\"/>\n                </observation>\n              </entryRelationship>\n            </substanceAdministration>\n          </entry>\n        </section>\n      </component>\n    </structuredBody>\n  </component>\n</ClinicalDocument>";
    private final Logger logger = LoggerFactory.getLogger(ClientConnectorServiceSkeletonMock.class);
    private final List<PatientDemographics> patientsList = new ArrayList<>();
    private final List<EpsosDocument1> documentMetaDataList = new ArrayList<>();

    public ClientConnectorServiceSkeletonMock() {
        patientsList.add(createMockedPatient("Bilbo", "Baggins", "190012121234", Gender.MALE));
        patientsList.add(createMockedPatient("Frodo", "Baggins", "190001011234", Gender.MALE));
        documentMetaDataList.add(createMockedDocumentMetadata("bla", "57833-6", "urn:epsos:ep:pre:2010"));
    }

    private PatientDemographics createMockedPatient(String givenName, String familyName, String patient, Gender gender) {

        var patientDemographics = PatientDemographics.Factory.newInstance();
        patientDemographics.setGivenName(givenName);
        patientDemographics.setFamilyName(familyName);
        patientDemographics.setAdministrativeGender(gender.getValue());

        var calendar = Calendar.getInstance();
        calendar.set(Integer.parseInt(patient.substring(0, 4)), Integer.parseInt(patient.substring(4, 6)),
                Integer.parseInt(patient.substring(6, 8)));
        patientDemographics.setBirthDate(calendar);
        patientDemographics.setCountry(COUNTRY);
        patientDemographics.setCity("Shire");

        PatientId pId = PatientId.Factory.newInstance();
        pId.setRoot(HOME_COMMUNITY_ID);
        pId.setExtension(patient);
        var ids = new PatientId[1];
        ids[0] = pId;
        patientDemographics.setPatientIdArray(ids);

        return patientDemographics;
    }

    private EpsosDocument1 createMockedDocumentMetadata(String id, String classCodeString, String formatCodeString) {

        EpsosDocument1 documentMetaData = EpsosDocument1.Factory.newInstance();
        documentMetaData.setUuid(id);
        Author author = Author.Factory.newInstance();
        author.setPerson("R. R. Tolkien");
        documentMetaData.setAuthorsArray(new Author[]{author});
        documentMetaData.setDescription("Fantasy");
        documentMetaData.setTitle("The lord of the rings");
        GenericDocumentCode classCode = GenericDocumentCode.Factory.newInstance();
        classCode.setNodeRepresentation(classCodeString);
        documentMetaData.setClassCode(classCode);
        GenericDocumentCode formatCode = GenericDocumentCode.Factory.newInstance();
        formatCode.setNodeRepresentation(formatCodeString);
        documentMetaData.setFormatCode(formatCode);
        documentMetaData.setBase64Binary(MOCKED_CDA_XML_AS_STRING.getBytes());
        return documentMetaData;
    }

    @Override
    public QueryPatientResponseDocument queryPatient(QueryPatientDocument queryPatientRequest, Map<AssertionEnum, Assertion> assertionMap) {

        if (logger.isDebugEnabled()) {
            logger.debug("QueryPatientsMock():");
            logger.debug("\tAssertion:\n{}", assertionMap.get(AssertionEnum.CLINICIAN).toString());
            logger.debug(LOG_FORMAT_REQUEST, queryPatientRequest);
        }

        var queryPatientResponseDocument = QueryPatientResponseDocument.Factory.newInstance();
        var patientDemographicsRequest = queryPatientRequest.getQueryPatient().getArg0().getPatientDemographics();

        for (PatientDemographics patient : patientsList) {
            if (patientDemographicsRequest != null && patientDemographicsRequest.getPatientIdArray()[0].getExtension() != null
                    && patient.getPatientIdArray()[0].getExtension().equals(patientDemographicsRequest.getPatientIdArray()[0].getExtension())) {
                queryPatientResponseDocument.addNewQueryPatientResponse().addNewReturn().set(patient);
            }
        }
        if (queryPatientResponseDocument.getQueryPatientResponse() == null) {
            queryPatientResponseDocument.addNewQueryPatientResponse();
        }
        logger.debug(LOG_FORMAT_RESPONSE, queryPatientResponseDocument);
        return queryPatientResponseDocument;
    }

    @Override
    public QueryDocumentsResponseDocument queryDocuments(QueryDocumentsDocument queryDocuments, Map<AssertionEnum, Assertion> assertionMap) {

        if (logger.isDebugEnabled()) {
            logger.debug("QueryDocumentsMock()");
            logger.debug(LOG_FORMAT_REQUEST, queryDocuments);
        }
        var queryDocumentsResponseDocument = QueryDocumentsResponseDocument.Factory.newInstance();
        var patientId = queryDocuments.getQueryDocuments().getArg0().getPatientId();

        for (EpsosDocument1 doc : documentMetaDataList) {
            if (patientId != null && patientId.getExtension() != null && patientId.getRoot() != null) {
                queryDocumentsResponseDocument.addNewQueryDocumentsResponse().addNewReturn().set(doc);
            }
        }
        if (queryDocumentsResponseDocument.getQueryDocumentsResponse() == null) {
            queryDocumentsResponseDocument.addNewQueryDocumentsResponse();
        }
        logger.debug(LOG_FORMAT_RESPONSE, queryDocumentsResponseDocument);
        return queryDocumentsResponseDocument;
    }

    @Override
    public RetrieveDocumentResponseDocument retrieveDocument(RetrieveDocumentDocument1 retrieveDocument, Map<AssertionEnum, Assertion> assertionMap) {

        if (logger.isDebugEnabled()) {
            logger.debug("RetrieveDocumentMock():");
            logger.debug(LOG_FORMAT_REQUEST, retrieveDocument);
        }
        RetrieveDocumentResponseDocument retrieveDocumentResponse = RetrieveDocumentResponseDocument.Factory.newInstance();

        for (EpsosDocument1 doc : documentMetaDataList) {
            retrieveDocumentResponse.addNewRetrieveDocumentResponse().addNewReturn().set(doc);
        }
        logger.debug(LOG_FORMAT_RESPONSE, retrieveDocumentResponse);
        return retrieveDocumentResponse;
    }

    @Override
    public SubmitDocumentResponseDocument submitDocument(SubmitDocumentDocument1 submitDocument, Map<AssertionEnum, Assertion> assertionMap) {

        if (logger.isDebugEnabled()) {
            logger.debug("SubmitDocumentMock():");
            logger.debug(LOG_FORMAT_REQUEST, submitDocument);
        }
        throw new UnsupportedOperationException("Please implement " + this.getClass().getName() + "#submitDocumentMock");
    }

    @Override
    public SayHelloResponseDocument sayHello(SayHelloDocument sayHelloRequest) {

        if (logger.isDebugEnabled()) {
            logger.debug("SayHelloMock()");
            logger.debug(LOG_FORMAT_REQUEST, sayHelloRequest);
        }
        SayHelloResponseDocument sayHelloResponse = SayHelloResponseDocument.Factory.newInstance();
        sayHelloResponse.addNewSayHelloResponse().setReturn("Hi " + sayHelloRequest.getSayHello().getArg0());
        logger.debug(LOG_FORMAT_RESPONSE, sayHelloResponse);
        return sayHelloResponse;
    }
}
