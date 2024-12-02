import java.util.ArrayList;

public class User {
    private String name;
    private ArrayList<Post> posts;
    private ArrayList<Post> likedPosts;

    public User(String name) {
        this.name = name;
        this.posts = new ArrayList<>();
        this.likedPosts = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void createPost(String content) {
        Post post = new Post(content, this);
        posts.add(post);
        Network.getInstance().addPost(post);
        System.out.println(name + " created a post: " + content);
    }

    public void likePost(Post post) {
        if (!likedPosts.contains(post)) {
            likedPosts.add(post);
            post.addLike(this);
            System.out.println(name + " liked the post: " + post.getContent());
        } else {
            System.out.println(name + " has already liked this post.");
        }
    }

    public ArrayList<Post> getPosts() {
        return posts;
    }
}
