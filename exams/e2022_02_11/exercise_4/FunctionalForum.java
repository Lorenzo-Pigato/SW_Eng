package exams.e2022_02_11.exercise_4;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class FunctionalForum {
    private List<Post> posts;

    public List<Post> getAllUserPostToday(String userId){
        List<Post> userPost = this.posts.stream().filter(date -> date.getDate().getDayOfYear() == LocalDate.now().getDayOfYear())
                                                 .filter(usr -> usr.getUserId().equals(userId))
                                                 .collect(Collectors.toList());
        userPost.forEach(x -> System.out.println(x.getUserId()));
        return userPost;
    }

    public List<Post> getAllUserPost(String userId){
        List<Post> userPost = this.posts.stream().filter(usr -> usr.getUserId().equals(userId))
                                                 .collect(Collectors.toList());
        userPost.forEach(x -> System.out.println(x.getUserId()));
        return userPost;
    }
}

class Post {
    private String userId;
    private String post;
    private LocalDate date;

    public Post(String userId, String post, LocalDate date){
        this.userId = userId;
        this.post = post;
        this.date = date;
    }
    public String getUserId() {
        return userId;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getPost() {
        return post;
    }
}