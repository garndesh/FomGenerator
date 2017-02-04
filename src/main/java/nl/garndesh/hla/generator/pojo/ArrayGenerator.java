package nl.garndesh.hla.generator.pojo;

import com.sun.codemodel.*;
import nl.garndesh.hla.dataTypes.HLAArrayData;
import nl.garndesh.hla.generator.IGenerator;
import nl.garndesh.hla.generator.ModelContainer;

import java.util.List;
import java.util.Map;

/**
 * Created by christiaan on 2/3/17.
 */
public class ArrayGenerator implements IGenerator {


    private JCodeModel codeModel;
    private Map<String, JType> knownTypes;
    private JType stringType;

    @Override
    public void objectCreation(ModelContainer container) {

    }

    @Override
    public void typeListing(ModelContainer container) {
        this.codeModel = container.getCodeModel();
        this.knownTypes = container.getKnownTypes();
        stringType = container.getCodeModel().ref(String.class);
        List<HLAArrayData> arrays = container.getModel().getDataTypes().getArrayDataTypes();
        arrays.forEach(this::solveArrayData);
    }

    @Override
    public void fieldCreation(ModelContainer container) {

    }

    private void solveArrayData(HLAArrayData hlaArrayData){
        String dataType = hlaArrayData.getDataType();
        String name = hlaArrayData.getName();
        if("HLAASCIIchar".equals(dataType) || "HLAunicodeChar".equals(dataType)){
            //Array contains chars, should be a string.
            knownTypes.put(name, stringType);
        } else {
            JType type = knownTypes.get(dataType);
            if(type!=null){
                knownTypes.put(name, codeModel.ref(List.class).narrow(type));
            }
        }
    }
}
