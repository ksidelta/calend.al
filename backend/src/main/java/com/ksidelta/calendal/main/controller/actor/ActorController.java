package com.ksidelta.calendal.main.controller.actor;

import com.ksidelta.calendal.main.services.source.SourceService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/main/actor")
public class ActorController {
    SourceService sourceService;

    public ActorController(SourceService sourceService) {
        this.sourceService = sourceService;
    }

    @GetMapping("search")
    public SearchedSourcesViewModel findBySearchString(@RequestParam String searchString) {
        var foundSources = this.sourceService.findSourcesBySearchString(searchString);

        var returned = new SearchedSourcesViewModel(
                foundSources.stream().map(x ->
                        new SearchedSourcesViewModel.SourceElement(
                                x.getSource().getId(),
                                x.getSource().getSourceName(),
                                x.getPluginId()
                        )
                ).collect(Collectors.toList())
        );

        return returned;
    }
}
