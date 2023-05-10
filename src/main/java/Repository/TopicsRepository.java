package Repository;

import model.Topics;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface TopicsRepository extends JpaRepository<Topics, Long> {
    List<Topics> findTopicByName(String name);
}