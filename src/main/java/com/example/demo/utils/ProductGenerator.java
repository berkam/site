package com.example.demo.utils;

import com.example.demo.model.product.Scanner;
import com.example.demo.model.product.*;
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
        List<String> productTemplate = productData.get(randomType).get(level);

        return switch (randomType) {
            case Generator -> new Generator(productTemplate.get(0), BigDecimal.TEN, 20 + random.nextInt(80),
                    ProductType.Generator, Integer.parseInt(productTemplate.get(1)));
            case Capture -> new Capture(productTemplate.get(0), BigDecimal.TEN, 20 + random.nextInt(80),
                    ProductType.Capture, Integer.parseInt(productTemplate.get(1)), Integer.parseInt(productTemplate.get(2)));
            case Engine -> new Engine(productTemplate.get(0), BigDecimal.TEN, 20 + random.nextInt(80),
                    ProductType.Engine, Integer.parseInt(productTemplate.get(1)), Integer.parseInt(productTemplate.get(2)));
            case Droid -> new Droid(productTemplate.get(0), BigDecimal.TEN, 20 + random.nextInt(80),
                    ProductType.Droid, Integer.parseInt(productTemplate.get(1)));
            case FuelTank -> new FuelTank(productTemplate.get(0), BigDecimal.TEN, 20 + random.nextInt(80),
                    ProductType.FuelTank, Integer.parseInt(productTemplate.get(1)));
            case Radar -> new Radar(productTemplate.get(0), BigDecimal.TEN, 14 + random.nextInt(56),
                    ProductType.Radar, Integer.parseInt(productTemplate.get(1)));
            case Scanner -> new Scanner(productTemplate.get(0), BigDecimal.TEN, 14 + random.nextInt(56),
                    ProductType.Scanner, Integer.parseInt(productTemplate.get(1)));
        };
    }

    public static ProductType getRandomType() {
        return ProductType.values()[new Random().nextInt(ProductType.values().length)];
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
