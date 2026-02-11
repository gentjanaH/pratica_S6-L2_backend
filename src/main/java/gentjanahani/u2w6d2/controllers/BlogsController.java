package gentjanahani.u2w6d2.controllers;

import gentjanahani.u2w6d2.entities.Authors;
import gentjanahani.u2w6d2.entities.Blogs;
import gentjanahani.u2w6d2.payloads.NewAuthorPayload;
import gentjanahani.u2w6d2.payloads.NewBlogPayload;
import gentjanahani.u2w6d2.services.AuthorsService;
import gentjanahani.u2w6d2.services.BlogsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/blogs")
public class BlogsController {
    private final BlogsService blogsService;

    @Autowired
    public BlogsController(BlogsService blogsService) {
        this.blogsService = blogsService;
    }


    // 1. GET http://localhost:3002/blogs
    @GetMapping
    public List<Blogs> findBlogs() {
        return blogsService.findallBlogs();
    }

    // 2. POST http://localhost:3002/blogs (+payload)
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Blogs addNewblog(@RequestBody NewBlogPayload payload) {
        return this.blogsService.saveBlogs(payload);
    }

    // 3. GET http://localhost:3002/blogs/{blogId}
    @GetMapping("/{blogId}")
    public Blogs getBlogById(@PathVariable long blogId) {
        return this.blogsService.getBlogsById(blogId);
    }

    // 4. PUT http://localhost:3002/blogs/{blogId} (+payload)
    @PutMapping("/{blogId}")
    public Blogs updateBlogById(@PathVariable long blogId, @RequestBody NewBlogPayload payload) {
        return this.blogsService.findAndUpDate(blogId, payload);
    }

    // 5. DELETE http://localhost:3002/blog/{blogId}
    @DeleteMapping("/{blogId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void findBlogAndDelete(@PathVariable long blogId) {
        this.blogsService.findByIdAndDelete(blogId);
    }
}
