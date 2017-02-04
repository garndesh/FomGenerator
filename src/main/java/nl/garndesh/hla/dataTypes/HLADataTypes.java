package nl.garndesh.hla.dataTypes;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Created by christiaan on 2/3/17.
 */
@XmlRootElement(name = "dataTypes")
public class HLADataTypes {

    private List<HLASimpleData> simpleDataTypes;
    private List<HLAArrayData> arrayDataTypes;
    private List<HLAFixedRecord> fixedRecordDataTypes;
    private List<HLAVariantRecord> variantRecordDataTypes;
    private List<HLAEnum> enumeratedDataTypes;


    @XmlElementWrapper
    @XmlElement(name = "simpleData")
    public List<HLASimpleData> getSimpleDataTypes() {
        return simpleDataTypes;
    }

    public void setSimpleDataTypes(List<HLASimpleData> simpleDataTypes) {
        this.simpleDataTypes = simpleDataTypes;
    }

    @XmlElementWrapper
    @XmlElement(name = "arrayData")
    public List<HLAArrayData> getArrayDataTypes() {
        return arrayDataTypes;
    }

    public void setArrayDataTypes(List<HLAArrayData> arrayDataTypes) {
        this.arrayDataTypes = arrayDataTypes;
    }

    @XmlElementWrapper
    @XmlElement(name = "fixedRecordData")
    public List<HLAFixedRecord> getFixedRecordDataTypes() {
        return fixedRecordDataTypes;
    }

    public void setFixedRecordDataTypes(List<HLAFixedRecord> fixedRecordDataTypes) {
        this.fixedRecordDataTypes = fixedRecordDataTypes;
    }

    @XmlElementWrapper
    @XmlElement(name = "variantRecordData")
    public List<HLAVariantRecord> getVariantRecordDataTypes() {
        return variantRecordDataTypes;
    }

    public void setVariantRecordDataTypes(List<HLAVariantRecord> variantRecordDataTypes) {
        this.variantRecordDataTypes = variantRecordDataTypes;
    }

    @XmlElementWrapper
    @XmlElement(name = "enumeratedData")
    public List<HLAEnum> getEnumeratedDataTypes() {
        return enumeratedDataTypes;
    }

    public void setEnumeratedDataTypes(List<HLAEnum> enumerators) {
        this.enumeratedDataTypes = enumerators;
    }
}
