package main.java.br.edu.ifsp.Aulas.simulado1;

public class UserAccount {

    private String email;
    private String userName;

    private Post[] posts;
    private int postCount;

    private Post[] timeline;
    private int timelineCount;

    private UserAccount[] followers;
    private int followerCount;

    public UserAccount(String email, String userName) {
        this.email = email;
        this.userName = userName;

        this.posts = new Post[100];
        this.timeline = new Post[10];
        this.followers = new UserAccount[100];

        this.postCount = 0;
        this.timelineCount = 0;
        this.followerCount = 0;
    }

    public String getUserName() {
        return userName;
    }

    public void publish(String quote) {
        Post post = new Post(this, quote);

        posts[postCount++] = post;

        for (int i = 0; i < followerCount; i++)
            followers[i].updateTimeline(post);


    }

    public void updateTimeline(Post newPost) {
        if (timelineCount < 10)
            timeline[timelineCount++] = newPost;
        else {
            for (int i = 0; i < 9; i++)
                timeline[i] = timeline[i + 1];

            timelineCount--;
            timeline[timelineCount++] = newPost;

        }
    }

    public boolean delete(int postIdx) {
        if (postIdx < 0 || postIdx > postCount)
            return false;

        for (int i = postIdx; i < postCount; i++)
            posts[i] = posts[i + 1];

        postCount--;
        return true;
    }

    public void clapPost(int postIdx) {
        if (postIdx >= 0 && postIdx < timelineCount)
            timeline[postIdx].clap();
    }

    public void booPost(int postIdx) {
        if (postIdx >= 0 && postIdx < timelineCount)
            timeline[postIdx].boo();
    }

    public void acceptFollower(UserAccount newFollower) {
        followers[followerCount++] = newFollower;
    }

    public void blockFollower(UserAccount follower) {
        for (int i = 0; i < followerCount; i++) {
            if (followers[i] == follower){
                for (int j = i; j < followerCount; j++)
                    followers[j] = followers[j + 1];
                followerCount--;
                break;
            }
        }

    }

    public String showTimeline() {
        String s = "Timeline de " + userName + ":\n";

        for (int i = 0; i < timelineCount; i++)
            s += i + ":" + timeline[i].show() + "\n";

        return s;
    }

    public String showMyPosts() {
        String s = "Posts de " + userName + ":\n";

        for (int i = 0; i < postCount; i++)
            s += i + ":" + posts[i].show() + "\n";

        return s;
    }

    public String showMyFriends() {
        String s = "Friends de " + userName + ":\n";

        for (int i = 0; i < followerCount; i++)
            s += i + ":" + followers[i].getUserName() + "\n";

        return s;
    }

}
