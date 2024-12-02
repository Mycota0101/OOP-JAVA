public class Main {
    public static void main(String[] args) {
        Network network = Network.getInstance();

        User user1 = new User("Alice");
        User user2 = new User("Bob");

        network.addUser(user1);
        network.addUser(user2);

        user1.createPost("Hello, this is my first post!");
        user2.createPost("Good morning, everyone!");

        Post post1 = network.getPosts().get(0);
        Post post2 = network.getPosts().get(1);

        user2.likePost(post1);
        user1.likePost(post2);
    }
}
