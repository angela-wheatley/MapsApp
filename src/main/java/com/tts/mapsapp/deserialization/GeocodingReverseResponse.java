package com.tts.mapsapp.deserialization;

import java.util.List;

import lombok.Data;

@Data
public class GeocodingReverseResponse
{
    List<ReverseGeometry> results;
}
