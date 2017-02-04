package nl.garndesh.hla;

import nl.garndesh.hla.dataTypes.HLADataTypes;
import nl.garndesh.hla.interactions.HLAInteractions;
import nl.garndesh.hla.objects.HLAObjects;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by christiaan on 2/3/17.
 */
@XmlRootElement(name = "objectModel")
public class HLAObjectModel {

    private HLAObjects objects;
    private HLAInteractions interactions;
    private HLADataTypes dataTypes;

    public HLAObjects getObjects() {
        return objects;
    }

    public void setObjects(HLAObjects objects) {
        this.objects = objects;
    }

    public HLADataTypes getDataTypes() {
        return dataTypes;
    }

    public void setDataTypes(HLADataTypes dataTypes) {
        this.dataTypes = dataTypes;
    }

    public HLAInteractions getInteractions() {
        return interactions;
    }

    public void setInteractions(HLAInteractions interactions) {
        this.interactions = interactions;
    }
}
