package nl.garndesh.hla.generator.pojo;

import com.sun.codemodel.JClassAlreadyExistsException;
import com.sun.codemodel.JDefinedClass;
import com.sun.codemodel.JPackage;
import nl.garndesh.hla.dataTypes.HLAEnum;
import nl.garndesh.hla.generator.IGenerator;
import nl.garndesh.hla.generator.ModelContainer;

import java.util.List;

import static nl.garndesh.hla.utils.Constants.ENUM_PACKAGE;

/**
 * Created by christiaan on 2/4/17.
 */
public class EnumGenerator implements IGenerator{

    @Override
    public void objectCreation(ModelContainer container) {
        List<HLAEnum> enums = container.getModel().getDataTypes().getEnumeratedDataTypes();
        JPackage enumsPackage = container.getCodeModel()._package(ENUM_PACKAGE);
        enums.forEach(hlaEnum -> {
            try {
                String name = hlaEnum.getName();
                JDefinedClass anEnum = enumsPackage._enum(name);
                container.getClasses().put(name, anEnum);
                container.getKnownTypes().put(name, anEnum);

                //TODO move this to the field creation part and start using the given values.
                for (HLAEnum.Enumerator enumerator:
                        hlaEnum.getEnumerators()) {
                    anEnum.enumConstant(enumerator.getName());
                }
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

    }
}
