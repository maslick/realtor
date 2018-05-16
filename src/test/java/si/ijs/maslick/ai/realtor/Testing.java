package si.ijs.maslick.ai.realtor;

import com.maslick.ai.klassy.io.ContextLoader;
import org.junit.Assert;
import org.junit.Test;
import weka.classifiers.functions.LinearRegression;
import weka.core.Instance;
import weka.core.Instances;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Testing {

    @Test
    public void trainModel() throws Exception {
        //load data
        BufferedReader br = new BufferedReader(new InputStreamReader(new ContextLoader().getFile("house.arff"), "UTF-8"));
        Instances data = new Instances(br);
        data.setClassIndex(5);

        //build model
        LinearRegression model = new LinearRegression();
        model.buildClassifier(data);
        System.out.println(model);

        //classify the last instance
        Instance myHouse = data.lastInstance();
        double price = model.classifyInstance(myHouse);
        System.out.println("My house (" + myHouse + "): " + price);
    }

    @Test
    public void testGeneratedModel() {
        HouseKlassyFire model = new HouseKlassyFire(new ContextLoader());
        House house = House.builder()
                .houseSize(2983)
                .lotSize(9365)
                .bedrooms(5)
                .granite(0)
                .bathroom(1)
                .build();

        String klass = model.classify(house);
        Assert.assertEquals(230000, Double.valueOf(klass), 8000);
    }
}
