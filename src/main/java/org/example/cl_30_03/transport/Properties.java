package org.example.cl_30_03.transport;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class Properties {
    private String type;
    @JsonProperty("VehicleMetaData")
    private VehicleMetaData vehicleMetaData;
}