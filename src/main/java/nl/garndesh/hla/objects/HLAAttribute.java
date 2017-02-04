package nl.garndesh.hla.objects;

import nl.garndesh.hla.IField;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by christiaan on 2/3/17.
 */
@XmlRootElement(name = "attribute")
public class HLAAttribute implements IField {
    private String name;
    private String dataType;
    private String updateType;
    private String updateCondition;
    private String ownership;
    private String sharing;
    private String transportation;
    private String order;
    private String semantics;
    private String notes;

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
    public String getUpdateType() {
        return updateType;
    }

    public void setUpdateType(String updateType) {
        this.updateType = updateType;
    }

    @XmlAttribute
    public String getUpdateCondition() {
        return updateCondition;
    }

    public void setUpdateCondition(String updateCondition) {
        this.updateCondition = updateCondition;
    }

    @XmlAttribute
    public String getOwnership() {
        return ownership;
    }

    public void setOwnership(String ownership) {
        this.ownership = ownership;
    }

    @XmlAttribute
    public String getSharing() {
        return sharing;
    }

    public void setSharing(String sharing) {
        this.sharing = sharing;
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

    @XmlAttribute
    public String getSemantics() {
        return semantics;
    }

    public void setSemantics(String semantics) {
        this.semantics = semantics;
    }

    @XmlAttribute
    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
