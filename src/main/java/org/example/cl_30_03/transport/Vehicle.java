package org.example.cl_30_03.transport;

import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Setter@Getter
public class Vehicle {
    private String type;
    private Properties properties;
    private List<Feature> features;
}
