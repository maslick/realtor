package si.ijs.maslick.ai.realtor;

import com.maslick.ai.klassy.classifier.AbstractClassifier;
import com.maslick.ai.klassy.io.IFileLoader;
import weka.core.Attribute;
import weka.core.DenseInstance;
import weka.core.Instance;

import java.util.ArrayList;

import static com.maslick.ai.klassy.classifier.ClassifierType.REGRESSION;
import static si.ijs.maslick.ai.realtor.FeatureNames.*;
import static si.ijs.maslick.ai.realtor.FeatureHelper.*;


public class HouseKlassyFire extends AbstractClassifier<House> {

    public HouseKlassyFire(IFileLoader fileLoader) {
        super(fileLoader);
        MODEL = "house.model";         // model file name without path
        classifierType = REGRESSION;   // CLASSIFICATION or REGRESSION
        classIndex = 5;                // usually comes last (5) or first (0)
        relation = "house";            // name of the dataset (optional)
    }

    @Override
    public ArrayList<Attribute> createAttributeList() {
        ArrayList<Attribute> atts = new ArrayList<>();

        // Weka doesn't take attribute names into account, but their order!
        // However, for clarity one should specify attribute names like below

        atts.add(new Attribute(HOUSE_SIZE,          0));
        atts.add(new Attribute(LOT_SIZE,            1));
        atts.add(new Attribute(NUMBER_OF_BEDROOMS,  2));
        atts.add(new Attribute(GRANITE,             3));
        atts.add(new Attribute(NUMBER_OF_BATHROOMS, 4));
        atts.add(new Attribute(SELLING_PRICE,       5));    // class attribute (classIndex=5)

        return atts;
    }

    @Override
    public Instance calculateFeatures(House data) {
        // valid instance size is 5 or 6 (with class attribute)
        Instance instance = new DenseInstance(5);

        instance.setValue(attributes.get(0), calcHouseSize(data));
        instance.setValue(attributes.get(1), calcLotSize(data));
        instance.setValue(attributes.get(2), calcBedrooms(data));
        instance.setValue(attributes.get(3), calcGranite(data));
        instance.setValue(attributes.get(4), calcNumberOfBathrooms(data));

        return instance;
    }
}
