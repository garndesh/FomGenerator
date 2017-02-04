package nl.garndesh.hla.interactions;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by christiaan on 2/3/17.
 */
@XmlRootElement(name = "interactions")
public class HLAInteractions {

    private HLAInteraction rootObject;

    @XmlElement(name = "interactionClass")
    public HLAInteraction getRootObject() {
        return rootObject;
    }

    public void setRootObject(HLAInteraction rootObject) {
        this.rootObject = rootObject;
    }
}
