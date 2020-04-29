package com.example.demo.utils;

import com.example.demo.model.product.Droid;
import com.example.demo.model.product.Engine;
import com.example.demo.model.product.Product;
import com.example.demo.model.product.ProductType;
import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.*;

@Slf4j
public class ProductGenerator {

    private static final Map<ProductType, List<List<String>>> productData = new HashMap<>();

    static {
        for (ProductType productType : ProductType.values()) {
            List<List<String>> data = readCsv("src/main/resources/testData/" + productType.name() + ".csv");
            productData.put(productType, data);
        }
    }

    public static Product getRandomProduct() {
        Random random = new Random();
        int level = random.nextInt(8);
        ProductType randomType = getRandomType();
        List<String> productTemplate = productData.get(ProductType.Engine).get(level);

        return switch (randomType) {
            case Generator -> null;
            case Capture -> null;
            case Engine -> new Engine(productTemplate.get(0), BigDecimal.TEN, 20 + random.nextInt(80),
                    ProductType.Engine, Integer.parseInt(productTemplate.get(1)), Integer.parseInt(productTemplate.get(2)));

            case Droid -> new Droid(productTemplate.get(0), BigDecimal.TEN, 20 + random.nextInt(80),
                    ProductType.Droid, Integer.parseInt(productTemplate.get(1)));
            case FuelTank -> null;
            case Radar -> null;
            case Scanner -> null;
            case Body -> null;
            case Weapon -> null;
        };
    }

    public static ProductType getRandomType() {
        Random random = new Random();
        // return ProductType.values()[random.nextInt(ProductType.values().length)];
        return ProductType.Engine;
    }


    static List<List<String>> readCsv(String path) {
        List<List<String>> records = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(";");
                records.add(Arrays.asList(values));
            }
        } catch (FileNotFoundException e) {
            log.error("File with path {} not found", path);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return records;
    }
}
