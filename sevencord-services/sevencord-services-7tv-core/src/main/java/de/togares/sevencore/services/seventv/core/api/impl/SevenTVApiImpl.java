package de.togares.sevencore.services.seventv.core.api.impl;

import de.togares.sevencord.services.seventv.api.SevenTVApi;
import de.togares.sevencord.services.seventv.api.data.EmoteSize;
import de.togares.sevencore.services.seventv.core.business.SevenTVApiClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

@Service
public class SevenTVApiImpl implements SevenTVApi {
    @Autowired
    private SevenTVApiClient apiClient;

    @Override
    public InputStream getEmoteAsImage(String emoteName, EmoteSize size) {
        return new ByteArrayInputStream(new byte[0]);
    }
}
