package com.arhix.finalspace;

import com.arhix.finalspace.service.EpisodeService;
import com.arhix.finalspace.service.QuoteService;
import com.arhix.finalspace.model.CharacterEntity;
import com.arhix.finalspace.model.EpisodeEntity;
import com.arhix.finalspace.model.LocationEntity;
import com.arhix.finalspace.service.CharacterService;
import com.arhix.finalspace.service.LocationService;
import com.arhix.finalspace.model.QuoteEntity;
import graphql.schema.DataFetcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GraphQLDataFetchers {

    @Autowired
    private CharacterService characterService;
    @Autowired
    private LocationService locationService;
    @Autowired
    private EpisodeService episodeService;
    @Autowired
    private QuoteService quoteService;

    public DataFetcher<List<CharacterEntity>> getCharactersFetcher() {
        return dataFetchingEnvironment -> characterService.characters();
    }

    public DataFetcher<CharacterEntity> getCharacterFetcher() {
        return dataFetchingEnvironment -> {
            Integer id = dataFetchingEnvironment.getArgument("id");
            return characterService.character(id);
        };
    }

    public DataFetcher<List<LocationEntity>> getLocationsFetcher() {
        return dataFetchingEnvironment -> locationService.locations();
    }

    public DataFetcher<LocationEntity> getLocationFetcher() {
        return dataFetchingEnvironment -> {
            Integer id = dataFetchingEnvironment.getArgument("id");
            return locationService.location(id);
        };
    }

    public DataFetcher<List<EpisodeEntity>> getEpisodesFetcher() {
        return dataFetchingEnvironment -> episodeService.episodes();
    }

    public DataFetcher<EpisodeEntity> getEpisodeFetcher() {
        return dataFetchingEnvironment -> {
            Integer id = dataFetchingEnvironment.getArgument("id");
            return episodeService.episode(id);
        };
    }

    public DataFetcher<List<QuoteEntity>> getQuotesFetcher() {
        return dataFetchingEnvironment -> quoteService.quotes();
    }
}
