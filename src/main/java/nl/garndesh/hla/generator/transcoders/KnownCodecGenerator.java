package nl.garndesh.hla.generator.transcoders;

import com.sun.codemodel.JCodeModel;
import com.sun.codemodel.JType;
import hla.rti1516e.jlc.*;
import nl.garndesh.hla.generator.IGenerator;
import nl.garndesh.hla.generator.ModelContainer;

import java.util.Map;

/**
 * Created by christiaan on 2/4/17.
 */
public class KnownCodecGenerator implements IGenerator {


    @Override
    public void objectCreation(ModelContainer container) {
        Map<String, JType> knownCodecs = container.getKnownCodecs();
        JCodeModel model = container.getCodeModel();
        knownCodecs.put("HLAoctet", model.ref(BasicHLAoctetImpl.class));
        //knownCodecs.put("UnsignedChar", model.ref(HLAASCIIcharImpl.class));
        knownCodecs.put("SignedChar", model.ref(HLAASCIIcharImpl.class));
        knownCodecs.put("SignedByte", model.ref(BasicHLAbyteImpl.class));
        //knownCodecs.put("UnsignedByte", model.BYTE);

        knownCodecs.put("HLAoctetPairLE", model.ref(BasicHLAoctetPairLEImpl.class));
        knownCodecs.put("HLAinteger16LE", model.ref(BasicHLAinteger16LEImpl.class));
        knownCodecs.put("HLAinteger16BE", model.ref(BasicHLAinteger16BEImpl.class));
        //knownCodecs.put("UInteger16LE", model.ref(BasicHLAin.class));
        //knownCodecs.put("UInteger16BE", model.SHORT);
        //knownCodecs.put("UnsignedShort", model.SHORT);

        knownCodecs.put("HLAinteger32LE", model.ref(BasicHLAinteger32LEImpl.class));
        knownCodecs.put("HLAinteger32BE", model.ref(BasicHLAinteger32BEImpl.class));
        //knownCodecs.put("UInteger32LE", model.INT);
        //knownCodecs.put("UInteger32BE", model.INT);
        knownCodecs.put("HLAfloat32LE", model.ref(BasicHLAfloat32LEImpl.class));
        knownCodecs.put("HLAfloat32BE", model.ref(BasicHLAfloat32BEImpl.class));

        knownCodecs.put("HLAinteger64LE", model.ref(BasicHLAinteger64LEImpl.class));
        knownCodecs.put("HLAinteger64BE", model.ref(BasicHLAinteger64BEImpl.class));
        //knownCodecs.put("UInteger64LE", model.LONG);
        //knownCodecs.put("UInteger64BE", model.LONG);
        knownCodecs.put("HLAfloat64LE", model.ref(BasicHLAfloat64LEImpl.class));
        knownCodecs.put("HLAfloat64BE", model.ref(BasicHLAfloat64BEImpl.class));


        knownCodecs.put("HLAASCIIstring", model.ref(HLAASCIIstringImpl.class));
        knownCodecs.put("HLAunicodeString", model.ref(HLAunicodeStringImpl.class));
        knownCodecs.put("HLAboolean", model.ref(HLAbooleanImpl.class));

        knownCodecs.put("HLAASCIIchar", model.ref(HLAASCIIcharImpl.class));
        knownCodecs.put("HLAunicodeChar", model.ref(HLAunicodeCharImpl.class));

        knownCodecs.put("HLAbyte", model.ref(HLAunicodeCharImpl.class));

        knownCodecs.put("HLAvariableArray", model.ref(HLAvariableArrayImpl.class));
        knownCodecs.put("HLAfixedArray", model.ref(HLAfixedArrayImpl.class));
    }

    @Override
    public void typeListing(ModelContainer container) {

    }

    @Override
    public void fieldCreation(ModelContainer container) {

    }
}
