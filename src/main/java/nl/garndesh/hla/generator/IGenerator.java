package nl.garndesh.hla.generator;

/**
 * Created by christiaan on 2/3/17.
 */
public interface IGenerator {
    //void generate(ModelContainer container);

    /**
     * initial generator phase. Creates the initial classes.
     * @param container
     */
    void objectCreation(ModelContainer container);

    /**
     * second generator phase. updates listing of available types
     * @param container
     */
    void typeListing(ModelContainer container);

    /**
     * third generator phase. creation of fields and getters/setters
     * @param container
     */
    void fieldCreation(ModelContainer container);
}
