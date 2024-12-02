import java.util.ArrayList;

public class Post {
    private String content;
    private User author;
    private ArrayList<User> likes;

    public Post(String content, User author) {
        this.content = content;
        this.author = author;
        this.likes = new ArrayList<>();
    }

    public String getContent() {
        return content;
    }

    public User getAuthor() {
        return author;
    }

    public void addLike(User user) {
        likes.add(user);
    }

    public ArrayList<User> getLikes() {
        return likes;
    }
}
