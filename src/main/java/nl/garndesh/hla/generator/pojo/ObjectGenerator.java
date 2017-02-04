package nl.garndesh.hla.generator.pojo;

import com.sun.codemodel.JClassAlreadyExistsException;
import com.sun.codemodel.JDefinedClass;
import com.sun.codemodel.JPackage;
import nl.garndesh.hla.generator.IGenerator;
import nl.garndesh.hla.generator.ModelContainer;
import nl.garndesh.hla.objects.HLAObject;
import nl.garndesh.hla.utils.ClassCreationUtils;
import nl.garndesh.hla.utils.Constants;

import java.util.List;

/**
 * Created by christiaan on 2/4/17.
 */
public class ObjectGenerator implements IGenerator {

    private ClassCreationUtils utils = new ClassCreationUtils();

    @Override
    public void objectCreation(ModelContainer container) {
        HLAObject rootObject = container.getModel().getObjects().getRootObject();
        JPackage objectPackage = container.getCodeModel()._package(Constants.OBJECTS_PACKAGE);
        recurseObjectGen(rootObject.getObjects(), null, objectPackage, container);
    }

    @Override
    public void typeListing(ModelContainer container) {

    }

    @Override
    public void fieldCreation(ModelContainer container) {
        fillObjectsRecursive(container.getModel().getObjects().getRootObject().getObjects(), container);
    }

    private void fillObjectsRecursive(List<HLAObject> objects, ModelContainer container){
        objects.forEach(hlaObject -> {
            JDefinedClass object = container.getClasses().get(hlaObject.getName());
            if(hlaObject.getAttributes()!=null) {
                hlaObject.getAttributes().forEach(hlaAttribute -> utils.fillField(hlaAttribute, object, container));
            }
            if(hlaObject.getObjects()!=null){
                fillObjectsRecursive(hlaObject.getObjects(), container);
            }
        });
    }

    private void recurseObjectGen(List<HLAObject> objects, JDefinedClass parent, JPackage objectPackage, ModelContainer container){
        objects.forEach(hlaObject -> {
            try {
                JDefinedClass objectClass = objectPackage._class(hlaObject.getName());
                utils.updateMaps(hlaObject.getName(), objectClass, container);
                if(parent!=null){
                    objectClass._extends(parent);
                }
                List<HLAObject> subclasses = hlaObject.getObjects();
                if(subclasses!=null) {
                    recurseObjectGen(subclasses, objectClass, objectPackage, container);
                }
            } catch (JClassAlreadyExistsException e) {
                e.printStackTrace();
            }

        });
    }
}
