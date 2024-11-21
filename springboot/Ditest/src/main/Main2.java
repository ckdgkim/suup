package main;

public class Main2 {
    public static void main(String[] args) {
        Post post = new NewPost();
//        PrintPost printPost = new PrintLnPost(post);
        PrintPost printPost = new PrintNoLnPost(post);
        printPost.print();
        printPost.print();
        printPost.print();
    }
}

interface Post {
    String getAllPosts();
}

class NewPost implements Post {
    @Override
    public String getAllPosts() {
        return "This is all post data";
    }
}

interface PrintPost {
    void print();
}

class PrintLnPost implements PrintPost {
    private final Post post;

    public PrintLnPost(Post post) {
        this.post = post;
    }

//    public void setPost(Post post) {
//        this.post = post;
//    }
    @Override
    public void print() {
        System.out.println(post.getAllPosts());
    }
}

class PrintNoLnPost implements PrintPost {
    private Post post;

    public PrintNoLnPost(Post post) {
        this.post = post;
    }

    @Override
    public void print() {
        System.out.print(post.getAllPosts());
    }
}