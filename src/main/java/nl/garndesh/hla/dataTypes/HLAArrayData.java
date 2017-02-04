package nl.garndesh.hla.dataTypes;

import nl.garndesh.hla.IField;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by christiaan on 2/3/17.
 */
@XmlRootElement(name = "arrayData")
public class HLAArrayData implements IField {

    private String name;
    private String dataType;
    private String cardinality;
    private String encoding;
    private String semantics;

    public String getName() {
        return name;
    }

    @XmlAttribute
    public void setName(String name) {
        this.name = name;
    }

    public String getDataType() {
        return dataType;
    }

    @XmlAttribute
    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    public String getCardinality() {
        return cardinality;
    }

    @XmlAttribute
    public void setCardinality(String cardinality) {
        this.cardinality = cardinality;
    }

    public String getEncoding() {
        return encoding;
    }

    @XmlAttribute
    public void setEncoding(String encoding) {
        this.encoding = encoding;
    }

    public String getSemantics() {
        return semantics;
    }

    @XmlAttribute
    public void setSemantics(String semantics) {
        this.semantics = semantics;
    }
}
