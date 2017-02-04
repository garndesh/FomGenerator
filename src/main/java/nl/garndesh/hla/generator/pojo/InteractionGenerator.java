package nl.garndesh.hla.generator.pojo;

import com.sun.codemodel.JClassAlreadyExistsException;
import com.sun.codemodel.JDefinedClass;
import com.sun.codemodel.JPackage;
import nl.garndesh.hla.generator.IGenerator;
import nl.garndesh.hla.generator.ModelContainer;
import nl.garndesh.hla.interactions.HLAInteraction;
import nl.garndesh.hla.utils.ClassCreationUtils;
import nl.garndesh.hla.utils.Constants;

import java.util.List;

/**
 * Created by christiaan on 2/4/17.
 */
public class InteractionGenerator implements IGenerator {

    private ClassCreationUtils utils = new ClassCreationUtils();

    @Override
    public void objectCreation(ModelContainer container) {
        JPackage interactionPackage = container.getCodeModel()._package(Constants.INTERACTIONS_PACKAGE);
        recurseInteractionGen(container.getModel().getInteractions().getRootObject().getInteractions(), null, interactionPackage, container);
    }

    @Override
    public void typeListing(ModelContainer container) {

    }


    @Override
    public void fieldCreation(ModelContainer container) {
        fillInteractionsRecursive(container.getModel().getInteractions().getRootObject().getInteractions(), container);
    }

    private void fillInteractionsRecursive(List<HLAInteraction> interactions, ModelContainer container){
        interactions.forEach(interaction -> {
            JDefinedClass object = container.getClasses().get(interaction.getName());
            if(interaction.getParameters()!=null) {
                interaction.getParameters().forEach(parameter -> utils.fillField(parameter, object, container));
            }
            if(interaction.getInteractions()!=null){
                fillInteractionsRecursive(interaction.getInteractions(), container);
            }
        });
    }

    private void recurseInteractionGen(List<HLAInteraction> objects, JDefinedClass parent, JPackage objectPackage, ModelContainer container){
        objects.forEach(hlaObject -> {
            if(!"HLAmanager".equals(hlaObject.getName())) {
                try {
                    JDefinedClass objectClass = objectPackage._class(hlaObject.getName());
                    utils.updateMaps(hlaObject.getName(), objectClass, container);
                    if (parent != null) {
                        objectClass._extends(parent);
                    }
                    List<HLAInteraction> subclasses = hlaObject.getInteractions();
                    if (subclasses != null) {
                        recurseInteractionGen(subclasses, objectClass, objectPackage, container);
                    }
                } catch (JClassAlreadyExistsException e) {
                    System.out.println(hlaObject.getName());
                    e.printStackTrace();
                }
            }

        });
    }
}
