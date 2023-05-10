package Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import model.Comments;

@Repository
public interface CommentsRepository extends JpaRepository<Comments, Long> {
    List<Comments> findByAuthorName(String authorName);

    List<Comments> findAllByArticleId(Long articleId);
}

