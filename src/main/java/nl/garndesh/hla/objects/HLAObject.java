package nl.garndesh.hla.objects;

import nl.garndesh.hla.IClass;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Created by christiaan on 2/3/17.
 *
 */

@XmlRootElement(name = "objectClass", namespace = "http://standards.ieee.org/IEEE1516-2010")
public class HLAObject implements IClass {

    private String name;
    private String sharing;
    private String semantics;
    private List<HLAAttribute> attributes;
    private List<HLAObject> objects;

    @XmlAttribute
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlAttribute
    public String getSharing() {
        return sharing;
    }

    public void setSharing(String sharing) {
        this.sharing = sharing;
    }

    @XmlAttribute
    public String getSemantics() {
        return semantics;
    }

    public void setSemantics(String semantics) {
        this.semantics = semantics;
    }

    @XmlElement(name = "attribute")
    public List<HLAAttribute> getAttributes() {
        return attributes;
    }

    public void setAttributes(List<HLAAttribute> attributes) {
        this.attributes = attributes;
    }

    @XmlElement(name = "objectClass")
    public List<HLAObject> getObjects() {
        return objects;
    }

    public void setObjects(List<HLAObject> objects) {
        this.objects = objects;
    }
}
