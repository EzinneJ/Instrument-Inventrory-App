import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindGuitarTester {
    public static void main(String[] args) {
        Inventory inventory = new Inventory();
         initializeInventory(inventory);

        Map properties = new HashMap<>();
        properties.put("instrumentType", InstrumentType.GUITAR);
        InstrumentSpec clientSpec = new InstrumentSpec(properties);

        List matchingInstruments = inventory.search(clientSpec);
        for (Object matchingInstrument : matchingInstruments) {
            Instrument instrument = (Instrument) matchingInstrument;
            InstrumentSpec instrumentSpec = instrument.getInstrumentSpec();
            for (Object o : instrumentSpec.getProperties().keySet()) {
                String propertyName = (String) o;
                if (propertyName.equals("instrumentType")) {
                    System.out.println(" You can have this " +
                            instrumentSpec.getProperty("instrumentType") + " for $" +
                            instrument.getPrice() + "\n---");
                    break;
                } else {
                    System.out.println("Sorry, we have nothing for you.");

                }

            }
        }
    }
        private static void initializeInventory(Inventory inventory) {
            Map properties = new HashMap();
            properties.put("instrumentType", InstrumentType.GUITAR);
            properties.put("builder", Builder.GIBSON);
            properties.put("model", "CJ");
            properties.put("type", Type.ACOUSTIC);
            properties.put("numStrings", 6);
            properties.put("topWood", Wood.INDIAN_ROSEWOOD);
            properties.put("backWood", Wood.MAPLE);
            inventory.addInstrument("11277", 3999.95, new InstrumentSpec(properties));

            Map guitar = new HashMap<>();
            guitar.put("instrumentType", InstrumentType.GUITAR);
            guitar.put("builder", Builder.FENDER);
            guitar.put("model", "stratocastor");
            guitar.put("type", Type.ELECTRIC);
            guitar.put("numStrings", 6);
            guitar.put("topWood", Wood.ALDER);
            guitar.put("backWood", Wood.CEDAR);
            inventory.addInstrument("V95693", 1499.95, new InstrumentSpec(guitar));

            Map mandolin = new HashMap<>();
            mandolin.put("instrumentType", InstrumentType.MANDOLIN);
            mandolin.put("builder", Builder.GIBSON);
            mandolin.put("model", "mandolin");
            mandolin.put("type", Type.ACOUSTIC);
            mandolin.put("style", Style.F);
            mandolin.put("topWood", Wood.MAPLE);
            mandolin.put("backWood", Wood.ADIRONDACK);
            inventory.addInstrument("9019920", 5495.99, new InstrumentSpec(mandolin));

            Map mandolin1 = new HashMap<>();
            mandolin1.put("instrumentType", InstrumentType.MANDOLIN);
            mandolin1.put("builder", Builder.GIBSON);
            mandolin1.put("model", "mandolin");
            mandolin1.put("type", Type.ACOUSTIC);
            mandolin1.put("style", Style.F);
            mandolin1.put("topWood", Wood.MAPLE);
            mandolin1.put("backWood", Wood.ADIRONDACK);
            inventory.addInstrument("9019920", 5495.99, new InstrumentSpec(mandolin1));
    }
}

