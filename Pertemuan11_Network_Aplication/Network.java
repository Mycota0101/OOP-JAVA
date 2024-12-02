import java.util.ArrayList;

public class Network {
    private ArrayList<User> users;
    private ArrayList<Post> posts;
    private static Network instance;

    private Network() {
        users = new ArrayList<>();
        posts = new ArrayList<>();
    }

    public static Network getInstance() {
        if (instance == null) {
            instance = new Network();
        }
        return instance;
    }

    public void addUser(User user) {
        users.add(user);
        System.out.println("User added: " + user.getName());
    }

    public void addPost(Post post) {
        posts.add(post);
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public ArrayList<Post> getPosts() {
        return posts;
    }
}
