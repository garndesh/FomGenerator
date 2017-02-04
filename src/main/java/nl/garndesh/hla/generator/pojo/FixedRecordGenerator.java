package nl.garndesh.hla.generator.pojo;

import com.sun.codemodel.JClassAlreadyExistsException;
import com.sun.codemodel.JDefinedClass;
import com.sun.codemodel.JPackage;
import nl.garndesh.hla.dataTypes.HLAFixedRecord;
import nl.garndesh.hla.generator.IGenerator;
import nl.garndesh.hla.generator.ModelContainer;
import nl.garndesh.hla.utils.ClassCreationUtils;

import java.util.List;

import static nl.garndesh.hla.utils.Constants.FIXED_RECORDS_PACKAGE;

/**
 * Created by christiaan on 2/4/17.
 */
public class FixedRecordGenerator implements IGenerator {

    private ClassCreationUtils util = new ClassCreationUtils();

    @Override
    public void objectCreation(ModelContainer container) {
        List<HLAFixedRecord> fixedRecords = container.getModel().getDataTypes().getFixedRecordDataTypes();
        JPackage jPackage = container.getCodeModel()._package(FIXED_RECORDS_PACKAGE);
        fixedRecords.forEach(record -> {
            try {
                String name = record.getName();
                JDefinedClass recordClass = jPackage._class(name);
                util.updateMaps(name, recordClass, container);
            } catch (JClassAlreadyExistsException e) {
                e.printStackTrace();
            }
        });
    }

    @Override
    public void typeListing(ModelContainer container) {

    }


    @Override
    public void fieldCreation(ModelContainer container) {
        List<HLAFixedRecord> fixedRecords = container.getModel().getDataTypes().getFixedRecordDataTypes();
        fixedRecords.forEach(fixedRecord -> {
            JDefinedClass fixedRecordClass = container.getClasses().get(fixedRecord.getName());
            fixedRecord.getFields().forEach(field -> util.fillField(field, fixedRecordClass, container));
        });
    }

}
