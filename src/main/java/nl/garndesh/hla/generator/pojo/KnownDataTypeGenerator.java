package nl.garndesh.hla.generator.pojo;

import com.sun.codemodel.JCodeModel;
import com.sun.codemodel.JType;
import nl.garndesh.hla.generator.IGenerator;
import nl.garndesh.hla.generator.ModelContainer;

import java.util.Map;

/**
 * Created by christiaan on 2/4/17.
 */
public class KnownDataTypeGenerator implements IGenerator {

    @Override
    public void objectCreation(ModelContainer container) {
        Map<String, JType> knownTypes = container.getKnownTypes();
        JCodeModel model = container.getCodeModel();
        knownTypes.put("HLAboolean", model._ref(boolean.class));
        knownTypes.put("HLAbyte", model.BYTE);

        knownTypes.put("HLAoctet", model.BYTE);
        knownTypes.put("UnsignedChar", model.CHAR);
        knownTypes.put("SignedChar", model.BYTE);
        knownTypes.put("SignedByte", model.BYTE);
        knownTypes.put("UnsignedByte", model.BYTE);

        knownTypes.put("HLAoctetPairLE", model.SHORT);
        knownTypes.put("HLAinteger16LE", model.SHORT);
        knownTypes.put("HLAinteger16BE", model.SHORT);
        knownTypes.put("UInteger16LE", model.SHORT);
        knownTypes.put("UInteger16BE", model.SHORT);
        knownTypes.put("UnsignedShort", model.SHORT);

        knownTypes.put("HLAinteger32LE", model.INT);
        knownTypes.put("HLAinteger32BE", model.INT);
        knownTypes.put("UInteger32LE", model.INT);
        knownTypes.put("UInteger32BE", model.INT);
        knownTypes.put("HLAfloat32LE", model.FLOAT);
        knownTypes.put("HLAfloat32BE", model.FLOAT);

        knownTypes.put("HLAinteger64LE", model.LONG);
        knownTypes.put("HLAinteger64BE", model.LONG);
        knownTypes.put("UInteger64LE", model.LONG);
        knownTypes.put("UInteger64BE", model.LONG);
        knownTypes.put("HLAfloat64LE", model.DOUBLE);
        knownTypes.put("HLAfloat64BE", model.DOUBLE);
    }

    @Override
    public void typeListing(ModelContainer container) {

    }

    @Override
    public void fieldCreation(ModelContainer container) {

    }
}
