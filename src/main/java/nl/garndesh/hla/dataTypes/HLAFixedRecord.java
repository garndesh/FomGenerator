package nl.garndesh.hla.dataTypes;

import nl.garndesh.hla.IClass;
import nl.garndesh.hla.IField;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Created by christiaan on 2/3/17.
 */
@XmlRootElement(name = "fixedRecordData")
public class HLAFixedRecord implements IClass {

    private String name;
    private String encoding;
    private String semantics;
    private List<Field> fields;

    @XmlAttribute
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    @XmlAttribute

    public String getEncoding() {
        return encoding;
    }

    public void setEncoding(String encoding) {
        this.encoding = encoding;
    }

    @XmlAttribute
    public String getSemantics() {
        return semantics;
    }

    public void setSemantics(String semantics) {
        this.semantics = semantics;
    }

    @XmlElement(name = "field")
    public List<Field> getFields() {
        return fields;
    }

    public void setFields(List<Field> fields) {
        this.fields = fields;
    }

    public static class Field implements IField {
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
}
