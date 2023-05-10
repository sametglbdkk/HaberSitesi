package Service;

import Repository.TopicsRepository;
import model.Topics;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TopicsService {

    @Autowired
    TopicsRepository topicsRepository;

    public List<Topics> getAll() {
        return topicsRepository.findAll();
    }

    public void save(Topics topic) {
        topicsRepository.save(topic);
    }

    public Optional<Topics> getById(Long id) {
        return topicsRepository.findById(id);
    }

    public Topics create(Topics newTopic) {
        return topicsRepository.save(newTopic);
    }

    public Topics update(Topics updatedTopic) {
        return topicsRepository.save(updatedTopic);
    }

    public void deleteTopic(Long id) {
        topicsRepository.deleteById(id);
    }
}
