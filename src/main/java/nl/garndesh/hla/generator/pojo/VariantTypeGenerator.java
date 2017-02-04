package nl.garndesh.hla.generator.pojo;

import com.sun.codemodel.*;
import nl.garndesh.hla.dataTypes.HLAVariantRecord;
import nl.garndesh.hla.generator.IGenerator;
import nl.garndesh.hla.generator.ModelContainer;
import nl.garndesh.hla.utils.ClassCreationUtils;

import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * Created by christiaan on 2/3/17.
 */
public class VariantTypeGenerator implements IGenerator {

    private ClassCreationUtils utils = new ClassCreationUtils();

    @Override
    public void objectCreation(ModelContainer container) {

    }

    @Override
    public void typeListing(ModelContainer container) {
        Map<String, JType> knownTypes = container.getKnownTypes();
        List<HLAVariantRecord> variantRecords = container.getModel().getDataTypes().getVariantRecordDataTypes();
        variantRecords.forEach(record -> {
            HLAVariantRecord.Alternative alternative = record.getAlternatives().stream()
                    .filter(a -> !"NA".equals(a.getDataType()))
                    .findFirst().orElse(null);
            JType type = knownTypes.get(alternative.getDataType());
            if(type!=null) {
                JType optionalType = container.getCodeModel().ref(Optional.class).narrow(type);
                knownTypes.put(record.getName(), optionalType);
            }
        });
    }

    @Override
    public void fieldCreation(ModelContainer container) {
        List<HLAVariantRecord> variantRecords = container.getModel().getDataTypes().getVariantRecordDataTypes();
        variantRecords.forEach(record -> {
            JDefinedClass fixedRecordClass = container.getClasses().get(record.getName());
            record.getAlternatives().forEach(field -> utils.fillField(field, fixedRecordClass, container));
        });
    }
}
