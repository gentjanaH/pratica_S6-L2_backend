package gentjanahani.u2w6d2.services;

import gentjanahani.u2w6d2.entities.Authors;
import gentjanahani.u2w6d2.entities.Blogs;
import gentjanahani.u2w6d2.exceptions.NotFoundException;
import gentjanahani.u2w6d2.payloads.NewAuthorPayload;
import gentjanahani.u2w6d2.payloads.NewBlogPayload;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class BlogsService {
    List<Blogs> allBlogs = new ArrayList<>();

    //metodo find
    public List<Blogs> findallBlogs() {
        return this.allBlogs;
    }

    //metodo save
    public Blogs saveBlogs(NewBlogPayload payload) {
        Blogs newBlog = new Blogs(payload.getTitolo(), payload.getCategoria(),
                payload.getContenuto(), payload.getTempoDiLettura());
        this.allBlogs.add(newBlog);
        log.info("IL blog " + newBlog.getIdBlog() + " è stato aggiunto correttamente");
        return newBlog;

    }

    //metodo getById
    public Blogs getBlogsById(long blogId) {
        Blogs found = null;
        for (Blogs blog : this.allBlogs) {
            if (blog.getIdBlog() == blogId) found = blog;
        }
        if (found == null) throw new NotFoundException(blogId);
        return found;
    }

    //metodo updatebyid
    public Blogs findAndUpDate(long blogId, NewBlogPayload payload) {
        Blogs found = null;
        for (Blogs blog : this.allBlogs) {
            if (blog.getIdBlog() == blogId) {
                found = blog;
                found.setTitolo(payload.getTitolo());
                found.setCategoria(payload.getCategoria());
                found.setContenuto(payload.getContenuto());
                found.setTempoDiLettura(payload.getTempoDiLettura());

            }
        }
        if (found == null) throw new NotFoundException(blogId);
        return found;
    }

    //metoto findAndDelete
    public void findByIdAndDelete(long blogId) {
        Blogs found = null;
        for (Blogs blog : this.allBlogs) {
            if (blog.getIdBlog() == blogId) found = blog;
        }
        if (found == null) throw new NotFoundException(blogId);
        this.allBlogs.remove(found);
    }
}
