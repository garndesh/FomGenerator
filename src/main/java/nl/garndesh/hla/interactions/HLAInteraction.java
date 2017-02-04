package nl.garndesh.hla.interactions;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Created by christiaan on 2/3/17.
 */
@XmlRootElement(name = "interactionClass")
public class HLAInteraction {

    private List<HLAInteraction> interactions;
    private List<HLAParameter> parameters;
    private String name;
    private String sharing;
    private String dimensions;
    private String transportation;
    private String order;


    @XmlElement(name = "interactionClass")
    public List<HLAInteraction> getInteractions() {
        return interactions;
    }

    public void setInteractions(List<HLAInteraction> interactions) {
        this.interactions = interactions;
    }

    @XmlElement(name = "parameter")
    public List<HLAParameter> getParameters() {
        return parameters;
    }

    public void setParameters(List<HLAParameter> parameters) {
        this.parameters = parameters;
    }

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
    public String getDimensions() {
        return dimensions;
    }

    public void setDimensions(String dimensions) {
        this.dimensions = dimensions;
    }

    @XmlAttribute
    public String getTransportation() {
        return transportation;
    }

    public void setTransportation(String transportation) {
        this.transportation = transportation;
    }

    @XmlAttribute
    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }
}
