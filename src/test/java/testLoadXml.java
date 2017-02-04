import nl.garndesh.hla.HLAObjectModel;
import nl.garndesh.hla.dataTypes.HLASimpleData;
import nl.garndesh.hla.generator.FomGenerator;
import org.junit.Test;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * Created by christiaan on 2/3/17.
 */
public class testLoadXml {

    @Test
    public void load() throws JAXBException, XMLStreamException {
        HLAObjectModel model = getModel();
        System.out.println("");
    }


    private HLAObjectModel getModel() throws JAXBException, XMLStreamException {

        InputStream in = getClass().getResourceAsStream("/FRISO-TMS-FOM.xml");
        JAXBContext jaxbContext = JAXBContext.newInstance(HLAObjectModel.class);
        XMLInputFactory xif = XMLInputFactory.newFactory();
        xif.setProperty(XMLInputFactory.SUPPORT_DTD, false);
        XMLStreamReader xsr = xif.createXMLStreamReader(in);

        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

        return (HLAObjectModel) jaxbUnmarshaller.unmarshal(xsr);
    }


    @Test
    public void listSimpleDataTypes() throws JAXBException, XMLStreamException {
        HLAObjectModel model = getModel();
        List<HLASimpleData> simpleDataTypes = model.getDataTypes().getSimpleDataTypes();
        for (HLASimpleData data :
                simpleDataTypes) {
            System.out.println(data.getName() + " " + data.getRepresentation());
        }
    }


    @Test
    public void testGen() throws JAXBException, XMLStreamException, IOException {
        FomGenerator generator = new FomGenerator();
        generator.generate(getClass().getResourceAsStream("/FRISO-TMS-FOM.xml"));
    }


}
