package nl.garndesh.hla.generator.pojo;

import com.sun.codemodel.JType;
import nl.garndesh.hla.dataTypes.HLASimpleData;
import nl.garndesh.hla.generator.IGenerator;
import nl.garndesh.hla.generator.ModelContainer;

import java.util.*;

/**
 * Created by christiaan on 2/3/17.
 */
public class SimpleDataTypesGenerator implements IGenerator {

    private Map<String, String> simpleTypes = new HashMap<>();

    @Override
    public void objectCreation(ModelContainer container) {
        List<HLASimpleData> simpleDataList = container.getModel().getDataTypes().getSimpleDataTypes();
        for (HLASimpleData dataType : simpleDataList) {
            simpleTypes.put(dataType.getName(), dataType.getRepresentation());
        }
    }

    @Override
    public void typeListing(ModelContainer container) {
        int loop = 0;
        Iterator<String> iterator = simpleTypes.keySet().iterator();
        while (!simpleTypes.isEmpty() && loop++<5 ){
            iterator.forEachRemaining(type -> {
                JType representation = container.getKnownTypes().get(simpleTypes.get(type));
                if(representation!=null){
                    container.getKnownTypes().put(type, representation);
                    iterator.remove();
                }
            });
        }
    }

    @Override
    public void fieldCreation(ModelContainer container) {

    }
}
