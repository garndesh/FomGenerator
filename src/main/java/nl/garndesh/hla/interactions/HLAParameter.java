package nl.garndesh.hla.interactions;

import nl.garndesh.hla.IField;

import javax.xml.bind.annotation.XmlAttribute;

/**
 * Created by christiaan on 2/3/17.
 */
public class HLAParameter implements IField {

    private String name;
    private String dataType;
    private String semantics;

    @XmlAttribute
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlAttribute
    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    @XmlAttribute
    public String getSemantics() {
        return semantics;
    }

    public void setSemantics(String semantics) {
        this.semantics = semantics;
    }
}
