package com.jocuriledelfinului.delfinul.modules;


import com.fasterxml.jackson.databind.module.SimpleModule;
import com.jocuriledelfinului.delfinul.enums.Terrain;
import com.jocuriledelfinului.delfinul.serializers.TerrainSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TerrainRegisterModuleConfig {
    @Bean
    public SimpleModule javaTerrainModule() {
        SimpleModule module = new SimpleModule();
        module.addSerializer(Terrain.class, new TerrainSerializer());
        return module;
    }
}
