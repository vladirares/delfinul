package com.jocuriledelfinului.delfinul.serializers;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.jocuriledelfinului.delfinul.enums.Terrain;

import java.io.IOException;

public class TerrainSerializer extends StdSerializer<Terrain> {

    public TerrainSerializer() {
        this(null);
    }

    public TerrainSerializer(Class<Terrain> t) {
        super(t);
    }

    @Override
    public void serialize(
            Terrain value, JsonGenerator jsonGenerator, SerializerProvider provider)
            throws IOException {
        jsonGenerator.writeString(value.LABEL.toString());
    }
}