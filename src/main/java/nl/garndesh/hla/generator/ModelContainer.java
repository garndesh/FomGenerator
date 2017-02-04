package nl.garndesh.hla.generator;

import com.sun.codemodel.JCodeModel;
import com.sun.codemodel.JDefinedClass;
import com.sun.codemodel.JType;
import nl.garndesh.hla.HLAObjectModel;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by christiaan on 2/3/17.
 */
public class ModelContainer {

    private JCodeModel codeModel;
    private HLAObjectModel model;
    private Map<String, JDefinedClass> classes = new HashMap<>();
    private Map<String, JType> knownTypes = new HashMap<>();
    private Map<String, JType> knownCodecs = new HashMap<>();

    public JCodeModel getCodeModel() {
        return codeModel;
    }

    public void setCodeModel(JCodeModel codeModel) {
        this.codeModel = codeModel;
    }

    public HLAObjectModel getModel() {
        return model;
    }

    public void setModel(HLAObjectModel model) {
        this.model = model;
    }

    public Map<String, JDefinedClass> getClasses() {
        return classes;
    }

    public void setClasses(Map<String, JDefinedClass> classes) {
        this.classes = classes;
    }

    public Map<String, JType> getKnownTypes() {
        return knownTypes;
    }

    public void setKnownTypes(Map<String, JType> knownTypes) {
        this.knownTypes = knownTypes;
    }

    public Map<String, JType> getKnownCodecs() {
        return knownCodecs;
    }

    public void setKnownCodecs(Map<String, JType> knownCodecs) {
        this.knownCodecs = knownCodecs;
    }
}
