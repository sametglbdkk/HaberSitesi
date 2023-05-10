package Controller;



import Service.TopicsService;
import model.Topics;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping("/api")
@Validated
public class TopicsController {

    private final TopicsService topicsService;

    @Autowired
    public TopicsController(TopicsService topicsService) {
        this.topicsService = topicsService;
    }

    @GetMapping("/topics")
    public List<Topics> getAllTopics() {
        return topicsService.getAll();
    }

    @GetMapping("/topics/{id}")
    public ResponseEntity<Topics> getTopicById(@PathVariable @NotNull @Min(1) Long id) {
        Topics topic = topicsService.getById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Topic not found"));
        return ResponseEntity.ok(topic);
    }

    @PostMapping("/topics")
    public ResponseEntity<Topics> createTopic(@Valid @RequestBody Topics topic) {
        return ResponseEntity.ok(topicsService.create(topic));
    }

    @PutMapping("/topics/{id}")
    public ResponseEntity<Topics> updateTopic(@PathVariable @NotNull @Min(1) Long id,
                                              @Valid @RequestBody Topics updatedTopic) {
        Topics topic = topicsService.getById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Topic not found"));

        updatedTopic.setId(id);
        return ResponseEntity.ok(topicsService.update(updatedTopic));
    }

    @DeleteMapping("/topics/{id}")
    public ResponseEntity<Topics> deleteTopic(@PathVariable @NotNull @Min(1) Long id) {
        Topics topic = topicsService.getById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Topic not found"));

        topicsService.deleteTopic(id);
        return ResponseEntity.ok(topic);
    }
}
