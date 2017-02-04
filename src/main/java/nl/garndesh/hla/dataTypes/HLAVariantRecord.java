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
@XmlRootElement(name = "variantRecordData")
public class HLAVariantRecord implements IClass {

    private String name;
    private String discriminant;
    private String dataType;
    private String encoding;
    private String semantics;
    private List<Alternative> alternatives;

    @XmlAttribute
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlAttribute
    public String getDiscriminant() {
        return discriminant;
    }

    public void setDiscriminant(String discriminant) {
        this.discriminant = discriminant;
    }

    @XmlAttribute
    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
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

    @XmlElement(name = "alternative")
    public List<Alternative> getAlternatives() {
        return alternatives;
    }

    public void setAlternatives(List<Alternative> alternatives) {
        this.alternatives = alternatives;
    }

    public static class Alternative implements IField {
        private String enumerator;
        private String name;
        private String dataType;
        private String semantics;

        @XmlAttribute
        public String getEnumerator() {
            return enumerator;
        }

        public void setEnumerator(String enumerator) {
            this.enumerator = enumerator;
        }

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
