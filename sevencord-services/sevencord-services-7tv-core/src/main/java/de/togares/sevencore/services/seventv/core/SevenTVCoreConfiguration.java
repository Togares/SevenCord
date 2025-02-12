package de.togares.sevencore.services.seventv.core;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import de.togares.sevencord.services.seventv.api.data.seventv.*;
import de.togares.sevencore.services.seventv.core.api.data.mixins.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class SevenTVCoreConfiguration {
    @Bean
    public ObjectMapper objectMapper() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.NONE);
        objectMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);

        objectMapper.addMixIn(Emote.class, EmoteMixin.class);
        objectMapper.addMixIn(EmoteData.class, EmoteDataMixin.class);
        objectMapper.addMixIn(EmoteFile.class, EmoteFileMixin.class);
        objectMapper.addMixIn(EmoteHost.class, EmoteHostMixin.class);
        objectMapper.addMixIn(EmoteOwner.class, EmoteOwnerMixin.class);
        objectMapper.addMixIn(EmoteSet.class, EmoteSetMixin.class);
        objectMapper.registerModule(new JavaTimeModule())
                .configure(SerializationFeature.WRITE_DATE_TIMESTAMPS_AS_NANOSECONDS, false)
                .configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false)
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
                .configure(DeserializationFeature.READ_DATE_TIMESTAMPS_AS_NANOSECONDS, false)
                .setSerializationInclusion(JsonInclude.Include.NON_NULL);
        return objectMapper;
    }
}
