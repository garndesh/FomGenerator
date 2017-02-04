package nl.garndesh.hla.generator.pojo;

import nl.garndesh.hla.generator.IGenerator;
import nl.garndesh.hla.generator.ModelContainer;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by christiaan on 2/3/17.
 */
public class FomObjectsGenerator {

    private List<IGenerator> generatorList = new ArrayList<>();

    public FomObjectsGenerator(){
        generatorList.add(new ArrayGenerator());
        generatorList.add(new EnumGenerator());
        generatorList.add(new FixedRecordGenerator());
        generatorList.add(new InteractionGenerator());
        generatorList.add(new KnownDataTypeGenerator());
        generatorList.add(new ObjectGenerator());
        generatorList.add(new SimpleDataTypesGenerator());
        generatorList.add(new VariantTypeGenerator());
    }

    public void generate(ModelContainer container){
        generatorList.forEach(iGenerator -> iGenerator.objectCreation(container));
        generatorList.forEach(iGenerator -> iGenerator.typeListing(container));
        generatorList.forEach(iGenerator -> iGenerator.fieldCreation(container));
    }
}
