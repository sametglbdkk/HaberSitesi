package Service;

import Repository.CommentsRepository;
import model.Comments;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommentService {

    @Autowired
    CommentsRepository commentsRepository;

    public List<Comments> getAll() {
        return commentsRepository.findAll();
    }

    public void save(Comments comment) {
        commentsRepository.save(comment);
    }

    public Optional<Comments> getById(Long id) {
        return commentsRepository.findById(id);
    }

    public Comments create(Comments newComment) {
        return commentsRepository.save(newComment);
    }

    public Comments update(Comments updatedComment) {
        return commentsRepository.save(updatedComment);
    }

    public void deleteComment(Long id) {
        commentsRepository.deleteById(id);
    }
}
