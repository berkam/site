package com.example.demo.utils;

import com.example.demo.model.Product;
import com.example.demo.model.ProductType;
import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.*;

@Slf4j
public class ProductGenerator {

    private static Map<ProductType, List<List<String>>> productData;

    static {
        for (ProductType productType : ProductType.values()) {
            List<List<String>> data = readCsv("testData/" + productType.name() + ".csv");
            productData.put(productType, data);
        }
    }

    public static Product getRandomProduct() {
        return switch (getRandomType()) {
            case Engine -> createRandomProductFromCsv(ProductType.Engine, 20);
            case FuelTank -> createRandomProductFromCsv(ProductType.FuelTank, 20);
            default -> new Product();
        };
    }

    public static Product createRandomProductFromCsv(ProductType productType, int minVolume) {
        Random random = new Random();
        List<List<String>> data = productData.get(productType);
        List<String> value = data.get(random.nextInt(data.size()));

        Map<String, Integer> specification = new HashMap<>();
        for (int i = 1; i < data.size(); i++) {
            String[] strings = value.get(i).split(":");
            specification.put(strings[0], Integer.valueOf(strings[1]));
        }

        return new Product(value.get(0), BigDecimal.ONE,
                minVolume + random.nextInt(minVolume * 4),
                productType, specification);
    }

    public static ProductType getRandomType() {
        Random random = new Random();
        return ProductType.values()[random.nextInt(ProductType.values().length)];
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
