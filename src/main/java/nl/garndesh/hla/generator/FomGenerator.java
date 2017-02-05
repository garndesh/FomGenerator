package nl.garndesh.hla.generator;

import com.sun.codemodel.JCodeModel;
import nl.garndesh.hla.HLAObjectModel;
import nl.garndesh.hla.generator.pojo.FomObjectsGenerator;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

/**
 * Created by christiaan on 2/3/17.
 */
public class FomGenerator {

    private ModelContainer container;

    public void generate(InputStream fom, File output) throws JAXBException, XMLStreamException, IOException {
        container = new ModelContainer();
        container.setModel(getModel(fom));
        container.setCodeModel(new JCodeModel());

        FomObjectsGenerator objectsGenerator = new FomObjectsGenerator();
        objectsGenerator.generate(container);

        //CodecGenerator transcoderGenerator = new CodecGenerator();
        //transcoderGenerator.generate(container);

        saveAndExit(output);
    }

    private HLAObjectModel getModel(InputStream in) throws JAXBException, XMLStreamException {

        JAXBContext jaxbContext = JAXBContext.newInstance(HLAObjectModel.class);
        XMLInputFactory xif = XMLInputFactory.newFactory();
        xif.setProperty(XMLInputFactory.SUPPORT_DTD, false);
        XMLStreamReader xsr = xif.createXMLStreamReader(in);

        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

        return (HLAObjectModel) jaxbUnmarshaller.unmarshal(xsr);
    }

    private void saveAndExit(File output) throws IOException {
        /*if(output.exists()){
            cleanupOld(output);
        }*/
        output.mkdirs();
        container.getCodeModel().build(output);
    }


    private void cleanupOld(File f) throws IOException {
        Files.walkFileTree(f.toPath(), new SimpleFileVisitor<Path>() {
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                Files.delete(file);
                return FileVisitResult.CONTINUE;
            }

            @Override
            public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
                Files.delete(dir);
                return FileVisitResult.CONTINUE;
            }
        });
    }
}
