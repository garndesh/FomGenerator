package nl.garndesh.hla.utils;

import com.sun.codemodel.*;
import nl.garndesh.hla.IField;
import nl.garndesh.hla.generator.ModelContainer;

/**
 * Created by christiaan on 2/4/17.
 */
public class ClassCreationUtils {

    public void updateMaps(String name, JDefinedClass jClass, ModelContainer container) {
        container.getClasses().put(name, jClass);
        container.getKnownTypes().put(name, jClass);
    }

    public void fillField(IField field, JDefinedClass generatedClass, ModelContainer container){
        String dataType = field.getDataType();
        JType type = container.getKnownTypes().get(dataType);
        String name = field.getName();
        if(name.startsWith("Optional_")){
            name = name.substring(name.indexOf("_")+1);
            name = name.substring(0,1).toLowerCase() + name.substring(1);
        }
        if(type!=null && generatedClass!=null){
            //prevents creating double fields
            if(!generatedClass.fields().keySet().contains(name)){
                JFieldVar varField = generatedClass.field(JMod.PRIVATE, type, name);
                createGettersAndSetters(name, generatedClass, varField, container.getCodeModel());
            } else {
                System.out.println("Duplicate field found in: " + generatedClass.toString());
            }
        }
    }

    public void createGettersAndSetters(String name, JDefinedClass generatedClass, JFieldVar varField, JCodeModel codeModel){
        String capital = name.substring(0,1).toUpperCase() + name.substring(1);
        JMethod getVar = generatedClass.method(JMod.PUBLIC, varField.type(), "get"+capital);
        getVar.body()._return(varField);
        JMethod setVar = generatedClass.method(JMod.PUBLIC, codeModel.VOID, "set"+capital);
        setVar.param(varField.type(), varField.name());
        setVar.body().assign(JExpr._this().ref(varField.name()), JExpr.ref(varField.name()));
    }
}
