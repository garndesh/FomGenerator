package nl.garndesh.hla.dataTypes;

import nl.garndesh.hla.IClass;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Created by christiaan on 2/3/17.
 */
@XmlRootElement(name = "enumeratedData")
public class HLAEnum implements IClass {

    private String name;
    private String representation;
    private String semantics;
    private List<Enumerator> enumerators;

    @XmlAttribute
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlAttribute
    public String getRepresentation() {
        return representation;
    }

    public void setRepresentation(String representation) {
        this.representation = representation;
    }

    @XmlAttribute
    public String getSemantics() {
        return semantics;
    }

    public void setSemantics(String semantics) {
        this.semantics = semantics;
    }

    @XmlElement(name = "enumerator")
    public List<Enumerator> getEnumerators() {
        return enumerators;
    }

    public void setEnumerators(List<Enumerator> enumerators) {
        this.enumerators = enumerators;
    }

    public static class Enumerator {
        private String name;
        private String values;
        private String semantics;

        @XmlAttribute
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @XmlAttribute
        public String getValues() {
            return values;
        }

        public void setValues(String values) {
            this.values = values;
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
