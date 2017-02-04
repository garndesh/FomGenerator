package nl.garndesh.hla.objects;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by christiaan on 2/3/17.
 */
@XmlRootElement(name = "objects")
public class HLAObjects {

    private HLAObject rootObject;

    @XmlElement(name = "objectClass")
    public HLAObject getRootObject() {
        return rootObject;
    }

    public void setRootObject(HLAObject rootObject) {
        this.rootObject = rootObject;
    }
}
