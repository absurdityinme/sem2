package org.example.cl_30_03.transport;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Setter;
import lombok.Getter;

@Getter@Setter
public class FeatureProperties {
    private String type;
    @JsonProperty("TrajectorySegmentMetaData")
    private TrajectorySegmentMetaData trajectorySegmentMetaData;
}