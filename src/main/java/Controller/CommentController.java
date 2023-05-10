package Controller;


import Service.CommentService;
import model.Comments;
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
public class CommentController {

    private final CommentService commentService;

    @Autowired
    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @GetMapping("/comments")
    public List<Comments> getAllComments() {
        return commentService.getAll();
    }

    @GetMapping("/comments/{id}")
    public ResponseEntity<Comments> getCommentById(@PathVariable @NotNull @Min(1) Long id) {
        Comments comment = commentService.getById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Comment not found"));
        return ResponseEntity.ok(comment);
    }

    @PostMapping("/comments")
    public ResponseEntity<Comments> createComment(@Valid @RequestBody Comments comment) {
        return ResponseEntity.ok(commentService.create(comment));
    }

    @PutMapping("/comments/{id}")
    public ResponseEntity<Comments> updateComment(@PathVariable @NotNull @Min(1) Long id,
                                                  @Valid @RequestBody Comments updatedComment) {
        Comments comment = commentService.getById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Comment not found"));

        updatedComment.setId(id);
        return ResponseEntity.ok(commentService.update(updatedComment));
    }

    @DeleteMapping("/comments/{id}")
    public ResponseEntity<Comments> deleteComment(@PathVariable @NotNull @Min(1) Long id) {
        Comments comment = commentService.getById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Comment not found"));

        commentService.deleteComment(id);
        return ResponseEntity.ok(comment);
    }
}
