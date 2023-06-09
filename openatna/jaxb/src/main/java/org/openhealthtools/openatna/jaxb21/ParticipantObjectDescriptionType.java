package org.openhealthtools.openatna.jaxb21;

import javax.xml.bind.annotation.*;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/**
 * @deprecated ParticipantObjectDescriptionType is not used for ATNA based on RFC 3881, it would be used by DICOM objects.
 * <p>Java class for ParticipantObjectDescriptionType complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="ParticipantObjectDescriptionType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="MPPS" maxOccurs="unbounded" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;attribute name="UID" type="{}OID" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="Accession" maxOccurs="unbounded" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;attribute name="Number" type="{http://www.w3.org/2001/XMLSchema}string" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="SOPClass" maxOccurs="unbounded" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="Instance" maxOccurs="unbounded" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;attribute name="UID" use="required" type="{}OID" />
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *                 &lt;attribute name="UID" type="{}OID" />
 *                 &lt;attribute name="NumberOfInstances" type="{http://www.w3.org/2001/XMLSchema}integer" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ParticipantObjectDescriptionType", propOrder = {
        "mpps",
        "accession",
        "sopClass"
})
@Deprecated
public class ParticipantObjectDescriptionType {

    @XmlElement(name = "MPPS")
    protected List<ParticipantObjectDescriptionType.MPPS> mpps;
    @XmlElement(name = "Accession")
    protected List<ParticipantObjectDescriptionType.Accession> accession;
    @XmlElement(name = "SOPClass")
    protected List<ParticipantObjectDescriptionType.SOPClass> sopClass;

    /**
     * Gets the value of the mpps property.
     * <p/>
     * <p/>
     * This accessor method returns a reference to the live list, not a snapshot.
     * Therefore any modification you make to the returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the mpps property.
     * <p/>
     * <p/>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getMPPS().add(newItem);
     * </pre>
     * <p/>
     * <p/>
     * <p/>
     * Objects of the following type(s) are allowed in the list
     * {@link ParticipantObjectDescriptionType.MPPS }
     */
    public List<ParticipantObjectDescriptionType.MPPS> getMPPS() {
        if (mpps == null) {
            mpps = new ArrayList<>();
        }
        return this.mpps;
    }

    /**
     * Gets the value of the accession property.
     * <p/>
     * <p/>
     * This accessor method returns a reference to the live list, not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the accession property.
     * <p/>
     * <p/>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAccession().add(newItem);
     * </pre>
     * <p/>
     * <p/>
     * <p/>
     * Objects of the following type(s) are allowed in the list
     * {@link ParticipantObjectDescriptionType.Accession }
     */
    public List<ParticipantObjectDescriptionType.Accession> getAccession() {
        if (accession == null) {
            accession = new ArrayList<>();
        }
        return this.accession;
    }

    /**
     * Gets the value of the sopClass property.
     * <p/>
     * <p/>
     * This accessor method returns a reference to the live list, not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the sopClass property.
     * <p/>
     * <p/>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSOPClass().add(newItem);
     * </pre>
     * <p/>
     * <p/>
     * <p/>
     * Objects of the following type(s) are allowed in the list
     * {@link ParticipantObjectDescriptionType.SOPClass }
     */
    public List<ParticipantObjectDescriptionType.SOPClass> getSOPClass() {
        if (sopClass == null) {
            sopClass = new ArrayList<>();
        }
        return this.sopClass;
    }

    /**
     * <p>Java class for anonymous complex type.
     * <p/>
     * <p>The following schema fragment specifies the expected content contained within this class.
     * <p/>
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;attribute name="Number" type="{http://www.w3.org/2001/XMLSchema}string" />
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class Accession {

        @XmlAttribute(name = "Number")
        protected String number;

        /**
         * Gets the value of the number property.
         *
         * @return possible object is
         * {@link String }
         */
        public String getNumber() {
            return number;
        }

        /**
         * Sets the value of the number property.
         *
         * @param value allowed object is
         *              {@link String }
         */
        public void setNumber(String value) {
            this.number = value;
        }

    }

    /**
     * <p>Java class for anonymous complex type.
     * <p/>
     * <p>The following schema fragment specifies the expected content contained within this class.
     * <p/>
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;attribute name="UID" type="{}OID" />
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class MPPS {

        @XmlAttribute(name = "UID")
        protected String uid;

        /**
         * Gets the value of the uid property.
         *
         * @return possible object is
         * {@link String }
         */
        public String getUID() {
            return uid;
        }

        /**
         * Sets the value of the uid property.
         *
         * @param value allowed object is
         *              {@link String }
         */
        public void setUID(String value) {
            this.uid = value;
        }

    }

    /**
     * <p>Java class for anonymous complex type.
     * <p/>
     * <p>The following schema fragment specifies the expected content contained within this class.
     * <p/>
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="Instance" maxOccurs="unbounded" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;attribute name="UID" use="required" type="{}OID" />
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *       &lt;/sequence>
     *       &lt;attribute name="UID" type="{}OID" />
     *       &lt;attribute name="NumberOfInstances" type="{http://www.w3.org/2001/XMLSchema}integer" />
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
            "instance"
    })
    public static class SOPClass {

        @XmlElement(name = "Instance")
        protected List<ParticipantObjectDescriptionType.SOPClass.Instance> instance;
        @XmlAttribute(name = "UID")
        protected String uid;
        @XmlAttribute(name = "NumberOfInstances")
        protected BigInteger numberOfInstances;

        /**
         * Gets the value of the instance property.
         * <p/>
         * <p/>
         * This accessor method returns a reference to the live list, not a snapshot.
         * Therefore any modification you make to the returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the instance property.
         * <p/>
         * <p/>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getInstance().add(newItem);
         * </pre>
         * <p/>
         * <p/>
         * <p/>
         * Objects of the following type(s) are allowed in the list
         * {@link ParticipantObjectDescriptionType.SOPClass.Instance }
         */
        public List<ParticipantObjectDescriptionType.SOPClass.Instance> getInstance() {
            if (instance == null) {
                instance = new ArrayList<>();
            }
            return this.instance;
        }

        /**
         * Gets the value of the uid property.
         *
         * @return possible object is
         * {@link String }
         */
        public String getUID() {
            return uid;
        }

        /**
         * Sets the value of the uid property.
         *
         * @param value allowed object is
         *              {@link String }
         */
        public void setUID(String value) {
            this.uid = value;
        }

        /**
         * Gets the value of the numberOfInstances property.
         *
         * @return possible object is
         * {@link BigInteger }
         */
        public BigInteger getNumberOfInstances() {
            return numberOfInstances;
        }

        /**
         * Sets the value of the numberOfInstances property.
         *
         * @param value allowed object is
         *              {@link BigInteger }
         */
        public void setNumberOfInstances(BigInteger value) {
            this.numberOfInstances = value;
        }

        /**
         * <p>Java class for anonymous complex type.
         * <p/>
         * <p>The following schema fragment specifies the expected content contained within this class.
         * <p/>
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *       &lt;attribute name="UID" use="required" type="{}OID" />
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "")
        public static class Instance {

            @XmlAttribute(name = "UID", required = true)
            protected String uid;

            /**
             * Gets the value of the uid property.
             *
             * @return possible object is
             * {@link String }
             */
            public String getUID() {
                return uid;
            }

            /**
             * Sets the value of the uid property.
             *
             * @param value allowed object is
             *              {@link String }
             */
            public void setUID(String value) {
                this.uid = value;
            }
        }
    }
}
